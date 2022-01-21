package com.foodgrubber.rxjava;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomRvAdapter extends RecyclerView.Adapter<CustomRvAdapter.MyViewHolder> {

   private final List<String> mListView = new ArrayList<>();




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName.setText(mListView.get(position));
    }

    @Override
    public int getItemCount() {
        return mListView.size();
    }

    public void addToList (String steing){
        mListView.add(steing);
        notifyItemInserted(mListView.size() -1);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txtName)
        TextView txtName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
