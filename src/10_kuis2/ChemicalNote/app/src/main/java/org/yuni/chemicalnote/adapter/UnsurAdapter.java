package org.yuni.chemicalnote.adapter;

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

import org.yuni.chemicalnote.R;
import org.yuni.chemicalnote.model.DataUnsur;

import java.util.ArrayList;
import java.util.List;


public class UnsurAdapter extends RecyclerView.Adapter<UnsurAdapter.UnsurViewHolder> {
    private List<DataUnsur> listUnsur = new ArrayList<>();

    public UnsurAdapter(List<DataUnsur>listUnsur){
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
    public UnsurViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_row_item,viewGroup,false);
        UnsurViewHolder viewHolder = new UnsurViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UnsurViewHolder UnsurViewHolder, int i) {
        DataUnsur item=listUnsur.get(i);
        UnsurViewHolder.namaUnsur.setText(item.getNamaUnsur());
        UnsurViewHolder.gbrUnsur.setImageResource(item.getImage());

    }

    @Override
    public int getItemCount() {
        return listUnsur.size();
    }

    public class UnsurViewHolder extends RecyclerView.ViewHolder{
        public ImageView gbrUnsur;
        public TextView namaUnsur;

        public UnsurViewHolder(@NonNull View itemView){
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