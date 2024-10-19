package com.example.a02_session

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.os.Looper
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.MapView
import org.osmdroid.config.Configuration
import org.osmdroid.library.BuildConfig
import org.osmdroid.util.GeoPoint

class MainActivity : AppCompatActivity() {

    private lateinit var tv_long : TextView
    private lateinit var tv_lati : TextView
    private lateinit var tv_desc : TextView
    private lateinit var btn_sms : Button
    private lateinit var btn_map : Button
    private lateinit var mp_map : org.osmdroid.views.MapView

    var REQUEST_LOCATION_CODE = 5005

    private lateinit var fusedLocationProviderClient : FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Configure OSMdroid user agent
        val ctx = applicationContext
      setContentView(R.layout.activity_main)

        tv_long = findViewById(R.id.tv_longitude)
        tv_lati = findViewById(R.id.tv_latitude)
        tv_desc = findViewById(R.id.tv_desc)
        btn_sms = findViewById(R.id.btn_SMS)
        btn_map = findViewById(R.id.btn_Map)
        mp_map = findViewById(R.id.mv_mapview)

        Configuration.getInstance().load(this, getPreferences(MODE_PRIVATE))
        mp_map.setMultiTouchControls(true)

        btn_sms.setOnClickListener {
            val addressText = tv_desc.text.toString()
            val recipientNumber = "01024797847"

            if (addressText.isNotEmpty()) {
                val smsIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("sms:$recipientNumber")
                    putExtra("sms_body", "Address: $addressText")
                }
                startActivity(smsIntent)
            } else {
                Toast.makeText(this, "Address is not available!", Toast.LENGTH_LONG).show()
            }
        }

        btn_map.setOnClickListener {
            val latitude = tv_lati.text.toString().toDoubleOrNull()
            val longitude = tv_long.text.toString().toDoubleOrNull()
            if (latitude != null && longitude != null) {
                val geoPoint = GeoPoint(latitude, longitude)
                mp_map.controller.setZoom(19.0)
                mp_map.controller.setCenter(geoPoint)

                val marker = org.osmdroid.views.overlay.Marker(mp_map)
                marker.position = geoPoint
                marker.setAnchor(org.osmdroid.views.overlay.Marker.ANCHOR_CENTER, org.osmdroid.views.overlay.Marker.ANCHOR_BOTTOM)
                marker.title = "Current Location"
                mp_map.overlays.clear()  // Clear existing overlays
                mp_map.overlays.add(marker)
            }
        }









    }

    @SuppressLint("MissingPermission")
    override fun onStart() {
        super.onStart()
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                getFreshLocation()
            } else {
                enableLocationServices()
            }
        }
        else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_LOCATION_CODE
            )
        }
    }

    fun checkPermissions() : Boolean{
        var result = false
        if((ContextCompat.checkSelfPermission(this , ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(this , ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED))
        {
            result = true

        }
        return result
    }

    @SuppressLint("MissingPermission")
    fun getFreshLocation(){
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        fusedLocationProviderClient.requestLocationUpdates(
            LocationRequest.Builder(0).apply {
                setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            }.build(),
            object : LocationCallback(){
                override fun onLocationResult(location: LocationResult) {
                    super.onLocationResult(location)
                    var geocoder  = Geocoder(this@MainActivity)
                    var address = geocoder.getFromLocation(location.lastLocation?.latitude!! , location.lastLocation?.longitude!! , 1)
                    tv_long.text = location.lastLocation?.longitude.toString()
                    tv_lati.text = location.lastLocation?.latitude.toString()
                    tv_desc.text = address?.get(0)?.getAddressLine(0) ?: null
                }
            },
            Looper.myLooper()
        )

    }

    fun enableLocationServices(){
        Toast.makeText(this , "Turn on location" , Toast.LENGTH_LONG).show()
        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
        startActivity(intent)
    }

    private fun isLocationEnabled(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
    }






}