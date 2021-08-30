package com.amirmohammed.hti2021androidone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recieve);

        textViewResult = findViewById(R.id.tv_result);

        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (action.equals(Intent.ACTION_SEND) && type.equals("text/plain")){
            String text = intent.getStringExtra(Intent.EXTRA_TEXT);
            System.out.println(text);
            textViewResult.append(text);
        }

    }
}