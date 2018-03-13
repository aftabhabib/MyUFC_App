package com.example.tae.myufc_app.main_events.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.News;
import com.example.tae.myufc_app.data.network.service.ApiList;
import com.example.tae.myufc_app.main_events.NewsDetail_Activity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TAE on 12-Mar-18.
 */

public class NewsTab_Adapter extends RecyclerView.Adapter<NewsTab_Adapter.MyViewHolder>{

    private Context applicationContext;
    private int row;
    private List<News> result;

    public NewsTab_Adapter(Context applicationContext,  int row, List<News> result) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsTab_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row, parent, false)));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName.setText(result.get(position).getTitle());
        holder.tAuthor.setText(result.get(position).getAuthor());
        holder.tDate.setText(" Date: " + result.get(position).getLastModified().substring(0,10)
                + " \n" + " Time: " + result.get(position).getLastModified().substring(12,16) + " pm ");


        Context context = holder.tImage.getContext();
        if (result.get(position).getThumbnail() != ""){
            Picasso.with(context)
                    .load(result.get(position).getThumbnail())
                    .into(holder.tImage);
        }

        else if (result.get(position).getThumbnail() == ""){
            Picasso.with(context)
                    .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
                    .into(holder.tImage);
        }

        else
        {
            Picasso.with(context)
                    .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
                    .into(holder.tImage);
        }

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tName, tDate, tAuthor;
        private ImageView tImage;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tDate = itemView.findViewById(R.id.tDate);
            tAuthor = itemView.findViewById(R.id.tAuthor);
            tImage = itemView.findViewById(R.id.tImgView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    int id = result.get(pos).getId();


                    if (pos != RecyclerView.NO_POSITION) {
                        String URL = ApiList.NEWS_URL + id;

                        SharedPreferences sharedPref = applicationContext.getSharedPreferences("NewsDetail", applicationContext.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("news_detail", URL);
                        editor.commit();

                        Intent intent = new Intent(MyApp.getInstance().getAppContext(), NewsDetail_Activity.class);
                        MyApp.getInstance().getAppContext().startActivity(intent);
                    }
                }
            });

        }
    }
}
