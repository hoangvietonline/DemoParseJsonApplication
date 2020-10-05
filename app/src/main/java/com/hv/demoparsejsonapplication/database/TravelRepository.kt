package com.hv.demoparsejsonapplication.database

import android.app.Application
import androidx.lifecycle.LiveData
import com.hv.demoparsejsonapplication.model.DetailsTravel
import com.hv.demoparsejsonapplication.model.Travel

class TravelRepository(application: Application) {
    private var travelDao: TravelDao
    private var listAllTravel: LiveData<List<Travel>>
    private var listAllPlace: LiveData<List<DetailsTravel>>
    private var listAllHotel: LiveData<List<DetailsTravel>>
    private var listAllFood: LiveData<List<DetailsTravel>>

    init {
        val database = AppDataBase.getDataBase(application)
        travelDao = database.travelDao
        listAllTravel = travelDao.getAllTravel()
        listAllPlace = travelDao.getAllPlace()
        listAllHotel = travelDao.getAllHotel()
        listAllFood = travelDao.getAllFood()
    }

    fun getAllTravel(): LiveData<List<Travel>> {
        return listAllTravel
    }

    fun getAllplace(): LiveData<List<DetailsTravel>> {
        return listAllPlace
    }

    fun getAllHotel(): LiveData<List<DetailsTravel>> {
        return listAllHotel
    }

    fun getAllFood(): LiveData<List<DetailsTravel>> {
        return listAllFood
    }
}