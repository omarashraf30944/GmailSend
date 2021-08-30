package com.amirmohammed.hti2021androidone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amirmohammed.hti2021androidone.models.User;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.login_screen_et_email);
        editTextPassword = findViewById(R.id.login_screen_et_password);

    }

    public void login(View view) {
        System.out.println("Login press");

        String email = editTextEmail.getText().toString();
        System.out.println(email);

        String password = editTextPassword.getText().toString();
        System.out.println(password);

        if (email.isEmpty()) {
            editTextEmail.setError("Email required");
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password required");
            return;
        }

        if (email.equals("amir@gmail.com") && password.equals("123456")) {
            User user = new User("Amir", "Maadi");

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("user", user);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Email or password wrong", Toast.LENGTH_LONG).show();
        }

    }


    public void openRegisterScreen(View view) {
        System.out.println("Open register press");

        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}