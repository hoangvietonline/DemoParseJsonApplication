package com.hv.demoparsejsonapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hv.demoparsejsonapplication.database.TravelViewModel
import com.hv.demoparsejsonapplication.model.DetailsTravel
import com.hv.demoparsejsonapplication.model.Travel


class MainActivity : AppCompatActivity() {
    private var travels = listOf<DetailsTravel>()
    private lateinit var  travelViewModel : TravelViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        travelViewModel = ViewModelProvider(this).get(TravelViewModel::class.java)

        travelViewModel.getAllplace().observe(this,
            Observer<List<DetailsTravel>> { list ->
                if (list != null) {
                    travels = list
                    if (travels.isNotEmpty())
                    Log.d("TAG", "onCreate: " + travels[travels.size - 1].listTravel!![0].url)
                }
            })
    }
}
