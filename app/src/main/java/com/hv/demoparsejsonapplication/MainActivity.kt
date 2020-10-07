package com.hv.demoparsejsonapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hv.demoparsejsonapplication.database.TravelViewModel
import com.hv.demoparsejsonapplication.model.DetailsTravel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var travels = listOf<DetailsTravel>()
    private lateinit var travelViewModel: TravelViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        travelViewModel = ViewModelProvider(this).get(TravelViewModel::class.java)

        travelViewModel.getAllPlace().observe(this,
            Observer { list ->
                if (list != null) {
                    travels = list
                    if (travels.isNotEmpty()) {
                        for (travel in travels) {
                            Log.d("TAG", "onCreate: " + travel.travel?.title)
                        }
                    }
                }
            })

        travelViewModel.getAllTypePlace().observe(this, Observer {
            for (x in it) {
                Log.d("TAG", "onCreate1: $x")
            }
        })

        btnSubmit.setOnClickListener {
            updateTravel()
        }
    }

    private fun updateTravel() {
        if (travels.isNotEmpty()) {
            val travel = travels[0]
            travel.travel?.title = edtTitle.text.toString()
            travelViewModel.updateTravel(travel.travel!!)
        }
    }
}
