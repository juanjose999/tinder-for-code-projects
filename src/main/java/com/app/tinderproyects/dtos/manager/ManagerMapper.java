package com.app.tinderproyects.dtos.manager;

import com.app.tinderproyects.entity.Manager;

public class ManagerMapper {
    public static Manager managerDtoToManager(ManagerDto managerDto){
        Manager manager = new Manager();
        manager.setUser(manager.getUser());
        return manager;
    }
    public static ManagerResponseDto managerToMangerResponseDto(Manager manager){
        ManagerResponseDto managerResponseDto = new ManagerResponseDto();
        managerResponseDto.setId_manager(manager.getId_manager());
        managerResponseDto.setUser(manager.getUser());
        return managerResponseDto;
    }
}
