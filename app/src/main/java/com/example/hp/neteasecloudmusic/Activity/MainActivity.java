package com.example.hp.neteasecloudmusic.Activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hp.neteasecloudmusic.Adapter.ViewPagerAdapter;
import com.example.hp.neteasecloudmusic.Data.SongBySearchData;
import com.example.hp.neteasecloudmusic.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;

    private Button btn_music;
    private Button btn_musicCloud;
    private Button btn_video;
    private Button btn_list;
    private Button btn_search;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    private ImageView iv_album_pic;
    private TextView tv_song_name;
    private TextView tv_singer_name;
    private Button btn_play;
    private Button btn_playList;

//    private List<RVMusicItem> RVMusicItemLists = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private static MediaPlayer player;
    private SongBySearchData.Song song;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_main_activity);

        drawerLayout  = findViewById(R.id.dl_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

//        intiStaticRVMusicLists();
        initialize();
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager = findViewById(R.id.vp_main);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) { }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:highLightButton(btn_music);break;
                    case 1:highLightButton(btn_musicCloud);break;
                    case 2:highLightButton(btn_video);break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) { }
        });

        btn_music = findViewById(R.id.btn_music);
        btn_musicCloud = findViewById(R.id.btn_musicCloud);
        btn_video = findViewById(R.id.btn_video);
        btn_search = findViewById(R.id.btn_search);
        btn_play = findViewById(R.id.btn_play);
        btn_playList = findViewById(R.id.btn_playList);
        btn_list = findViewById(R.id.btn_list);
        iv_album_pic = findViewById(R.id.iv_album_pic);
        tv_song_name = findViewById(R.id.tv_song_name);
        tv_singer_name = findViewById(R.id.tv_singer_name);

        btn_music.setOnClickListener(this);
        btn_musicCloud.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        btn_search.setOnClickListener(this);
        btn_play.setOnClickListener(this);
        btn_playList.setOnClickListener(this);
        btn_list.setOnClickListener(this);

        highLightButton(btn_music);

        Fragment currentFragment = viewPagerAdapter.getCurrentFragment();
        Log.e("MainActivity",currentFragment==null?"得到当前fragment为空":currentFragment.toString());
        if(song!=null){
            tv_song_name.setText(song.getName());
            tv_singer_name.setText(song.getSinger());
            Glide.with(this).load(song.getPic()).into(iv_album_pic);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_music:
            case R.id.btn_musicCloud:
            case R.id.btn_video:
                highLightButton((Button) v);
                chooseFragment((Button) v);
                break;
            case R.id.btn_play:
                changePlayerStatus();
                break;
            case R.id.btn_search:
                startActivityForResult(new Intent(this,SearchActivity.class), 0);
                break;
            case R.id.btn_list:
                drawerLayout.openDrawer(Gravity.START);
                break;
        }



    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {//判断数据来源，requestCode在startActivityForResult时传入
            case 0:
            if (resultCode == RESULT_OK) {//判断数据返回状态
                song = (SongBySearchData.Song) data.getSerializableExtra("returnSongData");
                tv_song_name.setText(song.getName());
                tv_singer_name.setText(song.getSinger());
                Glide.with(this).load(song.getPic()).into(iv_album_pic);
                initMediaPlayer(Uri.parse(song.getUrl()));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onStop() {
        super.onStop();
        saveCurrentSong();
        if (player != null) {
            player.release();
            player = null;
        }
    }

////////////////////function


    private void saveCurrentSong(){
        if(song == null)
            return;
        SharedPreferences.Editor editor = getSharedPreferences("Song",MODE_PRIVATE).edit();
        String text = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(song);
            text = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString("Song",text);
        editor.apply();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void highLightButton(Button button){
        btn_music.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);//Mode.DARKEN
        btn_musicCloud.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);//Mode.DARKEN
        btn_video.setBackgroundTintMode(PorterDuff.Mode.MULTIPLY);
        button.setBackgroundTintMode(PorterDuff.Mode.SRC_IN);
    }

    @SuppressLint("NewApi")
    private void chooseFragment(Button button){
        switch (button.getId()){
            case R.id.btn_music:
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_musicCloud:
                viewPager.setCurrentItem(1);
                break;
            case R.id.btn_video:
                viewPager.setCurrentItem(2);
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void changePlayerStatus() {
        if(player == null)
            initMediaPlayer(Uri.parse(song.getUrl()));
        if (player.isPlaying()) {
//            player.stop();
            player.pause();
            btn_play.setBackgroundResource(R.drawable.play);
            tv_song_name.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            player.start();
            btn_play.setBackgroundResource(R.drawable.pause);
            tv_song_name.setEllipsize(TextUtils.TruncateAt.MARQUEE);
//            player.prepareAsync();
        }
    }





//    private void intiStaticRVMusicLists() {
//        RVMusicItemLists.add(new StaticItem("本地音乐","237",R.drawable.item_icon));
//        RVMusicItemLists.add(new StaticItem("最近播放","200",R.drawable.item_icon));
//        RVMusicItemLists.add(new StaticItem("下载管理","23",R.drawable.item_icon));
//        RVMusicItemLists.add(new StaticItem("我的电台","12",R.drawable.item_icon));
//        RVMusicItemLists.add(new StaticItem("我的收藏","120",R.drawable.item_icon));
//        RVMusicItemLists.add(new StaticItem("Sati 空间",null,R.drawable.item_icon));
//    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initMediaPlayer(Uri songUrl) {
        if(player == null)
            player = new MediaPlayer();
        else
            player.reset();
        if(songUrl!=null) {
            try {
                player.setDataSource(this,songUrl);
                player.prepareAsync();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        player.setAudioAttributes(new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());
        player.setOnPreparedListener(mp -> {
            mp.start();
            btn_play.setBackgroundResource(R.drawable.pause);
        });
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {

                return false;
            }
        });
        player.setOnCompletionListener((mp)->{
            mp.start();
        });
    }

    private void intiFragmentList() {
        fragmentList.add(MusicFragment.newInstance());
        fragmentList.add(TestFragment.newInstance("laji"));
        fragmentList.add(TestFragment.newInstance("video"));
    }


    private void initialize() {
        intiFragmentList();
        String text = getSharedPreferences("Song",MODE_PRIVATE).getString("Song",null);
        if(text!=null){
            ByteArrayInputStream bis = new ByteArrayInputStream(android.util.Base64.decode(text,Base64.NO_PADDING));
            try {
                ObjectInputStream ois = new ObjectInputStream(bis);
                song = (SongBySearchData.Song) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
