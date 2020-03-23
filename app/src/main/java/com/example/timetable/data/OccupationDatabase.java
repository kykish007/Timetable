package com.example.timetable.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Occupation.class}, version = 1, exportSchema = false)
public abstract class OccupationDatabase extends RoomDatabase {

    public static final String NAME_DB = "occupation.db";
    public static OccupationDatabase database;
    public static final Object LOCK = new Object();

    public static OccupationDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, OccupationDatabase.class, NAME_DB).fallbackToDestructiveMigration().build();
            }
        }
        return database;
    }

    public abstract OccupationDAO occupationDAO();
}
