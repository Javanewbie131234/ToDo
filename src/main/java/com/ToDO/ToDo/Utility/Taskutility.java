package com.ToDO.ToDo.Utility;

import com.ToDO.ToDo.DTO.TasksDTO;
import com.ToDO.ToDo.Entity.Tasks;
import org.springframework.scheduling.config.Task;

public class Taskutility {

    public static TasksDTO convertToDTO(Tasks task){
        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setTaskDescription((task.getTaskDescription()));
        tasksDTO.setTaskId(task.getTaskId());
        tasksDTO.setTaskName(task.getTaskName());
        if(task.getUser()!=null) {
            tasksDTO.setUser(task.getUser());

        }
        return tasksDTO;
    }

    public static Tasks convertToEntity(TasksDTO tasksDTO){
        Tasks tasks = new Tasks();
        tasks.setTaskName(tasksDTO.getTaskName());
        tasks.setTaskId(tasksDTO.getTaskId());
        tasks.setTaskDescription(tasksDTO.getTaskDescription());
        if(tasksDTO.getUser()!=null){
            tasks.setUser(tasksDTO.getUser());
        }
        return tasks;
    }




}
