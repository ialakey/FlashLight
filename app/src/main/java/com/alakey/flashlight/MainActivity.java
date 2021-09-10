package com.alakey.flashlight;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button isGreen;
    private ImageView light;
    private FlashClass flashClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        init();
    }

    private void init()
    {
        isGreen = findViewById(R.id.buttonFlash);
        light = findViewById(R.id.imageGreen);
        flashClass = new FlashClass(this);

    }

    public void onClickFlash(View view) {
        if (flashClass.isFlash_status()){
            flashClass.flashOff();
            light.setVisibility(View.GONE);
            //iGreen.setBackgroundResource(R.drawable.circle_green);
        }
        else {
            flashClass.flashOn();
            light.setVisibility(View.VISIBLE);
        }
//        else {
//            flashClass.flashOn();
//            iGreen.setBackgroundResource(R.drawable.circle_red);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(flashClass.isFlash_status())
        {
            flashClass.flashOff();
        }
    }

    public void onClickCompass(View view) {
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }

    public void onClickFollow(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/i_alakey/"));
        startActivity(browserIntent);
    }
}