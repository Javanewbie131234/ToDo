package com.ToDO.ToDo.DTO;

import com.ToDO.ToDo.Entity.Tasks;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String username;
    private String password;

    private List<Tasks> tasks;


}
