package com.maxi.backstock.services.user;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.maxi.backstock.domains.User;

public interface UserService {
    User save(User user, @RequestParam("foto") MultipartFile file) throws IOException;

    User findById(Long id);

    User update(Long id);

    List<User> findAll(Pageable page);
}
