package Check.Authentication.Services;

import Check.Authentication.DTO.TaskDTO;
import Check.Authentication.Entities.Task;
import Check.Authentication.Entities.User;
import Check.Authentication.Repositories.TaskRepository;
import Check.Authentication.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());

        User user = userRepository.findById(taskDTO.getAssigneeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        task.setAssigned(user);

        return taskRepository.save(task);
    }
}
