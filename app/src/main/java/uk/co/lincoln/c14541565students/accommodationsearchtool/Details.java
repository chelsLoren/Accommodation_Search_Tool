package uk.co.lincoln.c14541565students.accommodationsearchtool;

/**
 * Created by Chelsey on 10/03/2016.
 */
public class Details {

    private String Name = "";
    private String Address = "";
    private String Telephone = "";
    private String Email = "";
    private String Website = "";

    public Details(String name, String address, String telephone, String email, String website) {
        Name = name;
        Address = address;
        Telephone = telephone;
        Email = email;
        Website = website;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }
}
