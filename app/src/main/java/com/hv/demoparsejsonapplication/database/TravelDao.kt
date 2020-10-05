package com.hv.demoparsejsonapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hv.demoparsejsonapplication.model.DetailsTravel
import com.hv.demoparsejsonapplication.model.Travel

@Dao
interface TravelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(travel: Travel?): Long

    @Query("SELECT * FROM travel_table")
    fun getAllTravel(): LiveData<List<Travel>>

    @Query("DELETE FROM travel_table")
    fun deleteAll()

    @Transaction
    @Query("SELECT * FROM travel_table WHERE isPlace = 1")
    fun getAllPlace(): LiveData<List<DetailsTravel>>

    @Transaction
    @Query("SELECT * FROM travel_table WHERE isHotel = 1")
    fun getAllHotel(): LiveData<List<DetailsTravel>>

    @Transaction
    @Query("SELECT * FROM travel_table WHERE isFood = 1")
    fun getAllFood(): LiveData<List<DetailsTravel>>

}
