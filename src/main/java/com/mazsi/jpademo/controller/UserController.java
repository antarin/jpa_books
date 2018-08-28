package com.mazsi.jpademo.controller;

import com.mazsi.jpademo.Dto.LoginRequest;
import com.mazsi.jpademo.Dto.TokenDto;
import com.mazsi.jpademo.entity.User;
import com.mazsi.jpademo.exceptions.WrongPasswordException;
import com.mazsi.jpademo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import static com.mazsi.jpademo.security.SecurityConstants.HEADER_STRING;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(value = "/user", consumes = APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody User user) {
        log.info("\nBejövő: " + user.toString() + "\n");

        userService.saveUser(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest user, HttpServletResponse res) throws WrongPasswordException {
        TokenDto  token = new TokenDto(userService.login(user));
        res.setHeader(HEADER_STRING, token.getToken());

        log.info("\n\nToken: " + token + "\n\n");
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
