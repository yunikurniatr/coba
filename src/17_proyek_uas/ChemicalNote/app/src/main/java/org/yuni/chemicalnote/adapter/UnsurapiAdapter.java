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

public class UnsurapiAdapter extends RecyclerView.Adapter<UnsurapiAdapter.MyViewHolder> implements Filterable {

    private List<UnsurwApi> unsurwApiList;
    private List<UnsurwApi> unsurwApiListFiltered;
    private Context context;

    private OnUnsClickListener listener;

    public void setMovieList(Context context,final List<UnsurwApi> unsurwApiList){
        this.context = context;
        if(this.unsurwApiList == null){
            this.unsurwApiList = unsurwApiList;
            this.unsurwApiListFiltered = unsurwApiList;
            notifyItemChanged(0, unsurwApiListFiltered.size());
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
            this.unsurwApiListFiltered = unsurwApiList;
            result.dispatchUpdatesTo(this);
        }
    }

    public interface OnUnsClickListener {
        public void onClick(View view, int position);
    }

    public void setListener(OnUnsClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.recyclerview_row_item,viewGroup,false);
        MyViewHolder viewHolder = new MyViewHolder(vh);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder MyViewHolder, int i) {
        MyViewHolder.namaUns.setText(unsurwApiListFiltered.get(i).getName());
        MyViewHolder.kat.setText(unsurwApiListFiltered.get(i).getCategory());
        MyViewHolder.symboll.setText(unsurwApiListFiltered.get(i).getSymbol());
        // Glide.with(context).load(movieListFiltered.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);

        UnsurwApi unsurwApi = unsurwApiListFiltered.get(i);



    }

    @Override
    public int getItemCount() {
        if(unsurwApiList != null){
            return unsurwApiListFiltered.size();
        } else {
            return 0;
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    unsurwApiListFiltered = unsurwApiList;
                } else {
                    List<UnsurwApi> filteredList = new ArrayList<>();
                    for (UnsurwApi unsurwApi : unsurwApiList) {
                        if (unsurwApi.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(unsurwApi);
                        }
                    }
                    unsurwApiListFiltered = filteredList;

                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = unsurwApiListFiltered;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                unsurwApiListFiltered = (ArrayList<UnsurwApi>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView namaUns, kat, symboll;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            namaUns=itemView.findViewById(R.id.namaUnsur);
            kat=itemView.findViewById(R.id.kat);
            symboll=itemView.findViewById(R.id.symboll);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    listener.onClick(v, getAdapterPosition());
                }
            });
        }
    }
}
