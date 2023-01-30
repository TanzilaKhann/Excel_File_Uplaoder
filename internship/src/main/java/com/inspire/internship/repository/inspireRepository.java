package com.inspire.internship.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inspire.internship.entity.*;
public interface inspireRepository extends JpaRepository<inspire, Long> {
	
	
//	List<inspire> listAll();
}