package com.seemantshekhar;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    //Personal info
    private String fName;
    private String lName;
    private String email;
    private String contact;
    private String nationality;
    private String address;

    //Qualification
    private String college;
    private String gYear;
    private String branch;
    private String cgpa;
    private String degree;
    private String tenth;
    private String twelfth;

    //Skills and Experience
    private List<String> skills;
    private List<String> experience;
    private List<String> achievements;
    private String github;
    private String linkedin;




    public UserData(){
        skills = new ArrayList<>();
        experience = new ArrayList<>();
        achievements = new ArrayList<>();
    }


    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getgYear() {
        return gYear;
    }

    public void setgYear(String gYear) {
        this.gYear = gYear;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTenth() {
        return tenth;
    }

    public void setTenth(String tenth) {
        this.tenth = tenth;
    }

    public String getTwelfth() {
        return twelfth;
    }

    public void setTwelfth(String twelfth) {
        this.twelfth = twelfth;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getExperience() {
        return experience;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", college='" + college + '\'' +
                ", gYear='" + gYear + '\'' +
                ", branch='" + branch + '\'' +
                ", cgpa='" + cgpa + '\'' +
                ", degree='" + degree + '\'' +
                ", tenth='" + tenth + '\'' +
                ", twelfth='" + twelfth + '\'' +
                ", skills=" + skills +
                ", experience=" + experience +
                ", achievements=" + achievements +
                ", github='" + github + '\'' +
                ", linkedin='" + linkedin + '\'' +
                '}';
    }
}
