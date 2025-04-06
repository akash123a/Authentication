package Check.Authentication.Entities;

import Check.Authentication.enums.Role;
import jakarta.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false ,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isActive = false;

    @OneToMany
    @JoinTable(
            name = "user_subProject_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @MapKeyColumn(name = "subProject_id") // Key column for the map
    private Map<UUID, Roles> subProjectRole;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organisation organisation;

    @OneToMany(mappedBy = "assignedUser")
    List<Task> assignedTasks; //  To remove

    @ManyToMany(mappedBy = "members")
    List<SubProject> projects;

    // Default constructor
    public User() {
    }

    public User(UUID id, String name, String email, String password, Role role, boolean isActive, Map<UUID, Roles> subProjectRole, Organisation organisation, List<Task> assignedTasks, List<SubProject> projects) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        this.subProjectRole = subProjectRole;
        this.organisation = organisation;
        this.assignedTasks = assignedTasks;
        this.projects = projects;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Map<UUID, Roles> getSubProjectRole() {
        return subProjectRole;
    }

    public void setSubProjectRole(Map<UUID, Roles> subProjectRole) {
        this.subProjectRole = subProjectRole;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<SubProject> getProjects() {
        return projects;
    }

    public void setProjects(List<SubProject> projects) {
        this.projects = projects;
    }
}