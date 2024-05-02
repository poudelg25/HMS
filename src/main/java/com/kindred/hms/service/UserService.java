package com.kindred.hms.service;

import com.kindred.hms.dto.UserDto;
import com.kindred.hms.entity.User;
import com.kindred.hms.exception.UserNotFoundException;
import com.kindred.hms.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.kindred.hms.mapper.UserMapper.mapUserDtoToUser;
import static com.kindred.hms.mapper.UserMapper.mapUserToUserDto;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(UserDto userDto) {
        User user = userRepository.findUserByUserName(userDto.getUserName());
        if (user != null) {
            return "User name already exists!!";
        } else {
            userRepository.save(mapUserDtoToUser(userDto));
            return "User saved Successfully!!";
        }
    }

    public UserDto getUserById(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("User with id - "+ id + " not found!!")
        );
        return mapUserToUserDto(existingUser);
    }

    public String deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id - " + id + " not found!!"));
        userRepository.deleteById(id);
        return "User deleted Successfully!!";
    }

    public void updateUser(Long userId, UserDto userDto) {
        User existingUser = userRepository.findById(userId).
                orElseThrow(() -> new UserNotFoundException("Entered id - " + userId + " does not exist in the database!"));

        existingUser.setFullName(userDto.getFullName());
        existingUser.setUserName(userDto.getFullName());
        existingUser.setPassword(userDto.getPassword());

        userRepository.save(existingUser);
    }

    public UserDto checkValidUser(UserDto userDto) {
        User validatedUser = userRepository.findUserByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if (validatedUser != null) {
            return mapUserToUserDto(validatedUser);
        }
        return userDto;
    }
}
