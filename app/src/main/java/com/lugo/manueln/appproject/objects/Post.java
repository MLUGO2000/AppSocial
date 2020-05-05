package com.lugo.manueln.appproject.objects;

public class Post {

    int userId,id;
    String title,body,image;

    public Post(int userId, int id, String title, String body,String image) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.image= image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
