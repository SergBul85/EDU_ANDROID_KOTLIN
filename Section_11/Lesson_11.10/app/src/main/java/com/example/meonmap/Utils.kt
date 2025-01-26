package com.example.meonmap

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import java.util.Locale


class Utils(val context: Context) {


    private val _fusedLocationProviderClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @Suppress("MissingPermission")
    fun requestUpdatePosition(viewModel: PositionViewModel) {

        val locationCallbacc = object : LocationCallback() {
            override fun onLocationResult(point0: LocationResult) {
                super.onLocationResult(point0)
                point0.lastLocation?.let {
                    val newPosition =
                        PositionData(latitude = it.latitude, longitude = it.longitude)
                    viewModel.updatePosition(newPosition)
                }
            }
        }
        val posisitionRequest =
            LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 1000).build()

        _fusedLocationProviderClient.requestLocationUpdates(
            posisitionRequest,
            locationCallbacc,
            Looper.getMainLooper()
        )
    }


    fun hasPermission(context: Context): Boolean {
        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
    }

    fun getAddress(position: PositionData): String {
        val geocoder = Geocoder(context, Locale.getDefault())
        val address: MutableList<Address>? =
            geocoder.getFromLocation(position.latitude, position.longitude, 1)

        return if (address?.isNotEmpty() == true) {
            address[0].getAddressLine(0)
        } else {
            "No address on this position."
        }
    }

}

