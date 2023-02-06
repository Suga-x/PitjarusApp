package com.example.pitjarusapp

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pitjarusapp.API.RetrofitClient
import com.example.pitjarusapp.databinding.ActivityListStoreBinding

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.FusedLocationProviderClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListStore : AppCompatActivity(){

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityListStoreBinding
    private lateinit var mapFragment : SupportMapFragment

    private lateinit var currentLocation : Location
    private lateinit var  fusedLocation: FusedLocationProviderClient
    private var permissionCode = 101
    private var arraylist = ArrayList<LoginResponseList>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityListStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            val location = LatLng(12.00,10.20)
            mMap.addMarker(MarkerOptions().position(location).title("lokasi dummy"))
        })


        val recyclerView :RecyclerView = findViewById(R.id.recycleViewStore)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager =LinearLayoutManager(this)
        RetrofitClient.instance.login("pitjarus","admin").enqueue(object :Callback <LoginResponse>{
            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                var responCode = response.code().toString()
                response.body()?.let {
//                    arraylist.addAll(listOf(it))
                    val loginresponse = parseLoginResponse(it.toString())
                    arraylist.addAll(it.loginResponses)
                }
                val adapter = DataAdapter(arraylist)
                recyclerView.adapter = adapter


            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("error","On Faluare Error  :" + t )
            }

        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }
}