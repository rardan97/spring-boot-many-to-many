package com.blackcode.spring_boot_many_to_many.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hobie")
public class Hobie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobie_id;

    private String hobie_name;

    @ManyToMany(mappedBy = "user_hobie")
    @JsonIgnore
    private Set<User> users;

    public Hobie() {
    }

    public Hobie(Long hobie_id, String hobie_name) {
        this.hobie_id = hobie_id;
        this.hobie_name = hobie_name;
    }

    public Long getHobie_id() {
        return hobie_id;
    }

    public void setHobie_id(Long hobie_id) {
        this.hobie_id = hobie_id;
    }

    public String getHobie_name() {
        return hobie_name;
    }

    public void setHobie_name(String hobie_name) {
        this.hobie_name = hobie_name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
