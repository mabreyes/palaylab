package com.example.rickydanobantonare.smartrice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "StatisticsInfoDB";

    private static final String TABLE_INFO =  "info";

    private static final String KEY_ID = "id";
    private static final String KEY_DETECTION_NAME = "detectionName";
    private static final String KEY_DETECTION_DATE = "detectionDate";
    private static final String KEY_DETECTION_CONFIDENCE = "detectionConfidence";

    public static final String[] COLUMNS = {KEY_ID, KEY_DETECTION_NAME, KEY_DETECTION_DATE, KEY_DETECTION_CONFIDENCE};

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INFO_TABLE = "CREATE TABLE info ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "detectionName TEXT, " +
                "detectionDate DATE, " +
                "detectionConfidence TEXT   )";

        db.execSQL(CREATE_INFO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS info");
        this.onCreate(db);
    }

    public void addInfo(StatisticsInfo info) {
        Log.d("addInfo", info.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DETECTION_NAME, info.getDetectionName());
        values.put(KEY_DETECTION_DATE, info.getDetectionDate());
        values.put(KEY_DETECTION_CONFIDENCE, info.getDetectionConfidence());

        db.insert(TABLE_INFO, null, values);

        db.close();
    }

    public StatisticsInfo getInfo(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor =
                db.query(TABLE_INFO,
                        COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        StatisticsInfo info = new StatisticsInfo();

        info.setId(Integer.parseInt(cursor.getString(0)));
        info.setDetectionName(cursor.getString(1));
        info.setDetectionDate(cursor.getString(2));
        info.setDetectionConfidence(cursor.getString(3));

        Log.d("getInfo("+id+")", info.toString());

        return info;

    }

    public int countInfo(String detectionName) {
        SQLiteDatabase db = getReadableDatabase();

        String countQuery = "SELECT * FROM " + TABLE_INFO + " WHERE "+ KEY_DETECTION_NAME  + " = '"+ detectionName +"'";

        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        return count;
    }

    public List<StatisticsInfo> getAllInfo() {
        List<StatisticsInfo> infos = new LinkedList<StatisticsInfo>();

        String query = "SELECT * FROM " + TABLE_INFO;

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        StatisticsInfo info = null;
        if (cursor.moveToFirst()) {
            do {
                info = new StatisticsInfo();

                info.setId(Integer.parseInt(cursor.getString(0)));
                info.setDetectionName(cursor.getString(1));
                info.setDetectionDate(cursor.getString(2));
                info.setDetectionConfidence(cursor.getString(3));

                infos.add(info);
            } while (cursor.moveToNext());
        }

        Log.d("getAllInfo", infos.toString());

        return infos;
    }

    public int updateInfo(StatisticsInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("detectionName", info.getDetectionName());
        values.put("detectionData", info.getDetectionDate());
        values.put("detectionConfidence", info.getDetectionConfidence());

        int i = db.update(TABLE_INFO,
                values,
                KEY_ID+" = ?",
                new String[] { String.valueOf(info.getId())});

        db.close();

        return i;

    }

    public void deleteInfo(StatisticsInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_INFO,
                KEY_ID+" = ?",
                new String[] { String.valueOf(info.getId())});

        db.close();

        Log.d("deleteInfo", info.toString());
    }
}
