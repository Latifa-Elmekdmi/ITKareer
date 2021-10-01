package com.platform.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.platform.Entity.Resource;
import com.platform.dao.ResourceRepository;

@Controller
public class ResourcesController {
	// public static String uploadDirectory = System.getProperty("user.home")+"/uploadedResources";
	@Value("${dir.resources}") //elle injecte une propriete
	 private String resourcesDir;
	 @Autowired //injecte un objet
	private ResourceRepository  resourceRepository;
	 
	@GetMapping(path = "/resources")
	public String resources(Model model) {
		File folder = new File(resourcesDir);
		File[] listFiles = folder.listFiles();
		model.addAttribute("listFiles", listFiles);
		return "resources";
	}
	
	@PostMapping(path = "/upload")
	public String uploadFiles(Resource resource ,Model model,@RequestParam("fileResource") MultipartFile file) throws Exception, IOException {
		
		if(!(file.isEmpty())) {
			resource.setResourceName(file.getOriginalFilename());
			file.transferTo(new File(resourcesDir+file.getOriginalFilename()));
		}
		resourceRepository.save(resource);
	
		return "redirect:/resources";
	}
	@RequestMapping("/file/{fileName}")
	@ResponseBody
	public void show(@PathVariable("fileName") String fileName, HttpServletResponse response) {

	      if (fileName.indexOf(".doc")>-1) response.setContentType("application/msword");
	      if (fileName.indexOf(".docx")>-1) response.setContentType("application/msword");
	      if (fileName.indexOf(".xls")>-1) response.setContentType("application/vnd.ms-excel");
	      if (fileName.indexOf(".csv")>-1) response.setContentType("application/vnd.ms-excel");
	      if (fileName.indexOf(".ppt")>-1) response.setContentType("application/ppt");
	      if (fileName.indexOf(".pdf")>-1) response.setContentType("application/pdf");
	      if (fileName.indexOf(".zip")>-1) response.setContentType("application/zip");
	      response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
	      response.setHeader("Content-Transfer-Encoding", "binary");
	      try {
	    	  BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	    	  FileInputStream fis = new FileInputStream(resourcesDir+fileName);
	    	  int len;
	    	  byte[] buf = new byte[1024];
	    	  while((len = fis.read(buf)) > 0) {
	    		  bos.write(buf,0,len);
	    	  }
	    	  bos.close();
	    	  response.flushBuffer();
	      }
	      catch(IOException e) {
	    	  e.printStackTrace();
	    	  
	      }
	}
	 
}
