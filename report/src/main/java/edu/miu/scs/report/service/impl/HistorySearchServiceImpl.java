package edu.miu.scs.report.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.miu.scs.report.domain.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import edu.miu.scs.report.domain.SearchHistory;
import edu.miu.scs.report.repository.SearchHisRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class HistorySearchServiceImpl {
	@Autowired
	SearchHisRepository hisRepo;

	public List<SearchHistory> listHisReport() {

		return hisRepo.findAll();
	}

	public List<DemoUser> getUsers() {

		return getUserList();
	}

	private List<DemoUser> getUserList() {

		List<DemoUser> demoUsers = new ArrayList<DemoUser>();
		demoUsers.add(new DemoUser(1, "TestUser", 22, "Ub", "test@mol.mn"));
		demoUsers.add(new DemoUser(2, "TestUser", 23, "Ub", "test@mol.mn"));
		demoUsers.add(new DemoUser(3, "TestUser", 24, "Ub", "test@mol.mn"));
		demoUsers.add(new DemoUser(4, "TestUser", 24, "Ub", "test@mol.mn"));
		demoUsers.add(new DemoUser(5, "TestUser", 27, "Ub", "test@mol.mn"));


		return demoUsers;
	}

	public String exportReport(String format) throws FileNotFoundException, JRException{
		List<SearchHistory> userList = this.listHisReport();

		String createdURL = System.getProperty("user.dir")  + "/pdf";
//		String createdURL = "C:\\Users\\atakl\\OneDrive\\Desktop\\report";
//		String createdURL = "D:\\MIU\\Project Management PM\\PM Projects(Ataklete Haile)\\PM-\\report\\pdf";

		File file = ResourceUtils.getFile("classpath:templates/productReport.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(userList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy","Ati");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
		if(format.equalsIgnoreCase("pdf"))
		{
			JasperExportManager.exportReportToPdfFile(jasperPrint,createdURL + "/searchHistory.pdf");

		}
		if(format.equalsIgnoreCase("html"))
		{
			JasperExportManager.exportReportToHtmlFile(jasperPrint,createdURL + "/searchHistory.html");

		}

		return "report generated in path "+createdURL;
	}
	public String exportReportUser() throws FileNotFoundException, JRException{
		List<DemoUser> userList = this.getUserList();

		String createdURL = System.getProperty("user.dir")  + "/pdf";
//		String createdURL = "C:\\Users\\atakl\\OneDrive\\Desktop\\report";
//		String createdURL = "D:\\MIU\\Project Management PM\\PM Projects(Ataklete Haile)\\PM-\\report\\pdf";
		File file = ResourceUtils.getFile("classpath:templates/users.jrxml");
		JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(userList);
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("createdBy","Ati");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper,parameters,ds);
//		if(format.equalsIgnoreCase("users/pdf"))
//		{
//			JasperExportManager.exportReportToPdfFile(jasperPrint,createdURL + "\\users.pdf");
//
//		}
//		if(format.equalsIgnoreCase("users/html"))
//		{
//			JasperExportManager.exportReportToHtmlFile(jasperPrint,createdURL + "\\users.html");
//
//		}
//		if(format.equalsIgnoreCase("users"))
//		{
			JasperExportManager.exportReportToPdfFile(jasperPrint,createdURL + "\\user.pdf");

//		}
		return "report generated in path "+createdURL;
	}
}