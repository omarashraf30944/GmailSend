package com.amirmohammed.hti2021androidone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmailActivity extends AppCompatActivity {
    EditText editTextName;
    CheckBox checkBoxWhippedCream, checkBoxChocolate;
    TextView textViewQuantity, textViewOrderDetails;

    String hint = "Coffee 10$ , Whipped cream 1$ , chocolate 2 $";
    int quantity = 0;
    int totalPrice = 0;
    String message ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        editTextName = findViewById(R.id.et_name);
        checkBoxWhippedCream = findViewById(R.id.cb_whipped_cream);
        checkBoxChocolate = findViewById(R.id.cb_chocolate);
        textViewQuantity = findViewById(R.id.tv_counter);
        textViewOrderDetails = findViewById(R.id.tv_order_details);

        checkBoxWhippedCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                calculatePrice();
            }
        });

        checkBoxChocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                calculatePrice();
            }
        });
    }

    public void decrement(View view) {
        if (quantity == 0) return;

        quantity--;
        textViewQuantity.setText(String.valueOf(quantity));
        calculatePrice();
    }

    public void increment(View view) {
        quantity++;
        textViewQuantity.setText(String.valueOf(quantity));
        calculatePrice();
    }

    private void calculatePrice() {
        totalPrice = 0;

        int coffeePrice = 10;
        int whippedCreamPrice = checkBoxWhippedCream.isChecked() ? 1 : 0;
        int chocolatePrice = checkBoxChocolate.isChecked() ? 2 : 0;

        int price = coffeePrice + whippedCreamPrice + chocolatePrice;

        totalPrice = price * quantity;

        textViewOrderDetails.setText(hint + "\nTotal price : " + totalPrice);
    }

    public void makeOrder(View view) {
        if (message.isEmpty()){
            Toast.makeText(this, "Confirm your order", Toast.LENGTH_SHORT).show();
            return;
        }

        message += "\nThank you";

        System.out.println(message);

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"moryelnegm10@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Coffee order");
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

    public void addNewOrder(View view) {
        String name = editTextName.getText().toString();

        if (name.isEmpty()) {
            editTextName.setError("Name required");
            return;
        }

        message += "\nName : " + name
                + "\nAdd whipped cream : " + checkBoxWhippedCream.isChecked()
                + "\nAdd chocolate : " + checkBoxChocolate.isChecked()
                + "\nQuantity : " + quantity
                + "\nPrice : " + totalPrice;

        editTextName.setText("");
        checkBoxWhippedCream.setChecked(false);
        checkBoxChocolate.setChecked(false);
        quantity = 0;
        textViewQuantity.setText(String.valueOf(quantity));
        textViewOrderDetails.setText(hint);
    }
}