package ru.gorshkov.sixttask.base.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultCoroutinesDispatcher @Inject constructor(): CoroutinesDispatcher {
    override val Main: CoroutineDispatcher = Dispatchers.Main
    override val IO: CoroutineDispatcher = Dispatchers.IO
    override val Computation: CoroutineDispatcher = Dispatchers.Default
}