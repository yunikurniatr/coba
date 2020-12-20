package org.yuni.chemicalnote.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.yuni.chemicalnote.R;
import org.yuni.chemicalnote.UnsurwApi;

import java.util.ArrayList;
import java.util.List;

public class UnsurapiAdapter extends RecyclerView.Adapter<UnsurapiAdapter.MyViewHolder>  {

    private List<UnsurwApi> unsurwApiList;
    private Context context;

    private OnUnsClickListener listener;

    public interface OnUnsClickListener {
        public void onClick(View view, int position);
    }


    public void setUnsurList(Context context, final List<UnsurwApi> unsurwApiList) {
        this.context = context;
        if (this.unsurwApiList == null) {
            this.unsurwApiList = unsurwApiList;
            notifyItemChanged(0, unsurwApiList.size());
        } else {
            final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return UnsurapiAdapter.this.unsurwApiList.size();
                }

                @Override
                public int getNewListSize() {
                    return unsurwApiList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return UnsurapiAdapter.this.unsurwApiList.get(oldItemPosition).getName() == unsurwApiList.get(newItemPosition).getName();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    UnsurwApi newUnsurwApi = UnsurapiAdapter.this.unsurwApiList.get(oldItemPosition);

                    UnsurwApi oldUnsurwApi = unsurwApiList.get(newItemPosition);

                    return newUnsurwApi.getName() == oldUnsurwApi.getName();
                }
            });
            this.unsurwApiList = unsurwApiList;
            result.dispatchUpdatesTo(this);
        }
    }

    public void setListener(OnUnsClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_row_item, viewGroup, false);
        MyViewHolder viewHolder = new MyViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder MyViewHolder, int i) {
        UnsurwApi item = unsurwApiList.get(i);
        MyViewHolder.namaUns.setText(item.getName());
        MyViewHolder.kat.setText(item.getCategory());
        MyViewHolder.symboll.setText(item.getSymbol());
        MyViewHolder.numb.setText(item.getNumber());
    }

    @Override
    public int getItemCount() {
        if (unsurwApiList != null) {
            return unsurwApiList.size();
        } else {
            return 0;
        }
    }

    public void filterList(List<UnsurwApi> filteredList) {
        unsurwApiList = filteredList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView namaUns, kat, symboll, numb;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaUns = itemView.findViewById(R.id.namaUnsur);
            kat = itemView.findViewById(R.id.kat);
            symboll = itemView.findViewById(R.id.symboll);
            numb = itemView.findViewById(R.id.numb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
