package com.app.tinderproyects.repository.project;

import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.Profile;
import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import com.app.tinderproyects.repository.manager.ManagerRepository;
import com.app.tinderproyects.repository.profile.ProfileRepository;
import com.app.tinderproyects.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectRepositoryJpa projectRepositoryJpa;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;
    private final ProfileRepository profileRepository;

    @Override
    public List<Project> allProjects() {
        return projectRepositoryJpa.findAll();
    }

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectRepositoryJpa.findById(id);
    }
    @Override
    public Project saveProject(Project project){return projectRepositoryJpa.save(project);}

    public Project saveProjectWithUser(Long idUser, Project project) {
        Optional<User> userFind = userRepository.findUserById(idUser);
        if(userFind.isPresent()){
            User user = userFind.get();
            Project saveProject = projectRepositoryJpa.save(project);
            Manager manager = new Manager();
            Profile profile = new Profile();
            manager.setUser(user);
            manager.setProject(project);
            managerRepository.saveManger(manager);
            user.setProject(saveProject);
            userRepository.saveUser(user);
            saveProject.setUserManager(user);

            profileRepository.saveProfile(profile);
            String nameProject = project.getName_project();
            profile.setName(project.getName_project());
            profile.setDescription(project.getDescription());
            profile.setId_manager(user.getId_user());
            profile.setId_project(project);
            profileRepository.saveProfile(profile);

            return projectRepositoryJpa.save(saveProject);
        }
        throw new RuntimeException("Error in save project.");
    }

    @Override
    public Project updateProject(Long id, Project project) {
        Optional<Project> findProject = findProjectById(id);
        if(findProject.isPresent()){
            Project existingProject = findProject.get();
            existingProject.setName_project(project.getName_project());
            existingProject.setDescription(project.getDescription());
            return projectRepositoryJpa.save(existingProject);
        }
        throw new RuntimeException("Error in save project.");
    }

    @Override
    public Boolean deleteProjectById(Long id) {
        Optional<Project> findProject = findProjectById(id);
        if(findProject.isPresent()){
            projectRepositoryJpa.delete(findProject.get());
            return true;
        }else return false;
    }
}
