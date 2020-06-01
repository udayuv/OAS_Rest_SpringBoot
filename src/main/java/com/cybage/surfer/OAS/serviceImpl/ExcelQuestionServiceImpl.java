package com.cybage.surfer.OAS.serviceImpl;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cybage.surfer.OAS.model.Question;
import com.cybage.surfer.OAS.repository.ExcelQuestionRepository;
import com.cybage.surfer.OAS.service.ExcelQuestionService;


@Service
@Transactional
public class ExcelQuestionServiceImpl implements ExcelQuestionService {

	@Autowired
	private ExcelQuestionRepository questionRepository;
	
	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return (List<Question>) questionRepository.findAll();
	}

	@Override
	public boolean savaDataFromUploadfile(MultipartFile file) {
		boolean isFlag =false;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		if(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx") ){
			isFlag = readDataFromExcel(file);
		}
		return isFlag;
	}

	//to read all the data from the file
	private boolean readDataFromExcel(MultipartFile file) {
		Workbook workbook = getWorkBook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		String question=null,opt1=null,opt2=null, opt3=null, opt4=null,correctans=null,dlevel=null,sub_topic=null, marks=null;
		int id = 0,counter=0;
		rows.next();
		String [] options = new String[4];
		while(rows.hasNext()){
			Row row = rows.next();
			Question ques = new Question();
			
			System.out.println("id-------: "+new DataFormatter().formatCellValue(row.getCell(0)));
			System.out.println("marks-------: "+new DataFormatter().formatCellValue(row.getCell(4)));
			if(counter ==0){
					id=Integer.parseInt(new DataFormatter().formatCellValue(row.getCell(0)));
				
			}
			if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING){
				if(counter ==0)
					question=row.getCell(1).getStringCellValue();
				
			}
			if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING){
				// internal checking
				options[counter]=row.getCell(2).getStringCellValue();
			}			
			if(row.getCell(3).getCellType() == Cell.CELL_TYPE_STRING){
				if(counter ==0)
					correctans=row.getCell(3).getStringCellValue();
			}
			
				if(counter ==0){
					marks=new DataFormatter().formatCellValue(row.getCell(4));
			}
			if(row.getCell(5).getCellType() == Cell.CELL_TYPE_STRING){
				if(counter ==0)
					dlevel =row.getCell(5).getStringCellValue();
			}
			if(row.getCell(6).getCellType() == Cell.CELL_TYPE_STRING){
				if(counter ==0)	
					sub_topic =row.getCell(6).getStringCellValue();
			}
		
			
			//ques.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
			
		
			
			System.out.println("---- set in parameter const-------------------->");
				
			
		
			for(int i=0; i<options.length; i++){
				System.out.println(options[i]);
			}
			
			if(counter==3){
				opt1=options[0];
				opt2=options[1];
				opt3=options[2];
				opt4=options[3];
				//Question ques1 = new Question(id,question,opt1,opt2, opt3, opt4,correctans,dlevel,sub_topic,marks,ques.getFileType());
				//questionRepository.save(ques1);
				counter =0;
			}
			else{
				counter++;
			}
			
		}
		return true;
	}

	private Workbook getWorkBook(MultipartFile file) {
		Workbook workbook =null;
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		
		try {
			
			if(extension.equalsIgnoreCase("xls")){
				workbook = new XSSFWorkbook(file.getInputStream());
			}else if(extension.equalsIgnoreCase("xlsx")) {
				workbook = new XSSFWorkbook(file.getInputStream());
			}
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
