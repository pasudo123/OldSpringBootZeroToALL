package com.doubler.jpa.extendtodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="entendUser")
public interface UserRepository extends JpaRepository<User, Long> {

}
