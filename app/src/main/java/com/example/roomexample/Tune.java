package com.example.roomexample;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tunes")
public class Tune {
    @PrimaryKey
    int _id;
    String title;
    String artist;
    int year;

    @Ignore
    public Tune(){
        title="";
        artist="";
        _id=0;
        year=0;

    }
    public Tune(int _id, String title, String artist, int year) {
        this._id = _id;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Мелодия: " +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year=" + year + "\n"+
                '}';
    }
}
