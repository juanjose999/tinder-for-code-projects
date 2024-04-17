package com.app.tinderproyects.controller;

import com.app.tinderproyects.dtos.profile.ProfileDto;
import com.app.tinderproyects.dtos.profile.ProfileResponseDto;
import com.app.tinderproyects.service.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping
    public ResponseEntity<List<ProfileResponseDto>> AllProfile(){
        return ResponseEntity.ok(profileService.allProfiles());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfileResponseDto> findProfileById(@PathVariable Long id){
        return ResponseEntity.of(profileService.findProfileById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<ProfileResponseDto> saveProfile(@RequestBody ProfileDto profileDto){
        return ResponseEntity.ok(profileService.saveProfile(profileDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfileResponseDto> updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto){
        return ResponseEntity.ok(profileService.saveProfile(profileDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable Long id){
        return ResponseEntity.ok(profileService.deleteProfile(id));
    }

}
