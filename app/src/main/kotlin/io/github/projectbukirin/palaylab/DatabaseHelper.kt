package io.github.projectbukirin.palaylab

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.util.*

class DatabaseHelper(context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_INFO_TABLE = "CREATE TABLE info ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "detectionName TEXT, " +
                "detectionDate DATE, " +
                "detectionConfidence TEXT   )"
        db.execSQL(CREATE_INFO_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS info")
        onCreate(db)
    }

    fun addInfo(info: StatisticsInfo) {
        Log.d("addInfo", info.toString())
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_DETECTION_NAME, info.detectionName)
        values.put(KEY_DETECTION_DATE, info.detectionDate)
        values.put(KEY_DETECTION_CONFIDENCE, info.detectionConfidence)
        db.insert(TABLE_INFO, null, values)
        db.close()
    }

    fun getInfo(id: Int): StatisticsInfo {
        val db = this.readableDatabase
        val cursor = db.query(TABLE_INFO,
                COLUMNS,
                " id = ?", arrayOf(id.toString()),
                null,
                null,
                null,
                null)
        cursor?.moveToFirst()
        val info = StatisticsInfo()
        info.id = cursor!!.getString(0).toInt()
        info.detectionName = cursor.getString(1)
        info.detectionDate = cursor.getString(2)
        info.detectionConfidence = cursor.getString(3)
        Log.d("getInfo($id)", info.toString())
        return info
    }

    fun countInfo(detectionName: String): Int {
        val db = readableDatabase
        val countQuery = "SELECT * FROM " + TABLE_INFO + " WHERE " + KEY_DETECTION_NAME + " = '" + detectionName + "'"
        val cursor = db.rawQuery(countQuery, null)
        return cursor.count
    }

    fun countThisWeek(detectionName: String): Int {
        val db = readableDatabase
        val countThisWeekQuery = "SELECT * FROM " + TABLE_INFO + " WHERE DATE(" + KEY_DETECTION_DATE + ") >= DATE('now', 'weekday 0', '-7 days') AND " + KEY_DETECTION_NAME + " = '" + detectionName + "'"
        val cursor = db.rawQuery(countThisWeekQuery, null)
        return cursor.count
    }

    fun countAllData(): Int {
        val db = readableDatabase
        val query = "SELECT * FROM " + TABLE_INFO
        val cursor = db.rawQuery(query, null)
        return cursor.count
    }

    val allInfo: List<StatisticsInfo>
        get() {
            val infos: MutableList<StatisticsInfo> = LinkedList()
            val query = "SELECT * FROM " + TABLE_INFO
            val db = writableDatabase
            val cursor = db.rawQuery(query, null)
            var info: StatisticsInfo? = null
            if (cursor.moveToFirst()) {
                do {
                    info = StatisticsInfo()
                    info.id = cursor.getString(0).toInt()
                    info.detectionName = cursor.getString(1)
                    info.detectionDate = cursor.getString(2)
                    info.detectionConfidence = cursor.getString(3)
                    infos.add(info)
                } while (cursor.moveToNext())
            }
            Log.d("getAllInfo", infos.toString())
            return infos
        }

    fun updateInfo(info: StatisticsInfo): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("detectionName", info.detectionName)
        values.put("detectionData", info.detectionDate)
        values.put("detectionConfidence", info.detectionConfidence)
        val i = db.update(TABLE_INFO,
                values,
                KEY_ID + " = ?", arrayOf(info.id.toString()))
        db.close()
        return i
    }

    fun deleteInfo(info: StatisticsInfo) {
        val db = this.writableDatabase
        db.delete(TABLE_INFO,
                KEY_ID + " = ?", arrayOf(info.id.toString()))
        db.close()
        Log.d("deleteInfo", info.toString())
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "StatisticsInfoDB"
        private const val TABLE_INFO = "info"
        private const val KEY_ID = "id"
        private const val KEY_DETECTION_NAME = "detectionName"
        private const val KEY_DETECTION_DATE = "detectionDate"
        private const val KEY_DETECTION_CONFIDENCE = "detectionConfidence"
        val COLUMNS = arrayOf(KEY_ID, KEY_DETECTION_NAME, KEY_DETECTION_DATE, KEY_DETECTION_CONFIDENCE)
    }
}