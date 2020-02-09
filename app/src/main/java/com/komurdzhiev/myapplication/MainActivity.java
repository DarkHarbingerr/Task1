package com.komurdzhiev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button nextPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextPageBtn = findViewById(R.id.nextPageBtn);
        editText = findViewById(R.id.inputText);

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, DisplayTextActivity.class);
                intent.putExtra(DisplayTextActivity.INPUT_TEXT, text);
                startActivity(intent);
            }
        });
    }
}
