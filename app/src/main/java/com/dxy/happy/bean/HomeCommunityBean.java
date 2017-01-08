package com.dxy.happy.bean;

import java.util.List;

/**
 * Created by 韩永光
 * on 2017/1/4 22:08.
 */
public class HomeCommunityBean {


    /**
     * code : 1
     * width : 0
     * height : 0
     * success : true
     * data : [{"frmList":[],"imgs":[],"floor":"1楼","floorReplyTimes":0,"userId":8433,"phone":"","forumId":10448,"createTime":1482480244000,"yulin":"95530","headImg":"http://photo-60481.oss-cn-shenzhen.aliyuncs.com/photo/20.gif","userRole":null,"userName":"louis-jiao","id":26290,"host":0,"content":"我和我老公在一起九年了，现在宝宝十个月了，我俩睡觉还是缠在一起，就是那种胳膊搂胳膊，腿压着腿的那种，晚上给宝宝喂奶不得不分开，他也是跟着过来手搭着我，总要有点接触的那种，所以主要还是看感情的"},{"frmList":[],"imgs":[],"floor":"2楼","floorReplyTimes":0,"userId":7808,"phone":"","forumId":10448,"createTime":1482485796000,"yulin":"93535","headImg":"http://photo-60481.oss-cn-shenzhen.aliyuncs.com/%E5%B0%8F%E5%AE%87%E7%9A%84%E5%A4%B4%E5%83%8F%E7%AC%AC%E4%BA%8C%E6%B3%A2/507.jpg","userRole":null,"userName":"陪君千里-","id":26291,"host":0,"content":"不用担心，你们没有几十年后那天的"},{"frmList":[],"imgs":[],"floor":"3楼","floorReplyTimes":0,"userId":7624,"phone":"","forumId":10448,"createTime":1482497713000,"yulin":"92983","headImg":"http://photo-60481.oss-cn-shenzhen.aliyuncs.com/%E6%99%93%E4%B8%BD%E5%A4%B4%E5%83%8F3/16.jpg","userRole":null,"userName":"此生卟渝","id":26292,"host":0,"content":"这就是啪前如色魔，啪后如圣佛"}]
     * message : null
     */

    private int code;
    private int width;
    private int height;
    private boolean success;
    private Object message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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
         * frmList : []
         * imgs : []
         * floor : 1楼
         * floorReplyTimes : 0
         * userId : 8433
         * phone :
         * forumId : 10448
         * createTime : 1482480244000
         * yulin : 95530
         * headImg : http://photo-60481.oss-cn-shenzhen.aliyuncs.com/photo/20.gif
         * userRole : null
         * userName : louis-jiao
         * id : 26290
         * host : 0
         * content : 我和我老公在一起九年了，现在宝宝十个月了，我俩睡觉还是缠在一起，就是那种胳膊搂胳膊，腿压着腿的那种，晚上给宝宝喂奶不得不分开，他也是跟着过来手搭着我，总要有点接触的那种，所以主要还是看感情的
         */

        private String floor;
        private int floorReplyTimes;
        private int userId;
        private String phone;
        private int forumId;
        private long createTime;
        private String yulin;
        private String headImg;
        private Object userRole;
        private String userName;
        private int id;
        private int host;
        private String content;
        private List<?> frmList;
        private List<?> imgs;

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

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getForumId() {
            return forumId;
        }

        public void setForumId(int forumId) {
            this.forumId = forumId;
        }

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
