package com.sevenre.controller;

import com.sevenre.entity.User;
import com.sevenre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ws/users")
public class UserController {


    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Return all users
     */
    @RequestMapping( method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userRepository.findAll();

    }


    /**
     * Save the users
     */
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody List<User> users){

        for(User user:users) {
            userRepository.save(user);
        }
        return "User created successfully!";

    }

    /**
     * Update the passed user
     */
    //TODO:  How to update the entity as the user_id is auto generated? May be passing the id?
    @RequestMapping( method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String editUser(@RequestBody User user){

        userRepository.save(user);
        return "User updated successfully!";

    }

    /**
     * Delete the user
     */
    //TODO:  How to delete the entity as the user_id is auto generated? May be passing the id?
    @RequestMapping( method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteUser(@RequestBody User user){

        userRepository.delete(user);
        return "User deleted successfully!";

    }

    /**
     * Return the user with the specific userId
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable long id){
        return userRepository.findOne(id);

    }

}
