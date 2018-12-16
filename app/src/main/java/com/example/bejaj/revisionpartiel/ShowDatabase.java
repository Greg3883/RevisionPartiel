package com.example.bejaj.revisionpartiel;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MyObject.class}, version = 1, exportSchema = false)
public abstract class ShowDatabase extends RoomDatabase {
    public abstract DaoAccess daoAccess() ;
}
