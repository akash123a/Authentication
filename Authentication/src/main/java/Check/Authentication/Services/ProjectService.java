//package Check.Authentication.Services;
//
//import Check.Authentication.DTO.ProjectDTO;
//import Check.Authentication.Entities.Organisation;
//import Check.Authentication.Entities.Project;
//import Check.Authentication.Entities.User;
//import Check.Authentication.Repositories.OrganisationRepository;
//import Check.Authentication.Repositories.ProjectRepository;
//import Check.Authentication.Repositories.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectService {
//
//    private final ProjectRepository projectRepository;
//    private final OrganisationRepository organisationRepository;
//    private final UserRepository userRepository;
//
//    // Constructor-based Dependency Injection
//    public ProjectService(ProjectRepository projectRepository,
//                          OrganisationRepository organisationRepository,
//                          UserRepository userRepository) {
//        this.projectRepository = projectRepository;
//        this.organisationRepository = organisationRepository;
//        this.userRepository = userRepository;
//    }
//
//    public Project createProject(ProjectDTO projectDTO) {
//        Project project = new Project();
//        project.setName(projectDTO.getName());
//        project.setDescription(projectDTO.getDescription());
//
//        // Find Organisation
//        Organisation organisation = organisationRepository.findById(projectDTO.getOrganisationId())
//                .orElseThrow(() -> new RuntimeException("Organisation not found"));
//        project.setOrganisation(organisation);
//
//        // Find Users
//        List<User> users = userRepository.findAllById(projectDTO.getUserIds());
//        project.setUsers(users);
//
//        // Save and return the project
//        return projectRepository.save(project);
//    }
//}







package Check.Authentication.Services;

import Check.Authentication.DTO.ProjectDTO;
import Check.Authentication.Entities.Organisation;
import Check.Authentication.Entities.Project;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.OrganisationRepository;
import Check.Authentication.Repositories.ProjectRepository;
import Check.Authentication.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final OrganisationRepository organisationRepository;
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository,
                          OrganisationRepository organisationRepository,
                          UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.organisationRepository = organisationRepository;
        this.userRepository = userRepository;
    }

    public Project createProject(ProjectDTO projectDTO) {
        if (projectDTO.getOrganisationId() == null) {
            throw new IllegalArgumentException("Organisation ID is null.");
        }

        Organisation organisation = organisationRepository.findById(projectDTO.getOrganisationId())
                .orElseThrow(() -> new RuntimeException("Organisation not found with ID: " + projectDTO.getOrganisationId()));

        List<User> users = userRepository.findAllById(projectDTO.getUserIds());
        if (users.isEmpty()) {
            throw new IllegalArgumentException("No valid users found for provided IDs.");
        }

        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setOrganisation(organisation);
        project.setUsers(users);

        return projectRepository.save(project);
    }
}
