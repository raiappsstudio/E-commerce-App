package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    TextView tvDtitle, tvDbrand, tvDrating, tvDcat,tvDprice , tvDstock, tvDesh;
    public static String TITLE, BRAND, RATING, CAT, PRICE, STOCK, DESH = "";



    ////kahani of image slider====
    ImageSlider image_slider;
    public static String IMAGEARRAY="";
    ArrayList <SlideModel> imageList = new ArrayList<>();




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



        //kahani of image slider====
        image_slider = findViewById(R.id.image_slider);
        try {
            JSONArray jsonArray = new JSONArray(IMAGEARRAY);
            if (jsonArray.length()>0){
                JSONArray imageURLArray = jsonArray.getJSONArray(0);
                for ( int i=0; i<imageURLArray.length();i++){
                    String imageURL = imageURLArray.getString(i);
                    imageList.add( new SlideModel(imageURL,null));
                }
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        image_slider.setImageList(imageList);

        //kahani of image slider====





        tvDtitle.setText(TITLE);
        tvDbrand.setText("Brand: "+BRAND);
        tvDrating.setText("Rating: "+RATING);
        tvDcat.setText("Category: "+CAT);
        tvDprice.setText("Price: "+PRICE);
        tvDstock.setText(STOCK+" in a Stock");
        tvDesh.setText(DESH);












    }
}