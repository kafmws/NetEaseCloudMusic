package com.example.hp.neteasecloudmusic.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.neteasecloudmusic.Data.RVMusicItem;
import com.example.hp.neteasecloudmusic.Data.StaticItem;
import com.example.hp.neteasecloudmusic.R;

import java.util.List;

public class RVMusicAdapter extends RecyclerView.Adapter<RVMusicAdapter.ViewHolder> {

    private List<RVMusicItem> dataList;


    public RVMusicAdapter(List<RVMusicItem> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RVMusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = null;
        ViewHolder holder = null;
        int choosedResourceId = 0;
        switch (viewType){
            case RVMusicItem.ITEM_STATIC:
                view = inflater.inflate(R.layout.rv_static_item,viewGroup,false);
                holder = new StaticViewHolder(view);
                break;
            case RVMusicItem.ITEM_PLAYLIST:
                view = inflater.inflate(R.layout.rv_playlist_item,viewGroup,false);
                holder = new PlayListViewHolder(view);
                break;
            case RVMusicItem.ITEM_PLAYLIST_LABLE:
                view = inflater.inflate(R.layout.rv_playlistlable_item,viewGroup,false);
                holder = new PlayListLableViewHolder(view);
                break;
                default:
                    Log.e("ERROR","unknown viewType");
        }
        view.setOnClickListener(new View.OnClickListener() {//将item作为一个整体监听
            @Override
            public void onClick(View v) {

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVMusicAdapter.ViewHolder viewHolder, int position) {
        RVMusicItem item = dataList.get(position);
        switch (item.getTYPE()){
            case RVMusicItem.ITEM_STATIC:
                viewHolder.tv_title.setText(item.getItemTitle());
                ((StaticViewHolder)viewHolder).tv_number.setText(item.getItemNumber()!=null?"("+item.getItemNumber()+")":"");
                ((StaticViewHolder)viewHolder).iv_icon.setImageResource(((StaticItem)item).getIconId());
                break;
            case RVMusicItem.ITEM_PLAYLIST:

                break;
            case RVMusicItem.ITEM_PLAYLIST_LABLE:

                break;
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getTYPE();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }

    static class StaticViewHolder extends ViewHolder{

        private TextView tv_number;
        private ImageView iv_icon;

        public StaticViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_number = itemView.findViewById(R.id.tv_number);
            iv_icon = itemView.findViewById(R.id.iv_icon);
        }
    }

    static class PlayListViewHolder extends ViewHolder{

        private TextView tv_number;

        public PlayListViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_number = itemView.findViewById(R.id.tv_number);
        }
    }

    static class PlayListLableViewHolder extends ViewHolder{

        public PlayListLableViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
