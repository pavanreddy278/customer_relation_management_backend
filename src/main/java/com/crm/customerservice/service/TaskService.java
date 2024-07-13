package com.crm.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crm.customerservice.model.Contact;
import com.crm.customerservice.model.Task;
import com.crm.customerservice.repository.TaskRepository;

//import io.swagger.annotations.ApiOperation;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByContact(Contact contact) {
        return taskRepository.findByContact(contact);
    }

    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDeadline(updatedTask.getDeadline());
            existingTask.setCompleted(updatedTask.isCompleted());
            existingTask.setContact(updatedTask.getContact());
            return taskRepository.save(existingTask);
        } else {
            return null; // Or throw an exception as per your error handling strategy
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    
  
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
}
