package com.example.dell.eight808;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import static android.R.attr.name;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DELL on 2017/8/8.
 */
@Entity
public class User {

    @Id
    Long id;
    @Property

    String name;
    @Property
    String sex;
    @Property
    String phone;
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1906082722)
    public User(Long id, String name, String sex, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    


}
