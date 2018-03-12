package com.example.tae.myufc_app.more_ufc;

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
import com.example.tae.myufc_app.data.network.model.Medium;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TAE on 08-Mar-18.
 */

public class MediaTab_Adapter extends RecyclerView.Adapter<MediaTab_Adapter.MyViewHolder> {
    private Context applicationContext;
    private int row;
    private List<Medium> result;

    public MediaTab_Adapter(Context applicationContext, List<Medium> result, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MediaTab_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row,parent,false)));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName.setText(" "+result.get(position).getTitle());
        holder.tDesc.setText(result.get(position).getDescription());
        holder.tDate.setText(" Date: " + result.get(position).getCreated().substring(0,10)
        + " \n" + " Time: " + result.get(position).getCreated().substring(12,19) + " pm ");

        Context context = holder.tImgView.getContext();

        if (result.get(position).getThumbnail() != null) {
            Picasso.with(context)
                    .load(result.get(position).getThumbnail())
                    .into(holder.tImgView);
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tName, tDesc, tDate;
        private ImageView tImgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgView = itemView.findViewById(R.id.tImgView);
            tDesc = itemView.findViewById(R.id.tDesc);
            tDate = itemView.findViewById(R.id.tDate);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();

                    String urlStream = (result.get(pos).getMobileVideoUrl());

                    if(pos != RecyclerView.NO_POSITION)
                    {
                        //SharedPreferences sharedPref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE);
                       // SharedPreferences.Editor editor = sharedPref.edit();
                        //editor.putString("urlStream", urlStream);
                      //  editor.commit();

                        //MainActivity.playMediaVideo(urlStream);

                        SharedPreferences sharedPref = applicationContext.getSharedPreferences("MediaVideoURL", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("mediaVideoURL", urlStream);
                        editor.commit();

                        Intent intent = new Intent(MyApp.getInstance().getAppContext(), MediaTab_Main.class);
                        MyApp.getInstance().getAppContext().startActivity(intent);

                    }
                    }

            });
        }
    }
}
