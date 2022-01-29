package com.example.omblusapi.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

//

@Entity(name="ActiveWorker")
@Table(name="active_worker", uniqueConstraints = {@UniqueConstraint(name="active_worker_user_id_unique", columnNames = "user_id")})
public class ActiveWorker {

    @Id
    @SequenceGenerator(name="active_worker_sequence", sequenceName = "active_worker_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "active_worker_sequence")
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="user_id", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String userId;

    @Column(name="is_working", nullable = false, columnDefinition = "boolean default true")
    private Boolean isWorking;

    @Column(name="is_alert", nullable = false, columnDefinition = "boolean default false")
    private Boolean isAlert;

    @Column(name="is_logged_in", nullable = false, columnDefinition = "boolean default false")
    private Boolean isLoggedIn;


    public ActiveWorker() {
    }

    public ActiveWorker(Long id, String userId, Boolean isWorking, Boolean isAlert, Boolean isLoggedIn) {
        this.id = id;
        this.userId = userId;
        this.isWorking = isWorking;
        this.isAlert = isAlert;
        this.isLoggedIn = isLoggedIn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                ", userId='" + userId + '\'' +
                ", isWorking=" + isWorking +
                ", isAlert=" + isAlert +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
