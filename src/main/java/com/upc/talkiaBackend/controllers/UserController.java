package com.upc.talkiaBackend.controllers;

import com.upc.talkiaBackend.dtos.UserDTO;
import com.upc.talkiaBackend.dtos.queries.ShowSuscriptionDetailsDTO;
import com.upc.talkiaBackend.security.entities.User;
import com.upc.talkiaBackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    ModelMapper modelMapper = new ModelMapper();

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PostMapping("/user")
    public UserDTO insertUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userService.insertUser(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/user_get_id/{username}")
    public Integer getIdByUsername(@PathVariable String username){
        return userService.getIdByUsername(username);
    }

    @GetMapping("/users_exist/{userName}")
    public boolean existsUser(@PathVariable String userName){
        return userService.existsUser(userName);
    }
    @PutMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        user = userService.updateUser(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping("/users")
    public List<UserDTO> listUsers(){
        List<User>users = userService.listUsers();
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_admin")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listUsersAdmin(){
        List<User>users = userService.listUsersAdmin();
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_register_date/{startDate}/{endDate}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listUsersByRegisterDate(@PathVariable LocalDate startDate,@PathVariable  LocalDate endDate){
        List<User>users = userService.listUsersByRegisterDate(startDate, endDate);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/users_status/{status}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDTO> listUsersByStatus(@PathVariable String status){
        List<User>users =  userService.listUsersByStatus(status);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }

    @GetMapping("/user_by_username/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public  List<UserDTO> getUserByUserNameContains(@PathVariable String username){
        List<User>users =  userService.getUserByUserNameContains(username);
        List<UserDTO> userDTOS = modelMapper.map(users, List.class);
        return userDTOS;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/current_suscription_by_user_id/{userId}")
    public ShowSuscriptionDetailsDTO getCurrentSuscription(@PathVariable int userId){
        return userService.getCurrentSuscription(userId);
    }

    @GetMapping("/user/status/{userId}")
    public String getStatusByUser(@PathVariable int userId) {
        return userService.getStatusByUser(userId);
    }

    @GetMapping("/user/age/{userId}")
    public Integer getUserAge(@PathVariable int userId) {
        return userService.getUserAge(userId);
    }
}