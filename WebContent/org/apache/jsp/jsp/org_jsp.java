package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class org_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>学院概况</title>\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"");
      out.print(basepath);
      out.write("/icons/favicon.ico\" />\r\n");
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
      out.write("/js/org.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\tspan.title1 {\r\n");
      out.write("    color: #1B2C7A;\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-family: \"黑体\";\r\n");
      out.write("    font-size: 25px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    line-height: 70px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tp.title2{\r\n");
      out.write("\tcolor: #1B2C7A;\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-family: \"黑体\";\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    line-height: 70px;\r\n");
      out.write("   \r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tspan.index3-newsContent-Title{\r\n");
      out.write("\t\tcolor:black;\r\n");
      out.write("\t    font-family:\"黑体\";\r\n");
      out.write("\t    font-size:23px;\r\n");
      out.write("\t    font-weight:400;\r\n");
      out.write("\t    display:block;\r\n");
      out.write("\t    text-align:center;\r\n");
      out.write("\t    line-height:40px;\r\n");
      out.write("\t}\r\n");
      out.write("\tspan.index3-newsContent-Content{\r\n");
      out.write("\t\tfont-family:\"宋体\";\r\n");
      out.write("\t    font-size:14px;\r\n");
      out.write("\t    line-height:20px;\r\n");
      out.write("\t}\r\n");
      out.write("\tspan.index3-newsContent-Info{\r\n");
      out.write("\t\tcolor:#686868;\r\n");
      out.write("\t    font-family:\"黑体\";\r\n");
      out.write("\t    font-size:14px;\r\n");
      out.write("\t    font-weight:400;\r\n");
      out.write("\t    display:block;\r\n");
      out.write("\t    text-align:center;\r\n");
      out.write("\t    line-height:25px;\r\n");
      out.write("\t}\r\n");
      out.write("\tspan.index-newsContent-Editor{\r\n");
      out.write("\t\tcolor:#00008B;\r\n");
      out.write("\t}\r\n");
      out.write("span.department-title-1 {\r\n");
      out.write("    color: #1B2C7A;\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-family: \"黑体\";\r\n");
      out.write("    font-size: 25px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    line-height: 70px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\tdiv#index3-newsContent{\r\n");
      out.write("\twidth:700px;;\r\n");
      out.write("\tmin-height:400px;\r\n");
      out.write("\tdisplay:inline-block;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\r\n");
      out.write("}\t\r\n");
      out.write("\t#orgTable tr{\r\n");
      out.write("\t\theight:20px;\r\n");
      out.write("\t\tfont-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("    font-size: 13px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\tp.text{\r\n");
      out.write("\t\ttext-indent:2em;\r\n");
      out.write("\t\tfont-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("\t\tfont-size: 13px;\r\n");
      out.write("\t\tline-height: 20px;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t</style>\r\n");
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
      out.write("\t\t<div id=\"index3-news-header\"></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"index3-newsContent\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("    \r\n");
      out.write("            \r\n");
      out.write("        \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "banner.jsp", out, false);
      out.write("\r\n");
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
