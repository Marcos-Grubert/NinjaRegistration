package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Show all ninjas
    public List<NinjaDTO> showAll(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        //de algum modo essa doidera percorre a lista do model e retorna na lista DTO, como funciona não sei. te, que aprender
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    public NinjaDTO showById(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
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
    public NinjaDTO update(NinjaDTO ninja, Long id) {
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
