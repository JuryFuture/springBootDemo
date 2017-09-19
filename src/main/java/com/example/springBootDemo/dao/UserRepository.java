package com.example.springBootDemo.dao;

import com.example.springBootDemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
