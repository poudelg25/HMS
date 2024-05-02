package com.kindred.hms.controller;

import com.kindred.hms.dto.UserDto;
import com.kindred.hms.entity.User;
import com.kindred.hms.repository.UserRepository;
import com.kindred.hms.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
       return ResponseEntity.ok(userService.saveUser(userDto));
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

   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
       return ResponseEntity.ok(userService.deleteUserById(userId));
   }

    @PostMapping("/login")
    public ResponseEntity<UserDto> checkValidUser(@RequestBody UserDto userDto){
        System.err.println("Checking valid User!!!");
        return ResponseEntity.ok(userService.checkValidUser(userDto));
    }
}
