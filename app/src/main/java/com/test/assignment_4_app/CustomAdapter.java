package com.test.assignment_4_app;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int images[];
    String[] names;

    LayoutInflater inflter;
    public  static  ImageView img;

    // this is constructor if custom adapter class in which we are passing context , images and name
    public CustomAdapter(Context applicationContext, int[] images, String[] desert_name) {
        this.context = applicationContext;
        this.images = images;
        this.names = desert_name;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    // here in below code we are inflating custom view that we have created for showing text and image into gridview
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_row, null);
        img = (ImageView) view.findViewById(R.id.desert_img);
        TextView txt_name = (TextView) view.findViewById(R.id.desert_name);
        img.setImageResource(images[i]);
        txt_name.setText(names[i]);
        return view;
    }

}
