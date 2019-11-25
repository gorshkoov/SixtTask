package ru.gorshkov.sixttask.features.main.repositories

import ru.gorshkov.sixttask.data.pojo.SixtCar

interface CarsRepository {
    suspend fun getCars() : List<SixtCar>
}