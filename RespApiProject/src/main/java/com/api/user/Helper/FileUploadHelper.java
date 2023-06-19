package com.api.user.Helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
//	public final String UPLOAD_pics="/home/infinite/eclipse-newWorkspace/RespApiProject/src/main/resources/static/image";
	public final String UPLOAD_pics= new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	
	
	public boolean uploadFile(MultipartFile f) {
		boolean value =false;
		try {
//			InputStream is= f.getInputStream();
//			byte data[] = new byte[is.available()];
//			
//			is.read(data);
//			
//			FileOutputStream fos = new FileOutputStream(UPLOAD_pics+File.separator+f.getOriginalFilename());
//			fos.write(data);
//			System.out.println(fos);
//			fos.flush();
//			fos.close();
			
			Files.copy(f.getInputStream(), Paths.get(UPLOAD_pics+File.separator+f.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			
			value=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return value;
	}
	
}
