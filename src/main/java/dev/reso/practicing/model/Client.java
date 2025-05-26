package dev.reso.practicing.model;

import dev.reso.practicing.dto.ClientDTO;
import dev.reso.practicing.dto.MissionDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "missions")

@Entity
@Table(name = "tb_clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "missions_id")
    private Mission missions;

    private String rank;

    public Client(ClientDTO clientDTO){
        setId(clientDTO.getId());
        setName(clientDTO.getName());
        setEmail(clientDTO.getEmail());
        setAge(clientDTO.getAge());
        setMissions(clientDTO.getMissions());
    }

}
