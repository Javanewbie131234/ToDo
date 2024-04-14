package com.ToDO.ToDo.exception;

import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ToDoExceptionHandler {

    @ExceptionHandler(value = InvalidTaskDetails.class)
    public ResponseEntity<?> handleInvalidTaskDetails(InvalidTaskDetails ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>("Invalid Task Details " + ex.getMessage(), httpStatus);

    }

    @ExceptionHandler(value = InvalidUserDetails.class)
    public ResponseEntity<?> handleInvalidUserDetails(InvalidUserDetails ex){
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>("Invalid User Details " + ex.getMessage(), httpStatus);

    }

    @ExceptionHandler(value = TaskNotFoundException.class)
    public ResponseEntity<?> handleTaskNotFound(TaskNotFoundException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>("Task not found " + ex.getMessage(), httpStatus);

    }
    @ExceptionHandler(value = UserNotfoundException.class)
    public ResponseEntity<?> handleIUserNotfound(UserNotfoundException ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>("User not found " + ex.getMessage(), httpStatus);

    }




}
