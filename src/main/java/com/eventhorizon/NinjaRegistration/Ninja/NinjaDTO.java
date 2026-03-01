package com.eventhorizon.NinjaRegistration.Ninja;

import com.eventhorizon.NinjaRegistration.Mission.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;

    private String name;
    private String email;
    private String rank;

    private int age;


    private MissionModel mission;
}
