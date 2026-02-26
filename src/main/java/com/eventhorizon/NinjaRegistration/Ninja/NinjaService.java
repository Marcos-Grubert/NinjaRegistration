package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Show all ninjas
    public List<NinjaModel> showNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel showNinjaPerId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }
}
