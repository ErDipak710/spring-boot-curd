package com.users.demo.userDomain.repo;

import com.users.demo.userDomain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositry extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE CONCAT(u.username, ' ', u.password, ' ', u.active) LIKE %?1%")
    List<User> searchKey(String keyword);
}
