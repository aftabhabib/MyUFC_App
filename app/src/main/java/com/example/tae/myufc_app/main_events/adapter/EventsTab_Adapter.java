package com.example.tae.myufc_app.main_events.adapter;

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
import com.example.tae.myufc_app.data.network.model.Events;
import com.example.tae.myufc_app.main_events.event_details.Event_Details_Main;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by TAE on 09-Mar-18.
 */

public class EventsTab_Adapter extends RecyclerView.Adapter<EventsTab_Adapter.MyViewHolder> {

    private Context applicationContext;
    private int row;
    private List<Events> result;
    private static int limit = 23;

    public EventsTab_Adapter(Context applicationContext, List<Events> result, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsTab_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row, parent, false)));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.tName.setText(result.get(position).getBaseTitle() + "\n" + result.get(position).getArena());
        holder.tTitle.setText(result.get(position).getTitleTagLine());
        holder.tDate.setText("Date: " + result.get(position).getEventDategmt().substring(0, 10));
        holder.tTime.setText("Time: " + result.get(position).getEventDategmt().substring(12, 16) + "pm");

        Context context = holder.tImgView.getContext();

        if (result.get(position).getFeatureImage() != ""){
            Picasso.with(context)
                    .load(result.get(position).getFeatureImage())
                    .into(holder.tImgView);
        }

        else if (result.get(position).getFeatureImage() == ""
                && result.get(position).getSecondaryFeatureImage() != "") {
            Picasso.with(context)
                    .load(result.get(position).getSecondaryFeatureImage())
                    .into(holder.tImgView);
        }

        else
            {
            Picasso.with(context)
                .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
                .into(holder.tImgView);
        }
    }

    @Override
    public int getItemCount() {
        return Math.min(result.size(), limit) + 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tName, tDate, tTitle, tTime;
        private ImageView tImgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgView = itemView.findViewById(R.id.tImgView);
            tDate = itemView.findViewById(R.id.tWins);
            tTitle = itemView.findViewById(R.id.tTitle);
            tTime = itemView.findViewById(R.id.tTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    int id = result.get(pos).getId();
                    String name = (result.get(pos).getBaseTitle() + "\n" + result.get(pos).getArena());


                    if (pos != RecyclerView.NO_POSITION) {
                        SharedPreferences sharedPref = applicationContext.getSharedPreferences("EventDetails", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("event_id", id);
                        editor.putString("event_name", name);
                        editor.commit();


                        Intent intent = new Intent(MyApp.getInstance().getAppContext(), Event_Details_Main.class);
                        MyApp.getInstance().getAppContext().startActivity(intent);

                    }
                }
            });
        }
    }
}