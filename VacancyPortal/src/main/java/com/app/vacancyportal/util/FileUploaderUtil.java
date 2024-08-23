package com.app.vacancyportal.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploaderUtil {

	public static String uploadFile(Part file, String fileName, String userEmail) throws IOException {
		UUID uuid = UUID.randomUUID();
		String path = "D:/Java Development/Vac portal V3/Vacancy-portal-serv/VacancyPortal/src/main/webapp/images"
				+ File.separator + fileName;
		OutputStream outputStream = null;
		InputStream fileContent = file.getInputStream();
		/*
		 * if (!folder.exists()) { folder.mkdir(); }
		 */
		try {
			outputStream = new FileOutputStream(path);
			int read = 0;
			while ((read = fileContent.read()) != -1) {
				outputStream.write(read);
			}
			outputStream.flush();
			fileContent.close();
			outputStream.close();
			return "images/" + fileName;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "";
	}

}
