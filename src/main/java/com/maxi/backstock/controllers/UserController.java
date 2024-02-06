package com.maxi.backstock.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.maxi.backstock.domains.User;
import com.maxi.backstock.services.user.UserServiceImplementation;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user, @RequestParam("foto") MultipartFile file)
            throws IOException {
        User obj = userService.save(user, file);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<User> users = userService.findAll(page);
        return ResponseEntity.ok().body(users);
    }

}
