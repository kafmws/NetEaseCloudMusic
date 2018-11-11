package com.example.hp.neteasecloudmusic.Helper;


import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public abstract class OkHttpHelper {

    public static void SendOkHttpRequest(String url, Callback callback){
        final String result = null;
            Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(callback);
        }
}
