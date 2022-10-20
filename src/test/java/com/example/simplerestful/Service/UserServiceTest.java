package com.example.simplerestful.Service;

import com.example.simplerestful.Entity.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    EntityManager em;
    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public User createUser(){
        User user = new User();
        user.setUsername("호진");
        em.persist(user);

        return user;
    }
    @Test
    void read_test() {
        try(Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/user?serverTimezone=Asia/Seoul&characterEncoding=UTF-8", "root", "12345"
        )) {
            // given
            User user = createUser();

            User savedUser = userService.findById(user.getId());
            assertThat(savedUser.getUsername()).isEqualTo(user.getUsername());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
