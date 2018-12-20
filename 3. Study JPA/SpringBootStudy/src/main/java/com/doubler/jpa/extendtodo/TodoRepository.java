package com.doubler.jpa.extendtodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="extendTodo")
public interface TodoRepository extends JpaRepository<Todo, Long>{

}
