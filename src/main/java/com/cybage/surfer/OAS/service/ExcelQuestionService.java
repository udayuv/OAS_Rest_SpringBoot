package com.cybage.surfer.OAS.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.cybage.surfer.OAS.model.Question;

public interface ExcelQuestionService {
	List<Question> findAll();

	boolean savaDataFromUploadfile(MultipartFile file); 

}
