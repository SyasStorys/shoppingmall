package net.kzn.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final String ABS_PATH = "C:\\DEV\\workspace\\onlineshopping\\onlineshopping\\src\\main\\webapp\\resources\\images\\";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest req, MultipartFile file, String code) {
		
		// get the real path
		REAL_PATH = req.getSession().getServletContext().getRealPath("/resources/images/");
		
		logger.info(REAL_PATH);
		
		// to make sure all the directory exists
		// please create the directories
		if(!new File(ABS_PATH).exists()) {
			// create the directories
			new File(ABS_PATH).mkdir();
		}
		
		if(!new File(REAL_PATH).exists()) {
			// create the directories
			new File(REAL_PATH).mkdir();
		}
		
		try {
			// server upload
			file.transferTo(new File (REAL_PATH + code + ".jpg"));
			// project directory upload
			file.transferTo(new File (ABS_PATH + code + ".jpg"));
		}
		catch(IOException e) {
			
		}
	}
	
	

}
