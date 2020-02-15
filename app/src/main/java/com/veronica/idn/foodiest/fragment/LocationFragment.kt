package com.veronica.idn.foodiest.fragment


import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.util.Size
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.veronica.idn.foodiest.R
import com.veronica.idn.foodiest.model.Foods
import kotlinx.android.synthetic.main.fragment_location.*

/**
 * A simple [Fragment] subclass.
 */
class LocationFragment : Fragment(), OnMapReadyCallback {
    private lateinit var mapView: GoogleMap

    companion object {
        var mapFragment: SupportMapFragment? = null
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

        mapView.addMarker(MarkerOptions().position(idn).title("Ini Indonesia")).showInfoWindow()
        mapView.moveCamera(CameraUpdateFactory.newLatLngZoom(idn, 16.0f))

    }
}

