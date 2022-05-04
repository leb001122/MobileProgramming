package com.example.recyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imgView = findViewById(R.id.img_view);
//        Intent intent = getIntent();
//        int val = intent.getIntExtra("image", 0);
//        Drawable drawable = getDrawable(val);
//        imgView.setImageDrawable(drawable);
//
//        String str = intent.getStringExtra("myData");
////        Toast.makeText(this, str, Toast.LENGTH_SHORT);

    }
}