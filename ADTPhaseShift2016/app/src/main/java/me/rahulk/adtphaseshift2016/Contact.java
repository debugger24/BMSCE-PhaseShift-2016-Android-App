package me.rahulk.adtphaseshift2016;

/**
 * Created by rahulcomp24 on 06/09/16.
 */
public class Contact {
    private String name;
    private String email;
    private String mobileNumber;

    public Contact(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
