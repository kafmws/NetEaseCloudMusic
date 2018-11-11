package com.example.hp.neteasecloudmusic.Data;

import java.util.List;

public class PlayListData {

    /**
     * result : SUCCESS
     * code : 200
     * data : {"songListId":"2195440135","songListName":"粤语女声","songListPic":"https://p2.music.126.net/4Pu7M0q88fVVoo1ZFS_nmw==/3408486047237011.jpg","songListCount":48,"songListPlayCount":114,"songListDescription":null,"songListUserId":272278078,"songs":[{"id":"31152040","name":"绵绵","singer":"谢安琪","pic":"https://api.bzqll.com/music/netease/pic?id=31152040&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=31152040&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=31152040&key=579621905"},{"id":"316509","name":"飞女正传","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316509&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316509&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316509&key=579621905"},{"id":"307066","name":"狐狸你今天愉快吗","singer":"薛凯琪","pic":"https://api.bzqll.com/music/netease/pic?id=307066&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=307066&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=307066&key=579621905"},{"id":"316938","name":"再见二丁目","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316938&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316938&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316938&key=579621905"},{"id":"317145","name":"可惜我是水瓶座","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=317145&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=317145&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=317145&key=579621905"},{"id":"316686","name":"处处吻","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316686&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316686&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316686&key=579621905"},{"id":"276225","name":"夕阳之歌(Live) - live","singer":"梅艳芳","pic":"https://api.bzqll.com/music/netease/pic?id=276225&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=276225&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=276225&key=579621905"},{"id":"316486","name":"野孩子","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316486&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316486&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316486&key=579621905"},{"id":"316756","name":"小城大事","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316756&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316756&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316756&key=579621905"},{"id":"316498","name":"勇","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316498&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316498&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316498&key=579621905"}]}
     */

    private String result;
    private int code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * songListId : 2195440135
         * songListName : 粤语女声
         * songListPic : https://p2.music.126.net/4Pu7M0q88fVVoo1ZFS_nmw==/3408486047237011.jpg
         * songListCount : 48
         * songListPlayCount : 114
         * songListDescription : null
         * songListUserId : 272278078
         * songs : [{"id":"31152040","name":"绵绵","singer":"谢安琪","pic":"https://api.bzqll.com/music/netease/pic?id=31152040&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=31152040&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=31152040&key=579621905"},{"id":"316509","name":"飞女正传","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316509&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316509&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316509&key=579621905"},{"id":"307066","name":"狐狸你今天愉快吗","singer":"薛凯琪","pic":"https://api.bzqll.com/music/netease/pic?id=307066&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=307066&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=307066&key=579621905"},{"id":"316938","name":"再见二丁目","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316938&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316938&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316938&key=579621905"},{"id":"317145","name":"可惜我是水瓶座","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=317145&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=317145&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=317145&key=579621905"},{"id":"316686","name":"处处吻","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316686&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316686&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316686&key=579621905"},{"id":"276225","name":"夕阳之歌(Live) - live","singer":"梅艳芳","pic":"https://api.bzqll.com/music/netease/pic?id=276225&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=276225&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=276225&key=579621905"},{"id":"316486","name":"野孩子","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316486&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316486&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316486&key=579621905"},{"id":"316756","name":"小城大事","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316756&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316756&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316756&key=579621905"},{"id":"316498","name":"勇","singer":"杨千嬅","pic":"https://api.bzqll.com/music/netease/pic?id=316498&key=579621905","lrc":"https://api.bzqll.com/music/netease/lrc?id=316498&key=579621905","url":"https://api.bzqll.com/music/netease/url?id=316498&key=579621905"}]
         */

        private String songListId;
        private String songListName;
        private String songListPic;
        private int songListCount;
        private int songListPlayCount;
        private Object songListDescription;
        private int songListUserId;
        private List<SongsBean> songs;

        public String getSongListId() {
            return songListId;
        }

        public void setSongListId(String songListId) {
            this.songListId = songListId;
        }

        public String getSongListName() {
            return songListName;
        }

        public void setSongListName(String songListName) {
            this.songListName = songListName;
        }

        public String getSongListPic() {
            return songListPic;
        }

        public void setSongListPic(String songListPic) {
            this.songListPic = songListPic;
        }

        public int getSongListCount() {
            return songListCount;
        }

        public void setSongListCount(int songListCount) {
            this.songListCount = songListCount;
        }

        public int getSongListPlayCount() {
            return songListPlayCount;
        }

        public void setSongListPlayCount(int songListPlayCount) {
            this.songListPlayCount = songListPlayCount;
        }

        public Object getSongListDescription() {
            return songListDescription;
        }

        public void setSongListDescription(Object songListDescription) {
            this.songListDescription = songListDescription;
        }

        public int getSongListUserId() {
            return songListUserId;
        }

        public void setSongListUserId(int songListUserId) {
            this.songListUserId = songListUserId;
        }

        public List<SongsBean> getSongs() {
            return songs;
        }

        public void setSongs(List<SongsBean> songs) {
            this.songs = songs;
        }

        public static class SongsBean {
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
}
