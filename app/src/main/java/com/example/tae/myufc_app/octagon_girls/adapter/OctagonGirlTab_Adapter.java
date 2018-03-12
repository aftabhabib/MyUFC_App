package com.example.tae.myufc_app.octagon_girls.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tae.myufc_app.MainActivity;
import com.example.tae.myufc_app.MyApp;
import com.example.tae.myufc_app.R;
import com.example.tae.myufc_app.data.network.model.OctagonGirl;
import com.example.tae.myufc_app.octagon_girls.octagon_girls_details.OctagonGirlsDetails_Main;
import com.squareup.picasso.Picasso;

import java.util.List;

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

        holder.tName.setText("  " + result.get(position).getFirstName() + "\n  " + result.get(position).getLastName() + "  ");
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

        private TextView tName;
        private ImageView tImgView;

        public MyViewHolder(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.tName);
            tImgView = itemView.findViewById(R.id.tImgView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
               public void onClick(View view) {
                    int pos = getAdapterPosition();
                    // int id = result.get(pos).getId();
                    String name = (" ABOUT  " + result.get(pos).getFirstName() + " " + result.get(pos).getLastName());
                    String quote = result.get(pos).getQuote();
                    String food = result.get(pos).getFavoriteFoods();
                    String height = (result.get(pos).getHeight().toString() + " cm");
                    String weight = (result.get(pos).getWeight().toString() + " lb");
                    String website = result.get(pos).getWebsiteurl().toString();
                    String img = result.get(pos).getLargeBodyPicture();
                    String youtube = result.get(pos).getYoutubeChannelurl();


                    //check if item still exits
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        SharedPreferences sharedPref = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("name", name);
                        editor.putString("quote", quote);
                        editor.putString("food", food);
                        editor.putString("height", height);
                        editor.putString("weight", weight);
                        editor.putString("website", website);
                        editor.putString("img", img);
                        editor.putString("youtube", youtube);
                        editor.commit();

                       // MainActivity.loadOctagonGirlsDetailsFragment();
                        Intent intent = new Intent(MyApp.getInstance().getAppContext(), OctagonGirlsDetails_Main.class);
                        MyApp.getInstance().getAppContext().startActivity(intent);

                    }
                }
            });
        }
    }
}
