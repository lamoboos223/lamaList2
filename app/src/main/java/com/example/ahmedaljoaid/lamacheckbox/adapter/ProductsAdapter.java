package com.example.ahmedaljoaid.lamacheckbox.adapter;

import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.ahmedaljoaid.lamacheckbox.R;
import com.example.ahmedaljoaid.lamacheckbox.modals.Product;

import java.util.ArrayList;
import java.util.List;



public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {
    private ListAdapterListener mListener;
    public interface ListAdapterListener { // create an interface
        void getTotal(); // create callback function
    }

    // save check list state
    private final SparseBooleanArray checkedProduct = new SparseBooleanArray();
    private List<Product> moviesList;



    public ProductsAdapter(List<Product> moviesList,ListAdapterListener mListener) {
        this.mListener = mListener; // receive mListener from Fragment (or Activity)
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product movie = moviesList.get(position);
        holder.title.setText(movie.getName());
        holder.genre.setText(movie.getCategory());
        holder.year.setText(movie.getPrice());
        if (checkedProduct.get(position)) {
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatTextView title, year, genre;
        public AppCompatCheckBox checkBox;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.name);
            genre = view.findViewById(R.id.category);
            year = view.findViewById(R.id.price);
            checkBox = view.findViewById(R.id.checkBox);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //check if item checked or not
            if (checkedProduct.get(getAdapterPosition(), false)) {
                // delete checked
                checkedProduct.delete(getAdapterPosition());
                notifyDataSetChanged();
            } else {
                //checked
                checkedProduct.put(getAdapterPosition(), true);
                notifyDataSetChanged();
            }
            mListener.getTotal();
        }
    }

    public int getSelectedItemCount() {
        return checkedProduct.size();
    }



    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(checkedProduct.size());
        for (int i = 0; i < checkedProduct.size(); i++) {
            items.add(checkedProduct.keyAt(i));
        }
        return items;
    }





}