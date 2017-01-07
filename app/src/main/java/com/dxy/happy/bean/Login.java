package com.dxy.happy.bean;

/**
 * Created by 吕卓钊
 * on 2017/1/5 15:38.
 */

public class Login {

    /**
     * status : ok
     * data : {"userId":"10124","name":"godboy","phone":"18500704988"}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : 10124
         * name : godboy
         * phone : 18500704988
         */

        private String userId;
        private String name;
        private String phone;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
