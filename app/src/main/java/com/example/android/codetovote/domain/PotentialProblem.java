package com.example.android.codetovote.domain;

import java.util.Date;

public class PotentialProblem {

        private Long id;
        private String name;
        private String description;
        private Date dateCreated = new Date();
        private User user;
        private boolean converted;

    public PotentialProblem() {
        super();
    }

    public PotentialProblem(Long id, String name, String description, Date dateCreated, User user, boolean converted) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.user = user;
        this.converted = converted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isConverted() {
        return converted;
    }

    public void setConverted(boolean converted) {
        this.converted = converted;
    }
}
