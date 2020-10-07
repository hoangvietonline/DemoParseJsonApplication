package com.hv.demoparsejsonapplication.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.StandardCharsets

class AppUtils {
    companion object {
        fun loadJSONFromAsset(
            context: Context,
            jsonName: String?
        ): String? {
            val json: String?
            json = try {
                val `is` = context.assets.open(jsonName!!)
                val size = `is`.available()
                val buffer = ByteArray(size)
                `is`.read(buffer)
                `is`.close()
                String(buffer, StandardCharsets.UTF_8)
            } catch (ex: IOException) {
                ex.printStackTrace()
                return null
            }
            return json
        }
    }
}
