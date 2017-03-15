package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class banner_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"banner\">\r\n");
      out.write("\t<!-- banner begin -->\r\n");
      out.write("\t\t<div id=\"banner-line\"></div>\r\n");
      out.write("\t\t<div id=\"banner-text\">\r\n");
      out.write("\t\t\t<table style=\"height:25px;width:500px;\">\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<td style=\"border-right:1px solid #a0a0a0\" align=\"center\"><p class=\"banner2\"><a target=_blank href=\"../introduction/contactus.jsp\">联系我们</a></p></td>\t\r\n");
      out.write("\t\t\t\t\t<td style=\"border-right:1px solid #a0a0a0\" align=\"center\"><p class=\"banner2\"><a target=_blank href=\"../introduction/codeInfo.jsp\">技术支持</a></p></td>\r\n");
      out.write("\t\t\t\t\t<td style=\"border-right:1px solid #a0a0a0\" align=\"center\"><p class=\"banner2\"><a target=_blank href=\"../jsp/page.jsp?pageId=1010\" >友情链接</a></p></td>\r\n");
      out.write("\t\t\t\t\t<td style=\"border-right:1px solid #a0a0a0\" align=\"center\"><p class=\"banner2\"><a target=_blank href=\"../jsp/newsList.jsp?id=10015&page=1\" >诚聘英才</a></p></td>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\"><p class=\"banner2\"><a target=_blank href=\"../jsp/downloadList.jsp?page=1&sec=all\" >资源下载</a></p></td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div align=\"center\" style=\"width:100%;\">\r\n");
      out.write("\t\t\t<p id=\"banner1\">© Copyright 2011 Software College Northeastern University. 东北大学软件学院. All rights reserved.</p>\r\n");
      out.write("\t\t\t\t<p id=\"banner1\">地址：辽宁省沈阳市和平区文化路3号巷11号      邮编：110819 </p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- banner end -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
