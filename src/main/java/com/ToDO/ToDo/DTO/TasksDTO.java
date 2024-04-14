package com.ToDO.ToDo.DTO;

import com.ToDO.ToDo.Entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TasksDTO {
    private long taskId;
    private String taskName;
    private String taskDescription;


    private User user;

}
