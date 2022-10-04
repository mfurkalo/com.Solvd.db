/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "User")
@XmlType(propOrder = {"id", "username", "password", "fullname", "phone", "email", "status", "group_id"})

public final class User {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String email;
    private int status;
    private int group_id;

    public User() {
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
        this.fullname = builder.fullname;
        this.phone = builder.phone;
        this.email = builder.email;
        this.status = builder.status;
        this.group_id = builder.group_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", group_id='" + group_id + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @XmlElement(name = "username")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    @XmlElement(name = "fullname")
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    @XmlElement(name = "phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(name = "email")
    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(int status) {
        this.status = status;
    }

    public int getGroup_id() {
        return group_id;
    }

    @XmlElement(name = "group_id")
    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public static class Builder {
        private int id;
        private String username;
        private String password;
        private String fullname;
        private String phone;
        private String email;
        private int status;
        private int group_id;

        public Builder(int id, String username) {
            this.id = id;
            this.username = username;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder group_id(int group_id) {
            this.group_id = group_id;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}