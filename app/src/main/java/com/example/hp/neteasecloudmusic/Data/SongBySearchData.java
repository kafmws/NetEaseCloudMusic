package com.example.hp.neteasecloudmusic.Data;

import java.io.Serializable;
import java.util.List;

public class SongBySearchData {
    /**
     * result : SUCCESS
     * code : 200
     * data : [{"id":"31152040","name":"绵绵","singer":"谢安琪","pic":"https://api.bzqll.com/music/netease/pic?id=31152040&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=31152040&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=31152040&key=579621905"},{"id":"463352365","name":"绵绵 (Live)","singer":"AGA","pic":"https://api.bzqll.com/music/netease/pic?id=463352365&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=463352365&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=463352365&key=579621905"},{"id":"285777","name":"绵绵","singer":"如梦","pic":"https://api.bzqll.com/music/netease/pic?id=285777&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=285777&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=285777&key=579621905"},{"id":"500107579","name":"绵绵（Cover 谢安琪）","singer":"hata曾广豪","pic":"https://api.bzqll.com/music/netease/pic?id=500107579&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=500107579&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=500107579&key=579621905"},{"id":"499833078","name":"绵绵（Cover 谢安琪）","singer":"hata曾广豪","pic":"https://api.bzqll.com/music/netease/pic?id=499833078&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=499833078&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=499833078&key=579621905"},{"id":"541422908","name":"绵绵","singer":"姜君航","pic":"https://api.bzqll.com/music/netease/pic?id=541422908&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=541422908&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=541422908&key=579621905"},{"id":"556002551","name":"我在那一角落患过伤风/尤克里里指弹合奏（Cover 冯曦妤）","singer":"崔骏/绵绵","pic":"https://api.bzqll.com/music/netease/pic?id=556002551&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=556002551&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=556002551&key=579621905"},{"id":"479611616","name":"绵绵","singer":"丹一","pic":"https://api.bzqll.com/music/netease/pic?id=479611616&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=479611616&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=479611616&key=579621905"},{"id":"479679947","name":"Always With Me/尤克里里&吉他合奏（Cover 木村弓）","singer":"崔骏/绵绵","pic":"https://api.bzqll.com/music/netease/pic?id=479679947&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=479679947&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=479679947&key=579621905"},{"id":"542173113","name":"绵绵（童谣弹唱）","singer":"一蛙","pic":"https://api.bzqll.com/music/netease/pic?id=542173113&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=542173113&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=542173113&key=579621905"}]
     */

    private String result;
    private int code;
    private List<Song> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Song> getData() {
        return data;
    }

    public void setData(List<Song> data) {
        this.data = data;
    }

    public static class Song implements Serializable {
        /**
         * id : 31152040
         * name : 绵绵
         * singer : 谢安琪
         * pic : https://api.bzqll.com/music/netease/pic?id=31152040&key=579621905
         * lrc : https://api.bzqll.com/music/netease/lrc?id=31152040&key=579621905
         * url : https://api.bzqll.com/music/netease/url?id=31152040&key=579621905
         */

        private String id;
        private String name;
        private String singer;
        private String pic;
        private String lrc;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getLrc() {
            return lrc;
        }

        public void setLrc(String lrc) {
            this.lrc = lrc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
