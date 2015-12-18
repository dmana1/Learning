package com.me.care.upload;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private String name;
	MultipartFile file;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
