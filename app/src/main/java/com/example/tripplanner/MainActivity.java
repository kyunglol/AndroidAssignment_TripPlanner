package com.example.tripplanner;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    Button addbtn, homebtn, savebtn;
    ImageButton searchbtn;

    SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerTrips);
        addbtn = findViewById(R.id.btnAddTrip);
        homebtn = findViewById(R.id.btnHome);
        savebtn = findViewById(R.id.btnSaveTrips);
        searchbtn = findViewById(R.id.btnSearch);

        sharedPref = getSharedPreferences("tripsData", MODE_PRIVATE);

        addbtn.setOnClickListener(v -> {
            startActivity(new Intent(this, addtrip.class));
        });


    }
}