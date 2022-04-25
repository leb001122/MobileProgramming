package com.example.activityandintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button goGoogle;
    Button next;
    TextView textView;
    int val = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goGoogle = findViewById(R.id.goGoogle);
        next = findViewById(R.id.next);
        textView = findViewById(R.id.text);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Explicit Intent
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                intent.putExtra("val", val);
                startActivity(intent);
            }
        });

        goGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implicit Intent
                Uri uri = Uri.parse("http://www.google.com");
                Intent it = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(it);
            }
        });
    }
}