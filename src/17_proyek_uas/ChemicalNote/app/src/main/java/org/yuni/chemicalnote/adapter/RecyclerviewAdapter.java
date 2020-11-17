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
import org.yuni.chemicalnote.DetailUnsur;
import org.yuni.chemicalnote.model.DataUnsur;

import java.util.ArrayList;
import java.util.List;


public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {

    Context context;
    List<DataUnsur> dataUnsurList;
    List<DataUnsur> filteredUnsurList;

    public RecyclerviewAdapter(Context context, List<DataUnsur> dataUnsurList) {
        this.context = context;
        this.dataUnsurList = dataUnsurList;
        this.filteredUnsurList = dataUnsurList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row_item, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, final int position) {

        holder.namaUnsur.setText(filteredUnsurList.get(position).getNamaUnsur());
        holder.gbrUnsur.setImageResource(filteredUnsurList.get(position).getImageUrl());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DetailUnsur.class);
                intent.putExtra("nmunsur", filteredUnsurList.get(position).getNamaUnsur());
                context.startActivity(intent);
                }
        });

        holder.gbrUnsur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Nama Clicked", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return filteredUnsurList.size();
    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {


        ImageView gbrUnsur;
        TextView namaUnsur;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            gbrUnsur = itemView.findViewById(R.id.gbrUnsur);
            namaUnsur = itemView.findViewById(R.id.namaUnsur);


        }
    }

    public Filter getFilter(){

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String Key = charSequence.toString();
                if(Key.isEmpty()){
                    filteredUnsurList = dataUnsurList;
                }
                else{

                    List<DataUnsur> lstFiltered = new ArrayList<>();
                    for(DataUnsur row: dataUnsurList){
                        if(row.getNamaUnsur().toLowerCase().contains(Key.toLowerCase())){
                            lstFiltered.add(row);

                        }
                    }

                    filteredUnsurList = lstFiltered;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUnsurList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredUnsurList = (List<DataUnsur>)filterResults.values;
                notifyDataSetChanged();

            }
        };

    }


}
