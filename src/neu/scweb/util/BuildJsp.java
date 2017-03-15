package neu.scweb.util;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import neu.scweb.po.ExpandNews;
import neu.scweb.po.News;
//import org.apache.commons.codec.binary.Base64;
import org.apache.struts2.ServletActionContext;

public class BuildJsp {
	private String path;
	private String name;
	private List<News> list = new ArrayList<News>();
	private List<ExpandNews> expandNews_list = new ArrayList<ExpandNews>();

	public BuildJsp(List<News> list) {
		this.path = "/html";
		this.list = list;
	}
	//为了 实现 picNews 界面更新 传送包含图像的news，，而创建的 结构体
	public BuildJsp(List<ExpandNews> expandNews,int i) {
		this.path = "/html";
		this.expandNews_list = expandNews;
	}

	public BuildJsp(String name, List<News> list) {
		this.path = "/html";
		this.name = name;
		this.list = list;
	}
	


	public void buildLeft() {
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + this.getName();
		File f = new File(dstPath);
		System.out.println(dstPath);
		
		

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
			for(int i=0;i<list.size();i++){
				News news = list.get(i);
				
				String title = news.getNewsTitle();
				if(news.getNewsTitle().length()>11){
					title = news.getNewsTitle().substring(0,10)+"...";
				}
				String href="jsp/newsContent.jsp?newsId="+news.getNewsId();
				out.write("<span class='news-title'><a href='"+href+"' title='"+news.getNewsTitle()+"' target='_blank'>"+title+"</a></span>");
			}
				
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	
	}

	public void buildRight() {
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + this.getName();
		File f = new File(dstPath);
		System.out.println(dstPath);
		
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
			for(int i=0;i<list.size();i++){
				News news = list.get(i);
				
				String title = news.getNewsTitle();
				if(news.getNewsTitle().length()>10){
					title = news.getNewsTitle().substring(0,9)+"...";
				}
				String href="jsp/newsContent.jsp?newsId="+news.getNewsId();
				out.write("<span class='news-title'><a href='"+href+"' title='"+news.getNewsTitle()+"' target='_blank'>"+title+"</a></span>");
			}
				
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	
	}
	
	public void buildCenter() {
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + this.getName();
		File f = new File(dstPath);
		System.out.println(dstPath);		

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
			for(int i=0;i<list.size();i++){			
				News news = list.get(i);
				String title = news.getNewsTitle();
				if(news.getNewsTitle().length()>14){
					title = news.getNewsTitle().substring(0,13)+"...";
				}	
				
				String href="jsp/newsContent.jsp?newsId="+news.getNewsId();
				out.write("<span class='news-title-center'><img class='news-arrow' src='icons/arrow.gif'><a href='"+href+"' title='"+news.getNewsTitle()+"' target='_blank'>"+title+"</a></span>");
			}
				
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	
	
	}

	public void buildSlide() {
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + "slideNews.jsp";
		File f = new File(dstPath);
		System.out.println(dstPath);
		
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
			for(int i=0;i<list.size();i++){			
				News news = list.get(i);
				
				String href="jsp/newsContent.jsp?newsId="+news.getNewsId();
				String date = news.getNewsDate().toString();	
				out.write("<span class='announcement-title'>["+news.getSection().getSectionName()+"]&nbsp;<a href='"+href+"' title='"+news.getNewsTitle()+"' target='_blank'>"+news.getNewsTitle()+"("+date.substring(5,10)+")</a></span>");
			}				
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public void buildPic() {
//		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "\\";
		String dstPath = ServletActionContext.getServletContext().getRealPath(this.getPath())+ "/";
		dstPath = dstPath + "picNews.jsp";
		System.out.println(dstPath);
		File f = new File(dstPath);
		InputStream inputStream = null;
		InputStreamReader inputStreamReader =null;
		BufferedReader bufferedReader = null;
		StringBuilder stringBuilder = null;
		String line = null;
		
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
			for(int i=0;i<expandNews_list.size();i++){			
				ExpandNews expandNews = expandNews_list.get(i);
				byte[] pic=expandNews.getPicContent();
			    String picbase = Base64.getEncoder().encodeToString(pic);
				String href="jsp/newsContent.jsp?newsId="+expandNews.getNewsId();
				
				if(i==0){
					out.write("<%");
					out.write("String picnewsMax"+i+" = \"" +picbase+"\";");
					out.write("%>");
					out.write("<li style='display: list-item;'><a target='_blank' href='"+href+"'><img id='picnewsMax"+i+"'  src='data:image/png;base64,");
					out.write("<%");
					out.write("out.print(picnewsMax"+i+");");
					out.write("%>");
					out.write("'></a></li>");
				}
				else{
					out.write("<%");
					out.write("String picnewsMax"+i+" = \"" +picbase+"\";");
					out.write("%>");
					out.write("<li style='display: none;'><a target='_blank' href='"+href+"'><img id='picnewsMax"+i+"'  src='data:image/png;base64,");
					out.write("<%");
					out.write("out.print(picnewsMax"+i+");");
					out.write("%>");
					out.write("'></a></li>");
				}
			}
			out.write("</ul></div>");
			out.write("<div id='picturenews_opdiv'></div>");
			out.write("<div id='picturenews_tx'>");
			out.write("<ul id='picturenews_ul_tx'>");
			
			for(int i=0;i<expandNews_list.size();i++){			
				ExpandNews expandNews = expandNews_list.get(i);
				String title = expandNews.getNewsTitle();
				if(title.length()>20)
					title = title.substring(0, 18)+"...";
				if (i==0)
					out.write("<li class='current'><span class='picNews-title'>"+title+"</span></li>");
				else
					out.write("<li class='normal'><span class='picNews-title'>"+title+"</span></li>");
			}
			out.write("</ul></div>");
			out.write("</div>");
			out.write("<div id='picturenews_btn'>");
			out.write("<ul id='picturenews_ul_right'>");
			
			for(int i=0;i<expandNews_list.size();i++){			
				ExpandNews expandNews = expandNews_list.get(i);
				byte[] pic=expandNews.getPicContent();
			    String picbase = Base64.getEncoder().encodeToString(pic);
				String href="jsp/newsContent.jsp?newsId="+expandNews.getNewsId();
				String title = expandNews.getNewsTitle();
				if(title.length()>22)
					title = title.substring(0, 20)+"...";
				if(i==0){

					out.write("<li id='p0' class='current'><img id='picnewsMin"+i+"' alt='"+expandNews.getNewsTitle()+"'  src='data:image/png;base64,");
					out.write("<%");
					out.write("out.print(picnewsMax"+i+");");
					out.write("%>");
					
					out.write("'><a target='_blank' href='"+href+"'><p class='picturenews-title'>&nbsp;"+title+"</p></a></li>");
				}
				else{

					out.write("<li id='p"+i+"' class='normal'><img id='picnewsMin"+i+"'alt='"+expandNews.getNewsTitle()+"' src='data:image/png;base64,");
					out.write("<%");
					out.write("out.print(picnewsMax"+i+");");
					out.write("%>");
					out.write("'><a target='_blank' href='"+href+"'><p class='picturenews-title'>&nbsp;"+title+"</p></a></li>");
			
				}
					
			}				
				
			out.write("</ul></div>");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	
}
