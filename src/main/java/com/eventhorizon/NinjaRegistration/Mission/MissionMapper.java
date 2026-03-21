package com.eventhorizon.NinjaRegistration.Mission;

import org.springframework.stereotype.Component;

@Component
public class MissionMapper {
    public MissionModel map(MissionDto missionDto) {
        MissionModel missionModel = new MissionModel();
        missionModel.setId(missionDto.getId());
        missionModel.setName(missionDto.getName());
        missionModel.setDescription(missionDto.getDescription());
        missionModel.setStatus(missionDto.getStatus());
        missionModel.setDifficulty(missionDto.getDifficulty());
        return missionModel;
    }

    public MissionDto map(MissionModel missionModel) {
        MissionDto missionDto = new MissionDto();
        missionDto.setId(missionModel.getId());
        missionDto.setName(missionModel.getName());
        missionDto.setDescription(missionModel.getDescription());
        missionDto.setStatus(missionModel.getStatus());
        missionDto.setDifficulty(missionModel.getDifficulty());
        return missionDto;
    }
}
