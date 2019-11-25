package ru.gorshkov.sixttask.features.main.network

import retrofit2.http.GET
import ru.gorshkov.sixttask.data.pojo.SixtCar

interface CarsService {
    @GET("codingtask/cars")
    suspend fun getCars() : List<SixtCar>
}