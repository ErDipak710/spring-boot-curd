package com.users.demo.userDomain.service;

import com.users.demo.userDomain.entity.User;
import com.users.demo.userDomain.userVo.UserResponseVo;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    UserResponseVo getByPage(int pageNum, int pageSize);

    List<User> userFilter(String keyword);
}
