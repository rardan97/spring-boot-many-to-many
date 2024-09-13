package com.blackcode.spring_boot_many_to_many.service;

import com.blackcode.spring_boot_many_to_many.model.Hobie;
import com.blackcode.spring_boot_many_to_many.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    List<User> getListAll();

    Optional<User> getUserById(Long id);

    User addUser(User user);

    User updateUser(Long id, User user);

    boolean deleteUser(Long id);

    boolean findByHobieId(Long hobie_id);

}
