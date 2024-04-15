package com.app.tinderproyects.repository.manager;

import com.app.tinderproyects.entity.Manager;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    List<Manager> allManager();
    Optional<Manager> findManagerById(Long id);
    Manager saveManger(Manager manager);
    Manager updateManager(Long id, Manager manager);
    Boolean deleteManagerById(Long id);
}
