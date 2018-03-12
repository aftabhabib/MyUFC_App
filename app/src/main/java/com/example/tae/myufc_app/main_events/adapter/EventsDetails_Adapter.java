package com.example.tae.myufc_app.main_events.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.EventsDetails;
import com.squareup.picasso.Picasso;

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

        if (result.get(position).getFighter1record() != null) {
            holder.tRecord1.setText(result.get(position).getFighter1record());
        }

        else if (result.get(position).getFighter1record() == null)
        {
            holder.tRecord1.setText("Not provided");
        }

        if (result.get(position).getFighter2record() != null)
        {
            holder.tRecord2.setText(result.get(position).getFighter2record());
        }

        else if (result.get(position).getFighter2record() == null)
        {
            holder.tRecord2.setText("Not provided");
        }


        holder.tHeight1.setText(result.get(position).getFighter1height().toString() + "cm");
        holder.tHeight2.setText(result.get(position).getFighter2height().toString() + "cm");

        if (result.get(position).getFighter1weight() != null) {
            holder.tWeight1.setText(result.get(position).getFighter1weight().toString() + "kg");
        }

        else if (result.get(position).getFighter1weight() == null)
        {
            holder.tWeight1.setText("Not Specified");
        }

        if (result.get(position).getFighter2weight() != null) {
            holder.tWeight2.setText(result.get(position).getFighter2weight().toString() + "kg");
        }

        else if (result.get(position).getFighter2weight() == null)
        {
            holder.tWeight2.setText("Not Specified");
        }


        Context context1 = holder.tImgViewF1.getContext();
        Context context2 = holder.tImgViewF2.getContext();

        if (result.get(position).getFighter1ProfileImage() != ""){
            Picasso.with(context1)
                    .load(result.get(position).getFighter1ProfileImage())
                    .into(holder.tImgViewF1);
        }

        else if (result.get(position).getFighter1ProfileImage() == ""
                && result.get(position).getFighter1FullBodyImage() != "") {
            Picasso.with(context1)
                    .load(result.get(position).getFighter1FullBodyImage())
                    .into(holder.tImgViewF1);
        }

        if (result.get(position).getFighter2ProfileImage() != ""){
            Picasso.with(context2)
                    .load(result.get(position).getFighter2ProfileImage())
                    .into(holder.tImgViewF2);
        }

        else if (result.get(position).getFighter2ProfileImage() == ""
                && result.get(position).getFighter2FullBodyImage() != "") {
            Picasso.with(context2)
                    .load(result.get(position).getFighter1FullBodyImage())
                    .into(holder.tImgViewF2);
        }

        else
        {
            Picasso.with(context1)
                    .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
                    .into(holder.tImgViewF1);

            Picasso.with(context2)
                    .load("https://www.fightful.com/sites/default/files/event-header/ufc-og-image_5.png")
                    .into(holder.tImgViewF2);
        }
    }


    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tName1, tName2, tRecord1,
                tRecord2, tHeight1, tHeight2, tWeight1, tWeight2;
        private ImageView tImgViewF1, tImgViewF2;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName1 = itemView.findViewById(R.id.tName);
            tName2 = itemView.findViewById(R.id.tName2);
            tImgViewF1 = itemView.findViewById(R.id.tImgView);
            tImgViewF2 = itemView.findViewById(R.id.tImgViewF2);
            tRecord1 = itemView.findViewById(R.id.tDate);
            tRecord2 = itemView.findViewById(R.id.f2_record);
            tHeight1 = itemView.findViewById(R.id.f1_height);
            tHeight2 = itemView.findViewById(R.id.f2_height);
            tWeight1 = itemView.findViewById(R.id.f1_weight);
            tWeight2 = itemView.findViewById(R.id.f2_weight);

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