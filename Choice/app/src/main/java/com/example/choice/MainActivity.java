package com.example.choice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox check1;
    ToggleButton toggleButton;
    Switch aSwitch;
    TextView textView;
    String[] text = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioG);
        check1 = findViewById(R.id.check1);
        toggleButton = findViewById(R.id.toggle_btn);
        aSwitch = findViewById(R.id.switch1);
        textView = findViewById(R.id.textview);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                radioButton = findViewById(checkId);
                text[0] = radioButton.getText().toString();
                print();
            }
        });

        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    text[1] = check1.getText().toString();
                } else {
                    text[1] = null;
                }
                print();
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    text[2] = "toggle ON";
                } else {
                    text[2] = "toggle OFF";
                }
                print();

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    text[3] = "스위치 ON";
                } else {
                    text[3] = "스위치 OFF";
                }
                print();

            }
        });
    }


    public void print() {
        String str = "";
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null)
                str += " " + text[i];
        }
        textView.setText(str);
    }
}