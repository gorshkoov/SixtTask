package ru.gorshkov.sixttask.features.list.adapter

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.BaseAdapter
import ru.gorshkov.sixttask.data.pojo.SixtCar

class SixtCarAdapter : BaseAdapter<SixtCar, SixtCarViewHolder>() {
    override fun item(itemView: View) = SixtCarViewHolder(itemView)

    override fun getItemViewType(position: Int) = R.layout.holder_sixt_car

    fun update(newItems: List<SixtCar>) {
        val diffResult = DiffUtil.calculateDiff(SixtCarCallback(this.items, newItems))
        this.items = newItems
        diffResult.dispatchUpdatesTo(this)
    }
}