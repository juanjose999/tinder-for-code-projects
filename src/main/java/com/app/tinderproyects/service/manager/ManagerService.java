package com.app.tinderproyects.service.manager;

import com.app.tinderproyects.dtos.manager.ManagerDto;
import com.app.tinderproyects.dtos.manager.ManagerResponseDto;
import com.app.tinderproyects.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {
    List<ManagerResponseDto> allManager();
    Optional<ManagerResponseDto> findManagerById(Long id);
    ManagerResponseDto saveManger(ManagerDto managerDto);
    ManagerResponseDto updateManager(Long id, ManagerDto managerDto);
    Boolean deleteManagerById(Long id);
}
