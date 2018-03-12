package com.example.tae.myufc_app.more_ufc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.tae.myufc_app.MainActivity;
import com.example.tae.myufc_app.R;

public class MediaTab_Main extends AppCompatActivity {

    SharedPreferences sharedPref;
    Context context;
    String mediaURL;
    private VideoView videoView;
    private Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_tab__main);

        sharedPref = getSharedPreferences("MediaVideoURL", Context.MODE_PRIVATE);

        mediaURL = sharedPref.getString("mediaVideoURL", null);

        playVideo();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void playVideo()
    {
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath(mediaURL);
        videoView.start();

        btnClose = findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();

            }
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        videoView.stopPlayback();
    }
}
