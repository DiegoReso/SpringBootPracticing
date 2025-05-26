package dev.reso.practicing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

}
