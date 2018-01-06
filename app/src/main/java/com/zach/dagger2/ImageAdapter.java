package com.zach.dagger2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import com.zach.dagger2.utility.Constants;
import javax.inject.Inject;

/**
 * Created by Zach on 1/6/2018.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private String[] list = {Constants.IMAGE_ONE,Constants.IMAGE_TWO,Constants.IMAGE_THREE};
    private Picasso picasso;
    private Context context;


    @Inject
    public ImageAdapter(MainActivity context ,Picasso picasso){
        this.picasso =picasso;
        this.context = context;
    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
           picasso.load(list[position]).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }




    public class ImageViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
