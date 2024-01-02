package com.library.Library.Models;


import javax.persistence.*;

@Entity
public class Book {

    @Id
    private int isbnPass;

    @Column
    private String title;

    @Column
    private String summary;

    @Column
    private String releaseDate;

    public int getIsbnPass() {
        return isbnPass;
    }

    public void setIsbnPass(int isbnPass) {
        this.isbnPass = isbnPass;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
