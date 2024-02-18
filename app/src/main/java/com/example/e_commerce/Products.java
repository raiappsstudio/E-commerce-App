package com.example.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

public class Products extends AppCompatActivity {

    GridView gridViewproduct;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        gridViewproduct = findViewById(R.id.gridViewproduct);

        Myadapter myAdapter= new Myadapter();
        gridViewproduct.setAdapter(myAdapter);






    }


    private class Myadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
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





            return myview;
        }
    }


}