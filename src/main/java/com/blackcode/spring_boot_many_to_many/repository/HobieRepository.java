package com.blackcode.spring_boot_many_to_many.repository;

import com.blackcode.spring_boot_many_to_many.model.Hobie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobieRepository extends JpaRepository<Hobie, Long> {
}
