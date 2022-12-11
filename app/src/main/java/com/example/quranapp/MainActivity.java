package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText parah, ayat;
    TextView showAyat;
    Button btnSearch;
    QuranArabicText txt;
    QDH index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parah = findViewById(R.id.parahNum);
        ayat = findViewById(R.id.ayatNum);
        Integer parahNum, ayatNum;
        parahNum = Integer.parseInt(parah.getText().toString());
        ayatNum = Integer.parseInt(ayat.getText().toString());
        showAyat = findViewById(R.id.showAyat);
        btnSearch = findViewById(R.id.btnSearch);
//        btnSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showAyat.setText((txt.QuranArabicText[index.getParahStart(parahNum+ayatNum)]).toString());
//            }
//        });
    }
}