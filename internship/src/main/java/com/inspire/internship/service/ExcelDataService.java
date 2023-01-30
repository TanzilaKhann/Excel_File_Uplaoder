package com.inspire.internship.service;
import java.util.List;

import com.inspire.internship.entity.*;
public interface ExcelDataService {
	List<inspire> getExcelDataAsList(String file);
	
	int saveExcelData(List<inspire> invoices);
}
