package com.kuessiansan.springboot.restapitraining.member;



import java.time.LocalDate;

public class Member {

    private String name;
    private String firstname;

    private String profession;
    private String email;
    private LocalDate dob; //For date of birth


    public Member(){}

    public Member(String name, String firstname, String profession ,String email, LocalDate dob) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.dob = dob;
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }


    public int setProfession(String profession) {
        this.profession = profession;
        return 0;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
