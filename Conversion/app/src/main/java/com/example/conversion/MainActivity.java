package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText editText;
    Button button;
    private static final double MILE_TO_KM  = 1.609;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.txtResult);
        editText = findViewById(R.id.edtMile);
        button  = findViewById(R.id.btnOK);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                double val = Integer.parseInt(str) * MILE_TO_KM;
                result.setText(String.valueOf(val));
            }
        });
    }
}