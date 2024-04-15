package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepositoryJpa extends JpaRepository<member, Long> {
}
