package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class downloadList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>东北大学国家示范性软件学院</title>\r\n");
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
      out.write("/js/download.js\" type=\"text/javascript\"></script>\r\n");
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
      out.write("}\r\n");
      out.write("\tp.info{\r\n");
      out.write("\t\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-family: \"楷体\";\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    line-height: 30px;\r\n");
      out.write("  \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\ta.downLink{\r\n");
      out.write("\tcolor: #1B2C7A;\r\n");
      out.write("\t display: block;\r\n");
      out.write("     font-family: \"楷体\";\r\n");
      out.write("     font-size: 18px;\r\n");
      out.write("\t margin-right:10px;\r\n");
      out.write("\t margin-left:10px;\r\n");
      out.write("\t margin-top:10px;\r\n");
      out.write("\t display:block;\r\n");
      out.write("\t float:left;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t#downSelect{\r\n");
      out.write("\t\tdisplay:inline;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#docList{\r\n");
      out.write("\t    margin-left:40px;\r\n");
      out.write("\t\twidth:100%;\r\n");
      out.write("\t\theight:270px;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#docPage{\r\n");
      out.write("\t\theight:20px;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#index3-newsContent{\r\n");
      out.write("\t\tmargin-left:40px;\r\n");
      out.write("\t}\r\n");
      out.write("\tspan.index2-right-title{\r\n");
      out.write("\t\tmargin-left:10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t  \r\n");
      out.write("\t#download-table td{\r\n");
      out.write("\t\tBORDER-BOTTOM: #CCC 1px dashed;\r\n");
      out.write("\t}\r\n");
      out.write("\t#docList-table td{\r\n");
      out.write("\t\tBORDER-BOTTOM: #CCC 1px dashed;\r\n");
      out.write("\t}\r\n");
      out.write("\t#docList-table{\r\n");
      out.write("\t\tmargin:0px;\r\n");
      out.write("\t\tpadding:0px;\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</style>\r\n");
      out.write("\t  \r\n");
      out.write("\t\t<SCRIPT TYPE=\"text/javascript\">\r\n");
      out.write("\t\t $(function() {\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t    $('#downSelect').change(\r\n");
      out.write("\t\t\t      function() {\r\n");
      out.write("\t\t\t      \r\n");
      out.write("\t\t\t    \ttop.location = $(this).val();\r\n");
      out.write("\t\t\t        return false;\r\n");
      out.write("\t\t\t      });\r\n");
      out.write("\t\t });\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t/* \tfunction dropdown(mySel)\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\tvar myWin, myVal;\r\n");
      out.write("\t\t\tmyVal = mySel.options[mySel.selectedIndex].value;\r\n");
      out.write("\t\t\tif(myVal)\r\n");
      out.write("\t\t\t   {\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t   top.location = myVal;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t\t} */\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</SCRIPT>\r\n");
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
      out.write("\r\n");
      out.write("\t<div id=\"index3-news\">\r\n");
      out.write("\t\t<div id=\"index3-news-header\"><span class=\"part-name\">资源下载</span></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\r\n");
      out.write(" \t\r\n");
      out.write("\t\t\t<div id=\"docList\" style=\"margin-top:20px;\">\r\n");
      out.write("\t\t\t\t<span class=\"downSelect\"  >常用资料下载：</apan>\t\r\n");
      out.write("\t\t\t\t<table id='docList-table' width='820px' top=\"250px\" bgcolor='#F5F6F8'></table>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"docPage\"></div>\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"index3-newsContent\">\r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<span class=\"downSelect\"  >按类别查看新闻附件：</apan>\t\t\t\r\n");
      out.write("\t\t\t\t<select id=\"downSelect\" name=\"downList\">\t\r\n");
      out.write("\t\t\t\t<option value=\"downloadList.jsp?page=1&sec=all\">全部</opstion>\t\t\t\t\r\n");
      out.write("\t\t\t\t</select>\t\r\n");
      out.write("\t\t\t\t<br/>\t\r\n");
      out.write("\t\t\t\t<table id='download-table' width='820px' bgcolor='#F5F6F8'></table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
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
