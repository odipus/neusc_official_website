package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class department_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/index.css\" rel=\"stylesheet\"  type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/newsContent.css\" rel=\"stylesheet\"  type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/header.css\" rel=\"stylesheet\"  type=\"text/css\"/>\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/banner.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/style.css\" rel=\"stylesheet\" type=\"text/css\" >\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/department.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.easing-1.3.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.slide-0.4.3.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/swfobject.js\"  type=\"text/javascript\"></script>\r\n");
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
      out.write("</script>\t\r\n");
      out.write("\t\t\r\n");
      out.write("<style>\r\n");
      out.write("div.department-index-container{\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\twidth:1024px;\r\n");
      out.write("\tmargin:0 auto;\r\n");
      out.write("\tbackground-image:url('../images/department-index-bg.png');\r\n");
      out.write("\tbackground-repeat: repeat;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("div#department-title{\r\n");
      out.write("\tpadding-left:10px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("\twidth:190px;\r\n");
      out.write("\theight:36px;\r\n");
      out.write("}\r\n");
      out.write("div.department-menu-line{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\twidth:4px;\r\n");
      out.write("\theight:36px;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("div#department-left{\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\tclear:both;\r\n");
      out.write("\twidth:208px;\r\n");
      out.write("\theight:504px;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("div#department-right{\r\n");
      out.write("\tborder:1px solid #A8A8A8;\r\n");
      out.write("\theight:501px;\r\n");
      out.write("\tborder-right:0px;\r\n");
      out.write("\tborder-bottom:0px;\r\n");
      out.write("\t}\r\n");
      out.write("div#department-right-header{\r\n");
      out.write("\twidth:776px;\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\tbackground-image:url('../images/department-right-header.png');\r\n");
      out.write("\t}\r\n");
      out.write("div#department-right-content{\r\n");
      out.write("\twidth:740px;;\r\n");
      out.write("\theight:473px;\r\n");
      out.write("\tborder:1px solid #A8A8A8;\r\n");
      out.write("\tborder-top:0px;\r\n");
      out.write("\tborder-left:0px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tbackground-color:white;\r\n");
      out.write("\t}\r\n");
      out.write("div#department-right-content-area{\r\n");
      out.write("\twidth:640px;\r\n");
      out.write("\theight:100%;\r\n");
      out.write("\tclear:left;\r\n");
      out.write("\tmargin-left:50px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("}\r\n");
      out.write("div.department-side{\r\n");
      out.write("\t\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:250px;\r\n");
      out.write("\tborder:1px solid #A8A8A8;\r\n");
      out.write("\tbackground-color:white;\r\n");
      out.write("\tover-flow:hidden;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("div.department-side-pic{\r\n");
      out.write("\t\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:210px;\r\n");
      out.write("\tborder:1px solid #A8A8A8;\r\n");
      out.write("\tbackground-color:white;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("div.department-side-header{\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\tbackground-image:url('../images/department-side-header.png');\r\n");
      out.write("\t}\r\n");
      out.write("div.department-side-content{\r\n");
      out.write("\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:217px;\r\n");
      out.write("\tline-height:20px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("div.department-side-line{\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:5px;\r\n");
      out.write("\tbackground-image:url('../images/index-side-line.png');\r\n");
      out.write("\tbackground-repeat: repeat-x;\r\n");
      out.write("\t}\r\n");
      out.write("div.department-side-bottom{\r\n");
      out.write("\tvertical-align:middle;\r\n");
      out.write("\theight:25px;\r\n");
      out.write("\tmargin-left:130px;\r\n");
      out.write("\tmargin-top:20px;\r\n");
      out.write("\tline-height:25px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("marquee#announcement{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin-top:10px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\t\r\n");
      out.write("\t_margin-top:10px;\r\n");
      out.write("\t height:140px;\r\n");
      out.write("\t width:180px;\r\n");
      out.write("}\r\n");
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
      out.write("    div#menu-blank{\r\n");
      out.write("\twidth:40px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tbackground-repeat: repeat-x; \r\n");
      out.write("\tbackground: url('../images/department-menu-bg.png');\r\n");
      out.write("    height:36px;\r\n");
      out.write("    display:inline;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#menu ul.menu {\r\n");
      out.write("    padding-right: 3px;  \r\n");
      out.write("\tbackground: url('../images/department-menu-bg.png') right 0;\r\n");
      out.write("\tbackground-repeat: repeat-x; \r\n");
      out.write("    }\r\n");
      out.write("    div#menu a {\r\n");
      out.write("    line-height: 34px;\r\n");
      out.write("    height: 36px;\r\n");
      out.write("    margin-right:5px;\r\n");
      out.write("    text-transform: uppercase;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    z-index: 10;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    float: left;\r\n");
      out.write("    line-height: 36px;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    white-space: nowrap;\r\n");
      out.write("    width: auto;\r\n");
      out.write("    text-align:center;\r\n");
      out.write("   }\r\n");
      out.write("    div#menu span {\r\n");
      out.write("    padding-left: 5px;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    font: normal 13px;\r\n");
      out.write("    background: none;\r\n");
      out.write("    line-height: 36px;\t\r\n");
      out.write("    display: block;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\tdiv#menu ul.menu>li:hover>a span {\r\n");
      out.write("\t color:#B15BFF;\r\n");
      out.write("}\r\n");
      out.write(" /*   重写部分header的css */\r\n");
      out.write("    div#header-line{\r\n");
      out.write("\twidth:1024px;\r\n");
      out.write("\theight:8px;\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tbackground-image:url('../images/department-header-line.png');\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tdisplay:inline; \r\n");
      out.write("}\r\n");
      out.write("div#header-login{\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\twidth:983px;\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("\tborder: 1px solid #A8A8A8;\r\n");
      out.write("\tborder-right:0px;\r\n");
      out.write("\tborder-top:0px;\r\n");
      out.write("\tborder-bottom:0px;\r\n");
      out.write("\tvertical-align:middle; \r\n");
      out.write("\tline-height:24px;\r\n");
      out.write("\tborder-bottom:1px;\r\n");
      out.write("\tbackground-image:url('../images/department-login-bg.jpg');\r\n");
      out.write("\tbackground-repeat: repeat-x; \r\n");
      out.write("\tdisplay:inline; \r\n");
      out.write("\t}\r\n");
      out.write("\t/*重写banner的css*/\r\n");
      out.write("\tp.banner2 a:link{\r\n");
      out.write("\tcolor:#554590;\r\n");
      out.write("\tfont-family:黑体;\r\n");
      out.write("\tfont-weight: bold; \r\n");
      out.write("\t}\r\n");
      out.write("\tp.banner2 a:visited{\r\n");
      out.write("\tcolor:#554590;\r\n");
      out.write("\tfont-family:黑体;\r\n");
      out.write("\tfont-weight: bold; \r\n");
      out.write("\t}\r\n");
      out.write("\tp.banner2 a:active{\r\n");
      out.write("\tcolor:#554590;\r\n");
      out.write("\tfont-family:黑体;\r\n");
      out.write("\tfont-weight: bold; \r\n");
      out.write("\t}\r\n");
      out.write("\tdiv#banner-line {\r\n");
      out.write("    background-image: url(\"../images/department-banner-line.png\");\r\n");
      out.write("    background-repeat: repeat-x;\r\n");
      out.write("    float: left;\r\n");
      out.write("    height: 5px;\r\n");
      out.write("  \r\n");
      out.write("    position: relative;\r\n");
      out.write("    width: 1024px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("div#department-title span{\r\n");
      out.write("    display:inline;\r\n");
      out.write("    font-family:\"黑体\";\r\n");
      out.write("    font-size:18px;\r\n");
      out.write("    font-weight:600;\r\n");
      out.write("    letter-spacing: -0.3mm;\r\n");
      out.write("}\r\n");
      out.write("div#header {\r\n");
      out.write("    background-image: url(\"../images/department-header-bg.png\");\r\n");
      out.write("    background-repeat: repeat-x;\r\n");
      out.write("    height: 69px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    z-index: -1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/*部门业常用文字样式*/\r\n");
      out.write("span.department-title-1{\r\n");
      out.write("    display:block;\r\n");
      out.write("    font-family:\"黑体\";\r\n");
      out.write("    font-size:25px;\r\n");
      out.write("    font-weight:bold;\r\n");
      out.write("    line-height:70px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    color:#1b2c7a;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p.text{\r\n");
      out.write("\ttext-indent:2em;\r\n");
      out.write("\tfont-family: Arial,Helvetica,sans-serif;\r\n");
      out.write("\tfont-size: 13px;\r\n");
      out.write("\tline-height: 20px;\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#picRonud {position:relative; width:207px; height:180px; overflow:hidden; font-size:13px} \r\n");
      out.write("#picRonud_list img {border:0px;} \r\n");
      out.write("#picRonud_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=20);opacity:0.1;z-index:1000;cursor:pointer; width:205px; } \r\n");
      out.write("#picRonud_info{display:block;\r\n");
      out.write("position:absolute; bottom:2px; left:5px;height:25px;color:black;z-index:1001;cursor:pointer} \r\n");
      out.write("#picRonud_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;} \r\n");
      out.write("#picRonud ul { position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; z-index:1002; \r\n");
      out.write("margin:0; padding:0; bottom:3px; right:5px; height:25px} \r\n");
      out.write("#picRonud ul li { padding:0 8px; line-height:20px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background-color:#6f4f67;cursor:pointer; margin:0; font-size:13px;} \r\n");
      out.write("#picRonud_list a{position:absolute;} </style> \r\n");
      out.write("</head>\r\n");
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
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"swc\">\r\n");
      out.write("\t\t\t<!-- swc begin -->\r\n");
      out.write("\t\t\t\t&nbsp;&nbsp;<img src=\"");
      out.print(basepath);
      out.write("/images/header-title2.png\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- swc end -->\r\n");
      out.write("\t\t\t<div id=\"search\">\r\n");
      out.write("\t\t\t<!-- search begin -->\r\n");
      out.write("\r\n");
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
      out.write("\t\t    <ul class=\"menu\">\r\n");
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
      out.write("\t</div>\r\n");
      out.write("\t<!-- container end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"40px\"></td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div id=\"department-left\">\r\n");
      out.write("\t\t\t\t<div class=\"department-side\">\r\n");
      out.write("\t\t  \t\t\t<div class=\"department-side-header\"><span class='part-name'>最新动态</span></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"department-side-line\"></div>\r\n");
      out.write("\t\t  \t\t\t<div id=\"department-side1\" class=\"department-side-content\"></div>\r\n");
      out.write("\t\t  \t\t</div>\r\n");
      out.write("\t\t  \t\t<div class=\"department-side\">\r\n");
      out.write("\t\t  \t\t\t<div class=\"department-side-header\"><span class='part-name'>图片新闻</span></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"department-side-line\"></div>\r\n");
      out.write("\t\t  \t\t\t<div id=\"department-side2\" class=\"department-side-content\">\r\n");
      out.write("\t\t  \t\t\t\t<div id=\"picRonud\"> \r\n");
      out.write("\t\t\t\t\t\t<div id=\"picRonud_bg\"></div> \r\n");
      out.write("\t\t\t\t\t\t<!--标题背景--> \r\n");
      out.write("\t\t\t\t\t\t<div id=\"picRonud_info\"></div> \r\n");
      out.write("\t\t\t\t\t\t<!--标题--> \r\n");
      out.write("\t\t\t\t\t\t<ul id=\"picRound_ul\"> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</ul> \r\n");
      out.write("\t\t\t\t\t\t<div id=\"picRonud_list\"> \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t<script type=\"text/javascript\">// <![CDATA[ \r\n");
      out.write("\t\t\t\t\t\tvar t = n = 0, count; \r\n");
      out.write("\t\t\t\t\t\tsetTimeout(ss,1000);\r\n");
      out.write("\t\t\t\t\t\tfunction ss(){ \r\n");
      out.write("\t\t\t\t\t\t\tcount=$(\"#picRonud_list a\").length; \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#picRonud_list a:not(:first-child)\").hide(); \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#picRonud_info\").html($(\"#picRonud_list a:first-child\").find(\"img\").attr('alt')); \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#picRonud_info\").click(function(){window.open($(\"#picRonud_list a:first-child\").attr('href'), \"_blank\")}); \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#picRonud li\").click(function() { \r\n");
      out.write("\t\t\t\t\t\t\t\tvar i = $(this).text() - 1;//获取Li元素内的值，即1，2，3，4 \r\n");
      out.write("\t\t\t\t\t\t\t\tn = i; \r\n");
      out.write("\t\t\t\t\t\t\t\tif (i >= count) return; \r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#picRonud_info\").html($(\"#picRonud_list a\").eq(i).find(\"img\").attr('alt')); \r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#picRonud_info\").unbind().click(function(){window.open($(\"#picRonud_list a\").eq(i).attr('href'), \"_blank\")}) \r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#picRonud_list a\").filter(\":visible\").fadeOut(500).parent().children().eq(i).fadeIn(1000); \r\n");
      out.write("\t\t\t\t\t\t\t\t$(this).css({\"background\":\"#be2424\",'color':'#000'}).siblings().css({\"background\":\"#6f4f67\",'color':'#fff'}); \r\n");
      out.write("\t\t\t\t\t\t\t}); \r\n");
      out.write("\t\t\t\t\t\t\tt = setInterval(\"showAuto()\", 4000); \r\n");
      out.write("\t\t\t\t\t\t\t$(\"#picRonud\").hover(function(){clearInterval(t)}, function(){t = setInterval(\"showAuto()\", 4000);}); \r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\tfunction showAuto() \r\n");
      out.write("\t\t\t\t\t\t{ \r\n");
      out.write("\t\t\t\t\t\tn = n >=(count - 1) ? 0 : ++n; \r\n");
      out.write("\t\t\t\t\t\t$(\"#picRonud li\").eq(n).trigger('click'); \r\n");
      out.write("\t\t\t\t\t\t} \r\n");
      out.write("\t\t\t\t\t\t// ]]></script> \r\n");
      out.write("\t\t  \t\t\t\r\n");
      out.write("\t\t  \t\t\t</div>\r\n");
      out.write("\t\t  \t\t\t</div>\r\n");
      out.write("\t\t  \t\t</div>\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div id=\"department-right\">\r\n");
      out.write("\t\t\t\t<div id=\"department-right-header\"><span class='part-name'>部门简介</span></div>\r\n");
      out.write("\t\t\t\t<div id=\"department-right-content\">\r\n");
      out.write("\t\t\t\t\t<div id=\"department-right-content-area\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "banner.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
