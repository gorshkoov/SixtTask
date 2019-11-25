package ru.gorshkov.sixttask.features.list.adapter

import android.graphics.PorterDuff
import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.android.synthetic.main.holder_sixt_car.view.*
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.adapter.BaseViewHolder
import ru.gorshkov.sixttask.base.GlideApp
import ru.gorshkov.sixttask.data.pojo.*

class SixtCarViewHolder(private val view: View) : BaseViewHolder<SixtCar>(view) {
    override fun bind(item: SixtCar) {
        view.model_name_text.text = item.modelName
        view.driver_name_text.text = item.driverName
        view.license_plate_text.text = item.licensePlate
        view.fuel_text.setText(getFuelText(item.fuelType))
        view.cleanliness_text.setText(getCleanlinessText(item.innerCleanliness))
        view.color_image.setColorFilter(
            ContextCompat.getColor(view.context, getColor(item.color)), PorterDuff.Mode.SRC_IN
        )
        if (item.transmission == SixtTransmission.MANUAL) {
            view.transmission_image.setImageResource(R.drawable.ic_manual_transmission)
        } else {
            view.transmission_image.setImageResource(R.drawable.ic_automatic_transmission)
        }
        loadImage(item.carImageUrl)
    }

    private fun loadImage(url: String) {
        GlideApp.with(view)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.drawable.ic_list_placeholder)
            .into(view.car_image)
    }

    @StringRes
    private fun getCleanlinessText(cleanliness: SixtCleanliness?): Int {
        return when (cleanliness) {
            SixtCleanliness.REGULAR -> R.string.regular
            SixtCleanliness.CLEAN -> R.string.clean
            SixtCleanliness.VERY_CLEAN -> R.string.very_clean
            else -> R.string.unspecified
        }
    }

    @StringRes
    private fun getFuelText(fuel: SixtFuel?): Int {
        return when (fuel) {
            SixtFuel.PETROL -> R.string.petrol_short
            SixtFuel.DIESEL -> R.string.diesel_short
            SixtFuel.ELECTRO -> R.string.electronic_short
            else -> R.string.petrol_short
        }
    }

    private fun getColor(color: SixtColor?): Int {
        return when (color) {
            SixtColor.ABSOLUTE_BLACK_METAL,
            SixtColor.SCHWARZ,
            SixtColor.BLACK_METAL,
            SixtColor.SAPHIRSCHWARZ,
            SixtColor.BLACK -> R.color.black

            SixtColor.ICED_CHOCOLATE_METAL,
            SixtColor.HOT_CHOCOLATE -> R.color.brown

            SixtColor.LIGHT_WHITE,
            SixtColor.ALPINWEISS -> R.color.white

            SixtColor.ICED_CHOCOLATE -> R.color.iced
            else -> R.color.orange
        }
    }
}