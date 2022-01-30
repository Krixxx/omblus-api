package com.example.omblusapi.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name="ActiveWorker")
@Table(name="active_worker", uniqueConstraints = {@UniqueConstraint(name="active_worker_username_unique", columnNames = "username")})
public class ActiveWorker {

    @Id
    @SequenceGenerator(name="active_worker_sequence", sequenceName = "active_worker_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "active_worker_sequence")
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="username", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String username;

    @Column(name="is_working", nullable = false, columnDefinition = "boolean default true")
    private Boolean isWorking = true;

    @Column(name="is_alert", nullable = false, columnDefinition = "boolean default false")
    private Boolean isAlert = false;

    @Column(name="is_logged_in", nullable = false, columnDefinition = "boolean default false")
    private Boolean isLoggedIn = false;


    public ActiveWorker() {
    }

    public ActiveWorker(String username, Boolean isWorking, Boolean isAlert, Boolean isLoggedIn) {
        this.username = username;
        this.isWorking = isWorking;
        this.isAlert = isAlert;
        this.isLoggedIn = isLoggedIn;
    }

    public ActiveWorker(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public void setWorking(Boolean working) {
        isWorking = working;
    }

    public Boolean getAlert() {
        return isAlert;
    }

    public void setAlert(Boolean alert) {
        isAlert = alert;
    }

    public Boolean getLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "ActiveWorker{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", isWorking=" + isWorking +
                ", isAlert=" + isAlert +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
