package com.jeffnk.advoconnect.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private long companyId;

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

    @OneToMany(mappedBy = "advocate")
    private Set<Advocate> advocates;

    public long getCompanyId() {
        return companyId;
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
