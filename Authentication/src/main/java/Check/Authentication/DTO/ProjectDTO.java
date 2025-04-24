//
//
//
//
//package Check.Authentication.DTO;
//
//import java.util.List;
//import java.util.UUID;
//
//public class ProjectDTO {
//    private String name;
//    private String description;
//    private UUID organisationId;
//    private List<UUID> userIds;
//
//    public ProjectDTO() {}
//
//    public ProjectDTO(String name, String description, UUID organisationId, List<UUID> userIds) {
//        this.name = name;
//        this.description = description;
//        this.organisationId = organisationId;
//        this.userIds = userIds;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public UUID getOrganisationId() {
//        return organisationId;
//    }
//
//    public List<UUID> getUserIds() {
//        return userIds;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setOrganisationId(UUID organisationId) {
//        this.organisationId = organisationId;
//    }
//
//    public void setUserIds(List<UUID> userIds) {
//        this.userIds = userIds;
//    }
//}










package Check.Authentication.DTO;

import java.util.List;

public class ProjectDTO {
    private String name;
    private String description;
    private String organisationId; // keep this as string if it's passed as UUID string
    private List<String> usernames; // Changed from List<UUID> userIds

    public ProjectDTO() {}

    public ProjectDTO(String name, String description, String organisationId, List<String> usernames) {
        this.name = name;
        this.description = description;
        this.organisationId = organisationId;
        this.usernames = usernames;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }
}
