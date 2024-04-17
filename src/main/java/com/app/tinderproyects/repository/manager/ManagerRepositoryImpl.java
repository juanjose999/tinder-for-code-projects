package com.app.tinderproyects.repository.manager;

import com.app.tinderproyects.entity.Manager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class ManagerRepositoryImpl implements ManagerRepository {

    private final ManagerProjectJpa managerProjectJpa;

    @Override
    public List<Manager> allManager() {
        return managerProjectJpa.findAll();
    }

    @Override
    public Optional<Manager> findManagerById(Long id) {
        return managerProjectJpa.findById(id);
    }

    @Override
    public Manager saveManger(Manager manager) {
        return managerProjectJpa.save(manager);
    }

    @Override
    public Manager updateManager(Long id, Manager manager) {
        Optional<Manager> findManager = findManagerById(id);
        if(findManager.isPresent()){
            Manager existing = findManager.get();
            existing.setUser(manager.getUser());
            return managerProjectJpa.save(existing);
        }
        throw new RuntimeException("Error in update manager.");
    }

    @Override
    public Boolean deleteManagerById(Long id) {
        Optional<Manager> findManager = findManagerById(id);
        if(findManager.isPresent()){
            managerProjectJpa.delete(findManager.get());
            return true;
        }return false;
    }
}
