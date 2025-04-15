//package Check.Authentication.Controllers;
//
//import Check.Authentication.DTO.ProjectDTO;
//import Check.Authentication.Entities.Project;
//import Check.Authentication.Services.ProjectService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/projects")
//public class ProjectController {
//
//    private final ProjectService projectService;
//
//    // Constructor Injection
//    public ProjectController(ProjectService projectService) {
//        this.projectService = projectService;
//    }
//
//    // POST endpoint to create a project
//    @PostMapping
//    public ResponseEntity<Project> createProject(@RequestBody ProjectDTO projectDTO) {
//        Project createdProject = projectService.createProject(projectDTO);
//        return ResponseEntity.ok(createdProject);
//    }
//}





package Check.Authentication.Controllers;

import Check.Authentication.DTO.ProjectDTO;
import Check.Authentication.Entities.Project;
import Check.Authentication.Services.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody ProjectDTO projectDTO) {
        try {
            Project createdProject = projectService.createProject(projectDTO);
            return ResponseEntity.ok(createdProject);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid input: " + e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body("Server error: " + e.getMessage());
        }
    }
}
