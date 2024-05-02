package com.kindred.hms.controller;

import com.kindred.hms.dto.UserDto;
import com.kindred.hms.entity.User;
import com.kindred.hms.repository.UserRepository;
import com.kindred.hms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
       userService.saveUser(userDto);
       return ResponseEntity.ok("User Created Successfully!!");
   }

   @GetMapping("/id")
   public ResponseEntity<UserDto> getUserInfo(@RequestParam("id") Long userId) {
        return ResponseEntity.ok().body(userService.getUserById(userId));
   }

   @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userService.updateUser(userId, userDto);
       return ResponseEntity.status(HttpStatus.CREATED).body("User with ID: "+userId+") updated successfully!!");
   }

   @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestParam("id") Long userId) {
        userService.deleteUserById(userId);
       return ResponseEntity.ok("User Deleted Successfully!!");
   }

    @PostMapping("/login")
    public ResponseEntity<UserDto> checkValidUser(@RequestBody UserDto userDto){
        System.err.println("Checking valid user....");
        return ResponseEntity.ok(this.userService.checkValidUser(userDto));
    }
}
