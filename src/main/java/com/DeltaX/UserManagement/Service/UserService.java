package com.DeltaX.UserManagement.Service;

import com.DeltaX.UserManagement.Entity.User;
import com.DeltaX.UserManagement.Exception.UserNotFoundException;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> getAllUser();
    public User getAnUser(Long id) throws UserNotFoundException;
    public void deleteUser(Long id);
    public User updateUser(Long id,User user) throws UserNotFoundException;
}
