package com.dxy.happy.bean;

import java.util.List;

/**
 * Created by 韩永光
 * on 2017/1/4 22:08.
 */
public class HomeCommunityBean {

    private int code;
    private boolean success;
    private int height;
    private int width;
    private Object message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
         * createTime : 1482389782000
         * yulin : 93364
         * floor : 1楼
         * floorReplyTimes : 0
         * forumId : 10441
         * frmList : []
         * phone :
         * headImg : http://photo-60481.oss-cn-shenzhen.aliyuncs.com/%E6%99%93%E4%B8%BD%E5%A4%B4%E5%83%8F3/123.jpg
         * userRole : null
         * imgs : []
         * userId : 7751
         * userName : 琉璃心i
         * id : 26277
         * host : 0
         * content : 异地恋除了冷爆力该怎么办呢
         */

        private long createTime;
        private String yulin;
        private String floor;
        private int floorReplyTimes;
        private int forumId;
        private String phone;
        private String headImg;
        private Object userRole;
        private int userId;
        private String userName;
        private int id;
        private int host;
        private String content;
        private List<?> frmList;
        private List<?> imgs;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getYulin() {
            return yulin;
        }

        public void setYulin(String yulin) {
            this.yulin = yulin;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public int getFloorReplyTimes() {
            return floorReplyTimes;
        }

        public void setFloorReplyTimes(int floorReplyTimes) {
            this.floorReplyTimes = floorReplyTimes;
        }

        public int getForumId() {
            return forumId;
        }

        public void setForumId(int forumId) {
            this.forumId = forumId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public Object getUserRole() {
            return userRole;
        }

        public void setUserRole(Object userRole) {
            this.userRole = userRole;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getHost() {
            return host;
        }

        public void setHost(int host) {
            this.host = host;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<?> getFrmList() {
            return frmList;
        }

        public void setFrmList(List<?> frmList) {
            this.frmList = frmList;
        }

        public List<?> getImgs() {
            return imgs;
        }

        public void setImgs(List<?> imgs) {
            this.imgs = imgs;
        }
    }
}
