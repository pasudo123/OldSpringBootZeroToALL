package edu.doubler.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.doubler.todo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{}
