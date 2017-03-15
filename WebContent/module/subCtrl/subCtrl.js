/**
 *
 */
var savePath_dt = "";
var picPath_dt = "";
var isPicNews_sub = 0;
var picnewsState_sub = 0;
var picPath_sub = "";
var picId_sub = 1;
var picUp_sub = 0;
var isNotice_sub = 0;
var noticeState_sub = 0;
var isAttach_sub = 0;
var attachState_sub = 0;
var attachId_sub = 1;
var attachUp_sub = 0;
var newsIdT_sub = 0;
var attachPathT_sub = "";
var attachPath_sub = "";
var alertMsg_sub = "";
var SubNewsWin;
var SubNewsWinU;

if (window.innerHeight)
	var winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
	var winHeight = document.body.clientHeight;
var h = Math.round((winHeight-106)/20);

Ext.onReady(function() {
	var start = 0;
	limit = h;
	var subSiteCode = parent.subSignId;
	var gridId = subSiteCode+'Ctrl';
	var userName = parent.userName;
	var showName = parent.showName;
	var subXtype = 'Ext.ux.' + gridId;
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();
	var subPageStore = new Ext.data.Store({
                    reader: new Ext.data.JsonReader({
                        root: 'subNewsList',
                        totalProperty:'totalProperty',
                        fields: [{
                            name: 'subNewsTitle',
                            mapping: 'subNewsTitle'
                        }, {
                        	name: 'subNewsId',
                            mapping: 'subNewsId'
                        }, {
                        	name: 'subNewsAuthor',
                        	mapping: 'subNewsAuthor'
                        }, {
					        name: 'newsDate',
					        mapping: 'newsDate',
					        dateFormat: 'Y-m-d H:i:s'
					    },{
					        name: 'isPicNews',
					        mapping: 'isPicNews'
					    }, {
					    	name: 'picPath',
					    	mapping: 'picPath'
					    }, {
					        name: 'isNotice',
					        mapping: 'isNotice'
					    }, {
					    	name: 'isAttach',
					        mapping: 'isAttach'
					    }, {
					    	name: 'attachPath',
					    	mapping: 'attachPath'
					    }]
                   }),
                   baseParams:{
                    	'subSite.subSiteCode':subSiteCode,
                    	start:start,
            			limit:limit
                   },
                   url: 'subNewsAction!querySubNewsBySitePage',
                   autoLoad: true
               });
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype: 'panel',
			region:'center',
			items: [{
				xtype: 'grid',
                id: gridId,
                autoHeight: true,
                autoScroll: true,
                stripeRows: true,
                layout: 'fit',
                unstyled: true,
                viewConfig: {
                    forceFit: true
                },
                listeners: {
                	'rowclick' : function rowclick(){
		            	var subManage = Ext.getCmp(gridId);
		        		var removeBtn = Ext.getCmp('removeSub');
		        		var updateBtn = Ext.getCmp('updateSub');	        	
		        		removeBtn.setDisabled(false);
		        		updateBtn.setDisabled(false);	      
		        		subManage.removeListener('rowclick',rowclick);
                	}
                },
                ds: subPageStore,
                cm: new Ext.grid.ColumnModel([
				{
                    header: '新闻标题',
                    dataIndex: 'subNewsTitle',
                    sortable: true
                }, {
                	header: '新闻编号',
                    dataIndex: 'subNewsId',
                    sortable: true,
                    width: 60
                }, {
                	header: '作者',
        			dataIndex: 'subNewsAuthor',
        			sortable: true,
        			width: 40
                }, {
					header: '发布时间',
				    dataIndex: 'newsDate',
				    sortable: true,
				    type: 'date',
				    width: 83,
				    renderer: Ext.util.Format.dateRenderer('Y年m月d日 H:i:s')
				}, {
				    header: '是否为图片新闻',
				    dataIndex: 'isPicNews',
				    width: 80,
				    sortable: true
				}, {
					header: '图片新闻地址',
				    dataIndex: 'picPath',
				    width: 90,
				    sortable: true
				}, {
				    header: '是否为公告',
				    dataIndex: 'isNotice',
				    width: 60,
				    sortable: true
				},  {
					header: '是否有附件',
				    dataIndex: 'isAttach',
				    sortable: true,
				    width: 60
				}, {
					header: '附件地址',
				    dataIndex: 'attachPath',
				    sortable: true,
				    width: 120
				}])
			}],

			tbar:{
				xtype: 'toolbar',
                items: [{
                    text: '添加新闻',
                    iconCls: 'add',
                    handler: addSubNews
                }, '-', {
                    text: '删除新闻',
                    iconCls: 'remove',
                    handler: deleteNews,
                    id: 'removeSub',
                    disabled: true
                }, '-', {
                    text: '修改新闻',
                    iconCls: 'update',
                    handler: updateNews,
                    id: 'updateSub',
                    disabled: true
                }]
			},
			bbar:{
				store: subPageStore,
           		xtype: 'paging',
           		beforePageText: '第',
            	afterPageText: '页，共{0}页',
            	firstText: '首页',
            	lastText: '末页',
            	refreshText: '刷新',
            	nextText: '下一页',
            	prevText: '上一页',
           		pageSize: limit,
				displayInfo: true,
				displayMsg: '第 {0}条到 {1}条，一共 {2}条记录',
				emptyMsg: '没有记录'
			}
		}]
	}).show();

	function addSubNews() {
	
		if(SubNewsWin != null) {
			winReset();
			SubNewsWin.show();
		}
		else {
			SubNewsWin = new Ext.Window({
				id: 'addSubNews-win',
		        title: '添加子网站新闻',
		        closeAction: 'hide',
		        width: '80%',
		        height: 450,
		        minWidth: 500,
		        minHeight: 400,
		        layout: 'fit',
		        border: false,
		        modal: true,
		        buttonAlign: 'center',
				buttons: [{
					text: '确定',
		        	handler: function() {
						isPicNewsF();
		        		isNoticeF();
		        		isAttachF();
		        		var form = Ext.getCmp('addSubNews-form').getForm();
		  
		                if(loadValid() && alertMsg_sub == "") {
		   		                	
		                    Ext.Ajax.request({
		                    	waitMsg: '正在添加',
								url: 'subNewsAction!addSubNews',
								params:{
		                        	'subSiteCode': subSiteCode,
		                        	'subNews.isPicNews': isPicNews_sub,
		                        	'subNews.isNotice': isNotice_sub,
		                        	'subNews.isAttach': isAttach_sub,
		                        	'subNews.newsContent': KE.html('newsContent'),
		                        	'subNews.subNewsTitle': Ext.getCmp('subNewsTitle').getValue(),
		                        	'subNews.subNewsAuthor': Ext.getCmp('subNewsAuth').getValue(),
		                        	'subPicPath': '/upload/picnews/' + picPath_sub,
		                        	'subAttachPath': '/upload/attachment/' + attachPath_sub
		                        },
								success: function(form, action){
		                            Ext.Msg.alert('信息', '添加成功');
		                            SubNewsWin.hide();
		                            Ext.getCmp(gridId).getStore().reload();
		                        },
		                        failure: function(form, action){
		                            Ext.Msg.alert('信息', '添加失败');
		                        }
							});				
		                }
		                 else if(loadValid() && alertMsg_sub != "") {
		                	Ext.Msg.alert('提示', alertMsg_sub);
		                	alertMsg_sub = "";

		                }
		                else  {

		                }
		        	}
				}, {
					text: '取消',
		        	handler: function() {
 						SubNewsWin.hide();
		        	}
				}, {
					text: '重置',
		        	handler: function() {
						winReset();
		        	}
				}],
				items: [{
					xtype: 'form',
		            id: 'addSubNews-form',
		            layout: 'form',
		            frame: true,
		            bodyPadding: '10 20',
		            autoScroll: true,
		            defaults: {
		                anchor: '93%',
		                msgTarget: 'side',
		                allowBlank: false
		            },
		            items: [{
						fieldLabel: '新闻标题',
		            	id: 'subNewsTitle',
		                xtype: 'textfield',
		                name: 'subNews.subNewsTitle',
		                emptyText: '输入新闻标题',
		                blankText: '新闻标题不能为空'
		            }, {
						fieldLabel: '作者',
		                xtype: 'textfield',
		                id: 'subNewsAuth',
		                name: 'subNews.subNewsAuthor',
		                value: showName,
		               	disabled: true
		            }, {
		            	xtype: 'fieldset',
		                title: '公告',
		                id: 'subNotice',
		                checkboxToggle: true,
		                collapsed: true,
		                listeners: {
		            		expand : function() {
		            			noticeState_sub = 1;
		            		},
		            		collapse: function() {
		            			noticeState_sub = 0;
		            		}
		                }
		            }, {
		            	xtype: 'fieldset',
		                title: '图片',
		                id: 'subPicSet',
		                checkboxToggle: true,
		                collapsed: true,
		                buttons: [{
		            		id: 'PRBtnsub',
		            		text:'添加／删除图片',
		            		handler: function() {
		            			new Ext.Window({
								    width : 650,
								    title : '图片上传(请上传1M一下的照片)',
								    height : 300,
								    layout : 'fit',
								    items : [{
								            xtype : 'uploadPanel',
								            border : false,
								            id: 'picUp',
								            fileSize : 1024*50,//限制文件大小
								            uploadUrl : 'uploadAction!uploadAttach',
								            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
								            filePostName : 'attach', //后台接收参数
								            fileTypes : '*.jpg;*.png',//可上传文件类型
								            postParams : {savePath:'upload\\picnews\\'} //上传文件存放目录
								     }],
								     listeners:{
								     	beforeclose: function() {
								     		isPicUp();
								     		showPic();
								     	}
								     }
								}).show();
		            		}
		                }],
		                listeners: {
		            		expand : function() {
		            			picState_sub = 1;
		            		},
		            		collapse: function() {
		            			picState_sub = 0;
		            		}
		                },
		                items: [{
		                	xtype: 'label',
		                	id: 'picInfo'
		                }]
		            },{
		            	xtype: 'fieldset',
		                title: '附件',
		                id: 'subAttachSet',
		                checkboxToggle: true,
		                collapsed: true,
		                buttons: [{
		            		id: 'ARBtnsub',
		            		text:'添加／删除附件',
		            		handler: function() {
		            			new Ext.Window({
								    width : 650,
								    title : '附件上传',
								    height : 300,
								    layout : 'fit',
								    items : [{
								            xtype : 'uploadPanel',
								            border : false,
								            id: 'attachUp',
								            fileSize : 1024*50,//限制文件大小
								            uploadUrl : 'uploadAction!uploadAttach',
								            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
								            filePostName : 'attach', //后台接收参数
								            fileTypes : '*.jpg;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf',//可上传文件类型
								            postParams : {savePath:'upload\\attachment\\'} //上传文件存放目录
								     }],
								     listeners:{
								     	beforeclose: function() {
								     		isAttachUp();
								     		showAllAttach();
								     	}
								     }
								}).show();
		            		}
		                }],
		                listeners: {
		            		expand : function() {
		            			attachState_sub = 1;
		            		},
		            		collapse: function() {
		            			attachState_sub = 0;
		            		}
		                },
		                items: [{
		                	xtype: 'label',
		                	id: 'attachInfo'
		                }]
		            },{
		            	hideLabel: true,
		            	anchor: '94%',
		            	name: 'news.newsContent',
		                id: 'newsContent',
		                xtype: 'textarea',
		                height: 350
		            }],
		            listeners:{
			            'render':function(){
			                KE.show({
			                    id:'newsContent',
			                    imageUploadJson: '../../jsp/upload_json.jsp',
			                    fileManagerJson: '../../jsp/file_manager_json.jsp',
			                });
			                setTimeout("KE.create('newsContent');", 100);

			            }
			    	}
				}]
			}).show();
		}

	}

	function deleteNews() {
		Ext.Msg.confirm('信息', '确定删除新闻？' ,
			function(btn){
				if(btn == 'yes') {
					var newsGrid = Ext.getCmp(gridId);
					var sm = newsGrid.getSelectionModel();
					var store = Ext.getCmp(gridId).getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'subNewsAction!deleteSubNews',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','新闻删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'subNewsArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}

	function updateNews() {
		if(SubNewsWinU != null) {
			winUpSet();
			winLoad();
			SubNewsWinU.show();
		}
		else {
			SubNewsWinU = new Ext.Window({
				id: 'updateNews-win',
		        title: '修改新闻',
		        width: '80%',
		        height: 450,
		        minWidth: 500,
		        minHeight: 400,
		        layout: 'fit',
		        border: false,
		        modal: true,
		        closeAction: 'hide',
		        buttonAlign:'center',
		        buttons:[{
					text: '确定',
	            	handler: function() {
	            		isPicNewsFUp();
	            		isNoticeFUp();
	            		isAttachFUp();

	                    if (loadUpValid() && (alertMsg_sub == "")) {
	                    	var ppp = new String();
	            			var aaa = new String();
	            			ppp =  picPath_sub,
	            			aaa =  attachPath_sub
	                		if(ppp.charAt(0)=='/'){
	            				ppp = ppp;
	            			}
	            			else{
	            				ppp = '/upload/picnews/'+ppp;
	            			}
	            			if(aaa.charAt(0)=='/'){
	            				aaa = aaa;
	            			}
	            			else{
	            				aaa = '/upload/attachment/'+aaa;
	            			}
	                    	Ext.Ajax.request({
								url: 'subNewsAction!updateSubNews',
								params:{
									'subNews.subNewsId': newsIdT_sub,
		                        	'subSiteCode': subSiteCode,
		                        	'subNews.isPicNews': isPicNews_sub,
		                        	'subNews.isNotice': isNotice_sub,
		                        	'subNews.isAttach': isAttach_sub,
		                        	'subNews.newsContent': KE.html('subNewsContentUp'),
		                        	'subNews.subNewsTitle': Ext.getCmp('subNewsTitleUp').getValue(),
		                        	'subNews.subNewsAuthor': Ext.getCmp('subNewsAuthUp').getValue(),
		                        	'subPicPath': ppp,
		                        	'subAttachPath': aaa
		                        },
								success: function(form, action){
		                            Ext.Msg.alert('信息', '添加成功');		         
		                            SubNewsWinU.hide();
		                            Ext.getCmp(gridId).getStore().reload();
		                        },
		                        failure: function(form, action){
		                            Ext.Msg.alert('信息', '添加失败');
		                        }
							});

	                    }
	                    else if(loadUpValid() && (alertMsg_sub != "")) {
	                    	Ext.Msg.alert('提示', alertMsg_sub);
	                    	alertMsg_sub = "";
	                    }
	                    else  {
	                    }
	                }
		        }, {
					text: '重置',
	            	handler: function() {
						winUpSet();
	            	}
		        }, {
					text: '取消',
	            	handler: function() {
	            		 SubNewsWinU.hide();
	            	}
		        }],
		        items:[{
					xtype: 'form',
		            id: 'upSubNews-form',
		            layout: 'form',
		            frame: true,
		            bodyPadding: '10 20',
		            autoScroll: true,
		            defaults: {
		                anchor: '93%',
		                msgTarget: 'side',
		                allowBlank: false
		            },
		            items: [{
						fieldLabel: '新闻标题',
		            	id: 'subNewsTitleUp',
		                xtype: 'textfield',
		                name: 'subNews.subNewsTitle',
		                emptyText: '输入新闻标题',
		                blankText: '新闻标题不能为空'
		            }, {
						fieldLabel: '作者',
		                xtype: 'textfield',
		                id: 'subNewsAuthUp',
		                name: 'subNews.subNewsAuthor',
		                value: userName,
		               	disabled: true
		            }, {
		            	xtype: 'fieldset',
		                title: '公告',
		                id: 'subNoticeUp',
		                checkboxToggle: true,
		                collapsed: true,
		                listeners: {
		            		expand : function() {
		            			noticeState_sub = 1;
		            		},
		            		collapse: function() {
		            			noticeState_sub = 0;
		            		}
		                }
		            }, {
		            	xtype: 'fieldset',
		                title: '图片新闻',
		                id: 'subPicSetUp',
		                checkboxToggle: true,
		                collapsed: true,
		                buttons: [{
		            		id: 'subPRBtnUp',
		            		text:'添加／删除图片',
		            		handler: function() {
		            			new Ext.Window({
								    width : 650,
								    title : '图片上传(请上传1M一下的照片)',
								    height : 300,
								    layout : 'fit',
								    items : [{
								            xtype : 'uploadPanel',
								            border : false,
								            id: 'picUpUp',
								            fileSize : 1024*50,//限制文件大小
								            uploadUrl : 'uploadAction!uploadAttach',
								            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
								            filePostName : 'attach', //后台接收参数
								            fileTypes : '*.jpg;*.png',//可上传文件类型
								            postParams : {savePath:'upload\\picnews\\'} //上传文件存放目录
								     }],
								     listeners:{
								     	beforeclose: function() {
								     		isPicUpUp();
								     		showPicUp();
								     	}
								     }
								}).show();
		            		}
		                }],
		                listeners: {
		            		expand : function() {
		            			picState_sub = 1;
		            		},
		            		collapse: function() {
		            			picState_sub = 0;
		            		}
		                },
		                items: [{
		                	xtype: 'label',
		                	id: 'picInfoUp'
		                }]
		            },{
		            	xtype: 'fieldset',
		                title: '附件',
		                id: 'subAttachSetUp',
		                checkboxToggle: true,
		                collapsed: true,
		                buttons: [{
		            		id: 'subARBtnUp',
		            		text:'添加／删除附件',
		            		handler: function() {
		            			new Ext.Window({
								    width : 650,
								    title : '附件上传',
								    height : 300,
								    layout : 'fit',
								    items : [{
								            xtype : 'uploadPanel',
								            border : false,
								            id: 'attachUpUp',
								            fileSize : 1024*50,//限制文件大小
								            uploadUrl : 'uploadAction!uploadAttach',
								            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
								            filePostName : 'attach', //后台接收参数
								            fileTypes : '*.jpg;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf',//可上传文件类型
								            postParams : {savePath:'upload\\attachment\\'} //上传文件存放目录
								     }],
								     listeners:{
								     	beforeclose: function() {
								     		isAttachUpUp();
								     		showAllAttachUp();
								     	}
								     }
								}).show();
		            		}
		                }],
		                listeners: {
		            		expand : function() {
		            			attachState_sub = 1;
		            		},
		            		collapse: function() {
		            			attachState_sub = 0;
		            		}
		                },
		                items: [{
		                	xtype: 'label',
		                	id: 'attachInfoUp'
		                }]
		            },{
		            	hideLabel: true,
		            	anchor: '94%',
		            	name: 'news.newsContent',
		                id: 'subNewsContentUp',
		                xtype: 'textarea',
		                height: 350
		            }],
		            listeners:{
			            'render':function(){
			                KE.show({
			                    id:'subNewsContentUp',
			                    imageUploadJson: '../../jsp/upload_json.jsp',
			                    fileManagerJson: '../../jsp/file_manager_json.jsp',
			                });
			                setTimeout("KE.create('subNewsContentUp');", 100);

			            }
			    	}
		        }]
			}).show();
			winLoad();
		}
	}


	function isPicNewsF() {
		var fileUpload = Ext.getCmp('picInfo').text;
		if((fileUpload != "") && (picnewsState_sub == 1)) {
			isPicNews_sub=1;

		}
		else if((fileUpload == "") && (picnewsState_sub == 1)) {
			alertMsg_sub = alertMsg_sub + " 勾选图片新闻后，没有选择需要上传的图片";
		}
		else {

		}

	}

	function isPicNewsFUp() {
		var fileUpload = Ext.getCmp('picInfoUp').text;
		if((fileUpload != "") && (picnewsState_sub == 1)) {
			isPicNews_sub = 1;
	
		}
		else if((fileUpload == "") && (picnewsState_sub == 1)) {
			alertMsg_sub = alertMsg_sub + " 勾选图片新闻后，没有选择需要上传的图片";
		}
		else {

		}

	}

	function isNoticeF() {
		if(noticeState_sub == 1) {
			isNotice_sub = 1;
		}

		else {

		}
	}

	function isNoticeFUp() {
		if(noticeState_sub == 1) {
			isNotice_sub=1;
		}
		else {

		}
	}

	function isPicUp() {
		var picUpload = Ext.getCmp('picUp').getComponent('gp').getStore().getAt(0);
		if(picUpload) {
			isPicNews_sub = 1;
		}
	}
	
	function showPic() {
		
		var aStore = Ext.getCmp('picUp').getComponent('gp').getStore();
		var picInfo = Ext.getCmp('picInfo');
		var picSet = Ext.getCmp('subPicSet');
		var PRBtn = Ext.getCmp('PRBtnsub');
		var count = aStore.getCount();
		picPath_sub = "";

		
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);
			if(i==0){
				picPath_sub = picPath_sub + rec.data.name + ',';
				picPath_dt = '' + picPath_dt + "1" + ',';
			}
		
		}
		picPath_sub = picPath_sub.substring(0, picPath_sub.length - 1);
		picPath_dt = picPath_dt.substring(0, picPath_dt.length - 1);
		picInfo.setText(picPath_sub);

		if(count != 0) {
			picSet.remove(PRBtn,false);
			PRBtn.setVisible(false);
			picSet.doLayout();
	
		}
	}

	function isPicUpUp() {
		var picUpload = Ext.getCmp('picUpUp').getComponent('gp').getStore().getAt(0);
		if(picUpload) {
			picUp_sub = 1;
		}
	}
	
	function isAttachUp() {
		var attachUpload = Ext.getCmp('attachUp').getComponent('gp').getStore().getAt(0);
		if(attachUpload) {
			attachUp_sub = 1;
		}
	}

	function isAttachUpUp() {
		var attachUpload = Ext.getCmp('attachUpUp').getComponent('gp').getStore().getAt(0);
		if(attachUpload) {
			attachUp_sub = 1;
		}
	}

	function showAllAttach() {
		
		var aStore = Ext.getCmp('attachUp').getComponent('gp').getStore();
		var attachInfo = Ext.getCmp('attachInfo');
		var attachSet = Ext.getCmp('subAttachSet');
		var ARBtn = Ext.getCmp('ARBtnsub');
		var count = aStore.getCount();
		attachPath_sub = "";

		
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);

			attachPath_sub = attachPath_sub + rec.data.name + ',';
			savePath_dt = '' + savePath_dt + "1" + ',';
		}
		attachPath_sub = attachPath_sub.substring(0, attachPath_sub.length - 1);
		savePath_dt = savePath_dt.substring(0, savePath_dt.length - 1);
		attachInfo.setText(attachPath_sub);
		if(count != 0) {
			attachSet.remove(ARBtn,false);
			ARBtn.setVisible(false);
			attachSet.doLayout();

		}
	}

	function showAllAttachUp() {
		var aStore = Ext.getCmp('attachUpUp').getComponent('gp').getStore();
		var attachInfo = Ext.getCmp('attachInfoUp');
		var attachSet = Ext.getCmp('subAttachSetUp');
		var ARBtn = Ext.getCmp('subARBtnUp');
		var count = aStore.getCount();
		attachPath_sub = "";
	
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);
			attachPath_sub = attachPath_sub + rec.data.name + ',';
		}
		attachPath_sub = attachPath_sub.substring(0, attachPath_sub.length - 1);

		attachInfo.setText(attachPath_sub);
		
		if(count != 0) {
			attachSet.remove(ARBtn,false);
			ARBtn.setVisible(false);
			attachSet.doLayout();
	
		}
	}

	function isAttachF() {
		if(attachPathT_sub != null) {
			var array = attachPathT_sub.split(",");
			var attachInfo = Ext.getCmp('attachInfo');
			if(array.length == 0) {
				var state = 0;
			}
			else{
				state = 1;
			}

			if((attachUp_sub == 1 || state == 1) && (attachState_sub == 1)) {
				isAttach_sub =  1;
			}
			else if((attachUp_sub == 0) && (attachState_sub == 1)) {
				alertMsg_sub = alertMsg + " 勾选附件后，没有选择附件";
			}
			else {

			}
		}
	}

	function isAttachFUp() {
		if(attachPathT_sub != null) {
			var array = attachPathT_sub.split(",");
			var attachInfo = Ext.getCmp('attachInfoUp');
			if(array.length == 0) {
				var state = 0;
			}
			else{
				state = 1;
			}

			if((attachUp_sub == 1 || state == 1) && (attachState_sub == 1)) {
				isAttach_sub =  1;
			}
			else if((attachUp_sub == 0) && (attachState_sub == 1)) {
				alertMsg_sub = alertMsg + " 勾选附件后，没有选择附件";
			}
			else {

			}
		}
	}


	function loadValid() {
		var sbt = Ext.getCmp('subNewsTitle').isValid();
		var sna = Ext.getCmp('subNewsAuth').isValid();
		var ke = KE.isEmpty('newsContent');
		if(ke) {
			Ext.Msg.alert('信息','新闻内容不能为空');
			return false;
		}
		else if(sbt && sna && !ke) {
			return true;
		}
		else {
			return false;
		}
	}

	function loadUpValid() {
		var sbtu = Ext.getCmp('subNewsTitleUp').isValid();
		var snau = Ext.getCmp('subNewsAuthUp').isValid();
		var keu = KE.isEmpty('subNewsContentUp');
		if(keu) {
			Ext.Msg.alert('信息','新闻内容不能为空');
			return false;
		}
		else if(sbtu && snau && !keu) {
			return true;
		}
		else {
			return false;
		}
	}

	function winReset() {
		Ext.getCmp('subNewsTitle').reset();
		Ext.getCmp('subNewsAuth').reset();
		Ext.getCmp('subPicSet').collapse(false);
		Ext.getCmp('subNotice').collapse(false);
		Ext.getCmp('subAttachSet').collapse(false);
		Ext.getCmp('picInfo').setText("");
		Ext.getCmp('attachInfo').setText("");
		KE.html('newsContent','');
	}

	function winUpSet() {
		Ext.getCmp('subNewsTitleUp').reset();
		Ext.getCmp('subNewsAuthUp').reset();
		Ext.getCmp('subPicSetUp').collapse(false);
		Ext.getCmp('subNoticeUp').collapse(false);
		Ext.getCmp('subAttachSetUp').collapse(false);
		Ext.getCmp('picInfoUp').setText("");
		Ext.getCmp('attachInfoUp').setText("");
		KE.html('subNewsContentUp','');
	}

	function winLoad() {
		var updateForm = Ext.getCmp('upSubNews-form').getForm();
		var newsGrid = Ext.getCmp(gridId);
		var sm = newsGrid.getSelectionModel();
		var store = Ext.getCmp(gridId).getStore();
		var record = sm.getSelected();
		if(updateForm) {
			Ext.lib.Ajax.request(
				'post',
				'subNewsAction!querySubNewsById',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						newsIdT_sub = data.subNews.subNewsId;
						var newsTitleT_sub = data.subNews.subNewsTitle;
						var newsAuthorT_sub = data.subNews.subNewsAuthor;
						var isPicNewsT_sub = data.subNews.isPicNews;
						var isNoticeT_sub = data.subNews.isNotice;
						var isAttachT_sub = data.subNews.isAttach;
						var newsContent_sub = data.subNews.newsContent;
						var picPathT_sub = data.subNews.picPath;
						attachPathT_sub = data.subNews.attachPath;
						Ext.getCmp('subNewsTitleUp').setValue(newsTitleT_sub);
						Ext.getCmp('subNewsAuthUp').setValue(newsAuthorT_sub);
						KE.html('subNewsContentUp',newsContent_sub);
						if(isNoticeT_sub == 1) {
							Ext.getCmp('subNoticeUp').expand();
						}
						if(isPicNewsT_sub == 1) {
							Ext.getCmp('subPicSetUp').expand();		
							Ext.getCmp('picInfoUp').setText(picPathT_sub);	
						}
						if(isAttachT_sub == 1) {
							Ext.getCmp('subAttachSetUp').expand();
							attachPath_sub = attachPathT_sub;	
							Ext.getCmp('attachInfoUp').setText(attachPathT_sub);	
						}
					},
					failure: function() {
						Ext.Msg.alert('失败','初始化数据失败');
					}
				},
				'subNewsId=' + encodeURIComponent(record.data.subNewsId)
			);
		}
	}
});