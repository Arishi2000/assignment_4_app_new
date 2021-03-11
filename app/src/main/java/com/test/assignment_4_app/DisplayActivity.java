package com.test.assignment_4_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    int images[] = {R.drawable.atacama, R.drawable.gobi, R.drawable.mojave,R.drawable.patagonian,R.drawable.sahara};
    TextView txt_name;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // here we are settong title for screen
        this.setTitle("Display Screen");

        // this below line to show back button on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_name=findViewById(R.id.txt_name);
        img=findViewById(R.id.desert_img);

        // here we are creating bundle to get values from selection activity that we have passed when user click on spinner item

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            // here we are setting values by getting with their key
          txt_name.setText(extras.getString("name"));
          img.setImageResource(images[extras.getInt("position")]);

        }


    }

    // this code is to handle top back button click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:

                // here we are starting selection activity again when user press back on top actionbar
               finish();
               startActivity(new Intent(DisplayActivity.this,MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // this side is to handle back press event from bottom navigation view
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        // here we are starting selection activity again when user press back
        startActivity(new Intent(DisplayActivity.this,MainActivity.class));

    }
}