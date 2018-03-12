package com.example.tae.myufc_app.main_events.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.MainActivity;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.EventsDetails;

import java.util.List;

/**
 * Created by TAE on 09-Mar-18.
 */

public class EventsDetails_Adapter extends RecyclerView.Adapter<EventsDetails_Adapter.MyViewHolder> {

    private Context applicationContext;
    private int row;
    private List<EventsDetails> result;

    public EventsDetails_Adapter(Context applicationContext, List<EventsDetails> result, int row) {
        this.applicationContext = applicationContext;
        this.row = row;
        this.result = result;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsDetails_Adapter.MyViewHolder((LayoutInflater.from(parent.getContext()).inflate(row, parent, false)));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tName1.setText(result.get(position).getFighter1LastName());
        holder.tName2.setText(result.get(position).getFighter2LastName());

      //  holder.tTitle.setText(result.get(position).getTitleTagLine());
      //  holder.tDate.setText("Date: " + result.get(position).getEndEventDategmt().substring(0, 10));
     //   holder.tTime.setText("Time: " + result.get(position).getEndEventDategmt().substring(12, 16) + "pm");

      //  Context context = holder.tImgView.getContext();

       // if (result.get(position).getFeatureImage() != ""){
      //      Picasso.with(context)
      //              .load(result.get(position).getFeatureImage())
      //              .into(holder.tImgView);
        }

     //   else if (result.get(position).getFeatureImage() == ""
         //       && result.get(position).getSecondaryFeatureImage() != "") {
        //    Picasso.with(context)
         //           .load(result.get(position).getSecondaryFeatureImage())
          //          .into(holder.tImgView);
     //   }

      //  else
      //      {
       //     Picasso.with(context)
         //       .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
        //        .into(holder.tImgView);
       // }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tName1, tName2, tDesc, tDate, tTitle, tTime;
        private ImageView tImgViewF1, tImgViewF2;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName1 = itemView.findViewById(R.id.tName);
            tName2 = itemView.findViewById(R.id.tName2);
            tImgViewF1 = itemView.findViewById(R.id.tImgView);
            tImgViewF2 = itemView.findViewById(R.id.tImgViewF2);
         //   tImgView = itemView.findViewById(R.id.tImgView);
          //  tDesc = itemView.findViewById(R.id.tDesc);
           // tDate = itemView.findViewById(R.id.tDate);
         //   tTitle = itemView.findViewById(R.id.tTitle);
          //  tTime = itemView.findViewById(R.id.tTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                 //   int id = result.get(pos).getId();


                    if (pos != RecyclerView.NO_POSITION) {
                      //  SharedPreferences sharedPref = applicationContext.getSharedPreferences("EventDetails", MODE_PRIVATE);
                     //   SharedPreferences.Editor editor = sharedPref.edit();
                     //   editor.putInt("event_id", id);
                     //   editor.commit();

                      //  MainActivity.loadEventDetailsFragment();
                    }
                }
            });
        }
    }
}