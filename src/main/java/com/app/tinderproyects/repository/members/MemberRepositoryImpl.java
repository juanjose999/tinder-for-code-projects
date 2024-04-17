package com.app.tinderproyects.repository.members;

import com.app.tinderproyects.entity.Member;
import com.app.tinderproyects.entity.Profile;
import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import com.app.tinderproyects.repository.profile.ProfileRepository;
import com.app.tinderproyects.repository.project.ProjectRepository;
import com.app.tinderproyects.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MembersRepository {

    private final MembersRepositoryJpa membersRepositoryJpa;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;

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
        //buscar proyecto por id, buscar user ya existente y setearlo a member
        //agregarlo a la lista de menber
        Optional<User> findUser = userRepository.findUserById(projectMember.getUser().getId_user());
        Optional<Project> findProject = projectRepository.findProjectById(projectMember.getProject().getId_project());
        if(findUser.isPresent() && findProject.isPresent()){
            User user = findUser.get();
            Project project = findProject.get();
            Member member = new Member();
            membersRepositoryJpa.save(member);
            member.setProject(project);
            member.setUser(user);
            user.setProject(project);
            String name = project.getName_project();
            return membersRepositoryJpa.save(member);
        }else throw new RuntimeException("Error in save member");
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
