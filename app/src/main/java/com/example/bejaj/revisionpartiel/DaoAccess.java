package com.example.bejaj.revisionpartiel;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


@Dao
public interface DaoAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOnlySingleMovie (MyObject show);
    @Query("SELECT * FROM MyObject WHERE text =:minAge")
    MyObject selectOneShow(String minAge);
    @Query("SELECT * FROM MyObject")
    MyObject[] selectAll();
    @Update
    void updateMovie (MyObject show);

}
