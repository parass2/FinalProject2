package com.example.finalproject2;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//import com.example.finalproject2.finalCalc;

public class MainActivity extends AppCompatActivity {
    private int STORAGE_PERMISSION_CODE = 1;
    private static final String TAG = "final:Main";
    public static String toDisplay = "";
    public int score = 0;
    private long start = 60000;
    private long stop = 0;
    public Button card1 = null;
    public Button card2 = null;
    public Button card3 = null;
    public Button card4 = null;
    public TextView textView2 = null;
    public TextView scoring = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestStoragePermission();
        projectCode.readFile();
        scoring = findViewById(R.id.scoreView);
        textView2 = findViewById(R.id.OpDisplay);
        final TextView timer = findViewById(R.id.Timer);


        card1 = findViewById(R.id.c1);
        card1.setText(projectCode.card1Val);
        card1.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + projectCode.getVal1() + " ";
            textView2.setText(toDisplay);
        });

        card2 = findViewById(R.id.c2);
        card2.setText(projectCode.getVal1());
        card2.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + projectCode.getVal2() + " ";
            textView2.setText(toDisplay);
        });

        card3 = findViewById(R.id.c3);
        card3.setText(projectCode.card3Val);
        card3.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + projectCode.getVal3() + " ";
            textView2.setText(toDisplay);
        });

        card4 = findViewById(R.id.c4);
        card4.setText(projectCode.card4Val);
        card4.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + projectCode.getVal4() + " ";
            textView2.setText(toDisplay);
        });

        final Button add = findViewById(R.id.add);
        add.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + "+ ";
            textView2.setText(toDisplay);
        });

        final Button sub = findViewById(R.id.sub);
        sub.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + "- ";
            textView2.setText(toDisplay);
        });

        final Button mult = findViewById(R.id.mult);
        mult.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + "x ";
            textView2.setText(toDisplay);
        });

        final Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = "";
            textView2.setText("");
        });

        final Button div = findViewById(R.id.div);
        div.setOnClickListener(v -> {
            Log.d(TAG, "Potato");
            toDisplay = toDisplay + "/ ";
            textView2.setText(toDisplay);
        });

        final Button next = findViewById(R.id.next);
        next.setOnClickListener(v -> {
            boolean value1 = finalCalc.finalResult(toDisplay);
            System.out.println(value1);
            Log.d(TAG, "Potate");
            if (value1) {
                updateQuestion();
                Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                textView2.setText("");
                toDisplay = "";
                System.out.println(scoring + "SCORINGTESTRIGHTHEREHJKLMSDDA");
                score++;
                scoring.setText(Integer.toString(score));
            } else {
                Toast.makeText(MainActivity.this, "Incorrect", Toast.LENGTH_SHORT).show();
                score = score - 2;
                scoring.setText(Integer.toString(score));
                textView2.setText("");
                toDisplay = "";
            }

        });

    }

    private void updateQuestion() {
        projectCode.readFile();
        card1.setText(projectCode.card1Val);
        card2.setText(projectCode.card2Val);
        card3.setText(projectCode.card3Val);
        card4.setText(projectCode.card4Val);
        textView2.setText("");

    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Gibbeth")
                    .setMessage("This is needed b/c I want a grade")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,"This Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_SHORT). show();
            }
        }
    }
}
