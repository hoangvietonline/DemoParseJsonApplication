package com.hv.demoparsejsonapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hv.demoparsejsonapplication.model.Content

@Dao
interface ContentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(content: Content): Long

    @Query("DELETE FROM content")
    fun deleteAll()

    @Query("SELECT DISTINCT type FROM content")
    fun getAllTypePlace() : LiveData<List<String>>
}
