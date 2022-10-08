package com.jeffnk.advoconnect.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity()
@Table(name = "advocate")
public class Advocate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Column(name = "short_bio")
    private String shortBio;

    @Column(name = "long_bio")
    private String longBio;

    @Column(name = "years_of_experience")
    private float yearsOfExperience;

    @ElementCollection
    @CollectionTable(name = "advocate_links", joinColumns = @JoinColumn(name = "advocate_id"))
    @Column(name = "links")
    private Map<String, String> links = new HashMap<>();

    public Advocate(String firstName, String lastName, byte[] profilePicture, String shortBio, String longBio, float yearsOfExperience, Map<String, String> links) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicture = profilePicture;
        this.shortBio = shortBio;
        this.longBio = longBio;
        this.yearsOfExperience = yearsOfExperience;
        this.links = links;
    }

    public Advocate() {}

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getLongBio() {
        return longBio;
    }

    public void setLongBio(String longBio) {
        this.longBio = longBio;
    }

    public float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }
}