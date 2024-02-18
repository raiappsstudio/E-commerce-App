package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    TextView tvDtitle, tvDbrand, tvDrating, tvDcat,tvDprice , tvDstock, tvDesh;


    public static String TITLE, BRAND, RATING, CAT, PRICE, STOCK, DESH = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        tvDtitle = findViewById(R.id.tvDtitle);
        tvDbrand = findViewById(R.id.tvDbrand);
        tvDrating = findViewById(R.id.tvDrating);
        tvDcat = findViewById(R.id.tvDcat);
        tvDprice = findViewById(R.id.tvDprice);
        tvDstock = findViewById(R.id.tvDstock);
        tvDesh = findViewById(R.id.tvDesh);




        tvDtitle.setText(TITLE);
        tvDbrand.setText("Brand: "+BRAND);
        tvDrating.setText("Rating: "+RATING);
        tvDcat.setText("Category: "+CAT);
        tvDprice.setText("Price: "+PRICE);
        tvDstock.setText(STOCK+" in a Stock");
        tvDesh.setText(DESH);





    }
}