package com.ToDO.ToDo.Service;

import com.ToDO.ToDo.DTO.UserDTO;
import com.ToDO.ToDo.Entity.Tasks;
import com.ToDO.ToDo.Entity.User;
import com.ToDO.ToDo.Repository.Userrepository;
import com.ToDO.ToDo.Utility.UserUtility;
import com.ToDO.ToDo.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements TaskService{

    @Autowired
    Userrepository userrepository;

    public UserDTO saveUser(UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        if(userDTO.getTasks()!=null){
            List<Tasks> tasksList = new ArrayList<>();
            for(Tasks task:userDTO.getTasks()){
                Tasks addTask = new Tasks();
                addTask.setTaskDescription(task.getTaskDescription());
                addTask.setUser(task.getUser());
                addTask.setTaskName(task.getTaskName());
                addTask.setTaskId(task.getTaskId());
                addTask.setUser(user);
                tasksList.add(addTask);
            }
            user.setTasks(tasksList);
        }
        return UserUtility.convertToDTO(userrepository.save(user));


    }

    public List<UserDTO> getAllUsers(){
        return userrepository.findAll()
                .stream()
                .map(UserUtility::convertToDTO)
                .collect(Collectors.toList());

    }

    public UserDTO getUserByid(Long id){
        return userrepository.findById(id)
                        .map(UserUtility::convertToDTO)
                        .orElseThrow();

    }

    public UserDTO updateUser(Long id, UserDTO userDTO) throws UserNotfoundException {
        User user = userrepository.findById(id).orElseThrow(() -> new UserNotfoundException("No user"));
        if (user != null) {
            user.setTasks(userDTO.getTasks());
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());

        }
        if (userDTO.getTasks() != null) {
            List<Tasks> tasksList = new ArrayList<>();
            for (Tasks task : userDTO.getTasks()) {
                Tasks addTask = new Tasks();
                addTask.setTaskDescription(task.getTaskDescription());
                addTask.setUser(task.getUser());
                addTask.setTaskName(task.getTaskName());
                addTask.setTaskId(task.getTaskId());
                tasksList.add(addTask);
            }
            user.setTasks(tasksList);


        }
        return UserUtility.convertToDTO(userrepository.save(user));
    }

        public void deleteUser(Long id){
            User user = userrepository.findById(id).orElseThrow();
            userrepository.delete(user);
        }

    }


