package com.app.tinderproyects.dtos.profile;

import com.app.tinderproyects.entity.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileMapper {
    public static Profile profileDtoToProfile(ProfileDto profileDto){
        Profile profile = new Profile();
        profile.setName(profileDto.getName());
        profile.setDescription(profileDto.getDescription());
        profile.setId_manager(profileDto.getId_manager());
        profile.setId_project(profileDto.getId_project());
        return profile;
    }
    public static ProfileResponseDto profileToProfileResponseDto(Profile profile){
        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        profileResponseDto.setId_project(profile.getId_project());
        profileResponseDto.setName(profile.getName());
        profileResponseDto.setDescription(profile.getDescription());
        profileResponseDto.setId_manager(profile.getId_manager());
        return profileResponseDto;
    }
}
