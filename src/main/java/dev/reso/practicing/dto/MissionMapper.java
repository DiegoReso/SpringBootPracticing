package dev.reso.practicing.dto;

import dev.reso.practicing.model.Client;
import dev.reso.practicing.model.Mission;
import org.springframework.stereotype.Component;

@Component
public class MissionMapper {

    public Mission map(MissionDTO missionDTO){
        Mission mission = new Mission();
        mission.setId(missionDTO.getId());
        mission.setName(missionDTO.getName());
        mission.setClients(missionDTO.getClients().stream().map(Client::new).toList());
        mission.setDifficulty(missionDTO.getDifficulty());
         return mission;
    }

    public MissionDTO map(Mission mission){
        MissionDTO missionDTO = new MissionDTO();
        missionDTO.setId(mission.getId());
        missionDTO.setName(mission.getName());
        missionDTO.setClients(mission.getClients().stream().map(ClientDTO::new).toList());
        missionDTO.setDifficulty(mission.getDifficulty());
        return missionDTO;
    }
}
