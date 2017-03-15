<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>

	<link rel="stylesheet" type="text/css" href="../css/engHeader.css" /> 
	<link rel="stylesheet" type="text/css" href="../css/engMenu.css" /> 

	<div id="divup">
	<div id="eng-top">
			<div id="eng-rightLink">
				<a class="eng-rightLink"   href="../index.jsp">Chinese</a>
				<a class="eng-rightLink"   href="engPage?pageId=1003">Contact Us</a>
			</div>
			<div style="width:200px;display:inline;float:right;padding-top:10px;padding-right:280px;">
			<span style="color:#ffffff;font-family:Times New Roman;font-weight: bold;font-size:15px;">
			<script language="javascript"> 
				function PageDate(){   
					currentDate = new Date();  
					with(currentDate){   
						var day=getDay();
						var month=getMonth()+1;
						var engMonth = '';
						
						if(month==1){engMonth="January";}
						if(month==2){engMonth="February";}
						if(month==3){engMonth="March";}
						if(month==4){engMonth="April";}
						if(month==5){engMonth="May";}
						if(month==6){engMonth="June";}
						if(month==7){engMonth="July";}
						if(month==8){engMonth="August";}
						if(month==9){engMonth="September";}
						if(month==10){engMonth="October";}
						if(month==11){engMonth="November";}
						if(month==12){engMonth="December";}
						
						
						this.document.write(engMonth+' '+getDate()+','+getFullYear()+'   ') ;  
					}  
					
					if(day==1){document.write(' Monday');}
					if(day==2){document.write(' Tuesday');}
					if(day==3){document.write(' Wednesday');}
					if(day==4){document.write(' Thursday');}
					if(day==5){document.write(' Friday');}
					if(day==6){document.write(' Saturday');}
					if(day==0){document.write(' Sunday');} 
				}
				PageDate();
			</script>
			</span></div>
	</div>
		</div>

	
  <div id="menu">
      <ul class="menu">
          <li><a href="../enindex.html"><span style="font-size:17px;">Home</span></a></li>
          <li><a href="engPage.jsp?pageId=1001" ><span style="font-size:17px;">About</span></a></li>
          <li><a href="engFaculties.jsp"><span style="font-size:17px;">Faculties</span></a></li>
          <li><a href="engMajor.jsp"><span style="font-size:17px;">Major&Course</span></a></li>
          <li><a href="engNewsList.jsp?id=1001&page=1"><span style="font-size:17px;">News&Events</span></a></li>
          <li><a href="engNewsList.jsp?id=1002&page=1"><span style="font-size:17px;">International Cooperation</span></a></li>
          <!--<li><a href="engAdmissions.jsp"><span style="font-size:17px;">Admissions</span></a></li>-->
		  <li><a href="engPage?pageId=1015"><span style="font-size:17px;">Admission</span></a></li>
      </ul>
  </div>
  
