package com.scooter.service.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user", schema = "scooterservice")
public class UserModel extends BasicEntity {
    private int id;
    private String login;
    private String email;
    private Integer money;
    private int role;
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_and_scooters",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "scooter_id"))
    private Set<UserModel> users;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "money", nullable = true)
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }



    @Basic
    @Column(name = "password",nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel userModel = (UserModel) o;

        if (id != userModel.id) return false;
        if (role != userModel.role) return false;
        if (login != null ? !login.equals(userModel.login) : userModel.login != null) return false;
        if (email != null ? !email.equals(userModel.email) : userModel.email != null) return false;
        if (money != null ? !money.equals(userModel.money) : userModel.money != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + role;
        return result;
    }
}
