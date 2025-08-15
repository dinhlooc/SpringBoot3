package com.ProjectSpringBoot.identify_service.mapper;

import com.ProjectSpringBoot.identify_service.dto.request.UserCreationRequest;
import com.ProjectSpringBoot.identify_service.dto.request.UserUpdateRequest;
import com.ProjectSpringBoot.identify_service.dto.response.UserResponse;
import com.ProjectSpringBoot.identify_service.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setDob( request.getDob() );
        user.setLastName( request.getLastName() );
        user.setFirstName( request.getFirstName() );
        user.setPassword( request.getPassword() );
        user.setUsername( request.getUsername() );

        return user;
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        user.setDob( request.getDob() );
        user.setLastName( request.getLastName() );
        user.setFirstName( request.getFirstName() );
        user.setPassword( request.getPassword() );
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.id( user.getId() );
        userResponse.username( user.getUsername() );
        userResponse.password( user.getPassword() );
        userResponse.firstName( user.getFirstName() );
        userResponse.lastName( user.getLastName() );
        userResponse.dob( user.getDob() );

        return userResponse.build();
    }
}
