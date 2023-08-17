package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.exceptions.ConflictException;
import com.eteration.simplebanking.exceptions.ResourceNotFoundException;
import com.eteration.simplebanking.model.User;
import com.eteration.simplebanking.model.request.RegisterRequest;
import com.eteration.simplebanking.model.response.ResponseMessage;
import com.eteration.simplebanking.model.response.UserResponse;
import com.eteration.simplebanking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController( UserService userService) {
        this.userService = userService;
    }

    public UserController() {
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody RegisterRequest registerRequest) throws ConflictException, ResourceNotFoundException {
        User user= userService.addUser(registerRequest);
        UserResponse response=new UserResponse(ResponseMessage.REGISTER_RESPONSE_MESSAGE,true,user);
        return ResponseEntity.ok(response);
    }

}
