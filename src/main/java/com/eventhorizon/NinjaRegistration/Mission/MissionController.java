package com.eventhorizon.NinjaRegistration.Mission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {
    private final MissionService missionService;
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }
    @GetMapping("/getMissions")
    public ResponseEntity<List<MissionDto>> getMissions() {
        List<MissionDto> missionsDto = missionService.getMissions();
        return ResponseEntity.ok(missionsDto);
    }
}
