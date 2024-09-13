package com.blackcode.spring_boot_many_to_many.repository;

import com.blackcode.spring_boot_many_to_many.model.Hobie;
import com.blackcode.spring_boot_many_to_many.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.user_hobie h WHERE h.hobie_id = :hobieId")
    Set<User> findUsersByHobieId(@Param("hobieId") Long hobieId);
}
