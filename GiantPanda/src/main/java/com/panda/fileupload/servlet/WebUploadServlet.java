package com.panda.fileupload.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class WebUploadServlet
 */
public class WebUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadPath = "F:\\temp"; // 上传文件的目录
    private String tempPath = "F:\\temp\\buffer"; // 临时文件目录
    File tempPathFile=new File(tempPath);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		 
        factory.setSizeThreshold(4096*1024*1024); // 设置缓冲区大小，这里是4kb
        factory.setRepository(tempPathFile);// 设置缓冲区目录

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setHeaderEncoding("UTF-8");
        // Set overall request size constraint
        upload.setSizeMax(4194304*1021); // 设置最大文件尺寸，这里是4MB
        try{
        List<FileItem> items = upload.parseRequest(request);// 得到所有的文件
        Map<String,String> map=new HashMap<String,String>();
        for(FileItem item:items){
        	if(item.isFormField())
        		map.put(item.getFieldName(), item.getString("UTF-8"));
        }
        System.out.println(map);
        Iterator<FileItem> i = items.iterator();
        List<Map<String,Object>> resultList=new ArrayList<Map<String,Object>>();
        while (i.hasNext()) {
           Map<String,Object> resultMap=new HashMap<String,Object>();
           
           FileItem fi = (FileItem) i.next();
           String fileName = fi.getName();
           if (fileName != null) {
               File fullFile = new File(fi.getName());
               File savedFile = new File(uploadPath, fullFile.getName());
               resultMap.put("fi", fi);
               resultMap.put("saveFile", savedFile);
               resultList.add(resultMap);
               fi.write(savedFile);
           }
           else{
        	   
           }
        }
        System.out.print("upload succeed");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        response.setContentType("json");
        PrintWriter out=response.getWriter();
        out.write("{a:'upload succeed'}");
	}

}
