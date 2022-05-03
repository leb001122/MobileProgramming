package com.example.midtermexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     Spinner spinner;
     Button minus, plus, orderBtn;
     TextView count, result;
     CheckBox checkBox;
     String[] menus = {
             "라면",
             "스파게티",
             "햄버거"
     };
     int price = 0;
     String selectedItem;
     int menuCnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        orderBtn = findViewById(R.id.order_btn);
        count = findViewById(R.id.count);
        result =findViewById(R.id.result);
        checkBox = findViewById(R.id.checkbox);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                selectedItem = adapterView.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuCnt == 1) {
                    return;
                }
                menuCnt--;
                count.setText(String.valueOf(menuCnt));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (menuCnt == 5) {
                    return;
                }
                menuCnt++;
                count.setText(String.valueOf(menuCnt));
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            int temp = 0;
            @Override
            public void onClick(View view) {
                if (selectedItem.equals("라면")) {
                    temp = 2000;
                } else if (selectedItem.equals("스파게티")) {
                    temp = 3000 ;
                } else if (selectedItem.equals("햄버거")) {
                    temp = 4000;
                }
                price = temp * Integer.parseInt((String) count.getText());
                if (checkBox.isChecked()) {
                    price += 1000;
                }
                String resultStr = "";
                resultStr += selectedItem + " " + (String) count.getText() + "개";
                if (checkBox.isChecked()) {
                    resultStr += "(콜라 추가)를 주문했습니다.";
                } else {
                    resultStr += "(콜라 없음)를 주문했습니다.";
                }
                resultStr += "\n총액은 " + price + "원입니다.";
                result.setText(resultStr);
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menus);
        spinner.setAdapter(adapter);

    }
}