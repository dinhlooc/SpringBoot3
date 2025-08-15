package com.ProjectSpringBoot.identify_service.controller;

import com.ProjectSpringBoot.identify_service.dto.request.ApiResponse;
import com.ProjectSpringBoot.identify_service.dto.request.UserCreationRequest;
import com.ProjectSpringBoot.identify_service.dto.request.UserUpdateRequest;
import com.ProjectSpringBoot.identify_service.dto.response.UserResponse;
import com.ProjectSpringBoot.identify_service.entity.User;
import com.ProjectSpringBoot.identify_service.repository.UserRepository;
import com.ProjectSpringBoot.identify_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    ApiResponse <User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse= new ApiResponse<>();
        apiResponse.setResult((userService.createUser(request)));
        return apiResponse;


    }
    @GetMapping()
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") String userId){
        return userService.getUser(userId);


    }
    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId,@RequestBody UserUpdateRequest request){
        return userService.UpdateUser(userId, request);


    }
    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User  has been deleted";
    }


}
