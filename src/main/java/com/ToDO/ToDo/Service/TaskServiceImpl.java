package com.ToDO.ToDo.Service;

import com.ToDO.ToDo.DTO.TasksDTO;
import com.ToDO.ToDo.Entity.Tasks;
import com.ToDO.ToDo.Entity.User;
import com.ToDO.ToDo.Repository.TaskRepository;
import com.ToDO.ToDo.Repository.Userrepository;
import com.ToDO.ToDo.Utility.Taskutility;
import com.ToDO.ToDo.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    TaskRepository taskRepository;


    public TasksDTO addTask(TasksDTO tasksDTO){
        Tasks task = new Tasks();
        task.setTaskDescription(tasksDTO.getTaskDescription());
        task.setTaskName(tasksDTO.getTaskName());
        if(tasksDTO.getUser()!=null){
            task.setUser(tasksDTO.getUser());
        }
       return Taskutility.convertToDTO(taskRepository.save(task));

    }

    public List<TasksDTO> getAllTasks(){

        return taskRepository.findAll().stream()
                .map(Taskutility::convertToDTO)
                .collect(Collectors.toList());

    }

    public TasksDTO getTaskById(Long id){
        return taskRepository.findById(id)
                .map(Taskutility :: convertToDTO)
                .orElseThrow();

    }

    public TasksDTO updatetasks(Long id, TasksDTO tasksDTO){
        Tasks task = taskRepository.findById(id).orElseThrow();
        task.setTaskDescription(tasksDTO.getTaskDescription());
        task.setTaskName(tasksDTO.getTaskName());
        if(tasksDTO.getUser()!=null){
            task.setUser(tasksDTO.getUser());
        }
        return Taskutility.convertToDTO(taskRepository.save(task));


    }

    public void deleteTask(Long id) throws TaskNotFoundException{
        Tasks task = taskRepository.findById(id).orElseThrow();
        if(task!=null) {
            taskRepository.delete(task);
        }else {
            throw new TaskNotFoundException("No task");
        }



    }


}
