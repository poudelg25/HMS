package com.kindred.hms.mapper;

import com.kindred.hms.dto.UserDto;
import com.kindred.hms.entity.User;

public class UserMapper {

    public static UserDto  mapUserToUserDto(User user){
        return UserDto.builder().userId(user.getUserId()).fullName(user.getFullName()).userName(user.getUserName()).password(user.getPassword()).build();
    }

    public static User mapUserDtoToUser(UserDto userDto){
        return User.builder().userId(userDto.getUserId()).fullName(userDto.getFullName()).userName(userDto.getUserName()).password(userDto.getPassword()).build();
    }
}
