package com.main.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	public final String upload_dir="G:\\Rupesh\\spring\\Workspace\\FDWeb\\src\\main\\resources\\static\\image";
	
	/*
	 * public final String upload_dir = new
	 * ClassPathResource("classpath:static/image/Thanks.jpg").getFile().
	 * getAbsolutePath();
	 * 
	 * public FileUploadHelper() throws IOException{
	 * 
	 * }
	 */
			
	public boolean uploadFile(MultipartFile file) {
		boolean result=false;
		System.out.println(upload_dir);
		try {
			InputStream is = file.getInputStream();
			System.out.println(upload_dir);
			//read data
			byte data[] = new byte[is.available()];
			is.read(data);
			
			//write data
			FileOutputStream fos = new FileOutputStream(upload_dir+"\\"+file.getOriginalFilename());
			fos.write(data);
			
			fos.flush();
			fos.close();
			result = true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			result= false;
		}
		return result;
	}
	
	public boolean uploadFileNIo(MultipartFile file) {
		boolean result=false;
		try {
			Files.copy(file.getInputStream(), Paths.get(upload_dir+File.separator+file.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
			result = true;
		}catch(Exception ex){
			ex.printStackTrace();
			result= false;
		}
		return result;
	}
}
