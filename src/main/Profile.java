package main;

import java.io.Serializable;

/**
 * Created by cbbjs on 11/12/2016.
 */
public class Profile implements Serializable{

    private String email;
    private String firstname;
    private String lastname;
    private String address;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String month;
    private String day;
    private String year;
    private boolean gender;
    private Set<Preferences> preference;

    // Setters
    public void setName(String fn, String ln) {
        firstname = fn;
        lastname = ln;
    }
    public void setEmail(String e) {
        email = e;
    }
    public void setAddress(String str, String sta, String cit, String z) {
        address = str + ", " + cit + ", " + sta + ", " + z;
        street = str;
        city = cit;
        state = sta;
        zip = z;
    }
    public void setPhone(String p) {
        phone = p;
    }
    public void setMonth(String m) {
        month = m;
    }
    public void setYear(String y) {
        year = y;
    }
    public void setDay(String d) {
        day = d;
    }
    public void setGender(boolean g) {
        gender = g;
    }

    // Getters
    public String getEmail() { return email; }
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() { return address; }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getMonth() { return month; }
    public String getYear() { return year; }
    public String getDay() { return day; }
    public boolean getGender() { return gender; }

}
