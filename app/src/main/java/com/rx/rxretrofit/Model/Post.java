package com.rx.rxretrofit.Model;

public class Post {

    // vars
    public int userId;
    public int id;
    public String title;
    public String body;

    public Post() {
    } // empty constructor

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    } // constructor with parameters


}
