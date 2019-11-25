package ru.gorshkov.sixttask.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment


abstract class BaseFragment : DaggerFragment() {
    private var rootView: View? = null
    protected abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater, root: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(layoutRes, root, false)
        return rootView
    }
}