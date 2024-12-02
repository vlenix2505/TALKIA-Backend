package com.upc.talkiaBackend.services;

import com.upc.talkiaBackend.dtos.queries.ShowSuscriptionDetailsDTO;
import com.upc.talkiaBackend.security.entities.User;


import java.time.LocalDate;
import java.util.List;

public interface UserService {
    public User insertUser(User user);
    public User getUserById(int userId);
    Integer getIdByUsername(String username);
    public void deleteUser(int id);
    public List<User> listUsers();
    public List<User> listUsersAdmin();
    public boolean existsUser(String userName);
    public List<User> listUsersByRegisterDate(LocalDate startDate, LocalDate endDate);
    public List<User> listUsersByStatus(String status);
    public User updateUser(User user);
    List<User> getUserByUserNameContains(String username);
    public ShowSuscriptionDetailsDTO getCurrentSuscription(int userId);
    public void updateLevelUser(int userId);
    public String getStatusByUser(int userId);
    public Integer getUserAge(int userId);
    public Integer getLevelIdByUsername(String username);


}
