package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class pictures_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>东北大学国家示范性软件学院—学院风采</title>\r\n");
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
      out.write("<script src=\"");
      out.print(basepath);
      out.write("/js/jquery.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(basepath);
      out.write("/css/jquery.ad-gallery.css\">\r\n");
      out.write("\r\n");
      out.write(" <script type=\"text/javascript\" src=\"");
      out.print(basepath);
      out.write("/js/jquery.ad-gallery.js\"></script>\r\n");
      out.write("<link href=\"");
      out.print(basepath);
      out.write("/css/banner.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("   \r\n");
      out.write("  $(function() {\r\n");
      out.write("  \r\n");
      out.write("    var galleries = $('.ad-gallery').adGallery();\r\n");
      out.write("    $('#switch-effect').change(\r\n");
      out.write("      function() {\r\n");
      out.write("        galleries[0].settings.effect = $(this).val();\r\n");
      out.write("\t\r\n");
      out.write("        return false;\r\n");
      out.write("      }\r\n");
      out.write("    );\r\n");
      out.write("    $('#toggle-slideshow').click(\r\n");
      out.write("      function() {\r\n");
      out.write("        galleries[0].slideshow.toggle();\r\n");
      out.write("        return false;\r\n");
      out.write("      }\r\n");
      out.write("    );\r\n");
      out.write("    $('#toggle-description').click(\r\n");
      out.write("      function() {\r\n");
      out.write("        if(!galleries[0].settings.description_wrapper) {\r\n");
      out.write("          galleries[0].settings.description_wrapper = $('#descriptions');\r\n");
      out.write("        } else {\r\n");
      out.write("          galleries[0].settings.description_wrapper = false;\r\n");
      out.write("        }\r\n");
      out.write("        return false;\r\n");
      out.write("      }\r\n");
      out.write("    );\r\n");
      out.write("  });\r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
      out.write("\t\r\n");
      out.write("\t<style>\r\n");
      out.write("\tp.frendLink{\r\n");
      out.write("\t\r\n");
      out.write("    \tfont-family:\"楷体\";\r\n");
      out.write("    \tfont-size:15px;\r\n");
      out.write("    \tfont-weight:bold;\r\n");
      out.write(" \r\n");
      out.write("\t}\r\n");
      out.write("\t#linkPic-table tr{\r\n");
      out.write("\t\theight:70px;\r\n");
      out.write("\t}\r\n");
      out.write("\timg.pic{\r\n");
      out.write("\t\tclear:both;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tmargin-top:20px;\r\n");
      out.write("\t\tmargin-left:200px;\r\n");
      out.write("\t}\r\n");
      out.write("\tp.picTitle{\r\n");
      out.write("\t    font-family:\"楷体\";\r\n");
      out.write("    \tfont-size:15px;\r\n");
      out.write("    \ttext-align:center;\r\n");
      out.write("    \tfont-weight:bold;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</style>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"index3-container\" style=\"text-align:left\">\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header2.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"index3-news\">\r\n");
      out.write("\t\t<div id=\"index3-news-header\"><span class=\"part-name\">学院风采</span></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   <div id=\"gallery\" class=\"ad-gallery\" >\r\n");
      out.write("\t\t      <div class=\"ad-image-wrapper\">\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"ad-controls\">\r\n");
      out.write("\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\t\t      <div class=\"ad-nav\">\r\n");
      out.write("\t\t        <div class=\"ad-thumbs\">\r\n");
      out.write("\t\t          <ul class=\"ad-thumb-list\">\r\n");
      out.write("\t\t           \r\n");
      out.write("\t\t            <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年10月21日我院参加国家示范性软件学院十周年庆典并获多项殊荣.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年10月21日我院参加国家示范性软件学院十周年庆典并获多项殊荣.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年10月21日我院参加国家示范性软件学院十周年庆典并获多项殊荣\" class=\"image1\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\r\n");
      out.write("\t\t            <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年10月27日数字媒体技术专业召开虚拟现实技术专题讲座.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年10月27日数字媒体技术专业召开虚拟现实技术专题讲座.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年10月27日数字媒体技术专业召开虚拟现实技术专题讲座\" class=\"image2\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t            <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年10月9日台湾成功大学黄崇明教授来院访问并做学术报告.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年10月9日台湾成功大学黄崇明教授来院访问并做学术报告.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年10月9日台湾成功大学黄崇明教授来院访问并做学术报告\" class=\"image3\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t            <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年11月1日软件学院与中瑞教育集团签订合作协议.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年11月1日软件学院与中瑞教育集团签订合作协议.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年11月1日软件学院与中锐教育集团签订合作协议\" class=\"image4\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年11月3日日本岐阜大学藤田教授来院访问并做报告.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年11月3日日本岐阜大学藤田教授来院访问并做报告.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年11月3日日本岐阜大学藤田教授来院访问并做报告\" class=\"image5\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年2月28日丁烈云校长莅临软件学院调研.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年2月28日丁烈云校长莅临软件学院调研.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年2月28日丁烈云校长莅临软件学院调研\" class=\"image6\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年3月22日我院开展消防安全知识培训.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年3月22日我院开展消防安全知识培训.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年3月22日我院开展消防安全知识培训\" class=\"image7\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年5月日本立命馆大学情报理工学院陈延伟教授来院访问并作学术报告.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年5月日本立命馆大学情报理工学院陈延伟教授来院访问并作学术报告.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年5月日本立命馆大学情报理工学院陈延伟教授来院访问并作学术报告\" class=\"image8\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年6月14日我院开展青年管理人员培训.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年6月14日我院开展青年管理人员培训.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年6月14日我院开展青年管理人员培训\" class=\"image9\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年6月16日我院举行庆祝建党90周年暨党建工作总结表彰大会.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年6月16日我院举行庆祝建党90周年暨党建工作总结表彰大会.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年6月16日我院举行庆祝建党90周年暨党建工作总结表彰大会\" class=\"image10\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年6月1日我院承办国家信标委SOA标准工作组云计算标准研讨会.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年6月1日我院承办国家信标委SOA标准工作组云计算标准研讨会.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年6月1日我院承办国家信标委SOA标准工作组云计算标准研讨会\" class=\"image11\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年6月7日我院举行2009-2010学年学生奖励基金颁奖典礼.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年6月7日我院举行2009-2010学年学生奖励基金颁奖典礼.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年6月7日我院举行2009-2010学年学生奖励基金颁奖典礼\" class=\"image12\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年9月27日我院举行新网站开通暨学院成立九周年大会.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年9月27日我院举行新网站开通暨学院成立九周年大会.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年9月27日我院举行新网站开通暨学院成立九周年大会\" class=\"image13\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t             <li>\r\n");
      out.write("\t\t              <a href=\"../roundPic/2011年9月27日学院聘请杨本强为兼职教授.JPG\">\r\n");
      out.write("\t\t                <img src=\"../roundPic/2011年9月27日学院聘请杨本强为兼职教授.JPG\" width=\"50px\" height=\"28px\" title=\"学院风采\" alt=\"2011年9月27日学院聘请杨本强为兼职教授\" class=\"image14\">\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t            </li>\r\n");
      out.write("\t\t           </ul>\r\n");
      out.write("\t\t        </div>\r\n");
      out.write("\t\t      </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
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
