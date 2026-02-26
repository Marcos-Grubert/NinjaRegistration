package com.eventhorizon.NinjaRegistration.Mission;

import com.eventhorizon.NinjaRegistration.Ninja.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String dificulty;
    private String status;

    @OneToMany(mappedBy = "mission")
    @JsonIgnore
    private List<NinjaModel> ninja;
}
