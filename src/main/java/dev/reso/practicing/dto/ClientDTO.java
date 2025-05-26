package dev.reso.practicing.dto;



import dev.reso.practicing.model.Client;

import dev.reso.practicing.model.Mission;
import lombok.*;



@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode

public class ClientDTO {

    private Long id;
    private String name;
    private String email;
    private Integer age;
    private Mission missions;
    private String rank;


    public ClientDTO(Client client) {
        setId(client.getId());
        setName(client.getName());
        setAge(client.getAge());
        setEmail(client.getEmail());
        setMissions(client.getMissions());
        setRank(client.getRank());

    }
}