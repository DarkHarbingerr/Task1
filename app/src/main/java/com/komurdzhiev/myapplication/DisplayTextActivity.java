package com.komurdzhiev.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.komurdzhiev.myapplication.R;

public class DisplayTextActivity extends AppCompatActivity {

    final String VariableKey = "Variable_Name";
    final String TextViewKey = "TextView_Text";
    String text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle arg = getIntent().getExtras();
        if(arg != null){
            TextView textView = findViewById(R.id.outputText);
            textView.setMovementMethod(new ScrollingMovementMethod());
            text = arg.getString("inputText");
            textView.setText(text);
        }
    }

    //Save Data
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(VariableKey, text);
        TextView textView = findViewById(R.id.outputText);
        outState.putString(TextViewKey, textView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    //Restore Data
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text = savedInstanceState.getString(VariableKey);
        String textViewText = savedInstanceState.getString(TextViewKey);
        TextView textView = findViewById(R.id.outputText);
        textView.setText(textViewText);
    }
}
