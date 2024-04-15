package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MembersRepository {

    private final MembersRepositoryJpa membersRepositoryJpa;

    @Override
    public List<Member> allMembers() {
        return membersRepositoryJpa.findAll();
    }

    @Override
    public Optional<Member> findProjectMemberById(Long id) {
        return membersRepositoryJpa.findById(id);
    }

    @Override
    public Member saveMember(Member projectMember) {
        return membersRepositoryJpa.save(projectMember);
    }

    @Override
    public Member updateMember(Long id, Member projectMember) {
        Optional<Member> findProjectMember = findProjectMemberById(id);
        if(findProjectMember.isPresent()){
            Member existing = findProjectMember.get();
            existing.setUser(projectMember.getUser());
            existing.setProject(projectMember.getProject());
            return membersRepositoryJpa.save(existing);
        }
        throw new RuntimeException("Error in update members.");
    }

    @Override
    public Boolean deleteMemberById(Long id) {
        Optional<Member> findProjectMember = findProjectMemberById(id);
        if(findProjectMember.isPresent()){
            membersRepositoryJpa.delete(findProjectMember.get());
            return true;
        }else return false;
    }
}
