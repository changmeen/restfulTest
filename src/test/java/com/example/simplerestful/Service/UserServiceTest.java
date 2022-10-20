package com.example.simplerestful.Service;

import com.example.simplerestful.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    EntityManager em;


    @Test
    void read_test() {
        // given
        User user = new User();
        user.setUsername("호진");
        em.persist(user);

        User savedUser = userService.findById(user.getId());
        assertThat(savedUser.getUsername()).isEqualTo(user.getUsername());
    }
}
