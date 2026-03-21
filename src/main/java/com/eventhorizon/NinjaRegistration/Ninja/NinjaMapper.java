package com.eventhorizon.NinjaRegistration.Ninja;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDto NinjaDto) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(NinjaDto.getId());
        ninjaModel.setName(NinjaDto.getName());
        ninjaModel.setEmail(NinjaDto.getEmail());
        ninjaModel.setRank(NinjaDto.getRank());
        ninjaModel.setAge(NinjaDto.getAge());
        ninjaModel.setMission(NinjaDto.getMission());

        return ninjaModel;
    }

    public NinjaDto map(NinjaModel ninjaModel) {
        NinjaDto NinjaDto = new NinjaDto();
        NinjaDto.setId(ninjaModel.getId());
        NinjaDto.setName(ninjaModel.getName());
        NinjaDto.setEmail(ninjaModel.getEmail());
        NinjaDto.setRank(ninjaModel.getRank());
        NinjaDto.setAge(ninjaModel.getAge());
        NinjaDto.setMission(ninjaModel.getMission());
        return NinjaDto;
    }
}
