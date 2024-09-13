package com.blackcode.spring_boot_many_to_many.service;


import com.blackcode.spring_boot_many_to_many.model.Hobie;
import com.blackcode.spring_boot_many_to_many.model.User;
import com.blackcode.spring_boot_many_to_many.repository.HobieRepository;
import com.blackcode.spring_boot_many_to_many.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserImplService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HobieRepository hobieRepository;

    @Override
    public List<User> getListAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User addUser(User user) {
        User userTemp = new User();
        for (Hobie hobieTemp : user.getUser_hobie()){
            Optional<Hobie> hobieData = hobieRepository.findById(hobieTemp.getHobie_id());
            if(hobieData.isPresent()){
                userTemp.setUser_name(user.getUser_name());
                userTemp.setUser_hobie(user.getUser_hobie());
                return userRepository.save(userTemp);
            }
        }
        return null;
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()){
            for (Hobie hobieTemp : user.getUser_hobie()){
                Optional<Hobie> hobieData = hobieRepository.findById(hobieTemp.getHobie_id());
                if(hobieData.isPresent()){
                    userData.get().setUser_name(user.getUser_name());
                    userData.get().setUser_hobie(user.getUser_hobie());
                    return userRepository.save(userData.get());
                }
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean findByHobieId(Long hobie_id) {
        Set<User> user = userRepository.findUsersByHobieId(hobie_id);
        return user.isEmpty();
    }

}
