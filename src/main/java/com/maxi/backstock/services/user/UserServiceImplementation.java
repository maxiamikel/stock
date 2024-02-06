package com.maxi.backstock.services.user;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.maxi.backstock.domains.User;
import com.maxi.backstock.repositories.UserRepository;
import com.maxi.backstock.services.upload.FileUploadService;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @Override
    public User save(User user, @RequestParam("foto") MultipartFile file) throws IOException {
        User userDB = userRepository.findByEmail(user.getEmail());
        if (userDB != null) {
            return userDB;
        }
        String imageName = fileUploadService.uploadFoto(file);
        user.setFoto(imageName);
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            throw new RuntimeException("The User id not exists");
        }
        return user.get();
    }

    @Override
    public User update(Long id) {
        User user = findById(id);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll(Pageable page) {
        return userRepository.findAll();
    }

}
