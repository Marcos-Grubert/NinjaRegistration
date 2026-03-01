package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setMission(ninjaDTO.getMission());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setMission(ninjaModel.getMission());
        return ninjaDTO;
    }
}
