package com.hv.demoparsejsonapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "content")
data class Content(
    @PrimaryKey var travelId: String,
    var contentStart: String? = null,
    var contentMid: String? = null,
    var contentEnd: String? = null,
    var type: String? = null,
    var urlYoutube: String? = null
)
