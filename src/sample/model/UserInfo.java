package sample.model;

import java.io.Serializable;
import java.util.*;

/**
 * Created by JKKim on 2016. 6. 11..
 */
public class UserInfo implements Serializable {
    private Long userNum;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int sex;
    private String intro;
    private String email;
    private String image;
    private int emailStop;
    private String phone1;
    private String phone2;
    private String country;
    private String region;
    private String city;
    private Map<String, Object> _links;

    public Long getUserNum() {
        return userNum;
    }

    public void setUserNum(Long userNum) {
        this.userNum = userNum;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEmailStop() {
        return emailStop;
    }

    public void setEmailStop(int emailStop) {
        this.emailStop = emailStop;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, Object> get_links() {
        return _links;
    }

    public void set_links(Map<String, Object> _links) {
        this._links = _links;
    }
}
