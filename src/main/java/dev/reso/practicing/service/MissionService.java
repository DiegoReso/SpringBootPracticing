package dev.reso.practicing.service;



import dev.reso.practicing.dto.MissionDTO;
import dev.reso.practicing.dto.MissionMapper;
import dev.reso.practicing.model.Mission;
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

    @Transactional(readOnly = true)
    public MissionDTO getById(Long id) {
         return missionMapper.map(missionRepository.findById(id).orElse(null));
    }

    @Transactional
    public MissionDTO insert(MissionDTO missionDTO){
        Mission mission = missionMapper.map(missionDTO);
        mission = missionRepository.save(mission);

        return missionMapper.map(mission);
    }

    @Transactional
    public MissionDTO update(MissionDTO missionDTO, Long id){
        Mission mission = missionMapper.map(missionDTO);
        mission.setId(id);
        mission = missionRepository.save(mission);
        return missionMapper.map(mission);
    }
}
