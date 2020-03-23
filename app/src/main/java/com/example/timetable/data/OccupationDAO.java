package com.example.timetable.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OccupationDAO {

    @Query("SELECT * FROM occupation")
    LiveData<List<Occupation>> getAllOccupation();

    @Query("SELECT * FROM occupation WHERE id == :OccId")
    Occupation getOccupationById(int OccId);

    @Query("DELETE FROM occupation")
    void deleteAllOccupation();

    @Insert
    void insertOccupation(Occupation occupation);
}
