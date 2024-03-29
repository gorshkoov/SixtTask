package ru.gorshkov.sixttask.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.Timber
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.coroutines.CoroutinesDispatcher
import ru.gorshkov.sixttask.data.pojo.SixtCar
import ru.gorshkov.sixttask.di.scopes.ActivityScope
import ru.gorshkov.sixttask.features.main.interactors.CarsInteractor
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val carsInteractor: CarsInteractor,
    private val dispatchers : CoroutinesDispatcher
) : ViewModel() {
    val carsGetLiveData = MutableLiveData<List<SixtCar>>()
    val errorLiveData = MutableLiveData<Int>()

    private val handler = CoroutineExceptionHandler { _, exception ->
        Timber.e { "MainViewModel:: $exception" }
        errorLiveData.postValue(R.string.default_error)
    }

    fun activityCreated() {
        viewModelScope.launch(dispatchers.Main + handler) {
            val cars = withContext(dispatchers.IO) { carsInteractor.getCars() }
            carsGetLiveData.postValue(cars)
        }
    }
}