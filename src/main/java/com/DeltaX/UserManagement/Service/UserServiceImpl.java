package com.DeltaX.UserManagement.Service;

import com.DeltaX.UserManagement.Entity.User;
import com.DeltaX.UserManagement.Exception.UserNotFoundException;
import com.DeltaX.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getAnUser(Long id) throws UserNotFoundException {

        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) throws UserNotFoundException {
        User Old = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        Old.setEmail(user.getEmail());
        Old.setFirstName(user.getFirstName());
        Old.setLastName(user.getLastName());
        Old.setMobileNumber(user.getMobileNumber());


        return userRepository.save(Old);
    }
}
