package com.app.tinderproyects.repository.profile;

import com.app.tinderproyects.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {
    List<Profile> allProfiles();
    Optional<Profile> findProfileById(Long id);
    Profile saveProfile(Profile profile);
    Profile updateProject(Long id, Profile profile);
    Boolean deleteProfile(Long id);
}
