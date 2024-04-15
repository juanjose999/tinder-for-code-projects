package com.app.tinderproyects.service.manager;

import com.app.tinderproyects.dtos.manager.ManagerDto;
import com.app.tinderproyects.dtos.manager.ManagerMapper;
import com.app.tinderproyects.dtos.manager.ManagerResponseDto;
import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.repository.manager.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ManagerServiceImpl implements ManagerService{

    private final ManagerRepository managerRepository;

    @Override
    public List<ManagerResponseDto> allManager() {
        List<ManagerResponseDto> managerResponseDto = new ArrayList<>();
        managerRepository.allManager().forEach(manager -> managerResponseDto.add(ManagerMapper.managerToMangerResponseDto(manager)));
        return managerResponseDto;
    }

    @Override
    public Optional<ManagerResponseDto> findManagerById(Long id) {
        Manager manager =  managerRepository.findManagerById(id).orElseThrow(() -> new RuntimeException("Error in find manager."));
        ManagerResponseDto managerResponseDto = ManagerMapper.managerToMangerResponseDto(manager);
        return Optional.of(managerResponseDto);
    }

    @Override
    public ManagerResponseDto saveManger(ManagerDto managerDto) {
        return ManagerMapper.managerToMangerResponseDto(managerRepository.saveManger(ManagerMapper.managerDtoToManager(managerDto)));
    }

    @Override
    public ManagerResponseDto updateManager(Long id, ManagerDto managerDto) {
        return ManagerMapper.managerToMangerResponseDto(managerRepository.updateManager(id, ManagerMapper.managerDtoToManager(managerDto)));
    }

    @Override
    public Boolean deleteManagerById(Long id) {
        return managerRepository.deleteManagerById(id);
    }
}
