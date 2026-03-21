package com.eventhorizon.NinjaRegistration.Mission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDto {
    private Long id;

    private String name;
    private String description;
    private String difficulty;
    private String status;
}
