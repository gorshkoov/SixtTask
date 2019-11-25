package ru.gorshkov.sixttask.features.list.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.gorshkov.sixttask.data.pojo.SixtCar

class SixtCarCallback(
    private val oldList: List<SixtCar>,
    private val newList: List<SixtCar>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition].id == newList[newPosition].id
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition] == newList[newPosition]
    }
}