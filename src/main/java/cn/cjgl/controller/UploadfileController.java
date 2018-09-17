package cn.cjgl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("file")
public class UploadfileController {
	private static Logger logger = Logger.getLogger(UploadfileController.class);
	
	@RequestMapping(value="uploadFile.do", method = RequestMethod.POST,
			produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String uploadFile(@RequestParam("name") String name,
	        @RequestParam("upload") MultipartFile upload,
	        HttpServletRequest request, HttpServletResponse response){
		logger.info("uploadFile");
		
		try {
			File f = new File(request.getSession().getServletContext().getRealPath("")+"/"+name);
			logger.info(f.getPath());
			byte[] bytes = upload.getBytes();
			logger.info("FileName:"+upload.getOriginalFilename());
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(f));
			stream.write(bytes); 
	        stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
		return "{\"msg\":\""+"上传成功！"+"\",\"success\":true}";
	}   

}
