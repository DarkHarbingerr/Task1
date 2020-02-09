package com.komurdzhiev.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DisplayTextActivity extends AppCompatActivity {


    //TODO: ключ должен быть публичным и статичным, так же необходимо указывать класс к которому он относится
    // принято что ключ пишется заглавными буквами через нижнее подчёркивание

    public static final String VARIABLE_KEY = "DisplayTextActivity.VARIABLE_KEY";
    public static final String INPUT_TEXT = "DisplayTextActivity.INPUT_TEXT"; // при передаче между экранами

    final String TextViewKey = "TextView_Text"; // сделать аналогично
    private String text = "";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle arg = getIntent().getExtras();
        if (arg != null) {
            textView = findViewById(R.id.outputText);
            textView.setMovementMethod(new ScrollingMovementMethod());
            text = arg.getString(INPUT_TEXT);
            textView.setText(text);
        }
    }

    //Save Data
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(VARIABLE_KEY, text);
        textView = findViewById(R.id.outputText);
        outState.putString(TextViewKey, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //Restore Data
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text = savedInstanceState.getString(VARIABLE_KEY);
        String textViewText = savedInstanceState.getString(TextViewKey);
        textView = findViewById(R.id.outputText);
        textView.setText(textViewText);
    }
}
