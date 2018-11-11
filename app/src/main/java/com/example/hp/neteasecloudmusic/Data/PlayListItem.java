package com.example.hp.neteasecloudmusic.Data;

public class PlayListItem extends RVMusicItem{

    private static final  int TYPE = 2;

    //appear
    private String pictureUrl;
    private String owner;


    //hidden
    private String ownerUID;
    private String playListID;

    public PlayListItem(String itemTitle, String itemNumber, String pictureUrl, String owner) {
        super(itemTitle, itemNumber);
        this.pictureUrl = pictureUrl;
        this.owner = owner;
    }

    public int getTYPE() {
        return TYPE;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
