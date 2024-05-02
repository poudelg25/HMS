package com.kindred.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserDto {
    private Long userId;
    private String fullName;
    private String userName;
    private String password;

}
