package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class tchInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN” “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd”>\r\n");

	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<title>东北大学国家示范性软件学院---教师个人信息</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/index.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/newsList.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/newsContent.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/header.css\" rel=\"stylesheet\">\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/banner.css\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/teacherInfo.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("span.department-title-1{\r\n");
      out.write("    display:block;\r\n");
      out.write("    font-family:\"黑体\";\r\n");
      out.write("    font-size:25px;\r\n");
      out.write("    font-weight:bold;\r\n");
      out.write("    line-height:70px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    color:#1b2c7a;\r\n");
      out.write("}\r\n");
      out.write("p.department2-teacher{\r\n");
      out.write("\tfront-family:\"黑体\";\r\n");
      out.write("\tline-height:20px;\r\n");
      out.write("}\r\n");
      out.write("img.teacherPic{\r\n");
      out.write("\r\n");
      out.write("\tpadding:10px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("div#teacherInfo-left{\r\n");
      out.write("\tmargin-top:40px;\r\n");
      out.write("\tmargin-left:25px;\r\n");
      out.write("\twidth:200px;\r\n");
      out.write("\tmin-height:400px;\r\n");
      out.write("\r\n");
      out.write("\tbackground-image:url('../images/teacherInfo-bg.jpg');\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tfloat: left;\t\r\n");
      out.write("}\r\n");
      out.write("div#teacherInfo-right{\r\n");
      out.write("\tmargin-top:40px;\r\n");
      out.write("\tmargin-left:20px;\r\n");
      out.write("\twidth:520px;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\tfloat: left;\t\r\n");
      out.write("}\r\n");
      out.write("p.teacherInfo-style1{\r\n");
      out.write(" \tdisplay:block;\r\n");
      out.write("    font-family:\"楷体\";\r\n");
      out.write("    font-size:16px;\r\n");
      out.write("    font-weight:bold;\r\n");
      out.write("    line-height:30px;\r\n");
      out.write("    text-align: left;\r\n");
      out.write("    color:#1b2c7a;\r\n");
      out.write("    margin-left:20px;\r\n");
      out.write("}\r\n");
      out.write("div#teacher-area{\r\n");
      out.write("\twidth:820px;\r\n");
      out.write("\tmargin-left:50px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\tmin-height:400px;\r\n");
      out.write("\theight:auto !important;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\tmargin-bottom:20px;\r\n");
      out.write("}\r\n");
      out.write("p.text{\r\n");
      out.write("\t\ttext-indent:2em;\r\n");
      out.write("\t\tfont-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("\t\tfont-size: 13px;\r\n");
      out.write("\t\tline-height: 20px;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"index3-container\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header2.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"index3-news\">\r\n");
      out.write("\t\t<div id=\"index3-news-header\"><span class=\"part-name\">教师简介</span></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\t\r\n");
      out.write("\t\t\t<div id=\"teacher-area\">\r\n");
      out.write("\t\t\t<div id=\"teacherInfo-left\">\r\n");
      out.write("\t\t\t\t\t<img id=\"teacherPic\" height=\"240px\" width=\"175px\">\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"teacherInfo-right\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "banner.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
