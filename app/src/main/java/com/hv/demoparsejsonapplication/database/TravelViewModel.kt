package com.hv.demoparsejsonapplication.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.hv.demoparsejsonapplication.model.DetailsTravel
import com.hv.demoparsejsonapplication.model.Travel

class TravelViewModel(application: Application) : AndroidViewModel(application) {
    private val travelRepository: TravelRepository = TravelRepository(application)

    private var listTravel: LiveData<List<Travel>> = travelRepository.getAllTravel()
    private var listAllPlace: LiveData<List<DetailsTravel>> = travelRepository.getAllPlace()
    private var listAllHotel: LiveData<List<DetailsTravel>> = travelRepository.getAllHotel()
    private var listAllFood: LiveData<List<DetailsTravel>> = travelRepository.getAllFood()

    fun getAllTravel(): LiveData<List<Travel>> {
        return listTravel
    }

    fun getAllPlace(): LiveData<List<DetailsTravel>> {
        return listAllPlace
    }

    fun getAllHotel(): LiveData<List<DetailsTravel>> {
        return listAllHotel
    }

    fun getAllFood(): LiveData<List<DetailsTravel>> {
        return listAllFood
    }
    fun updateTravel(travel: Travel){
        travelRepository.update(travel)
    }
    fun getAllTypePlace() : LiveData<List<String>>{
        return travelRepository.getAllTypePlace()
    }
}