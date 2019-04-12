package com.example.auth.services;

import com.example.auth.model.User;
import com.example.auth.repositories.RoleRepository;
import com.example.auth.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;


public class UserServiceTest {

    @Mock
    private UserRepository mockUserRepository;

    @Mock
    private RoleRepository mockRoleRepository;

    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    @InjectMocks
    private UserService userService;

    private User user;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        userService =  new UserService(mockUserRepository, mockRoleRepository, mockBCryptPasswordEncoder);
        user = User.builder()
                .id(1)
                .name("Himanshu")
                .lastName("Mittal")
                .email("test@test.com")
                .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);

        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
    }

    @Test
    public void findUserByEmail() {
        String email = "test@test.com";
        User result = userService.findUserByEmail(email);
        assertEquals(email, result.getEmail());
    }

    @Test
    public void saveUser() {
        String email = "test@test.com";
        User result = userService.saveUser(User.builder().build());
        assertEquals(email, result.getEmail());
    }
}