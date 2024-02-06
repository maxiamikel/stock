package com.maxi.backstock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.backstock.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
