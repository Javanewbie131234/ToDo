package com.ToDO.ToDo.Repository;

import com.ToDO.ToDo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User,Long> {
}
