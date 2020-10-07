package com.hv.demoparsejsonapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel_table")
data class Travel(
    @PrimaryKey var id: String,
    var isFood: Boolean,
    var isPlace: Boolean,
    var isHotel: Boolean,
    var longitude: Float,
    var latitude: Float,
    var rate: Float,
    var title: String,
    var isFavourite: Boolean,
    var address: String
)
