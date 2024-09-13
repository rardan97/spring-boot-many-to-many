package com.blackcode.spring_boot_many_to_many.controller;

import com.blackcode.spring_boot_many_to_many.model.Hobie;
import com.blackcode.spring_boot_many_to_many.model.User;
import com.blackcode.spring_boot_many_to_many.service.HobieService;
import com.blackcode.spring_boot_many_to_many.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/hobie")
public class HobieController {

    @Autowired
    private HobieService hobieService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Hobie>> getListAll(){
        return ResponseEntity.ok(hobieService.getListAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hobie> getHobieById(@PathVariable Long id){
        Optional<Hobie> hobieData = hobieService.getHobieById(id);
        return new ResponseEntity<>(hobieData.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Hobie> addHobie(@RequestBody Hobie hobie){
        Hobie hobieData = hobieService.addHobie(hobie);
        return new ResponseEntity<>(hobieData, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hobie> updateHobie(@PathVariable Long id, @RequestBody Hobie hobie){
        Hobie hobieData = hobieService.updateHobie(id, hobie);
        return new ResponseEntity<>(hobieData, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHobie(@PathVariable Long id){
        boolean usersHobie = userService.findByHobieId(id);
        if(usersHobie){
            boolean hobieRtn = hobieService.deleteHobie(id);
            if(hobieRtn){
                return new ResponseEntity<>("Data Success Delete", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data Failed Delete", HttpStatus.NOT_FOUND);

        }else {
            return new ResponseEntity<>("Data Failed Delete (Data Used in User)", HttpStatus.NOT_FOUND);
        }


    }


}
