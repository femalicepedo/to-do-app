package app.todoapp.repositories;

import app.todoapp.models.Status;
import app.todoapp.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> getByStatus(Status status);
}
