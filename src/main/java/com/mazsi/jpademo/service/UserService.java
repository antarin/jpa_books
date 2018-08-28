package com.mazsi.jpademo.service;

import com.mazsi.jpademo.Dto.LoginRequest;
import com.mazsi.jpademo.entity.User;
import com.mazsi.jpademo.exceptions.WrongPasswordException;
import com.mazsi.jpademo.repository.UserRepository;
import com.mazsi.jpademo.security.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mazsi.jpademo.security.SecurityConstants.TOKEN_PREFIX;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public void saveUser(User user) {
        User newUser = User.builder()
                .username(user.getUsername())
                .password(bCryptPasswordEncoder.encode(user.getPassword()))
                .build();

        log.info("Save  user: " + userRepository.save(newUser).toString());
    }

    public String login(LoginRequest loginUser) throws WrongPasswordException {
        User user = userRepository.findByUsername(loginUser.getUsername());

        if (Objects.nonNull(user)) {
            if (bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
                String token = TOKEN_PREFIX + " " + SecurityUtils.generateToken(loginUser.getUsername());
                return token;
            } else throw new WrongPasswordException();
        }

        return null;
    }
}
