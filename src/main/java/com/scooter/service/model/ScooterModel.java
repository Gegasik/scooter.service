package com.scooter.service.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "scooter", schema = "scooterservice")
public class ScooterModel extends BasicEntity {
    private int id;
    private byte isElectric;
    private int costPerHour;
    private int producerId;
    private String login;
    private String description;
    private String image;



    @ManyToMany(mappedBy = "scooters")
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
    @Column(name = "is_electric", nullable = false)
    public byte getIsElectric() {
        return isElectric;
    }

    public void setIsElectric(byte isElectric) {
        this.isElectric = isElectric;
    }

    @Basic
    @Column(name = "cost_per_hour", nullable = false)
    public int getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(int costPerHour) {
        this.costPerHour = costPerHour;
    }

    @Basic
    @Column(name = "producer_id", nullable = false)
    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    @Basic
    @Column(name = "name",nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String name) {
        this.login = name;
    }
    @Basic
    @Column(name = "description",nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Basic
    @Column(name = "image",nullable = false)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScooterModel that = (ScooterModel) o;

        if (id != that.id) return false;
        if (isElectric != that.isElectric) return false;
        if (costPerHour != that.costPerHour) return false;
        if (producerId != that.producerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) isElectric;
        result = 31 * result + costPerHour;
        result = 31 * result + producerId;
        return result;
    }
}
