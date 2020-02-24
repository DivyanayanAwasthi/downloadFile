package com.excel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.Produces;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

		@Autowired
		private ApiService apiService;
	 	@GetMapping
	 	@Produces("application/pdf")
	    public ResponseEntity downloadFileWithGet() throws IOException {
	 		List<Employee> employees =  apiService.getData();
	 		XSSFWorkbook workbook = new XSSFWorkbook(); 
	 		XSSFSheet sheet = workbook.createSheet("sheet1");// creating a blank sheet
	 		 int rownum = 0;
	         for (Employee user : employees)
	            {
	            Row row = sheet.createRow(rownum++);
	            createList(user, row);
	                
	        }    
	         ByteArrayOutputStream bos = new ByteArrayOutputStream();
	         workbook.write(bos);
	         //workbook.write(out);
	         byte[] barray = bos.toByteArray();
	         InputStream is = new ByteArrayInputStream(barray);
	           InputStreamResource inputStreamResource = new InputStreamResource(is);
	           bos.close();
	 		return ResponseEntity.ok()
	 				.contentType(MediaType.MULTIPART_FORM_DATA)
	 				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "x1.xlsx" + "\"")
	 				.body(inputStreamResource);
	    }
	 	
	 	 private static void createList(Employee user, Row row) // creating cells for each row
	 	{
	 	        Cell cell = row.createCell(0);
	 	        cell.setCellValue(user.getEmployeeId());
	 	     
	 	        cell = row.createCell(1);
	 	        cell.setCellValue(user.getEmployeeName());
	 	     
	 	       
	 	    }
	 	}
	 

