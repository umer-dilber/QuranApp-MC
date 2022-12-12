package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText surah, ayat, ayatPrompt;
    TextView showAyat;
    Button btnSearch;
    QuranArabicText txt = new QuranArabicText();
    QDH index = new QDH();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surah = findViewById(R.id.surahNum);
        ayatPrompt = findViewById(R.id.txtAyat);
        ayat = findViewById(R.id.ayatNum);
        showAyat = findViewById(R.id.showAyat);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer surahNum = Integer.parseInt(surah.getText().toString());
                Integer ayatNum = Integer.parseInt(ayat.getText().toString());
                if (!(surahNum>0 && surahNum<115)){
                    Toast.makeText(getApplicationContext(),"Invalid Surah Number",Toast.LENGTH_LONG).show();
                }
                else{
                    if (!((ayatNum>0) && (ayatNum<=index.getSurahVerses(surahNum-1)))){
                        Toast.makeText(getApplicationContext(),"Invalid Ayat Number",Toast.LENGTH_LONG).show();
                    }
                    else {
                        showAyat.setText(txt.QuranArabicText[index.getSurahStart(surahNum - 1) + (ayatNum - 1)]);
                    }
                }
            }
        });
    }
}