package com.example.roomexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PlayList {
    //Можем писать самые разные вариант ыдля запросов к будущей базе данных.
    @Insert
    void addNewTune(Tune... tunes);
    @Delete
    void deleteTune(Tune... tunes);
    @Update
    void changeInfo(Tune... tunes);

    @Query("SELECT * FROM tunes WHERE _id=:id")
    Tune getTuneById(int id);
    @Query("SELECT * FROM tunes WHERE artist=:aretist")
    List<Tune> getTunesByArtist(String aretist);

    //TODO добавить сколько нужно методов запросов


}
