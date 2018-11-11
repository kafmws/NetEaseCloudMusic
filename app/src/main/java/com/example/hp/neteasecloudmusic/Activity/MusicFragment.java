package com.example.hp.neteasecloudmusic.Activity;

import com.example.hp.neteasecloudmusic.Adapter.RVMusicAdapter;
import com.example.hp.neteasecloudmusic.Data.RVMusicItem;
import com.example.hp.neteasecloudmusic.Data.StaticItem;
import com.example.hp.neteasecloudmusic.R;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MusicFragment extends Fragment {

    private RecyclerView rv_music;

    private List<RVMusicItem> RVMusicItemLists = new ArrayList<>();

    public static MusicFragment newInstance() {
        Bundle args = new Bundle();
//        args.putString("name", name);
        MusicFragment fragment = new MusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RVMusicItemLists.add(new StaticItem("本地音乐","237",R.drawable.item_icon));
        RVMusicItemLists.add(new StaticItem("最近播放","200",R.drawable.item_icon));
        RVMusicItemLists.add(new StaticItem("下载管理","23",R.drawable.item_icon));
        RVMusicItemLists.add(new StaticItem("我的电台","12",R.drawable.item_icon));
        RVMusicItemLists.add(new StaticItem("我的收藏","120",R.drawable.item_icon));
        RVMusicItemLists.add(new StaticItem("Sati 空间",null,R.drawable.item_icon));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.module_music_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_music = view.findViewById(R.id.rv_fgMusic);
        RecyclerView.Adapter adapter = new RVMusicAdapter(RVMusicItemLists);
        rv_music.setAdapter(adapter);
        rv_music.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_music.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        Bundle bundle = getArguments();
    }

    public RecyclerView getRv_music() {
        return rv_music;
    }
}
