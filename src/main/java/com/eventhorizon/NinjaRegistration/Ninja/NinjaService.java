package com.eventhorizon.NinjaRegistration.Ninja;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Show all ninjas
    public List<NinjaDto> showAll(){
        List<NinjaModel> ninjas = ninjaRepository.findAllWithMissions();
        //de algum modo essa doidera percorre a lista do model e retorna na lista DTO, como funciona não sei. te, que aprender
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDto showById(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    public NinjaDto create(NinjaDto NinjaDto){
        NinjaModel ninjaModel = ninjaMapper.map(NinjaDto);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //delete ninja by id - its necessary to be void
    public boolean deleteById(Long id){
        if(ninjaRepository.existsById(id)){
            ninjaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //Update ninja
    public NinjaDto update(NinjaDto ninja, Long id) {
        Optional<NinjaModel> existingNinja = ninjaRepository.findById(id);
        if(existingNinja.isPresent()){
            NinjaModel updatedNinja = ninjaMapper.map(ninja);
            updatedNinja.setId(id);
            NinjaModel SavedNinja = ninjaRepository.save(updatedNinja);
            return ninjaMapper.map(SavedNinja);
        }
        return null;
    }
}
