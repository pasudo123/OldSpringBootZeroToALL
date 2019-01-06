package edu.doubler.todo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.doubler.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	
	// http://appsdeveloperblog.com/specific-columns-jpa-native-query/
	// https://stackoverflow.com/questions/24710626/jpa-query-selecting-only-specific-columns-without-using-criteria-query/24710759
	// https://stackoverflow.com/questions/22007341/spring-jpa-selecting-specific-columns
	
	@Query(
	value = "SELECT TODO_ID FROM TODO WHERE USER_ID IN ( SELECT USER_ID FROM USER WHERE NAME = :name )", 
	nativeQuery = true)
	List<BigInteger> findTodoIdByUserName(@Param("name") String name);
	
	/**
	 * (1) QueryDsl 방식도 있음
	 * (2) JQ?? 이것도 알아봐야 함
	 * 위에는 Native Query 방식임
	 */
}

