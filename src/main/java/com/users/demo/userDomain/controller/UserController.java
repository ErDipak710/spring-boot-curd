package com.users.demo.userDomain.controller;

import com.users.demo.userDomain.entity.User;
import com.users.demo.userDomain.service.UserService;
import com.users.demo.userDomain.userVo.UserResponseVo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return  ResponseEntity.status(HttpStatus.FOUND).body(user);
    }

    @GetMapping("/page/{pageNum}/{pageSize}")
    public ResponseEntity<UserResponseVo> getUserPages(@PathVariable @Min(value = 1,message = "Minimum Page Number Should Be One") int pageNum,
                                                       @PathVariable @Positive(message = "PageSize Should Be Defined In Positive Number") int pageSize) {
        UserResponseVo byPage = userService.getByPage(pageNum, pageSize);
        return  ResponseEntity.status(HttpStatus.FOUND).body(byPage);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid User user) {
        User updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/{keyWord}")
    public ResponseEntity<List<User>> searchUser(@PathVariable String keyWord) {
        List<User> users = userService.userFilter(keyWord);
        return  ResponseEntity.status(HttpStatus.FOUND).body(users);
    }
}
