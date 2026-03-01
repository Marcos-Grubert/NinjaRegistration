package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Show all ninjas
    public List<NinjaModel> showAll(){
        return ninjaRepository.findAll();
    }

    public NinjaModel showById(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaDTO create(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //delete ninja by id - its necessary to be void
    public void deleteById(Long id){
        ninjaRepository.deleteById(id);
    }

    //Update ninja
    public NinjaModel update(NinjaModel ninja, Long id) {
        if(ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
