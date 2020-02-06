package com.komurdzhiev.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextPageBtn = findViewById(R.id.nextPageBtn);

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.inputText);
                String text = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, DisplayTextActivity.class);
                intent.putExtra("inputText", text);
                startActivity(intent);
            }
        });
    }
}
