package com.ToDO.ToDo.Controller;

import com.ToDO.ToDo.DTO.TasksDTO;
import com.ToDO.ToDo.Entity.Tasks;
import com.ToDO.ToDo.Service.TaskService;
import com.ToDO.ToDo.Service.TaskServiceImpl;
import com.ToDO.ToDo.Utility.Taskutility;
import com.ToDO.ToDo.exception.InvalidTaskDetails;
import com.ToDO.ToDo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;



    @PostMapping
    public ResponseEntity<?> saveTask(@RequestBody TasksDTO tasksDTO) throws InvalidTaskDetails{
        if(tasksDTO.getTaskName()!=null && tasksDTO.getTaskDescription()!=null){
            return ResponseEntity.ok(taskService.addTask(tasksDTO));
        }else {
            throw new InvalidTaskDetails("Enter details again");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody TasksDTO tasksDTO){
        return ResponseEntity.ok(taskService.updatetasks(id,tasksDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) throws TaskNotFoundException{
        TasksDTO task = taskService.getTaskById(id);
        if(task!=null){
            taskService.deleteTask(id);
            return ResponseEntity.ok(null);
        } else{
            throw new TaskNotFoundException("Not found");
        }

    }



}
