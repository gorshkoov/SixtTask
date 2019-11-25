package ru.gorshkov.sixttask.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import ru.gorshkov.sixttask.base.coroutines.CoroutinesDispatcher

class TestCoroutinesDispatcher :
    CoroutinesDispatcher {
    override val Main: CoroutineDispatcher = Dispatchers.Unconfined
    override val IO: CoroutineDispatcher = Dispatchers.Unconfined
    override val Computation: CoroutineDispatcher = Dispatchers.Unconfined
}