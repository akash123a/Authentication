//package Check.Authentication.DTO;
//
//import java.util.UUID;
//
//public class TaskDTO {
//    private String title;
//    private String description;
//    private UUID assigneeId;
//
//    // Getter and Setter for title
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    // Getter and Setter for description
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    // Getter and Setter for assigneeId
//    public UUID getAssigneeId() {
//        return assigneeId;
//    }
//
//    public void setAssigneeId(UUID assigneeId) {
//        this.assigneeId = assigneeId;
//    }
//}















package Check.Authentication.DTO;

public class TaskDTO {
    private String title;
    private String description;
    private String assigneeName;  // Changed from UUID to String for assignee's name

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter for assigneeName
    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }
}
