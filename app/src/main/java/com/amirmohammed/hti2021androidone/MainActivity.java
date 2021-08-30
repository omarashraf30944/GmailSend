package com.amirmohammed.hti2021androidone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.amirmohammed.hti2021androidone.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String email = getIntent().getStringExtra("email");

        System.out.println("Main activity => email : " + email);

        User user  = (User) getIntent().getSerializableExtra("user");

        System.out.println(user.toString());


        tv_address = findViewById(R.id.tvselectAddress);


    }

    public void navigateToEmailScreen(View view) {
        Intent intent = new Intent(MainActivity.this, EmailActivity.class);
        startActivity(intent);
    }


    public void tv_select_address(View view) {
        Intent intent = new Intent(MainActivity.this, SelectAddressActivity.class);
        startActivityForResult(intent,1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("RESULT HERE");
        if(requestCode == 1 & resultCode == RESULT_OK){
           String address = data.getStringExtra("address");
           tv_address.setText(address);
        }else if(requestCode == 1 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "no address picked", Toast.LENGTH_LONG).show();
        }
    }

    public void MENUS(View view) {
        Intent intent = new Intent(MainActivity.this,MenusActivity.class);
        startActivity(intent);
    }
}

