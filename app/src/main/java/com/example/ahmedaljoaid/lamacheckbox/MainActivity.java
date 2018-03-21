package com.example.ahmedaljoaid.lamacheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.ahmedaljoaid.lamacheckbox.adapter.ProductsAdapter;
import com.example.ahmedaljoaid.lamacheckbox.modals.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private List<Product> movieList = new ArrayList<>();
    private ProductsAdapter pAdapter;
    AppCompatButton appCompatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        appCompatButton = findViewById(R.id.appCompatButton);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Integer> selectedItemPositions = pAdapter.getSelectedItems();
                int currPos;
                for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
                    currPos = selectedItemPositions.get(i);
                    Log.w(TAG, "Product Selected : " + movieList.get(currPos).getName());

                }
            }
        });
        pAdapter = new ProductsAdapter(movieList, new ProductsAdapter.ListAdapterListener() {
            @Override
            public void getTotal() {
               // appCompatButton.setText(String.valueOf(pAdapter.getSelectedItemCount()));
                List<Integer> selectedItemPositions = pAdapter.getSelectedItems();
                int currPos;
                int total = 0;
                for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
                    currPos = selectedItemPositions.get(i);
                    total += Integer.parseInt(movieList.get(currPos).getPrice());
                    Log.w(TAG, "Product Selected : " + movieList.get(currPos).getName());
                    appCompatButton.setText(String.valueOf(total));
                }
            }
        });
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(pAdapter);
        prepareProductsData();

    }

    private void prepareProductsData() {
        Product product = new Product("Iphone 8", "Mobile", "799");
        movieList.add(product);
        product = new Product("Smart TV", "Tvs", "1200");
        movieList.add(product);
        product = new Product("Smart TV", "Tvs", "3000");
        movieList.add(product);
        product = new Product("Galaxy Note 8", "Mobile", "2342");
        movieList.add(product);
        product = new Product("LG Smart TV", "Tvs", "899");
        movieList.add(product);
        product = new Product("GO PRO", "Camera", "9999");
        movieList.add(product);
        product = new Product("Display Monitor", "Monitor", "12345");
        movieList.add(product);
        product = new Product("Ps4", "Game", "322");
        movieList.add(product);
        product = new Product("Xbox One", "Game", "-100 hh");
        movieList.add(product);
        product = new Product("Pc", "Computer", "2324");
        movieList.add(product);
        product = new Product("MacBook Pro", "Laptop", "9999");
        movieList.add(product);
        product = new Product("Smart TV", "Tvs", "1200");
        movieList.add(product);
        product = new Product("Smart TV", "Tvs", "3000");
        movieList.add(product);
        product = new Product("Galaxy Note 8", "Mobile", "2342");
        movieList.add(product);
        product = new Product("LG Smart TV", "Tvs", "899");
        movieList.add(product);
        product = new Product("GO PRO", "Camera", "9999");
        movieList.add(product);
        product = new Product("Display Monitor", "Monitor", "12345");
        movieList.add(product);
        product = new Product("Ps4", "Game", "322");
        movieList.add(product);
        product = new Product("Xbox One", "Game", "-100 hh");
        movieList.add(product);
        product = new Product("Pc", "Computer", "2324");
        movieList.add(product);
        product = new Product("MacBook Pro", "Laptop", "9999");
        movieList.add(product);
        pAdapter.notifyDataSetChanged();
    }

}
