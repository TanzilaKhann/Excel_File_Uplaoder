package com.inspire.internship.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.inspire.internship.repository.inspireRepository;
@Entity
public class inspire{
	@Id
@GeneratedValue
private Long id;
//	inspireRepository repo;

private String File;
private String Filepath;
private String fileType;
public void setFileType(String fileType) {
	this.fileType = fileType;
}

public inspire() {
	
}
  

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getFilepath() {
	return Filepath;
}
public void setFilepath(String name) {
	this.Filepath = name;
}


public String getFileType() {
    return fileType;
}

public String getFile() {
	return File;
}

public void setFile(String file) {
	File = file;
}

public inspire(Long id, String file, String filepath) {
	super();
	this.id = id;
	
	this.Filepath = filepath;
	this.File = file;
}
}