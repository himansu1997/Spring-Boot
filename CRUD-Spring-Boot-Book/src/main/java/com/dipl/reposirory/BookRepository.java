package com.dipl.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dipl.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
