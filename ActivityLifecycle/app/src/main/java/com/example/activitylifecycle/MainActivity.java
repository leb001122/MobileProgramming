package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("로그", "onCreate");
        
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("로그", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("로그", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("로그", "onRestart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("로그", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("로그", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("로그", "onDestroy");

    }
}