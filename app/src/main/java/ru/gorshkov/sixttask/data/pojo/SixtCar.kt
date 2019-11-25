package ru.gorshkov.sixttask.data.pojo

import com.google.gson.annotations.SerializedName

data class SixtCar(
    val id: String = "",
    val modelName: String = "",
    @SerializedName("name")
    val driverName: String = "",
    val make: String = "",
    val group: String = "",
    val color: SixtColor? = null,
    val series: String = "",
    val fuelType: SixtFuel? = null,
    val fuelLevel: Double = 0.0,
    val transmission: SixtTransmission? = null,
    val licensePlate: String = "",
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val innerCleanliness: SixtCleanliness? = null,
    val carImageUrl: String = ""
)