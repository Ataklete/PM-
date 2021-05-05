package edu.miu.scs.report.controller;

import java.io.*;
import java.net.URLConnection;
import java.util.List;

import edu.miu.scs.report.domain.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import edu.miu.scs.report.service.impl.HistorySearchServiceImpl;
import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/reports")
public class SearchHistoryController {

	@Autowired
	HistorySearchServiceImpl Service;


	@GetMapping("/html")
	private String exportReport() throws FileNotFoundException, JRException {
		return Service.exportReport("html");
	}
	@GetMapping("/users")
	public List<DemoUser> getUser(){

		return Service.getUsers();
	}
	@RequestMapping("/pdf")
	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
		File file = new File(Service.exportReport("pdf"));
		if (file.exists()) {
			//get the mimetype
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);

			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

//			Here we have mentioned it to show as attachment
			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

			response.setContentLength((int) file.length());

			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));

			FileCopyUtils.copy(inputStream, response.getOutputStream());

		}
	}
}