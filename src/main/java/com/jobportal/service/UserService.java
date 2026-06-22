package com.jobportal.service;

import com.jobportal.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();
}