package com.dxy.happy.bean;

/**
 * Created by 吕卓钊
 * on 2017/1/4 20:50.
 */

public class Zhuce {

    /**
     * data : {"image_url":"http://119.255.40.206:8089/pictures/headimg/userhead/null","name":"godboy","password":"","telNum":"18500704988","userId":"10124"}
     * status : ok
     */

    private DataBean data;
    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * image_url : http://119.255.40.206:8089/pictures/headimg/userhead/null
         * name : godboy
         * password :
         * telNum : 18500704988
         * userId : 10124
         */

        private String image_url;
        private String name;
        private String password;
        private String telNum;
        private String userId;

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTelNum() {
            return telNum;
        }

        public void setTelNum(String telNum) {
            this.telNum = telNum;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
