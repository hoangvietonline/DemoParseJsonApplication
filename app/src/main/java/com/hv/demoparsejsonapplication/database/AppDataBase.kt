package com.hv.demoparsejsonapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hv.demoparsejsonapplication.model.Content
import com.hv.demoparsejsonapplication.model.ImageTravel
import com.hv.demoparsejsonapplication.model.Travel
import com.hv.demoparsejsonapplication.utils.AppUtils
import java.util.concurrent.Executors

@Database(
    entities = [Travel::class, ImageTravel::class, Content::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract val travelDao: TravelDao
    abstract val contentDao : ContentDao
    abstract val imageDao : ImageTravelDao

    companion object {
        private val executorService = Executors.newFixedThreadPool(4)

        private var INSTANCE: AppDataBase? = null

        private fun callback(context: Context): Callback {
            return object : Callback() {
                override fun onOpen(db: SupportSQLiteDatabase) {
                    super.onOpen(db)
                    executorService.execute {
                        val gson = Gson()
                        val travelJson = AppUtils.loadJSONFromAsset(context, "travel.json")
                        val contentJson = AppUtils.loadJSONFromAsset(context, "content.json")
                        val imageJson = AppUtils.loadJSONFromAsset(context, "imageTravel.json")

                        val listTypeTravel = object : TypeToken<List<Travel>>() {}.type
                        val listTypeContent = object : TypeToken<List<Content>>() {}.type
                        val listTypeImage = object : TypeToken<List<ImageTravel>>() {}.type

                        val travels =
                            gson.fromJson(travelJson, listTypeTravel) as MutableList<Travel>
                        val contents = gson.fromJson(contentJson,listTypeContent) as MutableList<Content>
                        val images = gson.fromJson(imageJson,listTypeImage) as MutableList<ImageTravel>

                        val daoTravel = INSTANCE?.travelDao
                        daoTravel?.deleteAll()
                        val contentDao = INSTANCE?.contentDao
                        contentDao?.deleteAll()
                        val imageDao = INSTANCE?.imageDao
                        imageDao?.deleteAll()

                        for (travel in travels) {
                            daoTravel?.insert(travel)
                        }
                        for (content in contents){
                            contentDao?.insert(content)
                        }
                        for (image in images){
                            imageDao?.insert(image)
                        }
                    }
                }
            }
        }

        fun getDataBase(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(context, AppDataBase::class.java, "travel_db")
                        .addCallback(callback(context))
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}