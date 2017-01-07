package com.dxy.happy.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 张天成
 * on 2016/12/30 16:53.
 */
public class ForumTop_Bean implements Serializable{

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

    public static class DataBean implements Serializable{
        /**
         * frList : null
         * recommend : 0
         * topTime : 1483249618000
         * indexImg :
         * nice : 0
         * headImg : http://wx.qlogo.cn/mmopen/JCrjicctRMoerGibib2SAdXrkibUsG7PH1ZJ3JKFe7FEqs4a43U5OZgdUgGo7rJ04M32qSme1I8d9DGanxctX438FF8tNsFNaTOt/0
         * forumType : 10
         * click : 0
         * title : 我想知道原因
         * userId : 8940
         * phone : 安卓手机
         * audit : 1
         * top : 0
         * emotionStage1 : 1
         * emotionStage2 : 0
         * emotionStage3 : 0
         * emotionStage4 : 0
         * emotionStage5 : 0
         * emotionStage6 : 0
         * imgs : [{"originalImg":"http://img1.yulin520.com/yulinEvents/7VYQMKYMBIK0OH7G4U8S.jpeg","miniImg":"http://img1.yulin520.com/yulinEvents/7VYQMKYMBIK0OH7G4U8S.jpeg@250w_250h_100Q_1o","height":853,"width":640}]
         * replyTimes : 0
         * createTime : 1483249618000
         * img :
         * yulin : 97522
         * readOnly : 0
         * anonymous : 1
         * userName : 重琛
         * status : 1
         * id : 10466
         * content : 其实我长得也不丑，算是挺好看那种，但是我有点胖，我现在高中快结束了，都没有交过男朋友，因为知道高中能有一段恋情是很好的，我也很烦恼，我不喜欢和男生说话，因为我觉得我很胖……连同班的男生无论在哪里看见我都不会打招呼，像陌生人一样，可是大部分的男生我都不排斥，为什么就是没有男生主动跟我搭讪呢？虽然我对谈恋爱没什么看点，但我都要毕业了……怎么，是我的原因么
         */

        private Object frList;
        private int recommend;
        private long topTime;
        private String indexImg;
        private int nice;
        private String headImg;
        private int forumType;
        private int click;
        private String title;
        private int userId;
        private String phone;
        private int audit;
        private int top;
        private int emotionStage1;
        private int emotionStage2;
        private int emotionStage3;
        private int emotionStage4;
        private int emotionStage5;
        private int emotionStage6;
        private int replyTimes;
        private long createTime;
        private String img;
        private String yulin;
        private int readOnly;
        private int anonymous;
        private String userName;
        private int status;
        private int id;
        private String content;
        private List<ImgsBean> imgs;

        public Object getFrList() {
            return frList;
        }

        public void setFrList(Object frList) {
            this.frList = frList;
        }

        public int getRecommend() {
            return recommend;
        }

        public void setRecommend(int recommend) {
            this.recommend = recommend;
        }

        public long getTopTime() {
            return topTime;
        }

        public void setTopTime(long topTime) {
            this.topTime = topTime;
        }

        public String getIndexImg() {
            return indexImg;
        }

        public void setIndexImg(String indexImg) {
            this.indexImg = indexImg;
        }

        public int getNice() {
            return nice;
        }

        public void setNice(int nice) {
            this.nice = nice;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getForumType() {
            return forumType;
        }

        public void setForumType(int forumType) {
            this.forumType = forumType;
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

        public int getAudit() {
            return audit;
        }

        public void setAudit(int audit) {
            this.audit = audit;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getEmotionStage1() {
            return emotionStage1;
        }

        public void setEmotionStage1(int emotionStage1) {
            this.emotionStage1 = emotionStage1;
        }

        public int getEmotionStage2() {
            return emotionStage2;
        }

        public void setEmotionStage2(int emotionStage2) {
            this.emotionStage2 = emotionStage2;
        }

        public int getEmotionStage3() {
            return emotionStage3;
        }

        public void setEmotionStage3(int emotionStage3) {
            this.emotionStage3 = emotionStage3;
        }

        public int getEmotionStage4() {
            return emotionStage4;
        }

        public void setEmotionStage4(int emotionStage4) {
            this.emotionStage4 = emotionStage4;
        }

        public int getEmotionStage5() {
            return emotionStage5;
        }

        public void setEmotionStage5(int emotionStage5) {
            this.emotionStage5 = emotionStage5;
        }

        public int getEmotionStage6() {
            return emotionStage6;
        }

        public void setEmotionStage6(int emotionStage6) {
            this.emotionStage6 = emotionStage6;
        }

        public int getReplyTimes() {
            return replyTimes;
        }

        public void setReplyTimes(int replyTimes) {
            this.replyTimes = replyTimes;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getYulin() {
            return yulin;
        }

        public void setYulin(String yulin) {
            this.yulin = yulin;
        }

        public int getReadOnly() {
            return readOnly;
        }

        public void setReadOnly(int readOnly) {
            this.readOnly = readOnly;
        }

        public int getAnonymous() {
            return anonymous;
        }

        public void setAnonymous(int anonymous) {
            this.anonymous = anonymous;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public List<ImgsBean> getImgs() {
            return imgs;
        }

        public void setImgs(List<ImgsBean> imgs) {
            this.imgs = imgs;
        }

        public static class ImgsBean implements Serializable{
            /**
             * originalImg : http://img1.yulin520.com/yulinEvents/7VYQMKYMBIK0OH7G4U8S.jpeg
             * miniImg : http://img1.yulin520.com/yulinEvents/7VYQMKYMBIK0OH7G4U8S.jpeg@250w_250h_100Q_1o
             * height : 853
             * width : 640
             */

            private String originalImg;
            private String miniImg;
            private int height;
            private int width;

            public String getOriginalImg() {
                return originalImg;
            }

            public void setOriginalImg(String originalImg) {
                this.originalImg = originalImg;
            }

            public String getMiniImg() {
                return miniImg;
            }

            public void setMiniImg(String miniImg) {
                this.miniImg = miniImg;
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
        }
    }
}
