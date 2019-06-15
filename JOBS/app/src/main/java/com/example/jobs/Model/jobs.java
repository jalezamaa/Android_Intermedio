package com.example.jobs.Model;

public class jobs {

    private String title;
    private String company;
    private String description;
    private String company_logo;

    public jobs(String title, String company, String description, String company_logo) {
        this.title = title;
        this.company = company;
        this.description = description;
        this.company_logo = company_logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }
}
