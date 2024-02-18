package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Products extends AppCompatActivity {

    GridView gridViewproduct;
    ProgressBar progressber;

    ArrayList <HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap <String , String > hashMap;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        gridViewproduct = findViewById(R.id.gridViewproduct);
        progressber = findViewById(R.id.progressber);


        progressber.setVisibility(View.VISIBLE);

        String url = "https://dummyjson.com/products";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        progressber.setVisibility(View.GONE);


                        try {
                            JSONArray jsonArray = response.getJSONArray("products");


                            for (int x=0; x<jsonArray.length(); x++){

                            JSONObject jsonObjectRequest1 = jsonArray.getJSONObject(x);

                            String title = jsonObjectRequest1.getString("title");
                            String description = jsonObjectRequest1.getString("description");
                            String price = jsonObjectRequest1.getString("price");
                            String discountPercentage = jsonObjectRequest1.getString("discountPercentage");
                            String rating = jsonObjectRequest1.getString("rating");
                            String stock = jsonObjectRequest1.getString("stock");
                            String brand = jsonObjectRequest1.getString("brand");
                            String category = jsonObjectRequest1.getString("category");
                            String thumbnail = jsonObjectRequest1.getString("thumbnail");



                      /*      JSONArray imageArray = jsonObjectRequest1.getJSONArray("images");
                            for (int i=0; i<imageArray.length(); i++){

                                String imageURL = imageArray.getString(i);

                            }

                       */

                                hashMap = new HashMap<>();
                                hashMap.put("title", title);
                                hashMap.put("description", description);
                                hashMap.put("price", price);
                                hashMap.put("discountPercentage", discountPercentage);
                                hashMap.put("rating", rating);
                                hashMap.put("stock", stock);
                                hashMap.put("brand", brand);
                                hashMap.put("category", category);
                                hashMap.put("thumbnail", thumbnail);
                                arrayList.add(hashMap);


                            }

                            Myadapter myAdapter= new Myadapter();
                            gridViewproduct.setAdapter(myAdapter);



                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }


                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        progressber.setVisibility(View.GONE);

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(Products.this);
        requestQueue.add(jsonObjectRequest);



    }


    private class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myview = layoutInflater.inflate(R.layout.productitem,parent,false);

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView tvTham = myview.findViewById(R.id.tvTham);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvcat = myview.findViewById(R.id.tvcat);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvTitle = myview.findViewById(R.id.tvTitle);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvRating = myview.findViewById(R.id.tvRating);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tvPrice = myview.findViewById(R.id.tvPrice);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout layButton = myview.findViewById(R.id.layButton);

            hashMap  = arrayList.get(position);
            String title = hashMap.get("title");
            String description = hashMap.get("description");
            String price = hashMap.get("price");
            String discountPercentage = hashMap.get("discountPercentage");
            String rating = hashMap.get("rating");
            String stock = hashMap.get("stock");
            String brand = hashMap.get("brand");
            String category = hashMap.get("category");
            String thumbnail = hashMap.get("thumbnail");


            tvTitle.setText(title);
            tvcat.setText(category);
            tvRating.setText("Rating: "+rating);
            tvPrice.setText("Price: "+price);
           Picasso.get().load(thumbnail).placeholder(R.drawable.itemphoto).into(tvTham);


           layButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {


                   ProductDetails.TITLE= title;
                   ProductDetails.DESH= description;
                   ProductDetails.PRICE=price;
                   ProductDetails.BRAND= brand;
                   ProductDetails.STOCK= stock;
                   ProductDetails.CAT= category;
                   ProductDetails.RATING = rating;



                   Intent myIntent = new Intent(Products.this, ProductDetails.class);
                   startActivity(myIntent);
               }
           });




            return myview;
        }
    }


}