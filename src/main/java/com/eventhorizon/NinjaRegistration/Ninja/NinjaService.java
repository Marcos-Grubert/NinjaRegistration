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
    public List<NinjaModel> showAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel showById(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaModel create(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
}
