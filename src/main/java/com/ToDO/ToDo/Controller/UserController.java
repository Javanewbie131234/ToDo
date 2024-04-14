package com.ToDO.ToDo.Controller;

import com.ToDO.ToDo.DTO.TasksDTO;
import com.ToDO.ToDo.DTO.UserDTO;
import com.ToDO.ToDo.Repository.Userrepository;
import com.ToDO.ToDo.Service.UserServiceImpl;
import com.ToDO.ToDo.exception.InvalidTaskDetails;
import com.ToDO.ToDo.exception.InvalidUserDetails;
import com.ToDO.ToDo.exception.TaskNotFoundException;
import com.ToDO.ToDo.exception.UserNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) throws InvalidUserDetails{
        if(userDTO.getUsername()!=null && userDTO.getPassword()!=null){
           return ResponseEntity.ok(userService.saveUser(userDTO));
        } else{
            throw new InvalidUserDetails("Invalid");
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UserDTO userDTO) throws UserNotfoundException {
        return ResponseEntity.ok(userService.updateUser(id,userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) throws InvalidUserDetails{
        UserDTO userDTO = userService.getUserByid(id);
        if(userDTO!=null){
            userService.deleteUser(id);
            return ResponseEntity.ok(null);
        } else {
            throw new InvalidUserDetails("Wrong details");
        }

    }

}



