package com.DeltaX.UserManagement.Controller;

import com.DeltaX.UserManagement.Entity.User;
import com.DeltaX.UserManagement.Exception.UserNotFoundException;
import com.DeltaX.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String create(@RequestBody User user){
        userService.createUser(user);
        return "User Created";
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getAnUser(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getAnUser(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "User Deleted";
    }

    @PostMapping("/update/{userId}")
    public String updateUser(@PathVariable Long userId,@RequestBody User user) throws UserNotFoundException {
        userService.updateUser(userId,user);
        return "User Detail Updated";
    }

}
