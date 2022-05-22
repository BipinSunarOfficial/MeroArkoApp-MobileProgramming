package com.example.meroarkoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listview;
    private ListAdapter adapter;
    private List<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        initToolbar();
        setData();
        findViews();
//        getSupportFragmentManager().beginTransaction().add(R.id.frmContainer, new DashboardFragment()).commit();
    }


    private void findViews(){
        listview = findViewById(R.id.listview);
        adapter = new ListAdapter(productList, this);
        listview.setAdapter(adapter);
    }


    private void setData(){
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();

        p1.setTitle("Product 1.");
        p2.setTitle("Product 2.");
        p3.setTitle("Product 3.");
        p4.setTitle("Product 4.");
        p5.setTitle("Product 5.");

        p1.setDescription("Product 1 Description.");
        p2.setDescription("Product 2 Description.");
        p3.setDescription("Product 3 Description.");
        p4.setDescription("Product 4 Description.");
        p5.setDescription("Product 5 Description.");

        p1.setUnit("Product 1 Unit.");
        p2.setUnit("Product 2 Unit.");
        p3.setUnit("Product 3 Unit.");
        p4.setUnit("Product 4 Unit.");
        p5.setUnit("Product 5 Unit.");

        p1.setPrice("Price: 100");
        p2.setPrice("Price: 200");
        p3.setPrice("Price: 300");
        p4.setPrice("Price: 400");
        p5.setPrice("Price: 500");

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);

    }


    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Category");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId()== android.R.id.home){    //id of toolbar is home by default
//            getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer, new HomeFragment()).commit();
//        }
        return super.onOptionsItemSelected(item);
    }
}