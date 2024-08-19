package com.users.demo.userDomain.userVo;

import com.users.demo.userDomain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseVo {
    private List<User> users;
    private int currentPage;
    private int totalPage;
    private long totalItems;
}
