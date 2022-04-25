package com.example.mycount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView txtCount;
    Button btnCount;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("로그", "onCreate");
        txtCount = findViewById(R.id.txtCount);
        btnCount = findViewById(R.id.btnCount);
        reset = findViewById(R.id.btnReset);
//
//        //onCreate()에서 저징하는 방법
//        if (savedInstanceState != null) {
//            count = savedInstanceState.getInt("count");
//            txtCount.setText(String.valueOf(count));
//        }


        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                String s = Integer.toString(count);
                txtCount.setText(s);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                String s = Integer.toString(count);
                txtCount.setText(s);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("로그", "onStart");
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

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("로그", "onPause");


        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("count", count);
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("로그", "onResume");

        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if (pref != null && pref.contains("count")) { // 저장된 데이터가 있는 경우
            count = pref.getInt("count", count); // 두번째 인자는 저장된 값이 없는 경우 사용할 default 값
            txtCount.setText(String.valueOf(count));
        }
    }
//
//    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
//        // 상태 저장
//        savedInstanceState.putInt("count", count);
//        //항상 슈퍼클래스의 메소드 호출
//        super.onSaveInstanceState(savedInstanceState);
//        Log.d("로그", "-------save");
//
//    }
//
//    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//
//        // 복원을 위해 항상 호출
//        super.onRestoreInstanceState(savedInstanceState);
//        if (savedInstanceState != null) {
//            count = savedInstanceState.getInt("count");
//            txtCount.setText(String.valueOf(count));
//        }
//        Log.d("로그", "=======restore");
//
//    }
}