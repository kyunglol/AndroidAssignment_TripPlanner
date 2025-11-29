package com.example.tripplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class yourplan extends AppCompatActivity {
    TextView txtTrip;
    Button save;
    Button cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_yourplan);
        txtTrip = findViewById(R.id.txtTripInfo);
        cancel = findViewById(R.id.btnCancel);
        String destination = getIntent().getStringExtra("destination");
        String start = getIntent().getStringExtra("startDate");
        String end = getIntent().getStringExtra("endDate");

        txtTrip.setText(destination + "\n" + start + " to " + end);

        cancel.setOnClickListener(v -> {
            finish();   // closes PlanActivity and returns to MainActivity
        });
    }
}