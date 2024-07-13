package com.crm.customerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Task;
import com.crm.customerservice.service.CustomerService;
import com.crm.customerservice.service.TaskService;

@RestController
@RequestMapping("/api/crm/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/contact/{contactId}")
    public List<Task> getTasksByContact(@PathVariable Long contactId) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            return taskService.getTasksByContact(contact);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping("/contact/{contactId}")
    public Task createTask(@PathVariable Long contactId, @RequestBody Task task) {
        Contact contact = customerService.getContactById(contactId);
        if (contact != null) {
            task.setContact(contact);
            return taskService.createTask(task);
        } else {
            return null; // Or handle error appropriately
        }
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
