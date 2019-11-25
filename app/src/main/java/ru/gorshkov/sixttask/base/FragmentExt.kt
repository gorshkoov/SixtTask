package ru.gorshkov.sixttask.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> ViewModelFragment<T>.injectViewModel(): T {
    return ViewModelProviders.of(this, viewModelFactory)[T::class.java]
}

inline fun Fragment.toast(message : String) {
    Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
}