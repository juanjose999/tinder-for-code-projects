package com.app.tinderproyects.repository.profile;

import com.app.tinderproyects.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfileRepositoryJpa extends JpaRepository<Profile, Long> {
}
