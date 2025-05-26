package dev.reso.practicing.service;



import dev.reso.practicing.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;



}
