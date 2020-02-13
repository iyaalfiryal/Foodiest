package com.veronica.idn.foodiest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.veronica.idn.foodiest.R
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
        val indonesia = LatLng(-0.789275, 113.921326)
        mapView.addMarker(MarkerOptions().position(indonesia).title("Indonesia"))
        mapView.moveCamera(CameraUpdateFactory.newLatLng(indonesia))
    }
}

