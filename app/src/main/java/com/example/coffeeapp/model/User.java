package com.example.coffeeapp.model;


public class User {

    private static User userInstance;
    private String mUUID;
    private String mUserName;
    private String mEmail;
    private int mCredit;


    public static User getInstance(){
        if(userInstance==null){
            userInstance = new User();
        }
        return userInstance;
    }

    public User() {

    }


    public String getmUUID() {
        return mUUID;
    }

    public void setmUUID(String mUUID) {
        this.mUUID = mUUID;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getmCredit() {
        return mCredit;
    }

    public void setmCredit(int mCredit) {
        this.mCredit = mCredit;
    }
}
