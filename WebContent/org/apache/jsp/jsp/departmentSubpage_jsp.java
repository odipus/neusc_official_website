package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class departmentSubpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("/css/header.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/banner.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/departmentSubpage.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/departmentSubpage.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(basepath);
      out.write("/js/swfobject.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var flashvars = {};   \r\n");
      out.write("var params = {};   \r\n");
      out.write("params.quality = \"high\";   \r\n");
      out.write("params.bgcolor = \"#117390\";   \r\n");
      out.write("params.play = \"true\";   \r\n");
      out.write("params.loop = \"ture\";   \r\n");
      out.write("params.scale = \"showall\";   \r\n");
      out.write("params.menu = \"false\";   \r\n");
      out.write("params.devicefont = \"false\";   \r\n");
      out.write("params.salign = \"\";   \r\n");
      out.write("params.allowscriptaccess = \"sameDomain\";   \t  \r\n");
      out.write("params.wmode = \"Opaque\";\r\n");
      out.write("swfobject.embedSWF(\"../flash/header-flash3.swf\", \"header-flash-place\", \"1024px\", \"137px\", \"6.0.0\", \"expressInstall.swf\",flashvars,params);\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("/*重写部分menu的css*/\r\n");
      out.write("\tdiv#menu {\r\n");
      out.write("    background: url('../images/department-menu-bg.png');\r\n");
      out.write("\tbackground-repeat: repeat-x; \r\n");
      out.write("    width:1024px;\r\n");
      out.write("    height:36px;\r\n");
      out.write("    border:0px;\r\n");
      out.write("    padding:0px;\r\n");
      out.write("    margin:0px;\r\n");
      out.write("    line-height:0px;\r\n");
      out.write("    z-index:1;\r\n");
      out.write("    }\r\n");
      out.write("span.index3-newsContent-Title{\r\n");
      out.write("\tcolor:black;\r\n");
      out.write("    font-family:\"黑体\";\r\n");
      out.write("    font-size:23px;\r\n");
      out.write("    font-weight:400;\r\n");
      out.write("    display:block;\r\n");
      out.write("    text-align:center;\r\n");
      out.write("    line-height:40px;\r\n");
      out.write("}\r\n");
      out.write("span.index3-newsContent-Content{\r\n");
      out.write("\tfont-family:\"宋体\";\r\n");
      out.write("    font-size:14px;\r\n");
      out.write("    line-height:20px;\r\n");
      out.write("}\r\n");
      out.write("span.index3-newsContent-Info{\r\n");
      out.write("\tcolor:#686868;\r\n");
      out.write("    font-family:\"黑体\";\r\n");
      out.write("    font-size:14px;\r\n");
      out.write("    font-weight:400;\r\n");
      out.write("    display:block;\r\n");
      out.write("    text-align:center;\r\n");
      out.write("    line-height:25px;\r\n");
      out.write("}\r\n");
      out.write("span.index-newsContent-Editor{\r\n");
      out.write("\tcolor:#00008B;\r\n");
      out.write("}\r\n");
      out.write("div#header {\r\n");
      out.write("    background-image: url(\"../images/department-header-bg.png\");\r\n");
      out.write("    background-repeat: repeat-x;\r\n");
      out.write("    height: 69px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    z-index: -1;\r\n");
      out.write("}\r\n");
      out.write("\tp.text{\r\n");
      out.write("\t\ttext-indent:2em;\r\n");
      out.write("\t\tfont-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("\t\tfont-size: 13px;\r\n");
      out.write("\t\tline-height: 20px;\r\n");
      out.write("\t\ttext-align: left;\r\n");
      out.write("\t}\r\n");
      out.write("div#index3-download span {\r\n");
      out.write("    color: #686868;\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    line-height: 25px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("div#index3-download {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    height: auto;\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("    margin-left: 60px;\r\n");
      out.write("    margin-top: 50px;\r\n");
      out.write("    width: 800px;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("div#department2-main-content-area {\r\n");
      out.write("    margin-left: 50px;\r\n");
      out.write("    overflow: hidden;\r\n");
      out.write("    width: 820px;\r\n");
      out.write("    height: auto !important;\r\n");
      out.write("    min-height: 300px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("    <div class=\"department-index-container\">\r\n");
      out.write("\t<div id=\"header-container\">\r\n");
      out.write("\t<!-- container begin -->\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("\t\t<!-- header begin -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<div id=\"swc\">\r\n");
      out.write("\t\t\t<!-- swc begin -->\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;<img src=\"");
      out.print(basepath);
      out.write("/images/header-title2.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- swc end -->\r\n");
      out.write("\t\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t<!-- search begin -->\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(basepath);
      out.write("/images/department-header-arrow.png\">&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"text\" name=\"search\" />&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.print(basepath);
      out.write("/images/department-header-search.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- search end -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- header end -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"menu\">\r\n");
      out.write("\t\t<!-- menu beign -->\r\n");
      out.write("\t\t\t<div id=\"menu-blank\"></div>\r\n");
      out.write("\t\t\t<div id=\"department-title\"></div>\r\n");
      out.write("\t\t\t<div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>\r\n");
      out.write("\t\t   <ul class=\"menu\">\r\n");
      out.write("\t\t       <li><a id=\"menuIndex\" class=\"parent\"><span>首页</span></a></li>\r\n");
      out.write("\t\t        <div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>\r\n");
      out.write("\t\t        <li><a id=\"menuDuty\" class=\"parent\"><span>机构简介</span></a></li>\r\n");
      out.write("\t\t        <div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>\r\n");
      out.write("\t\t        <li><a id=\"menuTeach\" class=\"parent\"><span>师资队伍</span></a></li>\r\n");
      out.write("\t\t        <div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>\r\n");
      out.write("\t\t        <li><a id=\"menuNews\" class=\"parent\"><span>新闻动态</span></a></li>\r\n");
      out.write("\t\t        <div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>\r\n");
      out.write("\t\t        <li><a href=\"");
      out.print(basepath);
      out.write("/index.jsp\" class=\"parent\"><span>返回学院网站</span></a></li>  \r\n");
      out.write("\t\t        <div class=\"department-menu-line\"><img src=\"");
      out.print(basepath);
      out.write("/images/department-menu-line.png\"></div>        \r\n");
      out.write("\t\t    </ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- menu end -->\r\n");
      out.write("\t\t<div id=\"header-flash\"><div id=\"header-flash-place\"></div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"header-line\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- container end -->\r\n");
      out.write("\t\t<div id=\"department2-main\">\r\n");
      out.write("\t\t<div id=\"department2-main-header\"></div>\r\n");
      out.write("\t\t<div id=\"department2-main-content\">\r\n");
      out.write("\t\t\t<div id=\"department2-main-content-area\">\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t<div id=\"index3-download\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "banner.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
