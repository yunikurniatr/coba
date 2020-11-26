package org.aplas.recyclerviewrecipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.aplas.recyclerviewrecipe.R;
import org.aplas.recyclerviewrecipe.DataResep;

import java.util.ArrayList;
import java.util.List;

public class ResepAdapter extends RecyclerView.Adapter<ResepAdapter.ResepViewHolder> {
    private List<DataResep> listUnsur = new ArrayList<>();

    public ResepAdapter(List<DataResep>listUnsur){
        this.listUnsur=listUnsur;
    }

    private OnUnsClickListener listener;

    public interface OnUnsClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnUnsClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public ResepViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.activity_resep,viewGroup,false);
        ResepViewHolder viewHolder = new ResepViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResepViewHolder ResepViewHolder, int i) {
        DataResep item=listUnsur.get(i);
        ResepViewHolder.namaUnsur.setText(item.getNamaUnsur());
        ResepViewHolder.gbrUnsur.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return listUnsur.size();
    }

    public void filterList(List<DataResep> filteredList){
        listUnsur = filteredList;
        notifyDataSetChanged();
    }

    public class ResepViewHolder extends RecyclerView.ViewHolder{
        public ImageView gbrUnsur;
        public TextView namaUnsur;

        public ResepViewHolder(@NonNull View itemView){
            super(itemView);
            gbrUnsur=itemView.findViewById(R.id.gbrUnsur);
            namaUnsur=itemView.findViewById(R.id.namaUnsur);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }



    //void setFilter(ArrayList<DataUnsur>filterList){
    //listUnsur.addAll(filterList);
    // notifyDataSetChanged();
    // }
}