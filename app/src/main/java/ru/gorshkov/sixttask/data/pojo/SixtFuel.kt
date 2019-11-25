package ru.gorshkov.sixttask.data.pojo

import com.google.gson.annotations.SerializedName

enum class SixtFuel {
    @SerializedName("P")
    PETROL,
    @SerializedName("D")
    DIESEL,
    @SerializedName("E")
    ELECTRO
}