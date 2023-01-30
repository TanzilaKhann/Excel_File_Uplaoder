package com.inspire.internship.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.inspire.internship.entity.*;
import com.inspire.internship.repository.*;
import com.inspire.internship.service.*;

@Service
public class ExcelDataServiceImpl implements ExcelDataService {
	static XSSFRow row;
//	@Value("${app.upload.file:${user.home}}")
//	public String EXCEL_FILE_PATH;
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
	@Autowired
	inspireRepository repo;

	Workbook workbook;
//	 String FileName;
//	 ExcelDataServiceImpl(String file){
//		 this.FileName=file; 
//	 }
//public void getFileName(String file) {
//	System.out.println(file);
//
//
//}
	String path;
	public List<inspire> getExcelDataAsList(String file) {
//EXCEL_FILE_PATH+=file;
//Path copyLocation = Paths
//.get(uploadDir + File.separator + StringUtils.cleanPath(file));
		
	String s=	uploadDir + File.separator + StringUtils.cleanPath(file);
		List<String> list = new ArrayList<String>();
this.path=s;
		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
//		System.out.println(FileName + "   please");
		System.out.println(uploadDir);
		System.out.println(s);
		
		
		
		inspire inv = new inspire();

	
		inv.setFilepath(s);
	
		inv.setFile(file);

//			invList.add(inv);
		
		// Create the Workbook
//		try {
//			workbook = WorkbookFactory.create(new File(s));
//		} catch ( Exception e) {
//			e.printStackTrace();
//		}
//
//		// Retrieving the number of sheets in the Workbook
//		System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");
//
//		// Getting the Sheet at index zero
//		Sheet spreadsheet = workbook.getSheetAt(0);
//		Iterator < Row >  rowIterator = spreadsheet.iterator();
//		
//	    String table="";
//	    String values="";
//	      while (rowIterator.hasNext()) {
//	         row = (XSSFRow) rowIterator.next();
//	         Iterator < Cell >  cellIterator = row.cellIterator();
//	         
//	         while ( cellIterator.hasNext()) {
//	            Cell cell = cellIterator.next();
//	            int z=cell.getRowIndex(); 
//	      
//	           if(z==0){
//	               switch (cell.getCellType()) {
//	               case Cell.CELL_TYPE_NUMERIC:
//	            	   table+=","+cell.getNumericCellValue()+" "+"int";
//	            	 
//	                  break;
//	               
//	               case Cell.CELL_TYPE_STRING:
//	            	   table+=","+cell.getStringCellValue()+" "+"varchar(255)";
//	            
//	                  break;
//	           }
//	           }
//	           else  {  switch (cell.getCellType()) {
//	               case Cell.CELL_TYPE_NUMERIC:
//	            	   int a=cell.getColumnIndex();
//	                  System.out.print(cell.getNumericCellValue() + " \t\t ");
//	                  break;
//	               
//	               case Cell.CELL_TYPE_STRING:
//	            	   int b=cell.getColumnIndex();
//	                  System.out.print(
//	                  cell.getStringCellValue()+ " \t\t ");
//	                  break;
//	            }
//	           }
//	         }
//	         System.out.println();
//	      }
//	      table = (table.charAt(0) == ',') ? table.substring(1) : table;
//	      table = (table.charAt(table.length()-1) == ',') ? table.substring(0,table.length()-1) : table;
//	      System.out.println(table);
		// Getting number of columns in the Sheet
//		int noOfColumns = spreadsheet.getRow(0).getLastCellNum();
//		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");

		// Using for-each loop to iterate over the rows and columns
//		for (Row row : spreadsheet) {
//			for (Cell cell : row) {
//				String cellValue = dataFormatter.formatCellValue(cell);
//				list.add(cellValue);
//			}
//		}

		// filling excel data and creating list as List<Invoice>
//		List<inspire> invList = createList(list, noOfColumns);

		// Closing the workbook
//		try {
//			workbook.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
		List<inspire> invList = new ArrayList<inspire>();
		invList.add(inv);
		return invList;
	}

//	private List<inspire> createList(List<String> excelData, int noOfColumns) {
//
//		ArrayList<inspire> invList = new ArrayList<inspire>();
//
//		int i = noOfColumns;
//		do {
//			inspire inv = new inspire();
//
//			inv.setuserName(excelData.get(i));
//			inv.setFilepath(path);
////			inv.setNumber(excelData.get(i + 2));
//			inv.setReceivedDate(excelData.get(i + 3));
//
//			invList.add(inv);
//			i = i + (noOfColumns);
//
//		} while (i < excelData.size());
//		return invList;
//	}

	@Override
	public int saveExcelData(List<inspire> invoices) {
		invoices = repo.saveAll(invoices);
		return invoices.size();
	}
}