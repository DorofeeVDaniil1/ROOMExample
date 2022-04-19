package com.example.roomexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button addButton , clearButton;
    ListView tuneList;
    TunesDB tunesDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_button2);
        clearButton = findViewById(R.id.clear_button);
        tuneList = findViewById(R.id.list);

        tunesDB = TunesDB.get(getApplicationContext());
        getAllInUI();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        PlayList playList = tunesDB.playList();
                        playList.addNewTune(
                                new Tune(new Random().nextInt(10000),
                                        "Отшельник",
                                        "Ария",
                                        2000)
                        );
                    }
                }).start();

                getAllInUI();
            }
        });
    }

    void getAllInUI(){
        Context context = getApplicationContext();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Cursor cursor = tunesDB.query("SELECT * FROM tunes",null);
                SimpleCursorAdapter sb = new SimpleCursorAdapter(
                        context,R.layout.list_item,cursor, cursor.getColumnNames(),
                        new int[]{R.id._id,R.id.title_tune,R.id.artist,R.id.year},
                        CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                );
                tuneList.setAdapter(sb);

            }
        });
    }
}