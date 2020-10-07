package com.hv.demoparsejsonapplication.model

import androidx.room.Embedded
import androidx.room.Relation

class DetailsTravel {
    @Embedded
    var travel: Travel? = null

    @Relation(parentColumn = "id", entityColumn = "travelId")
    var listTravel: List<ImageTravel>? = null

    @Relation(parentColumn = "id", entityColumn = "travelId")
    var content: Content? = null
}
