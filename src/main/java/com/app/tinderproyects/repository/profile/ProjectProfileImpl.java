package com.app.tinderproyects.repository.profile;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.Profile;
import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import com.app.tinderproyects.repository.manager.ManagerRepository;
import com.app.tinderproyects.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class ProjectProfileImpl implements ProfileRepository {

    private final ProfileRepositoryJpa profileRepositoryJpa;

    @Override
    public List<Profile> allProfiles() {
        return profileRepositoryJpa.findAll();
    }

    @Override
    public Optional<Profile> findProfileById(Long id) {
        return profileRepositoryJpa.findById(id);
    }

    @Override
    public Profile saveProfile(Profile profile) {

        return profileRepositoryJpa.save(profile);
    }

    @Override
    public Profile updateProject(Long id, Profile profile) {
        Optional<Profile> findProfile = findProfileById(id);
        if(findProfile.isPresent()){
            Profile existingProfile = findProfile.get();
            existingProfile.setName(profile.getName());
            existingProfile.setDescription(profile.getDescription());
            return profileRepositoryJpa.save(existingProfile);
        }
        throw new RuntimeException("Error in update user.");
    }

    @Override
    public Boolean deleteProfile(Long id) {
        Optional<Profile> findProfile = findProfileById(id);
        if(findProfile.isPresent()){
            profileRepositoryJpa.delete(findProfile.get());
            return true;
        }
        else return false;
    }

}
