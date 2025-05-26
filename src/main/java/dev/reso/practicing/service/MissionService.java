package dev.reso.practicing.service;



import dev.reso.practicing.dto.MissionDTO;
import dev.reso.practicing.dto.MissionMapper;
import dev.reso.practicing.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private MissionMapper missionMapper;

    @Transactional(readOnly = true)
    public List<MissionDTO> getAll(){
        return missionRepository.findAll().stream().map(missionMapper::map).toList();
    }

    @Transactional
    public MissionDTO getById(Long id) {
         return missionMapper.map(missionRepository.findById(id).orElse(null));
    }


}
