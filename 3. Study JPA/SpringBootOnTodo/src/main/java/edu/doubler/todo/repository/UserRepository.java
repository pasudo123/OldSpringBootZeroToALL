package edu.doubler.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.doubler.todo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{}
