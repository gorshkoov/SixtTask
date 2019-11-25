package ru.gorshkov.sixttask.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<Item, Holder : BaseViewHolder<Item>> : RecyclerView.Adapter<Holder>() {
    protected var items: List<Item> = listOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, layoutId: Int
    ): Holder = item(
        LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup, false)
    )

    abstract fun item(itemView: View): Holder

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position])
    }
}