package com.example.hp.neteasecloudmusic.Helper;

import com.example.hp.neteasecloudmusic.Data.SongBySearchData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class ResponseDataPraser {

    private static Gson praser = new Gson();

    public static List<SongBySearchData.Song> SongBySearchDataPraser(String data){
        List<SongBySearchData.Song> list = ((SongBySearchData)(praser.fromJson(data,new TypeToken<SongBySearchData>() {
        }.getType()))).getData();
        return list==null?new ArrayList<SongBySearchData.Song>():list;
    }

//    public static boolean SongBySearchDataPraser(String data, List<SongBySearchData.Song> obj){
//        List<SongBySearchData.Song> songList= ((SongBySearchData)(praser.fromJson(data,new TypeToken<SongBySearchData>() {
//        }.getType()))).getData();
//        obj = songList == null?obj:songList;
//        return songList==null;
//    }

}
