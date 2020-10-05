package com.hv.demoparsejsonapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_travel")
data class ImageTravel(
    @PrimaryKey(autoGenerate = true) var id :Long,
    var travelId :String,
    var url : String
)
