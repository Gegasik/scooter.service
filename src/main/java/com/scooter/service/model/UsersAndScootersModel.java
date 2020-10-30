package com.scooter.service.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "users_and_scooters")
public class UsersAndScootersModel {
    private int id;
    private int userId;
    private int scooterId;
    private Timestamp rentDate;
    private int duration;
    ScooterModel scooter;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "scooter_id", nullable = false)
    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    @Basic
    @Column(name = "rent_date", nullable = false)
    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    @ManyToOne
    @JoinColumn(name = "scooter_id",insertable = false,updatable = false)
    public ScooterModel getScooter() {
        return scooter;
    }

    public void setScooter(ScooterModel scooter) {
        this.scooter = scooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAndScootersModel that = (UsersAndScootersModel) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (scooterId != that.scooterId) return false;
        if (duration != that.duration) return false;
        if (rentDate != null ? !rentDate.equals(that.rentDate) : that.rentDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + scooterId;
        result = 31 * result + (rentDate != null ? rentDate.hashCode() : 0);
        result = 31 * result + duration;
        return result;
    }
}
