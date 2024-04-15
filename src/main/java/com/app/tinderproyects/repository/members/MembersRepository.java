package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.member;

import java.util.List;
import java.util.Optional;

public interface MembersRepository {
    List<member> allMembers();
    Optional<member> findProjectMemberById(Long id);
    member saveMember(member projectMember);
    member updateMember(Long id, member projectMember);
    Boolean deleteMemberById(Long id);

}
