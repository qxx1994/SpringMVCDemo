package com.qxx.model;

import java.util.Date;

/**
 * Created by 24015 on 2016/11/2.
 */
public class BlogEntity {
    private int id;
    private String title;
    private String content;
    private Date pubDate;
    private int userId;

    public static class Builder{
        private String title;
        private String content;
        private Date pubDate;
        private int userId;

        public Builder(){}

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder pubDate(Date pubDate) {
            this.pubDate = pubDate;
            return this;
        }

        public Builder userId(int userId) {
            this.userId = userId;
            return this;
        }

        public BlogEntity build(){
            return new BlogEntity(this);
        }
    }

    public BlogEntity() {
    }

    private BlogEntity(Builder builder) {
        this.pubDate = builder.pubDate;
        this.content = builder.content;
        this.title = builder.title;
        this.userId = builder.userId;
    }

    public BlogEntity(int id, String title, String content, Date pubDate, int userId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.userId = userId;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "BlogEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubDate=" + pubDate +
                ", userId=" + userId +
                '}';
    }
}
