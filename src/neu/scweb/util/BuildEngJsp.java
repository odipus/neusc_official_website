package neu.scweb.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import neu.scweb.po.EngNews;




import org.apache.struts2.ServletActionContext;
public class BuildEngJsp {

	private String path;
	
	private List<EngNews> list = new ArrayList<EngNews>();
	
	public BuildEngJsp(List<EngNews> list) {
		this.path = "/html";
		this.list = list;
	}
	
	
	
	public void buildEngPic() {
		
		System.out.println("开始建立图片");
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + "engpicNews.jsp";
		File f = new File(dstPath);
		System.out.println("路径"+dstPath);
		//System.out.println(dstPath);
		
		try {
			f.createNewFile();
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(dstPath),"UTF-8");
									
			out.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>");
			out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			out.write("</head>");
			out.write("</body>");
			
			out.write("<div id='picturenews-left'>");
			out.write("<div style='left:0; top:0;' id='picturenews_piclist'>");
			out.write("<ul id='picturenews_ul_left'>");
			
			for(int i=0;i<list.size();i++){			
				EngNews news = list.get(i);			
				String href="jsp/engNews.jsp?newsId="+news.getNewsId();
				String img = "../ScWeb/"+news.getPicPath();
				System.out.println("img是aa"+img);
				
				if(i==0)
					out.write("<li style='display: list-item;'><a target='_blank' href='"+href+"'><img src='"+img+"'></a></li>");
				else
					out.write("<li style='display: none;'><a target='_blank' href='"+href+"'><img src='"+img+"'></a></li>");
			}
					
			out.write("</ul></div>");
			out.write("<div id='picturenews_opdiv'></div>");
			out.write("<div id='picturenews_btn'>");
			out.write("<ul id='picturenews_ul_right'>");
			
			for(int i=0;i<list.size();i++){			
				EngNews news = list.get(i);			
				String href="jsp/engNews.jsp?newsId="+news.getNewsId();
				String img = "../ScWeb/"+news.getPicPath();
				System.out.println("img是bb"+img);
				String title = news.getNewsTitle();
				if(title.length()>20)
					title = title.substring(0, 20)+"...";
				
				if(i==0)
					//out.write("<li id='p0' class='current'><a target='_blank' href='"+href+"'><p class='picturenews-title'>&nbsp;"+title+"</p></a></li>");
					out.write("<li id='p0' class='current'><a target='_blank' href='"+href+"'><p class='picturenews-title'>&nbsp;1</p></a></li>");
				else
					out.write("<li id='p"+i+"' class='normal'><a target='_blank' href='"+href+"'><p class='picturenews-title'>&nbsp;"+(i+1)+"</p></a></li>");
			}							
				
			out.write("</ul></div>");
			
			out.write("<div id='picturenews_tx'>");
			out.write("<ul id='picturenews_ul_tx'>");
			
			for(int i=0;i<list.size();i++){			
				EngNews news = list.get(i);	
				String title = news.getNewsTitle();
				if(title.length()>20)
					title = title.substring(0, 20)+"...";
				if (i==0)
					out.write("<li class='current'><span class='picNews-title'>"+title+"</span></li>");
				else
					out.write("<li class='normal'><span class='picNews-title'>"+title+"</span></li>");
			}
					
					
			out.write("</ul></div>");
			out.write("</div>");
			
	
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
}
