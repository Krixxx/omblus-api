package com.example.omblusapi.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

//we cannot use classname User, it must be something else!
//property userId must be unique value!
//we specified unique constraint for user_id column


@Entity(name="AppUser")
@Table(name="app_user", uniqueConstraints = {@UniqueConstraint(name="app_username_unique", columnNames = "username")})
public class AppUser {

    //We can specify properties of each column by annotating @Column and then parameters
    //Some parameters:
    //name - column name
    //updatable == false | true - we can define if we can edit this column or not
    //nullable = false | true - if false, then this column cannot be empty
    //columnDefinition - type of column data
    //unique = false | true - specify, if we want this column to have unique values
    //when we have column that has boolean value, we can use columnDefinition = "boolean default false | true",
    // this way we can assign default value to boolean.

    @Id
    @SequenceGenerator(name="app_user_sequence", sequenceName = "app_user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "app_user_sequence")
    @Column(name="id",updatable = false)
    private Long id;

    @Column(name="username", nullable = false, columnDefinition = "TEXT")
    private String username;

    @Column(name="password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name="role", nullable = false, columnDefinition = "TEXT")
    private String role;

    public AppUser() {
    }

    public AppUser(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
