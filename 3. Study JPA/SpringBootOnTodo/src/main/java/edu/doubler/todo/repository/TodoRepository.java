package edu.doubler.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.doubler.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{}