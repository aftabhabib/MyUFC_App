package com.example.tae.myufc_app.fighters.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.local_realm.model.TitleHoldersRealm;

import java.util.List;


/**
 * Created by TAE on 15-Mar-18.
 */

public class TitleHolder_Adapter_Realm extends RecyclerView.Adapter<TitleHolder_Adapter_Realm.MyViewHolder> {

    private Context applicationContext;
    private int row;
    private List<TitleHoldersRealm> resultDb;


    public TitleHolder_Adapter_Realm(Context applicationContext, List<TitleHoldersRealm> resultDb, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.resultDb = resultDb;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         return new TitleHolder_Adapter_Realm.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(row, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName.setText(resultDb.get(position).getName());
        holder.tWins.setText("WINS: " + resultDb.get(position).getWins());
        holder.tDraws.setText("DRAWS: " + resultDb.get(position).getDraws());
        holder.tLosses.setText("LOSSES: " + resultDb.get(position).getLosses());

        //Context context = holder.tImgV.getContext();

       // if (result.get(position).getBeltThumbnail() != "") {
         //   Picasso.with(context)
         //           .load(result.get(position).getBeltThumbnail())
         //          .into(holder.tImgV);
       // }

    }

    @Override
    public int getItemCount() {
        return resultDb.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tName, tWins, tDraws, tLosses;
        private ImageView tImgV;

        public MyViewHolder(View itemView) {
            super(itemView);
            tName = itemView.findViewById(R.id.tName);
            tImgV = itemView.findViewById(R.id.tImgV);
            tWins = itemView.findViewById(R.id.tWins);
            tLosses = itemView.findViewById(R.id.tLosses);
            tDraws = itemView.findViewById(R.id.tDraws);

        }
    }
}
