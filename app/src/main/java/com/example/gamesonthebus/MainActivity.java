package com.example.gamesonthebus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> rooms;
    List<Integer> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        views = new ArrayList<>();
        views.add(R.id.id1);
        views.add(R.id.id2);

        Button hostGameButton = (Button) findViewById(R.id.hostGameButton);
        hostGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hostGameClicked();
            }
        });

        Button joinGameButton = (Button) findViewById(R.id.joinGameButton);
        joinGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                joinGameClicked();
            }
        });


        FloatingActionButton home = findViewById(R.id.fab);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setVisibleView(R.id.id1);
            }
        });
    }

    private void hostGameClicked(){
        final LinearLayout hostGamePage = (LinearLayout) getLayoutInflater().inflate(R.layout.host_game_page, null);

        final DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                try {
                    rooms.add(findViewById(R.id.gameName).toString());
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        };

        new AlertDialog.Builder(MainActivity.this)
                .setView(hostGamePage)
                .setPositiveButton("Ok", onClickListener)
                .setNegativeButton("Cancel", null)
                .show();

    }

    private void joinGameClicked(){
        setVisibleView(R.id.id2);
    }

    private void setVisibleView(int id){
        for(Integer i : views){
            findViewById(i).setVisibility(View.GONE);
        }
        findViewById(id).setVisibility(View.VISIBLE);
    }
}
