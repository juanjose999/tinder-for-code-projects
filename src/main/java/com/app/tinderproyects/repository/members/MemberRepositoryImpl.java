package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MembersRepository {

    private final MembersRepositoryJpa membersRepositoryJpa;

    @Override
    public List<member> allMembers() {
        return membersRepositoryJpa.findAll();
    }

    @Override
    public Optional<member> findProjectMemberById(Long id) {
        return membersRepositoryJpa.findById(id);
    }

    @Override
    public member saveMember(member projectMember) {
        return membersRepositoryJpa.save(projectMember);
    }

    @Override
    public member updateMember(Long id, member projectMember) {
        Optional<member> findProjectMember = findProjectMemberById(id);
        if(findProjectMember.isPresent()){
            member existing = findProjectMember.get();
            existing.setUser(projectMember.getUser());
            existing.setProject(projectMember.getProject());
            return membersRepositoryJpa.save(existing);
        }
        throw new RuntimeException("Error in update members.");
    }

    @Override
    public Boolean deleteMemberById(Long id) {
        Optional<member> findProjectMember = findProjectMemberById(id);
        if(findProjectMember.isPresent()){
            membersRepositoryJpa.delete(findProjectMember.get());
            return true;
        }else return false;
    }
}
