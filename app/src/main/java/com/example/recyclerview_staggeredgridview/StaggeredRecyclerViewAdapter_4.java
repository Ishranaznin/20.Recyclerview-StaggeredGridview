package com.example.recyclerview_staggeredgridview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class StaggeredRecyclerViewAdapter_4 extends RecyclerView.Adapter<StaggeredRecyclerViewAdapter_4.ViewHolder>{

    private static final String TAG = "StaggeredRecyclerViewAd";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mNames2 = new ArrayList<>();

    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mContext;
    public StaggeredRecyclerViewAdapter_4(  Context mContext,ArrayList<String> mNames,ArrayList<String> mNames2, ArrayList<String> mImageUrls ) {
        this.mContext = mContext;
        this.mNames = mNames;
        this.mNames2 = mNames2;
        this.mImageUrls = mImageUrls;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background);

        Glide.with(mContext)
                .load(mImageUrls.get(position))
                .apply(requestOptions)
                .into(holder.image);

        holder.name.setText(mNames.get(position));holder.title.setText(mNames2.get(position));

    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageview_widget);
            this.name = itemView.findViewById(R.id.name_widget);
            this.title = itemView.findViewById(R.id.name_widget2);
        }
    }

}
