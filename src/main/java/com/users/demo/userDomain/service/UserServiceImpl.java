package com.users.demo.userDomain.service;

import com.users.demo.exceptionConfiguration.UserNotFoundException;
import com.users.demo.userDomain.entity.User;
import com.users.demo.userDomain.repo.UserRepositry;
import com.users.demo.userDomain.userVo.UserResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepositry userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        if(allUsers.isEmpty())
            throw new UserNotFoundException("No User Found!!");
        return allUsers;
    }


    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id "+ id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(userItem -> {
                    userItem.setUsername(updatedUser.getUsername());
                    userItem.setPassword(updatedUser.getPassword());
                    userItem.setActive(updatedUser.isActive());
                    return userRepository.save(userItem);
                })
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
    }

    @Override
    public void deleteUser(Long id) {
        if(userRepository.findById(id).isEmpty()){
            throw new UserNotFoundException(" User not Found With Id "+ id +" For Delete Operation");
        }
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseVo getByPage(int pageNum, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum - 1, pageSize);
        Page<User> userPage = userRepository.findAll(pageRequest);
        if(userPage.isEmpty())
            throw new UserNotFoundException("User Page Not Found For Page "+ pageNum+" Where Page Size Request Is "+pageSize);
        return UserResponseVo.builder().users(userPage.getContent()).currentPage(pageNum).totalPage(userPage.getTotalPages()).totalItems(userPage.getTotalElements()).build();
    }

    @Override
    public List<User> userFilter(String keyword) {
        List<User> users = userRepository.searchKey(keyword);
        if(users.isEmpty()){
            throw new UserNotFoundException("Empty Search Result!!");
        }
        return users;
    }
}
