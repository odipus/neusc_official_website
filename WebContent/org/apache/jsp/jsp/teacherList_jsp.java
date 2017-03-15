package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class teacherList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("/js/teacherList.js\" type=\"text/javascript\"></script> \r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\tp.department2-teacher{\r\n");
      out.write("\t\twidth:750px;\r\n");
      out.write("\t}\r\n");
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
      out.write("\tdiv#index3-news-content-area{\r\n");
      out.write("\t\tmargin-left:40px;\r\n");
      out.write("\t\twidth:650px;\r\n");
      out.write("\t}\r\n");
      out.write("\ta.tchLink{\r\n");
      out.write("\tmargin-right:10px;\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("\tmargin-bottom:10px;\r\n");
      out.write("\tfloat:left; \r\n");
      out.write("\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("\t.tchLink a:active{\r\n");
      out.write("\tmargin-right:10px;\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("\tmargin-bottom:10px;\r\n");
      out.write("\tfloat:left; \r\n");
      out.write("\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t.tchLink a:link{\r\n");
      out.write("\tmargin-right:10px;\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("\tmargin-bottom:10px;\r\n");
      out.write("\tfloat:left; \r\n");
      out.write("\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t.tchLink a:visited{\r\n");
      out.write("\tmargin-right:10px;\r\n");
      out.write("\tmargin-left:10px;\r\n");
      out.write("\tmargin-bottom:10px;\r\n");
      out.write("\tfloat:left; \r\n");
      out.write("\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("\thr.tchHr{\r\n");
      out.write("\t\twidth: 820px;\r\n");
      out.write("\t\tsize:2;\r\n");
      out.write("\t\tdisplay:block;\r\n");
      out.write("\t\tclear:left;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
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
      out.write("\t\t<div id=\"index3-news-header\"><span class=\"part-name\">师资队伍</span></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\r\n");
      out.write("\t\t\t<div id=\"index3-news-content-area\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"newsContent-Guide\">\r\n");
      out.write("\t\t\t\t<p class=\"commonLink\">当前位置：首页&nbsp;&gt;&nbsp;师资队伍</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<p><strong>(按姓氏笔画排序)</strong></p>\r\n");
      out.write("\t\r\n");
      out.write("<!-- \t\t\t<br>\r\n");
      out.write("\t\t\t<p class=\"department2-orgTitle\"><b>教授</b></p><br>\r\n");
      out.write("\t\t\t<p id=\"t1\" class=\"department2-teacher\">\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=7\">朱志良</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=21\">杨广明</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=98\">周福才</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=75\">姜慧研</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=57\">徐怀宇</a>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</p><hr class=\"tchHr\"><br><p class=\"department2-orgTitle\"><b>副教授</b></p><br>\r\n");
      out.write("\t\t\t<p id=\"t2\" class=\"department2-teacher\">\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=80\">于&nbsp;&nbsp;海</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=4\">于瑞云</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=63\">代&nbsp;&nbsp;钰</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=77\">任&nbsp;&nbsp;涛</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=76\">严&nbsp;&nbsp;丽</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=15\">张&nbsp;&nbsp;爽</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=17\">李丹程</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=11\">陈东明</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=41\">姜琳颖</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=47\">高天寒</a>\t\t\t\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=20\">程&nbsp;&nbsp;维</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=32\">韩春燕</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=31\">董傲霜</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</p><hr class=\"tchHr\"> <br><p class=\"department2-orgTitle\"><b>讲师</b></p><br>\r\n");
      out.write("\t\t\t<p id=\"t3\" class=\"department2-teacher\">\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=34\">赵晓丹</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=30\">张艳升</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=33\">张明卫</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=25\">张&nbsp;&nbsp;莉</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=24\">杨&nbsp;&nbsp;巍</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=43\">徐&nbsp;&nbsp;捷</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=29\">吴辰铌</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=35\">王&nbsp;&nbsp;爽</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=28\">王书睿</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=94\">王冬琦</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=23\">王蓓蕾</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=19\">佟&nbsp;&nbsp;强</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=44\">谭振华</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=22\">宋&nbsp;&nbsp;航</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=48\">那&nbsp;&nbsp;俊</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=65\">毛克明</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=42\">马&nbsp;&nbsp;毅</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=45\">刘&nbsp;&nbsp;莹</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=52\">刘洪娟</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=46\">刘国奇</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=66\">李&nbsp;&nbsp;昕</a>\r\n");
      out.write("\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=49\">李&nbsp;&nbsp;妲</a><a class=\"tchLink\" href=\"tchInfo.jsp?tchId=16\">黄利萍</a><a class=\"tchLink\" href=\"tchInfo.jsp?tchId=37\">宫晓莉</a><a class=\"tchLink\" href=\"tchInfo.jsp?tchId=39\">崔晓莉</a><a class=\"tchLink\" href=\"tchInfo.jsp?tchId=40\">毕&nbsp;&nbsp;佳</a></p><hr class=\"tchHr\"> <br><p class=\"department2-orgTitle\"><b>助教</b></p><br><p id=\"t4\" class=\"department2-teacher\"><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=59\">朱&nbsp;&nbsp;潜</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=64\">赵建喆</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=55\">徐&nbsp;&nbsp;剑</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=93\">谢&nbsp;&nbsp;青</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=56\">王学毅</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=53\">宋经平</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=54\">石&nbsp;&nbsp;凯</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=73\">孟婷婷</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=62\">刘益先</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=60\">高&nbsp;&nbsp;健</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=67\">邓卓夫</a><a class=\"tchLink\" href=\"teacherInfo.jsp?tchId=58\">陈&nbsp;&nbsp;默</a></p><hr class=\"tchHr\"> \r\n");
      out.write("\t -->\r\n");
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
