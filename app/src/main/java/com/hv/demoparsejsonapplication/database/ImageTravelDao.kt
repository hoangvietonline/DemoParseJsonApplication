package com.hv.demoparsejsonapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hv.demoparsejsonapplication.model.ImageTravel

@Dao
interface ImageTravelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(imageTravel: ImageTravel): Long

    @Query("DELETE FROM image_travel")
    fun deleteAll()
}