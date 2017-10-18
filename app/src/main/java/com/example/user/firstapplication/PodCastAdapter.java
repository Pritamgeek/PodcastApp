package com.example.user.firstapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.user.firstapplication.R.*;
import static com.example.user.firstapplication.R.id.parent;

/**
 * Created by User on 15-10-2017.
 */

public class PodCastAdapter extends RecyclerView.Adapter<PodCastAdapter.PodCastViewHolder> {


    private List<PodCastModel> podcasts;
    private int rowLayout;
    private Context context;

    public static class PodCastViewHolder extends RecyclerView.ViewHolder {

        LinearLayout podcastlayout;
        TextView podcasttitle;
        TextView podcastsubtitle;
        ImageView albumimage;
        ImageView downmenu;
        ImageView playbutton;

        public PodCastViewHolder(View itemView) {
            super(itemView);
            podcastlayout = (LinearLayout) itemView.findViewById(id.podcastlayout);
            podcasttitle = (TextView) itemView.findViewById(id.podcasttitle);
            podcastsubtitle =(TextView)itemView.findViewById(id.podcastsubtitle);
            albumimage = (ImageView) itemView.findViewById(id.albumimage);
            downmenu = (ImageView)itemView.findViewById(id.downmenu);
            playbutton = (ImageView)itemView.findViewById(id.play);
            //albumimage.setOnClickListener(new View.OnClickListener() /*{
                //@Override
                //public void onClick(View v) {
                 //   Intent intent = new
              //  }*/
           // });
        }
    }

    public PodCastAdapter(List<PodCastModel> podcasts, int rowLayout, Context context) {
        this.podcasts = podcasts;
        this.rowLayout = rowLayout;
        this.context = context;

    }

    @Override
    public PodCastAdapter.PodCastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PodCastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PodCastAdapter.PodCastViewHolder holder, int position) {
        holder.podcasttitle.setText(podcasts.get(position).getArtistName());
        holder.podcastsubtitle.setText(podcasts.get(position).getTrackName());
        Uri uri = Uri.parse(podcasts.get(position).getArtworkUrl100());
        Context context = holder.albumimage.getContext();
        Picasso.with(context).load(uri).into(holder.albumimage);
        Uri playuri = Uri.parse("C:\\Users\\User\\AndroidStudioProjects\\FirstApplication\\app\\src\\main\\res\\drawable\\play.png");
       // holder.downmenu.setImageBitmap(R.id.downmenu);
        Picasso.with(context).load(playuri).into(holder.playbutton);
    }

    @Override
    public int getItemCount() {
        return podcasts.size();
    }
}
