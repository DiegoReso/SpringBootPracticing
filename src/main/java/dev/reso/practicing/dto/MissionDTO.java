package dev.reso.practicing.dto;


import dev.reso.practicing.model.Client;
import dev.reso.practicing.model.Mission;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@ToString

public class MissionDTO {
    private Long id;
    private String name;
    private Character difficulty;
    private List<Client> clients = new ArrayList<>();

    public MissionDTO(Mission missions) {
        setId(missions.getId());
        setName(missions.getName());
        setDifficulty(missions.getDifficulty());
        setClients(missions.getClients());
    }
}
