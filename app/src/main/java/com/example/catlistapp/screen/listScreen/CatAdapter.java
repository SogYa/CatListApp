package com.example.catlistapp.screen.listScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catlistapp.R;
import com.example.catlistapp.model.Cat;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.ViewHolder> {


    private final LayoutInflater inflater;
    private final List<Cat> catList;

    public CatAdapter(LayoutInflater inflater, List<Cat> catList) {
        this.inflater = inflater;
        this.catList = catList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cat_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cat cat = catList.get(position);
        holder.catName.setText(cat.getName());
        holder.catAge.setText(cat.getAge());
        Glide.with(inflater.getContext())
                .load(cat.getImageUri())
                .placeholder(R.mipmap.ic_cat_foreground)
                .into(holder.catPhoto);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView catName;
        private final TextView catAge;
        private final ImageView catPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catName = itemView.findViewById(R.id.catNameOne);
            catAge = itemView.findViewById(R.id.catAgeOne);
            catPhoto = itemView.findViewById(R.id.imageViewOne);

        }
    }
}
