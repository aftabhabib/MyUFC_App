package com.example.tae.myufc_app.octagon_girls.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TAE on 06-Mar-18.
 */

public class OctagonGirlGalleryTab_Adapter extends RecyclerView.Adapter<OctagonGirlGalleryTab_Adapter.MyViewHolder>{

    private Context applicationContext;
    private int row;
    private List<OctagonGirl> result;


    public OctagonGirlGalleryTab_Adapter(Context applicationContext, List<OctagonGirl> result, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           return new MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row,parent,false)));
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName.setText(" " + result.get(position).getFirstName() + "\n   " + result.get(position).getLastName() + " ");
        Context context = holder.tImgView.getContext();

        if (result.get(position).getLargeProfilePicture() != null) {
            Picasso.with(context)
                    .load(result.get(position).getLargeBodyPicture())
                    .into(holder.tImgView);
        }

        else {
            Picasso.with(context)
                    .load(result.get(position).getMediumProfilePicture())
                    .into(holder.tImgView);
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tName;
        private ImageView tImgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgView = itemView.findViewById(R.id.tImgView);
        }
    }
}
