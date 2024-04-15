package com.app.tinderproyects.repository.profile;

import com.app.tinderproyects.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepositoryJpa extends JpaRepository<Profile, Long> {
}
