package com.sxxy.hospital.user.entity;


import javax.persistence.*;

@Entity
@Table(name = "epidemic_protection")
public class EpidemicProtection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "image_url")
    String imageUrl;
    @Column(name = "title")
    String title;
    @Column(name = "date")
    String date;
    @Column(name = "content")
    String content;


    public EpidemicProtection() {
    }

    public EpidemicProtection(int id, String title, String date, String content,String imageUrl) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
        this.imageUrl = imageUrl;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "EpidemicProtection{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
