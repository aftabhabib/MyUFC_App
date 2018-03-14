package com.example.tae.myufc_app.fighters.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.Fighters;
import com.example.tae.myufc_app.fighters.Fighters_View_Activity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TAE on 14-Mar-18.
 */

public class Fighters_Adapter extends RecyclerView.Adapter<Fighters_Adapter.MyViewHolder>{

    private Context applicationContext;
    private int row;
    private List<Fighters> result;

    public Fighters_Adapter(Context applicationContext, int row, List<Fighters> result) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Fighters_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row, parent, false)));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName.setText(result.get(position).getFirstName() + " '" + result.get(position).getNickname() + "' " + result.get(position).getLastName());
        holder.tWins.setText("WINS: " + result.get(position).getWins());
        holder.tDraws.setText("DRAWS: " + result.get(position).getDraws());
        holder.tLosses.setText("LOSSES: " + result.get(position).getLosses());

        Context context = holder.tImgV.getContext();

        if (result.get(position).getBeltThumbnail() != ""){
            Picasso.with(context)
                    .load(result.get(position).getBeltThumbnail())
                    .into(holder.tImgV);
        }

        else if (result.get(position).getBeltThumbnail() == "" || result.get(position).getProfileImage() != "")
        {
            Picasso.with(context)
                    .load(result.get(position).getProfileImage())
                    .into(holder.tImgV);
        }

        else
        {
            Picasso.with(context)
                    .load(result.get(position).getBeltThumbnail())
                    .into(holder.tImgV);
        }

    }

    @Override
    public int getItemCount() {

        if (result.size() != 0 && result != null) {
            return result.size();
        }
        else return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tName, tWins, tDraws, tLosses;
        private ImageView tImgV;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgV = itemView.findViewById(R.id.tImgV);
            tWins = itemView.findViewById(R.id.tWins);
            tLosses = itemView.findViewById(R.id.tLosses);
            tDraws = itemView.findViewById(R.id.tDraws);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    int id = result.get(pos).getId();
                    // String name = (result.get(pos).getBaseTitle() + "\n" + result.get(pos).getArena());


                    if (pos != RecyclerView.NO_POSITION) {
                        SharedPreferences sharedPref = applicationContext.getSharedPreferences("ViewFighter", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("fighter_details", id);
                        editor.commit();


                        Intent intent = new Intent(MyApp.getInstance().getAppContext(), Fighters_View_Activity.class);
                        MyApp.getInstance().getAppContext().startActivity(intent);

                    }
                }
            });
        }


    }
}
