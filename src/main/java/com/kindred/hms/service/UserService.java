package com.kindred.hms.service;

import com.kindred.hms.dto.UserDto;
import com.kindred.hms.entity.User;
import com.kindred.hms.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.kindred.hms.mapper.UserMapper.mapUserDtoToUser;
import static com.kindred.hms.mapper.UserMapper.mapUserToUserDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto userDto){
        userRepository.save(mapUserDtoToUser(userDto));
    }

    public UserDto getUserById(Long id){
        return mapUserToUserDto(userRepository.findById(id).get());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(Long userId, UserDto userDto){
        User existingUser = userRepository.findById(userId).
                orElseThrow(()->new RuntimeException("Entered id: " +userId + " does not exist in the database!"));

        existingUser.setFullName(userDto.getFullName());
        existingUser.setUserName(userDto.getFullName());
        existingUser.setPassword(userDto.getPassword());

        userRepository.save(existingUser);
    }

    public UserDto checkValidUser(UserDto userDto){
        User validatedUser = this.userRepository.findUserByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if(validatedUser != null){
            return mapUserToUserDto(validatedUser);
        }
        return userDto;
    }
}
