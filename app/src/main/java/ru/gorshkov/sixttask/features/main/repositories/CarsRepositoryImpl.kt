package ru.gorshkov.sixttask.features.main.repositories

import ru.gorshkov.sixttask.features.main.network.CarsService
import ru.gorshkov.sixttask.data.pojo.SixtCar
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val service: CarsService
) : CarsRepository {

    override suspend fun getCars(): List<SixtCar> = service.getCars()
}