package com.jeffnk.advoconnect.model;

import javax.persistence.*;

@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private byte[] logo;

    @Column(name = "summary")
    private String summary;

    public Company(String name, byte[] logo, String summary) {
        this.name = name;
        this.logo = logo;
        this.summary = summary;
    }

    public Company() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
