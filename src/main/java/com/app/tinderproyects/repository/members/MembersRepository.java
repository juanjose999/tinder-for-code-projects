package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MembersRepository {
    List<Member> allMembers();
    Optional<Member> findProjectMemberById(Long id);
    Member saveMember(Member projectMember);
    Member updateMember(Long id, Member projectMember);
    Boolean deleteMemberById(Long id);

}
