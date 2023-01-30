package com.inspire.internship.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.MediaType;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.inspire.internship.entity.*;
import com.inspire.internship.repository.*;
import com.inspire.internship.service.*;
import com.inspire.internship.serviceimpl.*;


@Controller

public class inspireController {
	
	@Autowired
	FileUploaderService fileService;
	
	@Autowired
	ExcelDataService excelservice;
	
	@Autowired
	inspireRepository repo;
	


	
	@GetMapping("/")
    public String index() {
        return "upload";
    }
String file;
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);
this.file=file.getOriginalFilename();

        redirectAttributes.addFlashAttribute("message",
            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/";
    }
    
    @GetMapping("/saveData")
    public String saveExcelData(Model model) {
    	
   	List<inspire> excelDataAsList = excelservice.getExcelDataAsList(file);
   	int noOfRecords = excelservice.saveExcelData(excelDataAsList);
    	model.addAttribute("noOfRecords",noOfRecords);
    	return "success";
    }


    
  @GetMapping("/viewFiles")
  public ModelAndView viewHomePage() {
	  ModelAndView mv= new ModelAndView("view");
	  
	    List<inspire> listProducts = repo.findAll();
	    System.out.println(listProducts.size());

	    mv.addObject("value",listProducts);
	   
	     
	    return mv;
	}
  @GetMapping("/view")
  public ModelAndView showEditProductPage(@RequestParam("id") Long id) {
      ModelAndView mav = new ModelAndView("viewfile");
      inspire product =repo.findById(id).get();
      String path=product.getFilepath();
      mav.addObject("product", path);
       
      return mav;
  }
//  @GetMapping("/view")
//  public void showEditProductPage(@RequestParam("id") Long id) {
// System.out.println(id);
// inspire product =repo.findById(id).get();
// String path=product.getFilepath();
// System.out.println(path);
////     inspire product =repo.findById(id).get();
//////     System.out.println(product);
//     viewfile a= new viewfile();
////     System.out.println(a);
//////     a.setObject(product);
//  a.view(path);
       
     
//  }
  
  
  

  @GetMapping("/downloadFile")
  public void getLogFile(@RequestParam("id") Long id,HttpSession session,HttpServletResponse response) throws Exception {
      try {
           
    	  inspire product =repo.findById(id).get();
          String path=product.getFilepath();
          String fileName=product.getFile();
//          String fileName="archivo demo.pdf";
//          String filePathToBeServed = "C:\\software\\Tomcat 7.0\\tmpFiles\\";
          File fileToDownload = new File(path);

          InputStream inputStream = new FileInputStream(fileToDownload);
          response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
          response.setHeader("Content-Disposition", "attachment; filename="+fileName); 
          IOUtils.copy(inputStream, response.getOutputStream());
          response.flushBuffer();
          inputStream.close();
      } catch (Exception exception){
          System.out.println(exception.getMessage());
        
  }
}
}