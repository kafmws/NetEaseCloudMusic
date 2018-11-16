package com.example.hp.neteasecloudmusic.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.neteasecloudmusic.Activity.SearchActivity;
import com.example.hp.neteasecloudmusic.Data.SongBySearchData;
import com.example.hp.neteasecloudmusic.R;

import java.util.List;

public class RVSearchAdapter extends RecyclerView.Adapter<RVSearchAdapter.ViewHolder> {

    private SearchActivity activity;
    private List<SongBySearchData.Song> songs;

    public RVSearchAdapter(SearchActivity activity, List<SongBySearchData.Song> songs) {
        this.activity = activity;
        this.songs = songs;
    }

    public void setSongs(List<SongBySearchData.Song> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rv_song_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        SongBySearchData.Song song = songs.get(position);
        viewHolder.tv_song_name.setText(song.getName());
        viewHolder.tv_singer_name.setText(song.getSinger());
        viewHolder.iv_moreInfo.setImageResource(R.drawable.more_info);
        viewHolder.iv_moreInfo.setOnClickListener((view)->{
            Toast.makeText(activity,"okk",Toast.LENGTH_SHORT).show();
        });
        viewHolder.layout_song_item.setOnClickListener(v -> {
            Intent intent= new Intent();
            intent.putExtra("returnSongData", songs.get(position));
            activity.setResult(Activity.RESULT_OK,intent);
            activity.finish();
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout layout_song_item;

        private TextView tv_song_name;
        private TextView tv_singer_name;
        private ImageView iv_moreInfo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_song_item = itemView.findViewById(R.id.layout_song_item);
            tv_song_name = itemView.findViewById(R.id.tv_song_name);
            tv_singer_name = itemView.findViewById(R.id.tv_singer_name);
            iv_moreInfo = itemView.findViewById(R.id.iv_moreInfo);
        }
    }
}
