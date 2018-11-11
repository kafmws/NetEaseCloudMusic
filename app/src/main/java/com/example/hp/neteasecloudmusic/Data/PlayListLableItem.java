package com.example.hp.neteasecloudmusic.Data;

import java.util.List;

public class PlayListLableItem extends RVMusicItem{

    private static final int TYPE = 1;

    private List<PlayListItem> playListItemList;

    public PlayListLableItem(String itemTitle, String itemNumber, List<PlayListItem> playListItemList) {
        super(itemTitle, itemNumber);
        this.playListItemList = playListItemList;
    }

    public int getTYPE() {
        return TYPE;
    }

    public List<PlayListItem> getPlayListItemList() {
        return playListItemList;
    }

    public void setPlayListItemList(List<PlayListItem> playListItemList) {
        this.playListItemList = playListItemList;
    }
}
