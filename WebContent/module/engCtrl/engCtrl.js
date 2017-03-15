/**
 *
 */
var isPicNews = 0;
var picnewsState = 0;
var isNotice = 0;
var noticeState = 0;
var isAttach = 0;
var attachState = 0;
var attachId = 1;
var attachUp = 0;
var picUp = 0;
var picPath = "";
var newsIdT = 0;
var attachPathT = "";
var attachPath = "";
var alertMsg = "";
var start = 0;
var savePath_dt = "";
var picPath_dt = "";
//var limit = 0;
var rowStart = 0;
var newsWin;
var newsWinU;


if (window.innerHeight)
	var winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
	var winHeight = document.body.clientHeight;
var h = Math.round((winHeight-106)/20);

Ext.onReady(function() {
	var themeCssS = parent.themeCf;
	var engName  = parent.engName;
	var userName = parent.userName;
	var showName = parent.showName;
	limit = h;
	var pageStore = new Ext.data.Store({
                    reader: new Ext.data.JsonReader({
                        root: 'engNewsList',
                        totalProperty:'totalProperty',
                        fields: [{
                            name: 'newsTitle',
                            mapping: 'newsTitle'
                        }, {
                        	name: 'newsId',
                            mapping: 'newsId'
                        }, {
                        	name: 'sectionName',
                        	mapping: 'engSection.sectionName'
                        }, {
                        	name: 'newsAuthor',
                        	mapping: 'newsAuthor'
                        },{
					        name: 'newsDate',
					        mapping: 'newsDate',
					        dateFormat: 'Y-m-d H:i:s',
				        	convert : function(v,rec){   
                             if(!v){   
                                 return "";   
                             }   
                             v = v.replace(new RegExp("-","gm"), "/").replace("T"," ");   
                    
                             if(!Ext.isDate(v)){   
                                 v = new Date(Date.parse(v));    
                             }   
                             return v.dateFormat("Y-m-d H:i:s");   
                             }   
					    }, {
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
					    }, {
					        name: 'newsStatus',
					        mapping: 'newsStatus'
					    }]
                    }),
                    baseParams:{
                    	start:start,
                    	limit:limit
                    },
                    url: 'engNewsAction!queryAllNewsByPage',
                    autoLoad: true
                })
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/xtheme-blue.css');
	Ext.QuickTips.init();
	Ext.ux.engCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
			this.items = [{
                xtype: 'grid',
                id: 'engCtrl-grid',
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
		            	var newsManage = Ext.getCmp('engCtrl-grid');
		        
		        		var removeBtn = Ext.getCmp('removeNews');
		        		var updateBtn = Ext.getCmp('updateNews');
		        		var publishBtn = Ext.getCmp('publishNews');
		        		removeBtn.setDisabled(false);
		        		updateBtn.setDisabled(false);
		        		/*publishBtn.setDisabled(false);*/
		        		newsManage.removeListener('rowclick',rowclick);
                	}
                },
                ds: pageStore,

                cm: new Ext.grid.ColumnModel([

    			{
                    header: '新闻标题',
                    dataIndex: 'newsTitle',
                    sortable: true
                    //width: 120
                }, {
                	header: '新闻编号',
                    dataIndex: 'newsId',
                    sortable: true,
                    width: 60
                }, {
                	header: '所属栏目',
        			dataIndex: 'sectionName',
                    sortable: true,
                    width: 60
                }, {
                	header: '作者',
        			dataIndex: 'newsAuthor',
        			sortable: true,
        			width: 40
                }, {
					header: '发布时间',
				    dataIndex: 'newsDate',
				    sortable: true,
				    type: 'date',
				    width: 83,
				    renderer:function(v){   
	                    if(!v){   
	                        return "";   
	                    }   
	                    //alert(v);   
	                    v = v.replace(new RegExp("-","gm"), "/").replace("T"," ");   
	                    //alert(v);   
	                    if(!Ext.isDate(v)){   
	                        v = new Date(Date.parse(v));    
	                    }   
	                    //alert(v);   
	                    return v.dateFormat("Y年m月d日 H:i:s");   
	                }   
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
				}, {
					header: '是否有附件',
				    dataIndex: 'isAttach',
				    sortable: true,
				    width: 60
				}, {
					header: '附件地址',
				    dataIndex: 'attachPath',
				    sortable: true,
				    width: 120
				}, {
					header: '新闻状态',
				    dataIndex: 'newsStatus',
				    renderer : function(value)
				    {
				    	if(value==2)
				    		return "已发布";
				    	if(value==0)
				    		return "待翻译";
				    	if(value==1)
				    		return "待审核";
				    },
				    sortable: true,
				    width: 120
				}])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加新闻',
                    iconCls: 'add',
                    handler: addNews,
                    id:'addNews'
                }, '-', {
                    text: '删除新闻',
                    iconCls: 'remove',
                    handler: deleteNews,
                    id: 'removeNews',
                    disabled: true
                }, '-', {
                    text: '修改新闻',
                    iconCls: 'update',
                    handler: updateNews,
                    id: 'updateNews',
                    disabled: true
                    }
                
                ]
            };
            this.bbar = {
            	store: pageStore,
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
           	};
			Ext.ux.engCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('engCtrl', Ext.ux.engCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'engCtrl',
			region:'center'
		}]
	}).show();

	function addNews() {

		isPicNews = 0;
		isNotice = 0;
		isAttach = 0;
		
		if(newsWin != null) {
			winSet();
			newsWin.show();
		}
		else{

			newsWin = new Ext.Window({
				id: 'addNews-win',
	            title: '添加新闻',
	            width: '80%',
	            height: 450,
	            minWidth: 500,
	            minHeight: 400,
	            layout: 'fit',
	            border: false,
	            modal: true,
	            closeAction: 'hide',
	            buttonAlign: 'center',
	            buttons: [{
	            	text: '确定',
	            	handler: function() {

	            		isPicNewsF();
	            		isNoticeF();
	            		isAttachF();

	            		var form = Ext.getCmp('addNews-form').getForm();
	        
	                   	if (loadValid() && (alertMsg == "")) {
	                   		
	                        
	                        Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'engNewsAction!addNews',
									params:{
			                        	'engNews.newsTitle': Ext.getCmp('newsTitle').getValue(),
										'engNews.newsAuthor': Ext.getCmp('newsAuth').getValue(),
										'newsSection': Ext.getCmp('section').getValue(),
			                        	'engNews.isPicNews': isPicNews,
		                            	'engNews.isNotice': isNotice,
		                            	'engNews.isAttach': isAttach,
		                            	'engNews.newsContent': KE.html('newsContent'),
		                            	'newsPicPath': '/upload/picnews/' + picPath,
		                            	'newsAttachPath': '/upload/attachment/' + attachPath,
			                        	'engNews.attachName':savePath_dt
			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '添加成功');
			                            newsWin.hide();
			                            Ext.getCmp('engCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '添加失败');
			                        }
								});
	                    }
	                    else if(loadValid() && (alertMsg != "")) {
	                 
	                    	Ext.Msg.alert('提示', alertMsg);
	                    	alertMsg = "";
	                    }
	                    else  {
	                    }

	            	}
	            },{
	            	text: '取消',
	            	handler: function() {
	            		newsWin.hide();
	            	}
	            }],
	            items: [{
	            	xtype: 'form',
	                id: 'addNews-form',
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
	                	id: 'newsTitle',
	                    xtype: 'textfield',
	                    name: 'engNews.newsTitle',
	                    emptyText: '输入新闻标题',
	                    blankText: '新闻标题不能为空'
	                }, {
	                	fieldLabel: '所属栏目',
	                	id: 'section',
	                    xtype: 'combo',
	                    name: 'newsSection',
	                    forceSelection: true,
	        			editable: false,
	        			mode: 'local',
	        			triggerAction: 'all',
	                    blankText: '所属栏目不能为空',
	                    store: new Ext.data.JsonStore({
	                    	url: 'engSectionAction!queryAllSections',
							root : 'sectionsList',
							baseParams: {
								roleId:parent.roleId
							},
							autoLoad : true,
							fields: ['sectionName']
	                    }),
	                    valueField: 'sectionName',
	                    displayField: 'sectionName'
	                }, {
	                	fieldLabel: '作者',
	                    xtype: 'textfield',
	                    id: 'newsAuth',
	                    name: 'engNews.newsAuthor',
	                    value: engName,
	                	disabled: true
	                }, {
	                	xtype: 'fieldset',
	                    title: '公告',
	                    id: 'notice',
	                    checkboxToggle: true,
	                    collapsed: true,
	                    listeners: {
	                		expand : function() {
	                			noticeState = 1;
	                		},
	                		collapse: function() {
	                			noticeState = 0;
	                		}
	                    }
	                },{
	                	xtype: 'fieldset',
	                	id: 'picSet',
	                    title: '图片新闻',
	                    checkboxToggle: true,
	                    style : 'font=size:15px',
	                    collapsed: true,
                    	buttons: [{
	                    		id: 'PRBtn',
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
									            fileSize : 1024*1,//限制文件大小
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
	                			picnewsState = 1;
	                		},
	                		collapse: function() {
	                			picnewsState = 0;
	                		}
	                    },
	                    items: [{
	                    	xtype: 'label',
	                    	id: 'picInfo',
	                    	text:''
	                    }]
	                }, {
	                	xtype: 'fieldset',
	                    title: '附件',
	                    id: 'attachSet',
	                    checkboxToggle: true,
	                    collapsed: true,
	                    buttons: [{
	                    		id: 'ARBtn',
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
									            fileSize : 1024*3.5,//限制文件大小
									            uploadUrl : 'uploadAction!uploadAttach',
									            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
									            filePostName : 'attach', //后台接收参数
									            fileTypes : '*.jpg;*.png;*.doc;*.docx;*.xls;*.xlsx;*.rar;*.zip;*.pdf',//可上传文件类型
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
	                			attachState = 1;
	                		},
	                		collapse: function() {
	                			attachState = 0;
	                		}
	                    },
	                    items: [{
	                    	xtype: 'label',
	                    	id: 'attachInfo',
	                    	text:''
	                    }]
	                }, {

	                	hideLabel: true,
	                	anchor: '94%',
	                	name: 'engNews.newsContent',
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
			                setTimeout("KE.create('newsContent');", 1000);

			            }
			    	}
	            }]
			});
		
			newsWin.show();
	
		}
		
		

	}
	


	function deleteNews() {
		Ext.Msg.confirm('信息', '确定删除新闻？' ,
			function(btn){
				if(btn == 'yes') {
					var engGrid = Ext.getCmp('engCtrl-grid');
					var sm = engGrid.getSelectionModel();
					var store = Ext.getCmp('engCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'engNewsAction!deleteNews',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','新闻删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'newsArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}

	function updateNews() {

			newsWinU = new  Ext.Window({
				id: 'updateNews-win',
				closeAction: 'close',
		        title: '修改新闻',
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
						isPicNewsFUp();
	            		isNoticeFUp();
	            		isAttachFUp();
	            		var form = Ext.getCmp('updateNews-form').getForm();
	            		if (loadUpValid() && (alertMsg == "")) {

	            			
							Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'engNewsAction!updateNews',
									params:{
										'engNews.newsId': newsIdT,
			                        	'engNews.newsTitle': Ext.getCmp('newsTitleUp').getValue(),
										'newsSection': Ext.getCmp('newsSectionUp').getValue(),
		                            	'engNews.isNotice': isNotice,		                            
		                            	'engNews.newsContent': KE.html('newsContentUp'),

			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '更新成功');
			                            newsWinU.close();
			                            Ext.getCmp('engCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '更新失败');
			                        }
								});
	                    }
	                    else if(loadUpValid() && (alertMsg != "")) {
	                    	Ext.Msg.alert('提示', alertMsg);
	                    	alertMsg = "";
	                    }
	                    else  {
	                    }
					}
		        }, {
					text: '取消',
					handler: function() {
						newsWinU.close();
					}
		        }],
		        items: [{
	            	xtype: 'form',
	                id: 'updateNews-form',
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
	                	id: 'newsTitleUp',
	                    xtype: 'textfield',
	                    name: 'engNews.newsTitle',
	                    emptyText: '输入新闻标题',
	                    blankText: '新闻标题不能为空'
	                }, {
	                	fieldLabel: '所属栏目',
	                	id: 'newsSectionUp',
	                    xtype: 'combo',
	                    name: 'newsSection',
	                    forceSelection: true,
	        			editable: false,
	        			mode: 'local',
	        			triggerAction: 'all',
	                    blankText: '所属栏目不能为空',
	                    store: new Ext.data.JsonStore({
	                    	url: 'engSectionAction!queryAllSections',
							root : 'sectionsList',
							autoLoad : true,
							fields: ['sectionName']
	                    }),
	                    valueField: 'sectionName',
	                    displayField: 'sectionName'
	                }, {
	                	fieldLabel: '作者',
	                    xtype: 'textfield',
	                    id: 'newsAuthUp',
	                    name: 'engNews.newsAuthor',
	                    emptyText: '输入作者',
	                    disabled: true
	                    //blankText: '新闻作者不能为空'
	                }, {
	                	xtype: 'fieldset',
	                    title: '公告',
	                    id: 'noticeUp',
	                    checkboxToggle: true,
	                    collapsed: true,
	        
	                    listeners: {
	                		expand : function() {
	                			noticeState = 1;
	                		},
	                		collapse: function() {
	                			noticeState = 0;
	                		}
	                    }
	                },{
	                	xtype: 'fieldset',
	                	id: 'picSetUp',
	                    title: '图片新闻',
	                    checkboxToggle: true,
	                    style : 'font=size:15px',
	                    collapsed: true,
	                    listeners: {
	                		expand : function() {
	                			picnewsState = 1;
	                		},
	                		collapse: function() {
	                			picnewsState = 0;
	                		}
	                    },
	                    items: [{
	                    	xtype: 'label',
	                    	id: 'picInfoUp'
	                    
	                    }]
	                }, {
	                	xtype: 'fieldset',
	                    title: '附件',
	                    id: 'attachSetUp',
	                    checkboxToggle: true,
	                    collapsed: true,
	                    listeners: {
	                		expand : function() {
	                			attachState = 1;
	                		},
	                		collapse: function() {
	                			attachState = 0;
	                		}
	                    },
	                    items: [{
	                    	xtype: 'label',
	                    	id: 'attachInfoUp'
	                    	
	                    }]
	                }, {
	                	hideLabel: true,
	                	anchor: '94%',
	                	name: 'news.newsContent',
	                    id: 'newsContentUp',
	                    xtype: 'textarea',
	                    height: 350
	                }],
	                listeners: {
		            	'render' : function(){
			                KE.show({
			                    id:'newsContentUp',
			                    imageUploadJson: '../../jsp/upload_json.jsp',
			                    fileManagerJson: '../../jsp/file_manager_json.jsp'
			                });
			                setTimeout("KE.create('newsContentUp');", 100);
			            }
					}
				}]
			});
			newsWinU.show();
			winLoad();
		
	}



	function isPicNewsF() {
		//var pfC = Ext.getCmp('picform').getComponent('newsPic');
		var fileUpload = Ext.getCmp('picInfo').text;

		if((fileUpload != "") && (picnewsState == 1)) {
			isPicNews =  1;
	
		}
		else if((fileUpload == "") && (picnewsState == 1)) {
			alertMsg = alertMsg + " 勾选图片新闻后，没有选择需要上传的图片";
		}
		else {

		}
		
		

	}

	function isPicNewsFUp() {
		//var pfuC = Ext.getCmp('picformUp').getComponent('newsPic');
		var fileUpload = Ext.getCmp('picInfoUp').text;
		//alert(Ext.getCmp('picformUp').getComponent('newsPic').getValue());
		if((fileUpload != "") && (picnewsState == 1)) {
			isPicNews =  1;
		
		}
		else if((fileUpload == "") && (picnewsState == 1)) {
			alertMsg = alertMsg + " 勾选图片新闻后，没有选择需要上传的图片";
		}
		else {
			isPicNews =  0;                                                     //change 2011.11.19
		}
	}

	function isNoticeF() {
	

		if(noticeState == 1)
			isNotice =  1;
	
	}

	function isNoticeFUp() {

		if(noticeState == 1)
			isNotice =  1;
	
	}
	function isPicUp() {
		var picUpload = Ext.getCmp('picUp').getComponent('gp').getStore().getAt(0);
		if(picUpload) {
			picUp = 1;
		}
	}
	function isAttachUp() {
		var attachUpload = Ext.getCmp('attachUp').getComponent('gp').getStore().getAt(0);
		if(attachUpload) {
			attachUp = 1;
		}
	}

	function isAttachUpUp() {
		var attachUpload = Ext.getCmp('attachUpUp').getComponent('gp').getStore().getAt(0);
		if(attachUpload) {
			attachUp = 1;
		}
	}
	function showPic() {
		var aStore = Ext.getCmp('picUp').getComponent('gp').getStore();
		var picInfo = Ext.getCmp('picInfo');
		var picSet = Ext.getCmp('picSet');
		var PRBtn = Ext.getCmp('PRBtn');
		var count = aStore.getCount();
		picPath = "";
	
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);
			if(i==0){
				picPath = picPath + rec.data.name + ',';
				picPath_dt = '' + picPath_dt + "1" + ',';
			}
		
		}
		picPath = picPath.substring(0, picPath.length - 1);
		picPath_dt = picPath_dt.substring(0, picPath_dt.length - 1);
		picInfo.setText(picPath);

		if(count != 0) {
			picSet.remove(PRBtn,false);
			PRBtn.setVisible(false);
			picSet.doLayout();
	
		}
	}
	function showAllAttach() {
		var aStore = Ext.getCmp('attachUp').getComponent('gp').getStore();
		var attachInfo = Ext.getCmp('attachInfo');
		var attachSet = Ext.getCmp('attachSet');
		var ARBtn = Ext.getCmp('ARBtn');
		var count = aStore.getCount();
		attachPath = "";

		
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);

			attachPath = attachPath + rec.data.name + ',';
			savePath_dt = '' + savePath_dt + "1" + ',';
		}
		attachPath = attachPath.substring(0, attachPath.length - 1);
		savePath_dt = savePath_dt.substring(0, savePath_dt.length - 1);
		attachInfo.setText(attachPath);
		if(count != 0) {
			attachSet.remove(ARBtn,false);
			ARBtn.setVisible(false);
			attachSet.doLayout();

		}
	}


	function isAttachF() {
		if(attachPathT != null) {
			var array = attachPathT.split(",");
			var attachInfo = Ext.getCmp('attachInfo');
			if(array.length == 0) {
				var state = 0;
			}
			else{
				state = 1;
			}

			if((attachUp == 1 || state == 1) && (attachState == 1)) {
				isAttach =  1;
			}
			else if((attachUp == 0) && (attachState == 1)) {
				alertMsg = alertMsg + " 勾选附件后，没有选择附件";
			}
			else {

			}
		}
	}
	function isAttachFUp() {
		if(attachPathT != null) {
			var array = attachPathT.split(",");
			var attachInfo = Ext.getCmp('attachInfoUp');
			if(array.length == 0) {
				var state = 0;
			}
			else{
				state = 1;
			}

			if((attachUp == 1 || state == 1) && (attachState == 1)) {
				isAttach =  1;
			}
			else if((attachUp == 0) && (attachState == 1)) {
				alertMsg = alertMsg + " 勾选附件后，没有选择附件";
			}
			else {

			}
		}
	}



	function loadValid() {
		var nt = Ext.getCmp('newsTitle').isValid();
		var na = Ext.getCmp('newsAuth').isValid();
		var ec = Ext.getCmp('section').isValid();
		var ke = KE.isEmpty('newsContent');
		if(ke) {
			Ext.Msg.alert('信息','新闻内容不能为空');
			return false;
		}
		else if(nt && na && ec && !ke) {
			return true;
		}
		else {
			return false;
		}
	}

	function loadUpValid() {
		var ntu = Ext.getCmp('newsTitleUp').isValid();
		var nau = Ext.getCmp('newsAuthUp').isValid();
		var ecu = Ext.getCmp('newsSectionUp').isValid();
		var keu = KE.isEmpty('newsContentUp');
		if(keu) {
			Ext.Msg.alert('信息','新闻内容不能为空');
			return false;
		}
		else if(ntu && nau && ecu && !keu) {
			return true;
		}
		else {
			return false;
		}
	}

	function winSet() {
		Ext.getCmp('addNews-form').getForm().reset();	
		Ext.getCmp('picSet').collapse(false);
		Ext.getCmp('notice').collapse(false);
		Ext.getCmp('attachSet').collapse(false);
		Ext.getCmp('attachInfo').setText("");
		Ext.getCmp('picInfo').setText("");
		KE.html('newsContent','');
		
	}
	
	function winLoad() {
		var updateForm = Ext.getCmp('updateNews-form').getForm();
		var engGrid = Ext.getCmp('engCtrl-grid');
		var sm = engGrid.getSelectionModel();
		var store = Ext.getCmp('engCtrl-grid').getStore();
		var record = sm.getSelected();
		if(updateForm) {
			Ext.lib.Ajax.request(
				'post',
				'engNewsAction!queryNews',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						newsIdT = data.engNews.newsId;
						var newsTitleT = data.engNews.newsTitle;
						var newsSectionT = data.engNews.engSection.sectionName;
						var newsAuthorT = data.engNews.newsAuthor;
						var isPicNewsT = data.engNews.isPicNews;
						var isNoticeT = data.engNews.isNotice;
						var isAttachT = data.engNews.isAttach;
						var newsContent = data.engNews.newsContent;
		
						var picPathT = data.engNews.picPath;
						attachPathT = data.engNews.attachPath;
						Ext.getCmp('newsTitleUp').setValue(newsTitleT);
						Ext.getCmp('newsSectionUp').setValue(newsSectionT);
						Ext.getCmp('newsAuthUp').setValue(newsAuthorT);
						KE.html('newsContentUp', newsContent);
						//Ext.getCmp('newsContentUp').setValue(newsContent);
						if(isNoticeT == 1) {
							Ext.getCmp('noticeUp').expand();

						}
						if(isPicNewsT == 1) {
							Ext.getCmp('picSetUp').expand();
							Ext.getCmp('picInfoUp').setText(picPathT);					
						}
						if(isAttachT == 1) {
							Ext.getCmp('attachSetUp').expand();
							Ext.getCmp('attachInfoUp').setText(attachPathT);	
						}
					},
					failure: function() {
						Ext.Msg.alert('失败','初始化数据失败');
					}
				},
				'newsId=' + encodeURIComponent(record.data.newsId)
			);
		}
	}


	function gainDate() {
		var today = new Date();
		var date = today.getDate();
		var month = today.getMonth() + 1;
		var year = today.getYear();
		var hour = today.getHours();
		var min = today.getMinutes();
		var sec = today.getSeconds();
		savePath_dt = ''+year + month + date + hour + min + sec;
		return savePath_dt;
	}
});