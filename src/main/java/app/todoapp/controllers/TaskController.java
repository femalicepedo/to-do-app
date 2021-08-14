package app.todoapp.controllers;

import app.todoapp.models.Task;
import app.todoapp.models.dto.TaskRequest;
import app.todoapp.models.dto.TaskResponse;
import app.todoapp.services.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskServiceImpl service;

    @Autowired
    public TaskController(TaskServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TaskResponse> create(@RequestBody TaskRequest request) {

        Task task = service.create(request.toCreate());

        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("{id}")
                .buildAndExpand(task.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new TaskResponse(task));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> all() {
        return ResponseEntity.ok(TaskResponse.toList(service.all()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam String status) {
        return ResponseEntity.ok(service.getByStatus(status));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable("id") Long id, @RequestBody TaskRequest request) {
        Task task = service.update(id, request.toUpdate());
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
