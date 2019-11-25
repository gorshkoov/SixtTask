package ru.gorshkov.sixttask.data.pojo

import com.google.gson.annotations.SerializedName

enum class SixtCleanliness {
    @SerializedName("REGULAR")
    REGULAR,
    @SerializedName("CLEAN")
    CLEAN,
    @SerializedName("VERY_CLEAN")
    VERY_CLEAN
}