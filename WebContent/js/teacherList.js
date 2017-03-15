$(document).ready(function(){
	
	$.ajaxSetup ({cache: false});
	var teacherList; 
	var jiaoshou ="";
	var fujiaoshou="";
	var jiangshi="";
	var zhujiao="";
		
		$("#index3-news-content-area").append("<br/><p class='department2-orgTitle'><b>教授</b></p></br><p id='t1' class='department2-teacher'></p><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>副教授</b></p></br><p id='t2' class='department2-teacher'></p><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>讲师</b></p></br><p id='t3' class='department2-teacher'></p><hr class='tchHr'/> "+
				"<br/><p class='department2-orgTitle'><b>助教</b></p></br><p id='t4' class='department2-teacher'></p><hr class='tchHr'/><br/><br/> ");
		$.getJSON("tchAction!queryFullTches",function(data){
			teacherList = data.tchesList;
			var list = new String();
			$.each(teacherList,function(i){
				
				if(i>=1&&(list.indexOf(teacherList[i].tchName)!=-1)){
					//用于去掉表中重复的老师
				}
				else{
					list = list+" "+teacherList[i].tchName;
			
			/*	var test = process(list, _surname);
				var _list = test.split(" ");
				
				// 姓名数据行循环
				for (var i=0; i<_list.length; ++i) {
					var _line = _list[i].replace(/^\s+/, '');
					alert(_line);
				}*/
	
					var tName = teacherList[i].tchName;
				
					if(tName.length==2){
						tName = tName.substring(0,1)+"&nbsp;&nbsp;"+tName.substring(1);
					
					}
					var tchHref = "tchInfo.jsp?tchId="+teacherList[i].teacherId;
					if(teacherList[i].tchInfo==null){
						tchHref = "#";
					}
				
					if(teacherList[i].tchTitle==null)
						{}
					else if(teacherList[i].tchTitle=="教授")
						jiaoshou = jiaoshou + "<a class='tchLink' href="+tchHref+">"+tName+"</a>*";
					else if(teacherList[i].tchTitle=="副教授")
						fujiaoshou = fujiaoshou + "<a class='tchLink' href="+tchHref+">"+tName+"</a>*";
					else if(teacherList[i].tchTitle.indexOf("讲师")!=-1)
						jiangshi = jiangshi + "<a class='tchLink' href="+tchHref+">"+tName+"</a>*";
					else if(teacherList[i].tchTitle.indexOf("助教")!=-1)
						zhujiao = zhujiao + "<a class='tchLink' href="+tchHref+">"+tName+"</a>*";
				}
			});
	
		
			var test = process(jiaoshou, _surname);
			$("#t1").append(test);
			var test = process(fujiaoshou, _surname);
			$("#t2").append(test);
			var test = process(jiangshi, _surname);
			$("#t3").append(test);
			var test = process(zhujiao, _surname);
			$("#t4").append(test);
			
			
			/*// 姓名数据行循环
			for (var i=0; i<_list.length; ++i) {
				var _line = _list[i];
				alert(_line);
			}
			*/
		});
		
		// 姓氏列表（复姓仅取首字）    
		var _surname = [];
		_surname[1] = '乙';
		_surname[2] = '丁七卜刁刀乜';
		_surname[3] = '干于寸万弋上山广门弓卫也习马子幺';
		_surname[4] = '支云亓元木王车丰韦尤戈区仇从公毛午牛长风凤计卞文方亢斗邓孔尹巴水';
		_surname[5] = '艾玉古东布石左龙归帅叶卢田申史冉付印仝丛丘白句包乐冯邝召台皮司边代';
		_surname[6] = '邢戎巩权吉西成毕过匡师吕曲乔年朱伍伏仲任伊伉华向后全邬危刘齐庄江池汤宇安关羊米许祁农那阮阳阴孙纪';
		_surname[7] = '麦杜杨邴芮花芦苏劳李吾严巫酉甫励邳抗轩连芈邺肖岐时旷吴岑何但佟邱佘余谷犹狄邹言辛库闵冷汪沐沙沃沈宋张陆阿陈妫姒邵邰孟';
		_surname[8] = '青武林杭苗英苟范昔郁欧卓尚呼明易罗国和邾季竺佴郈侬岳兒郄郐念金鱼周於庞冼郎房屈练';
		_surname[9] = '贰项柯相柏柳胡荆郝郦南荀荣革查赵哈思香钟钮郜侯段皇禹郗俞独昝逄施闻洪宦宫姜娄祖祝费胥姚贺绕骆';
		_surname[10] = '班敖秦桂耿索袁莫聂晋栗贾顾夏原柴党晁晏钱铁俸倪徐殷翁奚卿馀郭高栾席唐凌浦海涂容诸谈展陶姬桑';
		_surname[11] = '梅梓菅萧萨黄曹奢龚盛戚常崔符瘐康麻阎渔盖寇梁扈尉屠隗隆巢';
		_surname[12] = '琮韩彭葛董蒋壹覃粟惠辜斐喻嵇程税智傅储焦舒鲁童温滑游曾谢禄缗';
		_surname[13] = '槐楼赖靳甄蒯鄢蓝蓟蓬蒲蒙楚雷零裘肆訾虞睢路锡简解鲍詹雍满窦谬褚';
		_surname[14] = '慕蔡蔺蔚臧管鲜端韶廖阚赛谭熊翟缪';
		_surname[15] = '耦横撒墨稷黎樊滕颜潘豫';
		_surname[16] = '融薛薄燕霍冀黔穆衡嬴澹';
		_surname[17] = '璩檀懋鞠戴赡镡魏繇襄糜麋濮蹇';
		_surname[18] = '瞿';
		_surname[19] = '酆矍籍灌';
		_surname[20] = '露夔';
		_surname[21] = '囊鬻';

		function findit(zi, dict)
		{
		for (var i=1; i<dict.length; ++i) {
		var _str = dict[i];
		for (var j=0; j<_str.length; ++j) {
		if (zi == _str.charAt(j)) return i;
		}
		}
		return 0;
		}

		// txt 待处理的姓名数据行（一行一条信息）
		function process(txt, dict)
		{
		var _out = [];
		var _list = txt.split("*");
		_list.sort();
		// 姓名数据行循环
		for (var i=0; i<_list.length; ++i) {
		var _line = _list[i].replace(/^\s+/, '');
		if (_line == '')
		continue;
		// 取第一字

		var _chr =_line.charAt(_line.indexOf(">")+1);
		// 笔画数查询
		var _num = findit(_chr, dict);
		if (_out[_num] !== undefined) {
		_out[_num] += _line + " ";
		} else {
		_out[_num] = _line + " ";
		}
		}
		var _ret = '';
		for (var i=0; i<_out.length; ++i) {
		if (_out[i] !== undefined) {
		_ret += _out[i];
		}
		}
		return _ret;
		}



		
});