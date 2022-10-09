package com.jeffnk.advoconnect.model;

import javax.persistence.Embeddable;

@Embeddable
public class Links {

    private String youtube;

    private String twitter;

    private String github;

    public Links(String youtube, String twitter, String github) {
        this.youtube = youtube;
        this.twitter = twitter;
        this.github = github;
    }

    public Links() {

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
