package com.videostream.app.videostream.controller;

import com.videostream.app.videostream.dto.UserRequestDTO;
import com.videostream.app.videostream.entity.User;
import com.videostream.app.videostream.response.ResponseDTO;
import com.videostream.app.videostream.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> saveUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        log.info("Persists new User::" + userRequestDTO);

        return new ResponseEntity<>(userService.saveUser(userRequestDTO), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id)  {
       // User user = userService.getUserById(id);
         return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);


      // log.info("User is available" + userRequestDTO);



    }


}
