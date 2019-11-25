package ru.gorshkov.sixttask.features.main.interactors

import ru.gorshkov.sixttask.di.scopes.ActivityScope
import ru.gorshkov.sixttask.features.main.repositories.CarsRepositoryImpl
import javax.inject.Inject

@ActivityScope
class CarsInteractor @Inject constructor(
    private val carsRepository: CarsRepositoryImpl
) {
    suspend fun getCars() = carsRepository.getCars()
}