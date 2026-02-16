package auca.ac.rw.question5_task_api.controller;

import auca.ac.rw.question5_task_api.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    public TaskController() {
        tasks.add(new Task(1L, "Study Spring Boot",
                "Review controllers and REST APIs",
                false, "HIGH", "2026-02-20"));

        tasks.add(new Task(2L, "Complete Assignment",
                "Finish Question 5",
                false, "HIGH", "2026-02-18"));

        tasks.add(new Task(3L, "Gym",
                "Workout session",
                true, "MEDIUM", "2026-02-15"));

        tasks.add(new Task(4L, "Buy groceries",
                "Milk and bread",
                false, "LOW", "2026-02-17"));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return ResponseEntity.ok(task);
            }
        }

        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/status")
    public ResponseEntity<List<Task>> getByStatus(@RequestParam boolean completed) {

        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                result.add(task);
            }
        }

        return ResponseEntity.ok(result);
    }

    
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getByPriority(@PathVariable String priority) {

        List<Task> result = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(priority)) {
                result.add(task);
            }
        }

        return ResponseEntity.ok(result);
    }


    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        tasks.add(task);
        return ResponseEntity.status(201).body(task);
    }


    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId,
                                           @RequestBody Task updatedTask) {

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {

                task.setTitle(updatedTask.getTitle());
                task.setDescription(updatedTask.getDescription());
                task.setCompleted(updatedTask.isCompleted());
                task.setPriority(updatedTask.getPriority());
                task.setDueDate(updatedTask.getDueDate());

                return ResponseEntity.ok(task);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @PatchMapping("/{taskId}/complete")
    public ResponseEntity<Task> markCompleted(@PathVariable Long taskId) {

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setCompleted(true);
                return ResponseEntity.ok(task);
            }
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {

        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                tasks.remove(task);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();
    }
}
