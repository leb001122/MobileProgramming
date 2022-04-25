package com.example.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox check1, check2;
    Button payBtn;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        payBtn = findViewById(R.id.pay_btn);
        fab = findViewById(R.id.floating);

        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "";
                int id = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(id);
                msg = radioButton.getText().toString();

                if (check1.isChecked())
                    msg += " &" + check1.getText().toString();
                if (check2.isChecked())
                    msg += " &" + check2.getText().toString();
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Do something for FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }
}