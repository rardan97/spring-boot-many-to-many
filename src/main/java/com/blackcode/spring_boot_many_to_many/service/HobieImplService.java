package com.blackcode.spring_boot_many_to_many.service;

import com.blackcode.spring_boot_many_to_many.model.Hobie;
import com.blackcode.spring_boot_many_to_many.repository.HobieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HobieImplService implements HobieService{

    @Autowired
    private HobieRepository hobieRepository;

    @Override
    public List<Hobie> getListAll() {
        return hobieRepository.findAll();
    }

    @Override
    public Optional<Hobie> getHobieById(Long id) {
        return hobieRepository.findById(id);
    }

    @Override
    public Hobie addHobie(Hobie hobie) {
        Hobie hobieTemp = new Hobie();
        hobieTemp.setHobie_name(hobie.getHobie_name());
        return hobieRepository.save(hobieTemp);
    }

    @Override
    public Hobie updateHobie(Long id, Hobie hobie) {
        Optional<Hobie> hobieData = hobieRepository.findById(id);
        if(hobieData.isPresent()){
            hobieData.get().setHobie_name(hobie.getHobie_name());
            return hobieRepository.save(hobieData.get());
        }
        return null;
    }

    @Override
    public boolean deleteHobie(Long id) {
        Optional<Hobie> hobieData = hobieRepository.findById(id);
        if(hobieData.isPresent()){
            hobieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
