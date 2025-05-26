package dev.reso.practicing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import dev.reso.practicing.dto.ClientDTO;
import dev.reso.practicing.dto.MissionDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString(exclude = "clients")

@Entity
@Table(name = "tb_missions")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Character difficulty;

    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<Client> clients = new ArrayList<>();

    public Mission(MissionDTO missionDTO){
        setId(missionDTO.getId());
        setName(missionDTO.getName());
        setDifficulty(missionDTO.getDifficulty());
        for(ClientDTO clientDTO : missionDTO.getClients()){
            clients.add(new Client(clientDTO));
        }
    }
}
