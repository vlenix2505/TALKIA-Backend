package com.upc.talkiaBackend.serviceimpl;

import com.upc.talkiaBackend.dtos.queries.ShowSuscriptionDetailsDTO;
import com.upc.talkiaBackend.entities.Level;

import com.upc.talkiaBackend.repositories.LevelRepository;
import com.upc.talkiaBackend.repositories.RoleRepository;
import com.upc.talkiaBackend.repositories.SuscriptionHistoryRepository;
import com.upc.talkiaBackend.repositories.UserRepository;
import com.upc.talkiaBackend.security.entities.Role;
import com.upc.talkiaBackend.security.entities.User;
import com.upc.talkiaBackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LevelRepository levelRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SuscriptionHistoryRepository susHistoryRepository;

    @Override
    @Transactional
    public void deleteUser(int id) {
        susHistoryRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }
    @Override
    @Transactional
    public User insertUser(User user) {
        Level level = levelRepository.findById(1);
        Role role = roleRepository.findById(2);
        user.setLevel(level);
        user.setTotalPoints(0.0);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public Integer getIdByUsername(String userName){
        for(User user: listUsers()) {
            if(user.getUserName().equals(userName)) {
                return user.getId();
            }
        }
        return 0;
    }

    @Override
    public List<User> listUsersAdmin() {
        return userRepository.listUsersAdmin();
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean existsUser(String userName){
        for(User user: listUsers()) {
            if(user.getUserName().equals(userName)){
                return true;
            }
        }
        return false;
    }
    @Override
    @Transactional
    public User updateUser(User user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }


    @Override
    public User getUserById(int userId){
        return userRepository.getUserById(userId);
    }

    @Override
    public List<User> listUsersByRegisterDate(LocalDate startDate, LocalDate endDate){
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atStartOfDay();

        return userRepository.listUsersByRegisterDate(startDateTime, endDateTime);
    }

    @Override
    public List<User> listUsersByStatus(String status){
        return userRepository.listUsersByStatus(status);
    }

    @Override
    public  List<User> getUserByUserNameContains(String username){
        return userRepository.getUsersByUserNameContainingIgnoreCase(username);
    }

    @Override
    public ShowSuscriptionDetailsDTO getCurrentSuscription(int userId){
        return userRepository.getCurrentSuscription(userId);
    }

    @Override
    public String getStatusByUser(int userId) {
        return userRepository.getStatusByUser(userId);
    }

    @Override
    public void updateLevelUser(int userId){
        User user = userRepository.getUserById(userId);
        double userPoints = user.getTotalPoints();
        switch (user.getLevel().getId()){
            case 1:
                if(userPoints >200){
                    Level level = levelRepository.findById(2);
                    user.setLevel(level);
                }
                break;
            case 2:
                if(userPoints >500){
                    Level level = levelRepository.findById(3);
                    user.setLevel(level);
                }
                break;
            default:
                break;
        }

    }

    @Override
    public Integer getUserAge(int userId) {
        User user = userRepository.getUserById(userId);
        LocalDate hoy = LocalDate.now() ;
        int edad = hoy.getYear()-user.getDateOfBirth().getYear();
        return edad;
    }

    @Override
    public Integer getLevelIdByUsername(String username) {
        return userRepository.getLevelIdByUsername(username);
    }
}
