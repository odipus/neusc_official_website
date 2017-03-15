package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class yjsds_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>东北大学国家示范性软件学院--研究生导师</title>\r\n");
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
      out.write("\ta.tchLink {\r\n");
      out.write("    float: left;\r\n");
      out.write("    margin-bottom: 10px;\r\n");
      out.write("    margin-left: 20px;\r\n");
      out.write("   \r\n");
      out.write("        color: black;\r\n");
      out.write("    font-family: \"黑体\";\r\n");
      out.write("    font-size: 13px;\r\n");
      out.write("    letter-spacing: -0.3mm;\r\n");
      out.write("white-space:nowrap;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("\tdisplay:inline;\r\n");
      out.write("word-break:keep-all;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("hr.tchHr {\r\n");
      out.write("    clear: left;\r\n");
      out.write("    display: block;\r\n");
      out.write("    size: 2px;\r\n");
      out.write("    width: 820px;\r\n");
      out.write("}\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../jsp/header2.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"index3-news\">\r\n");
      out.write("\t\t<div id=\"index3-news-header\"><span class=\"part-name\">研究生导师</span></div>\r\n");
      out.write("\t\t<div id=\"index3-news-content\">\r\n");
      out.write("\t\t\t<div id=\"newsContent-Guide\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"index3-newsContent\">\r\n");
      out.write("\t\t\t<br><p class='department2-orgTitle'><b>(按姓氏笔画排序)</b></p>\r\n");
      out.write("\t\t\t\t\t\t\t<br/><p class='department2-orgTitle'><b>博士生导师</b></p><p id='t1' class='department2-teacher'><br/>\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' href=\"tchInfo.jsp?tchId=7\">朱志良</a>\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' href=\"tchInfo.jsp?tchId=98\">周福才</a>\t\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' >马宗民</a>\t\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' >王兴伟</a>\t\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' >乔建忠</a>\t\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' >张&nbsp;&nbsp;斌</a>\t\r\n");
      out.write("\t\t\t\t\t<a class='tchLink' >温&nbsp;&nbsp;涛</a>\t\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><p id='t2' class='department2-teacher'><br/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"tchInfo.jsp?tchId=7\" class=\"tchLink\">朱志良</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"tchInfo.jsp?tchId=21\" class=\"tchLink\">杨广明</a> <a href=\"tchInfo.jsp?tchId=98\" class=\"tchLink\">周福才</a> \r\n");
      out.write("\t\t\t\t\t<a href=\"tchInfo.jsp?tchId=75\" class=\"tchLink\">姜慧研</a> \r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副教授</b></p><br/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=4\">于瑞云</a>\r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=80\">于&nbsp;&nbsp;海</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=63\">代&nbsp;&nbsp;钰</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=77\">任&nbsp;&nbsp;涛</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=11\">陈东明</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=15\">张&nbsp;&nbsp;爽</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=17\">李丹程</a>\r\n");
      out.write("\r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=68\">宋&nbsp;&nbsp;杰</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=76\">严&nbsp;&nbsp;丽</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=41\">姜琳颖</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=47\">高天寒</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=20\">程&nbsp;&nbsp;维</a>\r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=31\">董傲霜</a> \r\n");
      out.write("<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=32\">韩春燕</a> \r\n");
      out.write("\t\t\t\t<hr class='tchHr'/> \r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>其他导师：</b></p>\r\n");
      out.write("\t\t\t\t<br/><a style=\"color:black;\" href='down.jsp?fname=daoshi.doc'>其他导师名单.doc</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- <br/><p class='department2-orgTitle'><b>东北大学软件学院</b></p><hr class='tchHr'/> <hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><br/><p id='t1' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a href=\"tchInfo.jsp?tchId=7\" class=\"tchLink\">朱志良</a> <a href=\"tchInfo.jsp?tchId=21\" class=\"tchLink\">杨广明</a> <a href=\"tchInfo.jsp?tchId=98\" class=\"tchLink\">周福才</a> <a href=\"tchInfo.jsp?tchId=75\" class=\"tchLink\">姜慧研</a> <a href=\"tchInfo.jsp?tchId=57\" class=\"tchLink\">徐怀宇</a> </p>\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副教授</b></p><br/><p id='t2' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=4\">于瑞云</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=80\">于&nbsp;&nbsp;海</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=63\">代&nbsp;&nbsp;钰</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=77\">任&nbsp;&nbsp;涛</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=11\">陈东明</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=15\">张&nbsp;&nbsp;爽</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=17\">李丹程</a><a class=\"tchLink\" href=\"tchInfo.jsp?tchId=68\">宋&nbsp;&nbsp;杰</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=76\">严&nbsp;&nbsp;丽</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=41\">姜琳颖</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=47\">高天寒</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=20\">程&nbsp;&nbsp;维</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=31\">董傲霜</a> <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=32\">韩春燕</a> \r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>讲师</b></p><br/><p id='t3' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=65\">毛克明</a>  \r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=94\">王冬琦</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\" href=\"tchInfo.jsp?tchId=46\">刘国奇</a>\r\n");
      out.write("\t\t\t\t <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=33\">张明卫</a> \r\n");
      out.write("\t\t\t\t <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=66\">李&nbsp;&nbsp;昕</a> \r\n");
      out.write("\t\t\t\t  <a class=\"tchLink\" href=\"tchInfo.jsp?tchId=44\">谭振华</a> \r\n");
      out.write("\t\t\t\t</p><br/><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>东北大学计算中心</b></p><hr class='tchHr'/> <hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><br/><p id='t1' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">常桂然</a> <a class=\"tchLink\">高克宁</a> <a class=\"tchLink\">黄卫祖</a> \t\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副教授</b></p><br/><p id='t2' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">吕振辽</a> <a class=\"tchLink\">易秀双</a> \r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>东北大学信息学院</b></p><hr class='tchHr'/> <hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><br/><p id='t1' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">马宗民</a><a class=\"tchLink\">王兴伟</a><a class=\"tchLink\">乔建忠</a><a class=\"tchLink\">张&nbsp;&nbsp;斌</a>\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副教授</b></p><br/><p id='t2' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">胡清河</a><a class=\"tchLink\">郭&nbsp;&nbsp;楠</a><a class=\"tchLink\">姚&nbsp;&nbsp;羽</a>\t\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>沈阳师范大学软件学院</b></p><hr class='tchHr'/> <hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><br/><p id='t1' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">周传生</a>\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> <br/>\r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>东软集团</b></p><hr class='tchHr'/> <hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>教授</b></p><br/><p id='t1' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">刘积仁</a><a class=\"tchLink\"> 卢朝霞</a><a class=\"tchLink\">赵&nbsp;&nbsp;宏</a><a class=\"tchLink\">赵大哲</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">胡景德</a><a class=\"tchLink\">张&nbsp;&nbsp;霞</a><a class=\"tchLink\"> 杨&nbsp;&nbsp;利 </a><a class=\"tchLink\">康&nbsp;&nbsp;雁</a>\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副教授</b></p><br/><p id='t2' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">江&nbsp;&nbsp;早</a><a class=\"tchLink\">李品彦</a><a class=\"tchLink\">李永旭</a><a class=\"tchLink\">柳玉辉</a>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">余克清</a><a class=\"tchLink\">张立东</a><a class=\"tchLink\">张应辉</a><a class=\"tchLink\">邹&nbsp;&nbsp;豪</a>\r\n");
      out.write("\t\t\t\t</p><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>研究员</b></p><br/><p id='t3' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">江根苗</a><a class=\"tchLink\">郑全录</a>\r\n");
      out.write("\t\t\t\t</p><br/><hr class='tchHr'/> \r\n");
      out.write("\t\t\t\t<br/><p class='department2-orgTitle'><b>副研究员</b></p><br/><p id='t3' class='department2-teacher'>\r\n");
      out.write("\t\t\t\t<a class=\"tchLink\">袁淮</a>\r\n");
      out.write("\t\t\t\t</p><br/><hr class='tchHr'/> <br/><br/><br/> -->\r\n");
      out.write(" \r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("    \t\r\n");
      out.write("<!-- <pre>\r\n");
      out.write("校内  朱志良\t男\t教授\t软件学院\t信息整合与中间件技术、多媒体信息处理、虚拟现实及地理信息系统、混沌分形与（数据压缩）\r\n");
      out.write("\t\t\t83680520\tzzl@mail.neu.edu.cn\r\n");
      out.write("校内\t 杨广明\t男\t教授\t软件学院\t信息安全技术、嵌入式系统\t83680512\tygm5@hotmail.com\t\r\n");
      out.write("校内\t 徐怀宇\t男\t教授\t软件学院\t电子商务、高速铁路、物联网\t13555788577\txuhuaiyu@hotmail.com\t\r\n");
      out.write("校内\t姜慧研\t女\t教授\t软件学院\t图像处理，模式识别，计算机辅助诊断\t13998163069\thyjiang@mail.neu.edu.cn\t\r\n");
      out.write("校内\t周福才\t男\t教授\t软件学院\t网络与信息安全、可信计算、电子商务安全的关键技术\t13940413064\tzhoufucai@ise.neu.edu.cn\t\r\n");
      out.write("校内\t陈东明\t男\t副教授\t软件学院\t信息处理与安全、复杂网络、企业信息化\t83680511，\r\n");
      out.write("\t\t\t13998834820\tchendm@mail.neu.edu.cn\t\r\n");
      out.write("校内\t董傲霜\t女\t副教授\t软件学院\t虚拟现实技术\t83681822\tdongaoshuang@mail.neu.edu.cn\t\r\n");
      out.write("校内\t韩春燕\t女\t副教授\t软件学院\t信息系统工程、分布式系统、嵌入式系统、网络通信\t13940575805\thancy0223@126.com\t\r\n");
      out.write("校内\t姜琳颖\t女\t副教授\t软件学院\t嵌入式系统、计算机网络\t13940055982\tlyjiang_neu@126.com\t\r\n");
      out.write("校内\t李丹程\t女\t副教授\t软件学院\t信息系统工程、软件架构\t83684726\tldc@mail.neu.edu.cn\t\r\n");
      out.write("校内\t宋杰\t男\t副教授\t软件学院\t信息整合，数据仓库\t13940346797\tsongjie@mail.neu.edu.cn\t\r\n");
      out.write("校内\t严丽\t女\t副教授\t软件学院\t数据库建模与智能信息处理\t83688873\tyanlilyjiaji@163.com\t\r\n");
      out.write("校内\t程维\t男\t副教授\t软件学院\t复杂网络\t13386889763\tcheng_weiqq@163.com\r\n");
      out.write("校内\t代钰\t女\t副教授\t软件学院\t服务组合；服务QoS管理\t13080703469\tneu_daiyu@126.com\r\n");
      out.write("校内\t高天寒\t男\t副教授\t软件学院\t下一代互联网及网络安全 \t13700038569\tgaoth@mail.neu.edu.cn\t\r\n");
      out.write("校内\t李昕\t女\t讲师\t软件学院\t计算机网络、保密通信、网络编码\t13514206875\tneulixin@139.com\t\r\n");
      out.write("校内\t刘国奇\t男\t讲师\t软件学院\t信息整合、服务计算\t13591402086\tguoqiliu@126.com\t\r\n");
      out.write("校内\t毛克明\t男\t讲师\t软件学院\t模式识别、图像处理\t13066751017\trockmao@live.cn\t\r\n");
      out.write("校内\t任涛\t男\t讲师\t软件学院\t计算机网络通信及加密算法\t13840366956\tchinarentao@163.com\t\r\n");
      out.write("校内\t谭振华\t男\t讲师\t软件学院\t分布式网络安全\t13478212785\ttanzh@mail.neu.edu.cn\t\r\n");
      out.write("校内\t于海\t男\t副教授\t软件学院\t复杂网络，混沌，非线性动力系统\t13804059171\tyuhai@mail.com\t\r\n");
      out.write("校内\t于瑞云\t男\t讲师\t软件学院\t无线传感器网络、参与式感知、多传感器数据融合\t13940259948\tyury@mail.neu.edu.cn\t\r\n");
      out.write("校内\t张明卫\t男\t讲师\t软件学院\t云计算、知识工程\t13898101130\tzhangmw@mail.neu.edu.cn\t\r\n");
      out.write("校内\t张爽\t女\t副教授\t软件学院\t电子商务/政务、虚拟现实、软件架构平台技术及应用开发\t13940069218\tzhangs914@163.com\r\n");
      out.write("\r\n");
      out.write("校内\t周传生\t男\t教授\t沈师软件学院\t软件工程与分布式组件技术\t13700037802\tjasoncs@126.com\t\r\n");
      out.write("\r\n");
      out.write("校内\t常桂然\t男\t教授\t计算中心\t计算机网络技术，网络与协同计算，网络与信息安全\t024-83672602\tchang@neu.edu.cn\t\r\n");
      out.write("校内\t高克宁\t女\t教授\t计算中心\tweb信息处理\t13940432022\tgkn@cc.neu.edu.cn\t\r\n");
      out.write("校内\t黄卫祖\t男\t教授\t计算中心\t多媒体与网络教育、信息集成、知识处理\t83682313\thwz@mail.neu.edu.cn\t\r\n");
      out.write("校内\t吕振辽\t男\t副教授\t计算中心\t企业信息化\t23994399\tlzl@cc.neu.edu.cn\t\r\n");
      out.write("校内\t易秀双\t男\t副教授\t计算中心\t新一代网络技术及应用、网络信息安全\t13304041232\txsyi@mail.neu.edu.cn\t\r\n");
      out.write("\r\n");
      out.write("校内\t郭楠\t女\t副教授\t信息学院\t服务计算\t13604076781\tguonan@ise.neu.edu.cn\t仅单证学生可选\r\n");
      out.write("校内\t胡清河\t男\t副教授\t信息学院\tSOA技术与应用、电子商务与供应链、电子政务\t13998889871\thuqinghe@ise.neu.edu.cn\t\r\n");
      out.write("校内\t马宗民\t男\t教授\t信息学院\t智能数据与知识工程\t13840472162\tmazongmin@ise.neu.edu.cn\t\r\n");
      out.write("校内\t乔建忠\t男\t教授\t信息学院\t软件体系结构、分布式并行计算和操作系统技术\t13709823906\tqiaojianzhong@ise.neu.edu.cn\t\r\n");
      out.write("校内\t王兴伟\t男\t教授\t信息学院\t下一代互联网、自组织网络、IP/DWDM光Internet、移动无线Internet、网络信息安全和网格计算\t\r\n");
      out.write("\t\t\t\t13940055404\twangxingwei@ise.neu.edu.cn\t\r\n");
      out.write("校内\t姚羽\t男\t副教授\t信息学院\t网络安全\t83686617\tyaoyu@mail.neu.edu.cn\t\r\n");
      out.write("校内\t张斌\t男\t教授\t信息学院\tWeb工程、数据库及数据挖掘技术、信息集成、组件技术、信息网格\t13604022102\r\n");
      out.write("\t\t\t\t\tzhangbin@ise.neu.edu.cn\t\r\n");
      out.write("\r\n");
      out.write("东软\t胡景德\t男\t教授\t东软集团\t嵌入式系统应用、ERP应用、网络及多媒体应用\t13348875533\thujd@neusoft.com\t\r\n");
      out.write("东软\t江根苗\t男\t研究员\t东软集团\t医学成像技术、图像处理与人工智能\t13804037506\tjianggm@neusoft.com\t\r\n");
      out.write("东软\t江早\t男\t副教授\t东软集团\t图像处理、数字放送\t13602543130\tjiangz@neusoft.com\t\r\n");
      out.write("东软\t康雁\t男\t教授\t东软集团\t生物医学工程\t13940472926\tkangy@neusoft.com\t\r\n");
      out.write("东软\t李品彦\t男\t副教授\t东软集团\t电子商务、软件方法学\t13602543130\tlipinyan@neusoft.com\t\r\n");
      out.write("东软\t李永旭\t男\t副教授\t东软集团\t生物医学工程\t13840421166\tliyongxu@neusoft.com\t\r\n");
      out.write("东软\t刘积仁\t男\t教授\t东软集团\t分布式多媒体、计算机网络、嵌入式软件\t13904016718\tliujr@neusoft.com\t\r\n");
      out.write("东软\t柳玉辉\t男\t副教授\t东软集团\t图像处理、网络安全技术\t13904007760\tliuyh@neusoft.com\t\r\n");
      out.write("东软\t卢朝霞\t女\t教授\t东软集团\t计算机网络安全、数据库理论与计算机集成管理\t13904006617\tluzx@neusoft.com\t\r\n");
      out.write("东软\t杨利\t男\t教授\t东软集团\t数据库与多媒体技术、分布式处理技术\t13302813206\tyangli@neusoft.com\t\r\n");
      out.write("东软\t余克清\t男\t副教授\t东软集团\t嵌入式计算机软件开发、计算机工作流系统研究\t13704116102\tyukq@neusoft.com\t\r\n");
      out.write("东软\t袁淮\t男\t副研究员\t东软集团\t工作流系统设计与实现、计算机网络安全\t13909816519\tyuanh@neusoft.com\t\r\n");
      out.write("东软\t张立东\t男\t副教授\t东软集团\t商业智能\t13604032526\tzhangld@neusoft.com\t\r\n");
      out.write("东软\t张霞\t女\t教授\t东软集团\t数据管理系统\t13604021349\tzhangx@neusoft.com\t\r\n");
      out.write("东软\t张应辉\t男\t副教授\t东软集团\t计算机网络、计算机软件技术、嵌入式软件技术\t13980806060\tzhangyh@neusoft.com\t\r\n");
      out.write("东软\t赵大哲\t女\t教授\t东软集团\t医学影像、软件工程学\t13804016931\tzhaodz@neusoft.com\t\r\n");
      out.write("东软\t赵宏\t男\t教授\t东软集团\t图像处理、分布式多媒体信息系统及多媒体网络技术\t13904002826\tzhaoh@neusoft.com\t\r\n");
      out.write("东软\t郑全录\t男\t研究员\t东软集团\t生物医学工程\t13804024751\tzhengql@neusoft.com\t\r\n");
      out.write("东软\t邹豪\t男\t副教授\t东软集团\t图象处理与模式识别、医学图象处理与三维医学图象重建\t13940069671\tzouh@neusoft.com\t\r\n");
      out.write("            \r\n");
      out.write("        </pre> -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../jsp/banner.jsp", out, false);
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
