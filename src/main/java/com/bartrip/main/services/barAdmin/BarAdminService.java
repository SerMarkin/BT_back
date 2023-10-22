package com.bartrip.main.services.barAdmin;

import java.util.List;

import com.bartrip.main.entity.Bar.Bar;
import com.bartrip.main.repositories.BarRepository;
import com.bartrip.main.services.barAdmin.exceptions.NotFoundException;
import com.google.inject.Inject;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor_ = @Inject)
public class BarAdminService {
    
    private final BarRepository barRepository;




    public List<Bar> getAllBar(){
        return barRepository.findAll();
    }

    public void createBar(Bar bar){
        barRepository.save(bar);
    }

    //TODO:: доделать обновление бара
    public void updateBar(Bar bar) {
        try {
            Bar oldBar = barRepository.findById(bar.getId()).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
