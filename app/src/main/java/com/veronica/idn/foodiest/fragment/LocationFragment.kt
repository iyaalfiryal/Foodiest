package com.veronica.idn.foodiest.fragment


import android.content.ContentValues.TAG
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.model.Foods
import com.veronica.idn.foodiest.model.Locations
import kotlinx.android.synthetic.main.fragment_location.*
import java.util.jar.Manifest

/**
 * A simple [Fragment] subclass.
 */
class LocationFragment : Fragment(), OnMapReadyCallback {
    private val locations = ArrayList<Locations>()

    private val TAG = this.javaClass.simpleName

    private lateinit var mapView: GoogleMap

    companion object {

        var mapFragment: SupportMapFragment? = null
        const val RQ_LOCATION_PERMISSION = 1

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_location, container, false)
        mapFragment =
            childFragmentManager.findFragmentById(R.id.fragment_location) as SupportMapFragment

        mapFragment?.getMapAsync(this)

        return view
    }


    override fun onMapReady(p0: GoogleMap?) {
        mapView = p0!!
        val idn = LatLng(-6.174760, 106.827070)
        mapView.addMarker(
            MarkerOptions().position(idn)
                .title("IDN").icon(
                    BitmapDescriptorFactory
                        .fromResource(R.drawable.store)
                )
        )
            .showInfoWindow()
        mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(idn, 16.0f))
        mapView.isTrafficEnabled = true
        setMapClick(mapView)
        setMapLongClick(mapView)
        enabledMyLocation()
    }

    private fun enabledMyLocation() {
        if (isPermissionGranted()) {
            mapView.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                RQ_LOCATION_PERMISSION
            )
        }
    }

    private fun isPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            requireContext(),
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    }

    private fun setMapLongClick(mapView: GoogleMap) {
        mapView.setOnMapLongClickListener { it ->
            val snippetValue = "${it.latitude.toFloat()} ${it.longitude.toFloat()}"
            mapView.addMarker(
                MarkerOptions().position(it).title("Pinned").icon(
                    BitmapDescriptorFactory.fromResource(
                        R.drawable.store
                    )
                ).snippet(snippetValue)
            ).showInfoWindow()
        }

    }

    private fun setMapClick(mapView: GoogleMap) {
        mapView.setOnPoiClickListener { it ->
            val poiMarker = mapView.addMarker(
                MarkerOptions().position(it.latLng)
                    .title(it.name)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.store))
                    .snippet(it.placeId)
            )
            poiMarker.showInfoWindow()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RQ_LOCATION_PERMISSION){
            if (grantResults.isNotEmpty()&& (grantResults[0] == PackageManager.PERMISSION_GRANTED)){
                enabledMyLocation()
            }
        }
    }
}

