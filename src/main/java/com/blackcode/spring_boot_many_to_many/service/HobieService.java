package com.blackcode.spring_boot_many_to_many.service;

import com.blackcode.spring_boot_many_to_many.model.Hobie;

import java.util.List;
import java.util.Optional;

public interface HobieService {

    List<Hobie> getListAll();

    Optional<Hobie> getHobieById(Long id);

    Hobie addHobie(Hobie hobie);

    Hobie updateHobie(Long id, Hobie hobie);

    boolean deleteHobie(Long id);

}
