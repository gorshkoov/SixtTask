package ru.gorshkov.sixttask.features.main.interactors

import ru.gorshkov.sixttask.di.scopes.ActivityScope
import ru.gorshkov.sixttask.features.main.repositories.CarsRepository
import javax.inject.Inject

@ActivityScope
open class CarsInteractor @Inject constructor(
    private val carsRepository: CarsRepository
) {
    suspend fun getCars() = carsRepository.getCars()
}