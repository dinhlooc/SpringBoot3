package com.ProjectSpringBoot.identify_service.service;

import com.ProjectSpringBoot.identify_service.dto.request.UserCreationRequest;
import com.ProjectSpringBoot.identify_service.dto.request.UserUpdateRequest;
import com.ProjectSpringBoot.identify_service.dto.response.UserResponse;
import com.ProjectSpringBoot.identify_service.exception.AppException;
import com.ProjectSpringBoot.identify_service.exception.ErrorCode;
import com.ProjectSpringBoot.identify_service.mapper.UserMapper;
import com.ProjectSpringBoot.identify_service.repository.UserRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProjectSpringBoot.identify_service.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    public   User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXIST);
        User user=userMapper.toUser(request);
        return  userRepository.save(user);


    }

    public List<User> getUsers(){
        return userRepository.findAll();

    }
    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_FOND)));


    }

    public UserResponse UpdateUser(String userId, UserUpdateRequest request){
        User user=userRepository.findById(userId).orElseThrow(()-> new AppException(ErrorCode.USER_NOT_FOND));
        userMapper.updateUser(user, request);


        return  userMapper.toUserResponse(userRepository.save(user));


    }
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
