package ru.gorshkov.sixttask.features.list

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.ViewModelFragment
import ru.gorshkov.sixttask.base.injectViewModel
import ru.gorshkov.sixttask.features.list.adapter.SixtCarAdapter
import ru.gorshkov.sixttask.features.main.MainViewModel


class ListFragment : ViewModelFragment<MainViewModel>() {
    override fun initViewModel() = injectViewModel()

    override val layoutRes = R.layout.fragment_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.carsGetLiveData.observe(this, Observer {
            (cars_recycler.adapter as SixtCarAdapter).update(it)
        })
        viewModel.errorLiveData.observe(this, Observer {
            list_error_text.visibility = View.VISIBLE
            cars_recycler.visibility = View.GONE
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(cars_recycler) {
            layoutManager = LinearLayoutManager(activity)
            val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            val horizontalDivider =
                ContextCompat.getDrawable(activity!!, R.drawable.vertical_divider)
            divider.setDrawable(horizontalDivider!!)
            addItemDecoration(divider)
            adapter = SixtCarAdapter()
        }
    }
}