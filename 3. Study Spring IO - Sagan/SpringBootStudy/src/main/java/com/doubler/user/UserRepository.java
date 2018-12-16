package com.doubler.user;

import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTS by spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer>{
	
}
