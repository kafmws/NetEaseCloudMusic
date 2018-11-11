package com.example.hp.neteasecloudmusic.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hp.neteasecloudmusic.Adapter.RVSearchAdapter;
import com.example.hp.neteasecloudmusic.Data.SongBySearchData;
import com.example.hp.neteasecloudmusic.Helper.OkHttpHelper;
import com.example.hp.neteasecloudmusic.Helper.ResponseDataPraser;
import com.example.hp.neteasecloudmusic.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SearchActivity extends AppCompatActivity {

    private static int offset = 0;

    private ImageButton im_back;
    private EditText et_search;
    private RecyclerView rv_search;
    private ProgressBar pb_loading;


    private RVSearchAdapter adapter;
    private List<SongBySearchData.Song> songs = new ArrayList<>();
    private String searchKey = "song";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_search_activity);

        findViewById(R.id.im_back).setOnClickListener((v)->{
            finish();
        });

        et_search = findViewById(R.id.et_search);
        rv_search = findViewById(R.id.rv_search);
        pb_loading = findViewById(R.id.pb_loading);
        pb_loading.setVisibility(View.GONE);

        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    // 先隐藏键盘
                    ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(SearchActivity.this.getCurrentFocus()
                                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    //进行搜索操作的方法，在该方法中可以加入mEditSearchUser的非空判断
                    search(et_search.getText().toString(),true);
                }
                return false;
            }
        });

        adapter = new RVSearchAdapter(SearchActivity.this,songs);
        rv_search.setAdapter(adapter);
        rv_search.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        rv_search.addItemDecoration(new DividerItemDecoration(SearchActivity.this,DividerItemDecoration.VERTICAL));
        rv_search.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                int lastVisibleItemPosition = 0;
                if(manager instanceof LinearLayoutManager){
                    lastVisibleItemPosition = ((LinearLayoutManager)manager).findLastVisibleItemPosition();
                }
                if(adapter!=null){
                    if(newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItemPosition + 1 == adapter.getItemCount()){
                        search(et_search.getText().toString(),false);
                            pb_loading.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }


//isNew       true:  new data        false :          more data
    private void search(String content, boolean isNew) {
        if (isNew)
            offset = 0;
        String url = String.format("https://api.bzqll.com/music/netease/search?" +
                "key=579621905&s=%s&type=%s&limit=20&offset=%d",content, searchKey, offset);
        offset+=20;//为下拉加载准备
        OkHttpHelper.SendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseText = response.body().string();
                List<SongBySearchData.Song> tem;
                tem = ResponseDataPraser.SongBySearchDataPraser(responseText);
                runOnUiThread(()->{
                    pb_loading.setVisibility(View.GONE);
                    if(!isNew){//若下拉 且有新数据
                        songs.addAll(tem);
                    }else{//新数据
                        adapter.setSongs(songs=tem);
                    }
                    if(tem.size()!=0) {
                        adapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(SearchActivity.this,"没有更多数据了",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}