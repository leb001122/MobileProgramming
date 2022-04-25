package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //TODO spinner는 selected, listview는 click

    Spinner spinner;
    TextView textResult;
    ListView listView;
    TextView textOutput;
    String[] localDataset = {
            "apple",
            "orange",
            "banana",
            "strawberry",
            "watermelon",
            "kiwi",
            "grape",
            "a", "b", "c", "d", "e"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spn_choice);
        textResult = (TextView) findViewById(R.id.text_result);
        listView = (ListView) findViewById(R.id.listview);
        textOutput = (TextView) findViewById(R.id.text_output);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                String spinner_item = adapterView.getItemAtPosition(pos).toString();
                textResult.setText(spinner_item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
               // textResult.setText("뭘 고를지 몰라 준비해 봤어");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                textOutput.setText("당신의 선택은?? : " +localDataset[pos]);
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, localDataset);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, localDataset);
        listView.setAdapter(arrayAdapter);
    }
}