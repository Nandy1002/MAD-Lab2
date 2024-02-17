package com.example.lab2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button button;
    ProgressBar Progress;
    CountDownTimer t;
    float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Program starts


        Button button=findViewById(R.id.loadButton);
        ProgressBar Progress=findViewById(R.id.progressBar);

        Progress.setVisibility(View.INVISIBLE);
        Progress.setMax(100);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Progress.setVisibility(View.VISIBLE);
                long min= 10*1000;//second * milisecond;
                new CountDownTimer(min,1000)
                {
                    @Override
                    public void onTick(long l) {
                        long a = min-l;
                        total= ((float)a/(float)min)*100;
                        Log.e("Total", String.valueOf( (a/min)));
                        Progress.setProgress((int) total);
                    }

                    @Override
                    public void onFinish() {
                        AlertDialog.Builder d = new AlertDialog.Builder(MainActivity.this);
                        d.setTitle(" Completed ").setMessage(" Loding as Been Completed").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"Done",Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("Reject", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Rejected", Toast.LENGTH_SHORT).show();
                            }
                        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "Canceled", Toast.LENGTH_SHORT).show();
                            }
                        });
                        AlertDialog dialog = d.create();
                        dialog.show();
                    }
                }.start();
//

            }
        });
    }
}