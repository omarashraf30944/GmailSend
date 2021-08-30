package com.amirmohammed.hti2021androidone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MenusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optional_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.IT_search){
            Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.IT_notifications) {
            Toast.makeText(this,"Notifications",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.IT_logout){
            Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }


}