package com.dxy.happy.bean;

import java.util.List;

/**
 * Created by 韩永光
 * on 2016/12/29 10:42.
 */
public class Fragment_KnowBean {

    /**
     * code : 1
     * height : 0
     * success : true
     * width : 0
     * data : [{"yuLinUser":null,"url":"http://www.yulin520.com/a2a/h/news/o/1992?a=1483412336594","reporterName":null,"indexImg":"","contentIntr":null,"click":1993,"title":"有奖征集 | 我有电影票，你有故事么？","star":144,"introduction":"在充满感恩、温暖与爱的圣诞期间，柠乐君将带你一起，踏上一段有笑有泪的《摆渡人》之旅。 ","replyTimes":2,"img":"http://img1.yulin520.com/news/RVH92M4H4F50O7XS0G4C.jpg#450_1125","startTime":null,"id":1992,"type":26}]
     * message : null
     */

    private int code;
    private int height;
    private boolean success;
    private int width;
    private Object message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * yuLinUser : null
         * url : http://www.yulin520.com/a2a/h/news/o/1992?a=1483412336594
         * reporterName : null
         * indexImg :
         * contentIntr : null
         * click : 1993
         * title : 有奖征集 | 我有电影票，你有故事么？
         * star : 144
         * introduction : 在充满感恩、温暖与爱的圣诞期间，柠乐君将带你一起，踏上一段有笑有泪的《摆渡人》之旅。
         * replyTimes : 2
         * img : http://img1.yulin520.com/news/RVH92M4H4F50O7XS0G4C.jpg#450_1125
         * startTime : null
         * id : 1992
         * type : 26
         */

        private Object yuLinUser;
        private String url;
        private Object reporterName;
        private String indexImg;
        private Object contentIntr;
        private int click;
        private String title;
        private int star;
        private String introduction;
        private int replyTimes;
        private String img;
        private Object startTime;
        private int id;
        private int type;

        public Object getYuLinUser() {
            return yuLinUser;
        }

        public void setYuLinUser(Object yuLinUser) {
            this.yuLinUser = yuLinUser;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getReporterName() {
            return reporterName;
        }

        public void setReporterName(Object reporterName) {
            this.reporterName = reporterName;
        }

        public String getIndexImg() {
            return indexImg;
        }

        public void setIndexImg(String indexImg) {
            this.indexImg = indexImg;
        }

        public Object getContentIntr() {
            return contentIntr;
        }

        public void setContentIntr(Object contentIntr) {
            this.contentIntr = contentIntr;
        }

        public int getClick() {
            return click;
        }

        public void setClick(int click) {
            this.click = click;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getStar() {
            return star;
        }

        public void setStar(int star) {
            this.star = star;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public int getReplyTimes() {
            return replyTimes;
        }

        public void setReplyTimes(int replyTimes) {
            this.replyTimes = replyTimes;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
