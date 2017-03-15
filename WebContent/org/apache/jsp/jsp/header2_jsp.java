package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import neu.scweb.util.Counter;
import java.util.*;

public final class header2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/jsp/countNo.jsp");
    _jspx_dependants.add("/jsp/date.jsp");
  }

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

      out.write('\r');
      out.write('\n');

	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/superfish.css\" media=\"screen\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/hoverIntent.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/superfish.js\"></script>\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("\t\t// initialise plugins\r\n");
      out.write("\t\tjQuery(function(){\r\n");
      out.write("\t\t\tjQuery('ul.sf-menu').superfish();\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../js/swfobject.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar flashvars = {};   \r\n");
      out.write("\t\tvar params = {};   \r\n");
      out.write("\t\tparams.quality = \"high\";   \r\n");
      out.write("\t\tparams.bgcolor = \"#117390\";   \r\n");
      out.write("\t\tparams.play = \"true\";   \r\n");
      out.write("\t\tparams.loop = \"false\";   \r\n");
      out.write("\t\tparams.scale = \"showall\";   \r\n");
      out.write("\t\tparams.menu = \"false\";   \r\n");
      out.write("\t\tparams.devicefont = \"false\";   \r\n");
      out.write("\t\tparams.salign = \"\";   \r\n");
      out.write("\t\tparams.allowscriptaccess = \"sameDomain\";   \t  \r\n");
      out.write("\t\tparams.wmode = \"Opaque\";\r\n");
      out.write("\t\tswfobject.embedSWF(\"../flash/header-flash2.swf\", \"header-flash-place\", \"1024px\", \"137px\", \"6.0.0\", \"expressInstall.swf\",flashvars,params);\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"header-container\">\r\n");
      out.write("<!-- container begin -->\r\n");
      out.write("\t<div id=\"header\">\r\n");
      out.write("\t<!-- header begin -->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div id=\"swc\">\r\n");
      out.write("\t\t<!-- swc begin -->\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(basepath);
      out.write("/images/header-title.jpg\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- swc end -->\r\n");
      out.write("\t\t<div id=\"search\">\r\n");
      out.write("\t\t<!-- search begin -->\r\n");
      out.write("\t\t\t<SPAN style=\"COLOR: #000000\">\r\n");
      out.write("\t\t\t\t<div id=\"searchbox\">\r\n");
      out.write("<!--\r\n");
      out.write("\t\t\t\t\t<form action=\"http://www.google.com/search\" method=\"get\" target=\"_blank\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" class=\"textfield\" style=\"color:#888;\" name=\"as_q\" size=\"24\" value='输入关键字搜索本站' onblur=\"if(this.value == '')this.value='输入关键字搜索本站'\" onfocus=\"if(this.value == '输入关键字搜索本站')this.value = ''\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"as_sitesearch\" value=\"sc.neu.edu.cn\" type=\"hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" class=\"button\" value=\"搜索\"/>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("-->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</SPAN>\r\n");
      out.write("\t\t\t<!--  \r\n");
      out.write("\t\t\t<img src=\"");
      out.print(basepath);
      out.write("/images/header-arrow.png\">&nbsp;\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"search\" size=\"13\" style=\"height:18px;\"/>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(basepath);
      out.write("/images/header-search.png\">\r\n");
      out.write("\t\t\t-->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!-- search end -->\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- header end -->\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"menu\">\r\n");
      out.write("\t<!-- menu beign -->\r\n");
      out.write("\t\t\t<ul class=\"sf-menu\">\r\n");
      out.write("\t\t\t<li class=\"current\"><a href=\"../index.jsp\" class=\"parent\"><span>学院首页</span></a></li>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>学院概况</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi2\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1008\"><span>学院简介</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/org.jsp?orgId=1\" target=\"_blank\"><span>理事会</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/org.jsp?orgId=2\" target=\"_blank\"><span>学院领导</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1002\"><span>大事记</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>机构设置</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi3\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/org.jsp?orgId=3\"><span>学院办公室</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/org.jsp?orgId=4\"><span>教学科研办公室</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/org.jsp?orgId=5\"><span>学生工作办公室</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/department.jsp?orgId=6\"><span>软件工程研究所</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/department.jsp?orgId=7\"><span>信息安全研究所</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/department.jsp?orgId=8\"><span>数字媒体技术研究所</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/department.jsp?orgId=9\"><span>外语教学部</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/department.jsp?orgId=10\"><span>实验中心</span></a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t</li><li><a class=\"parent\"><span>师资队伍</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi4\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1009\"><span>队伍概况</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/teacherList.jsp\"><span>教师队伍</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>党政工作</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi5\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10002&amp;page=1\"><span>党建工作</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10003&amp;page=1\"><span>人事行政</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>人才培养</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi6\">\r\n");
      out.write("\t\t\t\t<li><a class=\"parent\"><span>本科生教学</span></a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"guideLi28\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10016&amp;page=1\"><span>教学管理</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10017&amp;page=1\"><span>教学改革</span></a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>研究生教学</span></a>\r\n");
      out.write("\t\t\t\t<ul id=\"guideLi29\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10020&amp;page=1\"><span>教学管理</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10022&amp;page=1\"><span>教学点管理</span></a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>招生工作</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi7\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10012&amp;page=1\"><span>招生信息</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"parent\"><span>本科生专业</span></a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"guideLi42\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1022\"><span>软件工程</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1023\"><span>信息安全</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1024\"><span>数字媒体技术</span></a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"parent\"><span>研究生专业</span></a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"guideLi43\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1025\"><span>软件工程（学术型）</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1026\"><span>软件工程（应用型）</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1027\"><span>软件工程（单证）</span></a></li>\r\n");
      out.write("\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/yjsds.jsp\"><span>研究生导师</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>学生工作</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi8\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10007&amp;page=1\"><span>日常管理</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10008&amp;page=1\"><span>学生活动</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10009&amp;page=1\"><span>就业信息</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a class=\"parent\"><span>学生科创</span></a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"guideLi41\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10010&amp;page=1\"><span>科技竞赛</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10011&amp;page=1\"><span>创新项目</span></a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10029&amp;page=1\"><span>学生社团</span></a></li>\r\n");
      out.write("\t\t\t\t\t</ul></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>学科科研</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi9\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10004&amp;page=1\"><span>学科建设</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10005&amp;page=1\"><span>科学研究</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10006&amp;page=1\"><span>学术活动</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/page.jsp?pageId=1005\"><span>研究室</span></a></li><li>\r\n");
      out.write("\t\t\t\t<a href=\"../jsp/page.jsp?pageId=1006\"><span>联合实验室</span></a></li><li>\r\n");
      out.write("\t\t\t\t<a href=\"../jsp/page.jsp?pageId=1007\"><span>工程中心</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t\t<li><a class=\"parent\"><span>合作交流</span></a>\r\n");
      out.write("\t\t\t<ul id=\"guideLi10\">\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10013&amp;page=1\"><span>校企合作</span></a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"../jsp/newsList.jsp?id=10014&amp;page=1\"><span>国际交流</span></a></li>\r\n");
      out.write("\t\t\t</ul></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\r\n");
      out.write("\t  \r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- menu end -->\r\n");
      out.write("\t<div id=\"header-flash\"><div id=\"header-flash-place\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"header-line\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"header-login\">\r\n");
      out.write("\t\t<table width=\"980px\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"463px\"></td>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<td width=\"200px\"></td>\r\n");
      out.write("\t\t\t\t<td><span class=\"header-login-info\">总访问量：");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
Counter cb=new Counter();String counter=cb.getCounterNo();
      out.write('\r');
      out.write('\n');
      out.print(counter );
      out.write('\r');
      out.write('\n');
      out.write("</span>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td><span class=\"header-login-info\"> ");
      out.write("\r\n");
      out.write("<script language=\"javascript\"> \r\n");
      out.write("\tfunction PageDate(){   \r\n");
      out.write("\t\tcurrentDate = new Date();  \r\n");
      out.write("\t\twith(currentDate){   \r\n");
      out.write("\t\t\tday=getDay();\r\n");
      out.write("\t\t\tmonth=getMonth()+1;\r\n");
      out.write("\t\t\tthis.document.write(getFullYear()+'年'+month+'月'+getDate()+'日')   \r\n");
      out.write("\t\t}   \r\n");
      out.write("\t\tif(day==1){document.write(' 星期一');}\r\n");
      out.write("\t\tif(day==2){document.write(' 星期二');}\r\n");
      out.write("\t\tif(day==3){document.write(' 星期三');}\r\n");
      out.write("\t\tif(day==4){document.write(' 星期四');}\r\n");
      out.write("\t\tif(day==5){document.write(' 星期五');}\r\n");
      out.write("\t\tif(day==6){document.write(' 星期六');}\r\n");
      out.write("\t\tif(day==0){document.write(' 星期日');} \r\n");
      out.write("\t}\r\n");
      out.write("\tPageDate();\r\n");
      out.write("</script>");
      out.write("</span>&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\t\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"header-line2\"></div>\t\r\n");
      out.write("</div>\r\n");
      out.write("<!-- container end -->");
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
