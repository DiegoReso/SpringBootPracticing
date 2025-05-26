package dev.reso.practicing.dto;

import dev.reso.practicing.model.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public Mission map(MissionDTO missionDTO){
        Mission mission = new Mission();
        mission.setId(missionDTO.getId());
        mission.setName(missionDTO.getName());
        mission.setClients(missionDTO.getClients());
        mission.setDifficulty(missionDTO.getDifficulty());
         return mission;
    }

    public MissionDTO map(Mission mission){
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(mission.getId());
        missionDTO.setName(mission.getName());
        missionDTO.setClients(mission.getClients());
        mission.setDifficulty(mission.getDifficulty());
        return missionDTO;
    }
}
