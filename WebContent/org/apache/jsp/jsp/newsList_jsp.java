package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class newsList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/header.css\" rel=\"stylesheet\">\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/banner.css\" rel=\"stylesheet\">\r\n");
      out.write("<link type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/superfish.css\" media=\"screen\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/hoverIntent.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/superfish.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.easing-1.3.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/newsList.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.slide-0.4.3.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("<style>\r\n");
      out.write("\t\r\n");
      out.write("div.index-side{\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:220px;\r\n");
      out.write("\tborder:1px solid #A8A8A8;\r\n");
      out.write("\tbackground-color:white;\t\r\n");
      out.write("}\r\n");
      out.write("div.index-side-header{\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:28px;\r\n");
      out.write("\tbackground-image:url('../images/index-side-header.png');\r\n");
      out.write("\t}\r\n");
      out.write("div.index-side-content{\r\n");
      out.write("\ttext-align:left;\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:169px;\r\n");
      out.write("\tline-height:20px;\r\n");
      out.write("\toverflow:hidden;\r\n");
      out.write("}\r\n");
      out.write("div.index-side-line{\r\n");
      out.write("\twidth:206px;\r\n");
      out.write("\theight:5px;\r\n");
      out.write("\tbackground-image:url('../images/index-side-line.png');\r\n");
      out.write("\tbackground-repeat: repeat-x;\r\n");
      out.write("}\r\n");
      out.write("div.index-side-bottom{\r\n");
      out.write("\tvertical-align:middle;\r\n");
      out.write("\theight:35px;\r\n");
      out.write("\tmargin-left:130px;\r\n");
      out.write("\tline-height:35px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("}\r\n");
      out.write("marquee#announcement{\r\n");
      out.write("\tfloat:left;\r\n");
      out.write("\tmargin-top:10px;\r\n");
      out.write("\tposition:relative;\r\n");
      out.write("\t\r\n");
      out.write("\t_margin-top:10px;\r\n");
      out.write("\t height:140px;\r\n");
      out.write("\t width:180px;\r\n");
      out.write("}\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("<style type=\"text/css\"> \r\n");
      out.write("#picRonud {position:relative; width:207px; height:180px; overflow:hidden; font-size:13px} \r\n");
      out.write("#picRonud_list img {border:0px;} \r\n");
      out.write("#picRonud_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=10);opacity:0.1;z-index:1000;cursor:pointer; width:205px; } \r\n");
      out.write("#picRonud_info{display:block;\r\n");
      out.write("position:absolute; bottom:2px; left:5px;height:25px;color:#fff;z-index:1001;cursor:pointer} \r\n");
      out.write("#picRonud_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;} \r\n");
      out.write("#picRonud ul { position:absolute;list-style-type:none;filter: Alpha(Opacity=80);opacity:0.8; z-index:1002; \r\n");
      out.write("margin:0; padding:0; bottom:3px; right:5px; height:25px} \r\n");
      out.write("#picRonud ul li { padding:0 8px; line-height:20px;float:left;display:block;color:#FFF;border:#e5eaff 1px solid;background-color:#6f4f67;cursor:pointer; margin:0; font-size:13px;} \r\n");
      out.write("#picRonud_list a{position:absolute;} </style> \r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"index-container\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header2.jsp", out, false);
      out.write("\r\n");
      out.write("\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"40px\"></td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div id=\"index2-left\">\r\n");
      out.write("\t\t\t\t<div class=\"index-side\">\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-header\"><span class='part-name'>最新公告</span></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-line\"></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-content\" id=\"index2-announcement\"></div>\r\n");
      out.write("\t\t  \t\t</div>\r\n");
      out.write("\t\t  \t\t<div class=\"index-side\">\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-header\"><span class='part-name'>图片新闻</span></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-line\"></div>\r\n");
      out.write("\t\t  \t\t\t<div class=\"index-side-content\" id=\"index2-news\">\r\n");
      out.write("\t\t  \t\t\t     \r\n");
      out.write("\t\t\t\t\t\t<div id=\"picRonud\"> \r\n");
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
      out.write("\t\t\t\t\t\tsetTimeout(ss,500);\r\n");
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
      out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\r\n");
      out.write("\t\t  \t\t\t</div>\r\n");
      out.write("\t\t  \t\t</div>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div id=\"index2-right\">\r\n");
      out.write("\t\t\t\t<div id=\"index2-right-header\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"index2-right-content\">\r\n");
      out.write("\t\t\t\t\t<div id=\"newsContent-Guide\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<table id=\"index2-right-table\" width=\"650px\" bgcolor='#F5F6F8'>\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<div id=\"newsContent-Page\">\r\n");
      out.write("\t\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
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
