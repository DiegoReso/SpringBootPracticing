package dev.reso.practicing.controller;


import dev.reso.practicing.dto.MissionDTO;
import dev.reso.practicing.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@CrossOrigin(origins = {"http://localhost:3000"})
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping
    public ResponseEntity<List< MissionDTO>> getAll(){
        List<MissionDTO> missionDTO = missionService.getAll();
        return ResponseEntity.ok(missionDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> getById(@PathVariable Long id){
        MissionDTO missionDTO = missionService.getById(id);
        return ResponseEntity.ok(missionDTO);
    }

    @PostMapping
    public ResponseEntity<MissionDTO> insert(@RequestBody MissionDTO mission){
        MissionDTO missionDTO = missionService.insert(mission);
        return ResponseEntity.status(HttpStatus.CREATED).body(missionDTO);
    }
}
