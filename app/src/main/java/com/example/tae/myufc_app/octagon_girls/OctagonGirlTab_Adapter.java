package com.example.tae.myufc_app.octagon_girls;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tae.myufc_app.MainActivity;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.function.Consumer;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TAE on 06-Mar-18.
 */

public class OctagonGirlTab_Adapter extends RecyclerView.Adapter<OctagonGirlTab_Adapter.MyViewHolder>{

    private Context applicationContext;
    private int row;
    private List<OctagonGirl> result;

    public OctagonGirlTab_Adapter(Context applicationContext, List<OctagonGirl> result, int row) {
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
                    .load(result.get(position).getLargeProfilePicture())
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

        private TextView tName, tDateOB, tDescShort;
        private ImageView tImgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgView = itemView.findViewById(R.id.tImgView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View view) {
                    int pos = getAdapterPosition();
                    int id = result.get(pos).getId();
                    //GET IN BUNDLE ETC

                    //check if item still exits
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        OctagonGirl clickedDataItem = result.get(pos);
                        //MainActivity.OctagonGirlID(id, applicationContext);
//                        SharedPreferences sharedPreference =

                        SharedPreferences.Editor editor = applicationContext.getSharedPreferences("myPrefs", Context.MODE_PRIVATE).edit();
                        editor.putInt("id", id);
                        editor.apply();

                    }
                }
            });
        }
    }
}
