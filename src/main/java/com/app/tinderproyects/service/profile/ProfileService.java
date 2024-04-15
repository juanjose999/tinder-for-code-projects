package com.app.tinderproyects.service.profile;

import com.app.tinderproyects.dtos.profile.ProfileDto;
import com.app.tinderproyects.dtos.profile.ProfileResponseDto;
import com.app.tinderproyects.entity.Profile;

import java.util.List;
import java.util.Optional;

public interface ProfileService {
    List<ProfileResponseDto> allProfiles();
    Optional<ProfileResponseDto> findProfileById(Long id);
    ProfileResponseDto saveProfile(ProfileDto profileDto);
    ProfileResponseDto updateProject(Long id, ProfileDto profileDto);
    Boolean deleteProfile(Long id);
}
