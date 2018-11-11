package com.example.hp.neteasecloudmusic.Data;

import java.util.List;

public abstract class RVMusicItem {
    public static final int ITEM_STATIC = 0;
    public static final int ITEM_PLAYLIST = 1;
    public static final int ITEM_PLAYLIST_LABLE = 2;

    private String itemTitle;
    private String itemNumber;


    public RVMusicItem(String itemTitle, String itemNumber) {
        this.itemTitle = itemTitle;
        this.itemNumber = itemNumber;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    abstract public int getTYPE();
}

