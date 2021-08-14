package app.todoapp.services;

import app.todoapp.models.Task;

import java.util.List;

public interface TaskService {

    public Task create(Task t);

    public List<Task> all();

    public Task getById(Long id);

    public List<Task> getByStatus(String status);

    public Task update(Long id, Task newTask);

    public void delete(Long id);
}
