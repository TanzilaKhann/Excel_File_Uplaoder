package com.inspire.internship.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploaderService {
	public void uploadFile(MultipartFile file);
}
