package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText surah, ayat, ayatPrompt;
    TextView showAyat;
    Button btnSearch, btnPrev, btnNext, btnBrowser;
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
        btnBrowser = findViewById(R.id.btnBrowser);
        btnBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://github.com/umer-dilber/QuranApp-MC";
                Intent moveToCode = new Intent(Intent.ACTION_VIEW);
                moveToCode.setData(Uri.parse(url));
                startActivity(moveToCode);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!((surah.getText().toString().equalsIgnoreCase("")) || (ayat.getText().toString().equalsIgnoreCase("")))) {
                    Integer surahNum = Integer.parseInt(surah.getText().toString());
                    Integer ayatNum = Integer.parseInt(ayat.getText().toString());
                    if (!(surahNum > 0 && surahNum < 115)) {
                        Toast.makeText(getApplicationContext(), "Invalid Surah Number", Toast.LENGTH_LONG).show();
                    } else {
                        if (!((ayatNum > 0) && (ayatNum <= index.getSurahVerses(surahNum - 1)))) {
                            Toast.makeText(getApplicationContext(), "Invalid Ayat Number", Toast.LENGTH_LONG).show();
                        } else {
                            showAyat.setMovementMethod(new ScrollingMovementMethod());
                            showAyat.setText(txt.QuranArabicText[index.getSurahStart(surahNum - 1) + (ayatNum - 1)]);
                        }
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Fields cannot be empty", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnPrev = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ayatnumber = Integer.parseInt(ayat.getText().toString());
                String ayNum = Integer.toString(ayatnumber-1);
                ayat.setText(ayNum);
                btnSearch.performClick();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ayatnumber = Integer.parseInt(ayat.getText().toString());
                String ayNum = Integer.toString(ayatnumber+1);
                ayat.setText(ayNum);
                btnSearch.performClick();
            }
        });
    }
    public String ayat(int surah, int ayat){
        return txt.QuranArabicText[index.getSurahStart(surah - 1) + (ayat - 1)];
    }
}