package com.app.tinderproyects.service.profile;

import com.app.tinderproyects.dtos.profile.ProfileDto;
import com.app.tinderproyects.dtos.profile.ProfileMapper;
import com.app.tinderproyects.dtos.profile.ProfileResponseDto;
import com.app.tinderproyects.entity.Profile;
import com.app.tinderproyects.repository.profile.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService{

    private final ProfileRepository profileRepository;
    @Override
    public List<ProfileResponseDto> allProfiles() {
        List<ProfileResponseDto> responseDto = new ArrayList<>();
        profileRepository.allProfiles().forEach(profile -> responseDto.add(ProfileMapper.profileToProfileResponseDto(profile)));
        return responseDto;
    }

    @Override
    public Optional<ProfileResponseDto> findProfileById(Long id) {
        Profile findProfile = profileRepository.findProfileById(id).orElseThrow(() -> new RuntimeException("Error in find project by id : " + id));
        return Optional.of(ProfileMapper.profileToProfileResponseDto(findProfile));
    }

    @Override
    public ProfileResponseDto saveProfile(ProfileDto profileDto) {
        return ProfileMapper.profileToProfileResponseDto(profileRepository.saveProfile(ProfileMapper.profileDtoToProfile(profileDto)));
    }

    @Override
    public ProfileResponseDto updateProject(Long id, ProfileDto profileDto) {
        return ProfileMapper.profileToProfileResponseDto(profileRepository.updateProject(id, ProfileMapper.profileDtoToProfile(profileDto)));
    }

    @Override
    public Boolean deleteProfile(Long id) {
        return profileRepository.deleteProfile(id);
    }
}
