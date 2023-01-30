package com.inspire.internship.serviceimpl;



import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.inspire.internship.entity.*;
import com.inspire.internship.service.FileUploaderService;

@Service
public class FileUploaderServiceImpl implements FileUploaderService {

	
	public List<inspire> invoiceExcelReaderService() {
		return null;
	}
	
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
	

    public void uploadFile(MultipartFile file) {
System.out.println(uploadDir);
        try {
            Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
//            String a= uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename());
//            System.out.println(a);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
    }
    
    
}