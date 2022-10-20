package com.example.simplerestful.Repository;

import com.example.simplerestful.Entity.User;
import com.example.simplerestful.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void read(){
        User user = new User();
        user.setUsername("호진");
        userRepository.save(user);

        User user1 = userService.findById(1L);
        Assertions.assertThat(user1.getId()).isEqualTo(user.getId());
    }

}
