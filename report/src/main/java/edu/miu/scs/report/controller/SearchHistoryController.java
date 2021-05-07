package edu.miu.scs.report.controller;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.miu.scs.report.service.impl.HistorySearchServiceImpl;
import net.sf.jasperreports.engine.JRException;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/reports")
public class SearchHistoryController {

	@Autowired
	HistorySearchServiceImpl Service;

	@GetMapping("/{format}")
	private String exportReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return Service.exportReport(format);
	}


	@GetMapping("/user")
	public String getUser() throws FileNotFoundException, JRException {

		return Service.exportReportUser();
	}
//	@RequestMapping("/pdf")
//	public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response) throws IOException, JRException {
//		File file = new File(Service.exportReport("pdf"));
//		if (file.exists()) {
//			//get the mimetype
//			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//			if (mimeType == null) {
//				mimeType = "application/octet-stream";
//			}
//			response.setContentType(mimeType);
//
//			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//
////			Here we have mentioned it to show as attachment
//			response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
//
//			response.setContentLength((int) file.length());
//
//			BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//			FileCopyUtils.copy(inputStream, response.getOutputStream());
//
//		}
//	}
}