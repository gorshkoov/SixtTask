package ru.gorshkov.sixttask.data.pojo

import com.google.gson.annotations.SerializedName

enum class SixtTransmission {
    @SerializedName("M")
    MANUAL,
    @SerializedName("A")
    AUTOMATIC
}