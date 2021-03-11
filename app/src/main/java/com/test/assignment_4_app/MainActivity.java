package com.test.assignment_4_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] desert_names={"Atacama","Gobi","Mojave","Patagonian","Sahara"};

    int images[] = {R.drawable.atacama, R.drawable.gobi, R.drawable.mojave,R.drawable.patagonian,R.drawable.sahara};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Selection Screen");
        GridView  gridview = (GridView) findViewById(R.id.gridview);
        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),images,desert_names);
        gridview.setAdapter(customAdapter);
        gridview.setOnItemClickListener(new GridView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4){

                finish();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("name", desert_names[p3]);  // pass your values and retrieve them in the other Activity using keyName
                intent.putExtra("position",p3);
                startActivity(intent);

            }
        });

    }
}