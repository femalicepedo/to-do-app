package app.todoapp.services.impl;

import app.todoapp.models.Status;
import app.todoapp.models.Task;
import app.todoapp.repositories.TaskRepository;
import app.todoapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {


    private final TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public List<Task> all() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Task getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Task> getByStatus(String status) {
        return repository.getByStatus(Status.valueOf(status.toUpperCase(Locale.ROOT)));
    }


//    public Task getByPagination(String pagination) {
//        return null;
//    }

    public Task update(Long id, Task newTask) {

        Task task = getById(id);
        task.populate(newTask);

        return repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
