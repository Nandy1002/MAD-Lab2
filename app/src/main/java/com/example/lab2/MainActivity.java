package com.example.lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.loadButton);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value += 10;
                progressBar.setProgress(value);
                if(value ==  100){
                    Toast.makeText(MainActivity.this, "Progress Bar Filled", Toast.LENGTH_SHORT).show();
                    value = 0;
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
                    alertbox.setTitle("Completed");
                    alertbox.setMessage("Loading has been finished.");
                    alertbox.create().show();
                }
            }
        });
    }
}