package app.todoapp.models.dto;

import app.todoapp.models.Status;
import app.todoapp.models.Task;

import java.time.LocalDateTime;

public class TaskRequest {

    private Long id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Task toCreate() {
        return new Task(this.id, this.description, Status.TODO, this.createdAt, this.updatedAt);
    }

    public Task toUpdate() {
        return new Task(this.id, this.description, Status.TODO, this.createdAt, this.updatedAt);
    }
}
