package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepositoryJpa extends JpaRepository<Member, Long> {
}
