package ru.gorshkov.sixttask.features.map

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*
import ru.gorshkov.sixttask.R
import ru.gorshkov.sixttask.base.ViewModelFragment
import ru.gorshkov.sixttask.base.injectViewModel
import ru.gorshkov.sixttask.data.pojo.SixtCar
import ru.gorshkov.sixttask.features.main.MainViewModel

class MapFragment : ViewModelFragment<MainViewModel>() {
    private var googleMap: GoogleMap? = null

    override fun initViewModel() = injectViewModel()

    override val layoutRes = R.layout.fragment_map

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.carsGetLiveData.observe(this, Observer {
            val firstCarPos = LatLng(it[0].latitude, it[0].longitude)
            for(car in it) {
                googleMap?.addMarker(getMarker(car))
            }
            // For zooming automatically to the location of the marker
            val cameraPosition = CameraPosition.Builder().target(firstCarPos).zoom(12f).build()
            googleMap?.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()// needed to get the map to display immediately
        MapsInitializer.initialize(activity)
        map_view.getMapAsync { googleMap -> this.googleMap = googleMap }
    }

    private fun getMarker(car: SixtCar) : MarkerOptions {
        return MarkerOptions()
            .position(LatLng(car.latitude, car.longitude))
            .title(car.modelName)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE))
    }
}