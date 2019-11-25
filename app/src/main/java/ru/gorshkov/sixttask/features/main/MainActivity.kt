package ru.gorshkov.sixttask.features.main

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.Observer
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.BaseActivity
import ru.gorshkov.sixttask.navigator.MainNavigator
import javax.inject.Inject

class MainActivity : BaseActivity() {
    @Inject
    lateinit var mainNavigator: MainNavigator
    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)
        mainNavigator.init()
        mainViewModel.activityCreated()

        mainViewModel.errorLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
    }
}
