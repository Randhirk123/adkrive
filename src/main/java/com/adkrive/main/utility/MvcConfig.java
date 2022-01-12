package com.adkrive.main.utility;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	private static String filepath="";
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        exposeDirectory("photo/admin", registry);
	    }
	 
	 private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {

		 Path uploadDir = Paths.get(dirName);
	        String uploadPath = uploadDir.toFile().getAbsolutePath();
	         
	        if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
	         
	        registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
	    }
	 
	 public static String  getPath(String filePath) {
		 filepath=filePath.replace("/", "");
		 return filepath;
	 }
}
