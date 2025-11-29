package com.example.tripplanner;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class addtrip extends AppCompatActivity {


    Button start, end, next, cancel;
    EditText etDestination;

    String startDate = "", endDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addtrip);


        etDestination = findViewById(R.id.etDestination);
        start = findViewById(R.id.btnStartDate);
        end = findViewById(R.id.btnEndDate);
        next = findViewById(R.id.btnNext);
        cancel = findViewById(R.id.btnCancel);

        start.setOnClickListener(v -> pickDate(true));
        end.setOnClickListener(v -> pickDate(false));

        next.setOnClickListener(v -> {
            Intent intent = new Intent(this, yourplan.class);
            intent.putExtra("destination", etDestination.getText().toString());
            intent.putExtra("startDate", startDate);
            intent.putExtra("endDate", endDate);
            startActivity(intent);
        });
        cancel.setOnClickListener(v -> {
            finish();   // closes PlanActivity and returns to MainActivity
        });
    }

    private void pickDate(boolean isStart) {
        Calendar calendar = Calendar.getInstance();

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                (view, year, month, day) -> {

                    String selectedDate = day + "/" + (month + 1) + "/" + year;

                    if (isStart) {
                        startDate = selectedDate;
                        start.setText(selectedDate);
                    } else {
                        endDate = selectedDate;
                        end.setText(selectedDate);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        dialog.show();
    }
    }
