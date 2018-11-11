package com.example.hp.neteasecloudmusic.Data;

public class StaticItem extends RVMusicItem{//固定选项
    private static final int TYPE = 0;

    private int iconId;

    public StaticItem(String itemTitle, String itemNumber, int icon_id) {
        super(itemTitle, itemNumber);
        this.iconId = icon_id;
    }

    public int getTYPE() {
        return TYPE;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
