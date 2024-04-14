package com.ToDO.ToDo.Utility;

import com.ToDO.ToDo.DTO.UserDTO;
import com.ToDO.ToDo.Entity.Tasks;
import com.ToDO.ToDo.Entity.User;
import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

public class UserUtility {

    public static User convertToEntity(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getPassword());
        user.setPassword(userDTO.getPassword());
        if(userDTO.getTasks()!=null){
            List<Tasks> tasksList = new ArrayList<>();
            for(Tasks task:userDTO.getTasks()){
                Tasks addTask = new Tasks();
                addTask.setTaskDescription(task.getTaskDescription());
                addTask.setUser(task.getUser());
                addTask.setTaskName(task.getTaskName());
                addTask.setTaskId(task.getTaskId());
                tasksList.add(addTask);
            }
            user.setTasks(tasksList);
        }
        return user;
    }

    public static UserDTO convertToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setUsername(user.getUsername());
        if(user.getTasks()!=null){
            List<Tasks> tasksList = new ArrayList<>();
            for(Tasks task:user.getTasks()){
                Tasks addTask = new Tasks();
                addTask.setTaskDescription(task.getTaskDescription());
                addTask.setUser(task.getUser());
                addTask.setTaskName(task.getTaskName());
                addTask.setTaskId(task.getTaskId());
                tasksList.add(addTask);
            }
            userDTO.setTasks(tasksList);
        }
        return userDTO;

    }


}
