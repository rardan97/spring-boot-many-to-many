package com.blackcode.spring_boot_many_to_many.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String user_name;

    @ManyToMany
    @JoinTable(
            name = "user_hobie",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobie_id"))
    private Set<Hobie> user_hobie;

    public User() {
    }

    public User(Long user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Set<Hobie> getUser_hobie() {
        return user_hobie;
    }

    public void setUser_hobie(Set<Hobie> user_hobie) {
        this.user_hobie = user_hobie;
    }
}
