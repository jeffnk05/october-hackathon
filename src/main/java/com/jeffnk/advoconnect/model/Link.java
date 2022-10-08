package com.jeffnk.advoconnect.model;

import javax.persistence.*;

public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "advocate_id")
    private long id;

    @Column(name = "youtube")
    private String youtube;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "github")
    private String github;

    public Link(String youtube, String twitter, String github) {
        this.youtube = youtube;
        this.twitter = twitter;
        this.github = github;
    }

    public Link() {
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

}
