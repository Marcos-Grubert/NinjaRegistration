package com.eventhorizon.NinjaRegistration.Ninja;

import com.eventhorizon.NinjaRegistration.Mission.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_ninjas")
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;

    @ManyToOne
    @JoinColumn(name = "missions_id")
    private MissionModel mission;
}
