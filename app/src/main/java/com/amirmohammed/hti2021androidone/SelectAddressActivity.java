package com.amirmohammed.hti2021androidone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.amirmohammed.hti2021androidone.R;

import org.w3c.dom.Text;

public class SelectAddressActivity extends AppCompatActivity {


    EditText editTextAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);

        editTextAddress = findViewById(R.id.ed_address);
    }

    public void confirm_address(View view) {
        Intent intent = new Intent(SelectAddressActivity.this, MainActivity.class);
        String address = editTextAddress.getText().toString();
        intent.putExtra("address",address);
        setResult(RESULT_OK,intent);
        finish();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_CANCELED);
    }
}