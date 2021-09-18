package com.technotab.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technotab.user.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
