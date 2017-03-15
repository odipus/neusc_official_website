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
var newsWinUp;
var status = 0;



if (window.innerHeight)
	var winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
	var winHeight = document.body.clientHeight;
var h = Math.round((winHeight-106)/20);

Ext.onReady(function() {
	var themeCssS = parent.themeCf;
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
					        name: 'newsStatus',
					        mapping: 'newsStatus'
					    }, {
					        name: 'isPicNews',
					        mapping: 'isPicNews'
					    }, {
					    	name: 'picPath',
					    	mapping: 'picPath'
					    }, {
					        name: 'isNotice',
					        mapping: 'isNotice'
					    },{
					    	name: 'isAttach',
					        mapping: 'isAttach'
					    }, {
					    	name: 'attachPath',
					    	mapping: 'attachPath'
					    }, {
					    	name: 'chnNews',
					    	mapping: 'chnNews'
					    }]
                    }),
                    baseParams:{
                    	start:start,
                    	limit:limit
                    },
                    url: 'engNewsAction!queryNewsTrans',
                    autoLoad: true
                })
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/xtheme-blue.css');
	Ext.QuickTips.init();
	Ext.ux.transCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
			this.items = [{
                xtype: 'grid',
                id: 'transCtrl-grid',
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
		            	var newsManage = Ext.getCmp('transCtrl-grid');
		        
		        		var transBtn = Ext.getCmp('transNews');
		        		var updateBtn = Ext.getCmp('updateNews');
		        		transBtn.setDisabled(false);	
		        		updateBtn.setDisabled(false);
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
				    width: 80
				}, {
					header: '对应中文新闻',
				    dataIndex: 'chnNews',
				    sortable: true,
				    width: 80
				}])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [ {
                    text: '翻译新闻',
                    iconCls: 'update',
                    handler: transNews,
                    id: 'transNews',
                    disabled: true
                    }, {
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
			Ext.ux.transCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('transCtrl', Ext.ux.transCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'transCtrl',
			region:'center'
		}]
	}).show();


	function transNews() {
 
		if(newsWin != null) {
			winSet();
			winLoad();
			newsWin.show();
		}
		else{
	        var nav = new Ext.Panel({
	            title: '中文',
	            region: 'west',
	            split: true,
	            width: 350,
	            collapsible: false,
	            margins:'3 0 3 3',
	            cmargins:'3 3 3 3',
	            autoScroll: true,
	        	items: [{
					xtype: 'form',
				    id: 'chnNews-form',
				    layout: 'form',
				    frame: true,
				    bodyPadding: '10 10',
				    autoScroll: true,
				    defaults: {
				        anchor: '93%',
				        msgTarget: 'side',
				        disabled:'ture' 
				    },
			        items: [{
			        	xtype: 'textfield',
			        	fieldLabel:"标题",
			        	id: 'newsTitleChn'
	        
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"作者",
			        	id: 'newsAuthChn'
	      
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"图片地址",
			        	id: 'newsPicChn'
		        
			        },{
			        	xtype:'textfield',
			        	fieldLabel:"附件地址",
			        	id: 'newsAttachChn'
		        
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"对应中文新闻",
			        	id: 'chnNewsChn',
	    
			        },{
			        	xtype: 'textarea',
			        	fieldLabel:"新闻内容",
			        	id: 'newsContentChn',
			        	height:300
	      
			        }]
	        	}]
	        });
	        
	        var tra = new Ext.Panel({
	        	title:'翻译',
	            region: 'center',
	            margins:'3 3 3 0', 
	            defaults:{autoScroll:true},

	        	items: [{
							xtype: 'form',
						    id: 'transNews-form',
						    layout: 'form',
						    frame: true,
						    bodyPadding: '10 10',
						    autoScroll: true,
						    defaults: {
						        anchor: '95%',
						        msgTarget: 'side',
						        allowBlank: false
						    },
						    items: [{
						    	fieldLabel: '新闻标题',
						    	id: 'newsTitleTrans',
						        xtype: 'textfield',
						        name: 'engNews.newsTitle',
						        emptyText: '输入新闻标题',
						        blankText: '新闻标题不能为空'
			
						        	
						    }, {
						    	fieldLabel: '所属栏目',
						    	id: 'newsSectionTrans',
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
						        id: 'newsAuthTrans',
						        name: 'engNews.newsAuthor',
						        value: showName,
						        disabled: true
						        
						    }, {
						    	xtype: 'fieldset',
						        title: '公告',
						        id: 'noticeTrans',
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
						    	id: 'picSetTrans',
						        title: '图片新闻(选取后将引用原中文新闻图片)',
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
						        }
						    }, {
						    	xtype: 'fieldset',
						        title: '附件(选取后将引用原中文新闻附件)',
						        id: 'attachSetTrans',
						        checkboxToggle: true,
						        collapsed: true,
						        listeners: {
						    		expand : function() {
						    			attachState = 1;
						    		},
						    		collapse: function() {
						    			attachState = 0;
						    		}
						        }
						    }, {
						    	hideLabel: true,
						    	anchor: '100%',
						    	name: 'engNews.newsContent',
						        id: 'newsContentTrans',
						        xtype: 'textarea',
						        height: 190
						    }],
						    listeners: {
						    	'render' : function(){
						            KE.show({
						                id:'newsContentTrans',
						                imageUploadJson: '../../jsp/upload_json.jsp',
						                fileManagerJson: '../../jsp/file_manager_json.jsp'
						            });
						            setTimeout("KE.create('newsContentTrans');", 100);
						        }
							}
						}]
	        });
	        
			newsWin = new  Ext.Window({
				id: 'transNews-win',
				closeAction: 'hide',
		        title: '翻译新闻',
		        width: '90%',
		        height: 450,
	            plain:true,
	            layout: 'border',
		        minWidth: 660,
		        minHeight: 400,
		        closable:true,
		        border: false,
		        modal: true,
		        buttonAlign: 'center',
		        buttons: [{
					text: '确定',
					handler: function() {
						isPicNewsTrans();
	            		isNoticeTrans();
	            		isAttachTrans();
	            		var form = Ext.getCmp('transNews-form').getForm();
	            		if (loadValid() && (alertMsg == "")) {

	            			
							Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'engNewsAction!transNews',
									params:{
										'engNews.newsId': newsIdT,
			                        	'engNews.newsTitle': Ext.getCmp('newsTitleTrans').getValue(),
										'newsSection': Ext.getCmp('newsSectionTrans').getValue(),
										'engNews.newsAuthor':Ext.getCmp('newsAuthTrans').getValue(),
		                            	'engNews.isNotice': isNotice,	
		                            	'engNews.isPicNews':isPicNews,
		                            	'engNews.isAttach':isAttach,
		                            	'engNews.picPath':Ext.getCmp('newsPicChn').getValue(),
							            'engNews.attachPath':Ext.getCmp('newsAttachChn').getValue(),
		                            	'engNews.newsContent': KE.html('newsContentTrans'),
		                            	'engNews.chnNews': Ext.getCmp('chnNewsChn').getValue()

			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '翻译成功');
			                            newsWin.hide();
			                            Ext.getCmp('transCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '翻译失败');
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
		        }, {
					text: '取消',
					handler: function() {
						newsWin.hide();
					}
		        }],
		        items: [nav,tra]
			});
			newsWin.show();
			winLoad();
	}
		
	}


	function updateNews() {
		 
		if(newsWinUp != null) {
			winSetUp();
			winLoadUp();
			newsWinUp.show();
		}
		else{
	        var nav = new Ext.Panel({
	            title: '中文',
	            region: 'west',
	            split: true,
	            width: 350,
	            collapsible: false,
	            margins:'3 0 3 3',
	            cmargins:'3 3 3 3',
	            autoScroll: true,
	        	items: [{
					xtype: 'form',
				    id: 'chnNewsUp-form',
				    layout: 'form',
				    frame: true,
				    bodyPadding: '10 10',
				    autoScroll: true,
				    defaults: {
				        anchor: '93%',
				        msgTarget: 'side',
				        disabled:'ture' 
				    },
			        items: [{
			        	xtype: 'textfield',
			        	fieldLabel:"标题",
			        	id: 'newsTitleChnUp'
	        
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"所属栏目",
			        	id: 'newsSectionChnUp'

			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"作者",
			        	id: 'newsAuthChnUp'
	      
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"图片地址",
			        	id: 'newsPicChnUp'
		        
			        },{
			        	xtype:'textfield',
			        	fieldLabel:"附件地址",
			        	id: 'newsAttachChnUp'
		        
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"对应中文新闻",
			        	id: 'chnNewsChnUp',
	    
			        },{
			        	xtype: 'textarea',
			        	fieldLabel:"新闻内容",
			        	id: 'newsContentChnUp',
			        	height:300
	      
			        }]
	        	}]
	        });
	        
	        var tra = new Ext.Panel({
	        	title:'翻译',
	            region: 'center',
	            margins:'3 3 3 0', 
	            defaults:{autoScroll:true},

	        	items: [{
							xtype: 'form',
						    id: 'updateNews-form',
						    layout: 'form',
						    frame: true,
						    bodyPadding: '10 10',
						    autoScroll: true,
						    defaults: {
						        anchor: '95%',
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
						        value: showName,
						        disabled: true
						        
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
						        title: '图片新闻(选取后将引用原中文新闻图片)',
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
						        }
						    }, {
						    	xtype: 'fieldset',
						        title: '附件(选取后将引用原中文新闻附件)',
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
						        }
						    }, {
						    	hideLabel: true,
						    	anchor: '100%',
						    	name: 'engNews.newsContent',
						        id: 'newsContentUp',
						        xtype: 'textarea',
						        height: 190
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
	        
			newsWinUp = new  Ext.Window({
				id: 'updateNews-win',
				closeAction: 'hide',
		        title: '翻译新闻',
		        width: '90%',
		        height: 450,
	            plain:true,
	            layout: 'border',
		        minWidth: 660,
		        minHeight: 400,
		        closable:true,
		        border: false,
		        modal: true,
		        buttonAlign: 'center',
		        buttons: [{
					text: '确定',
					handler: function() {
						isPicNewsTrans();
	            		isNoticeTrans();
	            		isAttachTrans();
	            		var form = Ext.getCmp('updateNews-form').getForm();
	            		if (loadUpValid() && (alertMsg == "")) {

	            			
							Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'engNewsAction!transNews',
									params:{
										'engNews.newsId': newsIdUp,
			                        	'engNews.newsTitle': Ext.getCmp('newsTitleUp').getValue(),
										'newsSection': Ext.getCmp('newsSectionUp').getValue(),
										'engNews.newsAuthor':Ext.getCmp('newsAuthUp').getValue(),
		                            	'engNews.isNotice': isNotice,	
		                            	'engNews.isPicNews':isPicNews,
		                            	'engNews.isAttach':isAttach,
		                            	'engNews.picPath':Ext.getCmp('newsPicChnUp').getValue(),
							            'engNews.attachPath':Ext.getCmp('newsAttachChnUp').getValue(),
		                            	'engNews.newsContent': KE.html('newsContentUp'),
		                            	'engNews.chnNews': Ext.getCmp('chnNewsChnUp').getValue()

			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '翻译成功');
			                            newsWinUp.hide();
			                            Ext.getCmp('transCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '翻译失败');
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
						newsWinUp.hide();
					}
		        }],
		        items: [nav,tra]
			});
			newsWinUp.show();
			winLoadUp();
	}
		
	}




	function isPicNewsTrans() {
	
	
	
		if(picnewsState == 1) {
			isPicNews =  1;
		
		}
		else {
			isPicNews =  0;                                                     //change 2011.11.19
		}
	}



	function isNoticeTrans() {
		if( noticeState == 1) 
			isNotice =  1;

	}


	function isAttachTrans() {
			if(attachState == 1) {
				isAttach =  1;
			}	
			else {
				isAttach = 0;
			}	
	}



	function loadValid() {
		var ntu = Ext.getCmp('newsTitleTrans').isValid();
		var nau = Ext.getCmp('newsAuthTrans').isValid();
		var ecu = Ext.getCmp('newsSectionTrans').isValid();
		var keu = KE.isEmpty('newsContentTrans');
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
		Ext.getCmp('transNews-form').getForm().reset();	
		Ext.getCmp('chnNews-form').getForm().reset();	
		Ext.getCmp('picSetTrans').collapse(false);
		Ext.getCmp('noticeTrans').collapse(false);
		Ext.getCmp('attachSetTrans').collapse(false);
		KE.html('newsContentTrans','');
		
	}
	
	function winSetUp() {
		Ext.getCmp('updateNews-form').getForm().reset();	
		Ext.getCmp('chnNewsUp-form').getForm().reset();	
		Ext.getCmp('picSetUp').collapse(false);
		Ext.getCmp('noticeUp').collapse(false);
		Ext.getCmp('attachSetUp').collapse(false);
		KE.html('newsContentUp','');
		
	}
	
	function winLoad() {
		var transForm = Ext.getCmp('chnNews-form').getForm();
		var newsGrid = Ext.getCmp('transCtrl-grid');
		var sm = newsGrid.getSelectionModel();
		var store = Ext.getCmp('transCtrl-grid').getStore();
		var record = sm.getSelected();


		if(transForm) {
			Ext.lib.Ajax.request(
				'post',
				'engNewsAction!queryNews',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						newsIdT = data.engNews.newsId;
						status = data.engNews.newsStatus;
						var newsTitleT = data.engNews.newsTitle;
						var newsSectionT = data.engNews.engSection.sectionName;
						var newsAuthorT = data.engNews.newsAuthor;
						var isPicNewsT = data.engNews.isPicNews;
						var isNoticeT = data.engNews.isNotice;
						var isAttachT = data.engNews.isAttach;
						var newsContentT = data.engNews.newsContent;
						var picPathT = data.engNews.picPath;
						var chnNewsT = data.engNews.chnNews;
						attachPathT = data.engNews.attachPath;

						Ext.getCmp('newsTitleChn').setValue(newsTitleT);
						Ext.getCmp('newsAuthChn').setValue(newsAuthorT);
						Ext.getCmp('newsContentChn').setValue(newsContentT);
			
						Ext.getCmp('newsPicChn').setValue(picPathT);					
						Ext.getCmp('newsAttachChn').setValue(attachPathT);	
						Ext.getCmp('chnNewsChn').setValue(chnNewsT);	
	                    if(status != 0){
	                    	newsWin.hide();
							Ext.Msg.alert('提示','该新闻已翻译'+status);
							
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

	function winLoadUp() {
		var updateForm = Ext.getCmp('chnNewsUp-form').getForm();
		var newsGrid = Ext.getCmp('transCtrl-grid');
		var sm = newsGrid.getSelectionModel();
		var store = Ext.getCmp('transCtrl-grid').getStore();
		var record = sm.getSelected();
		var chnNewsUp = 0;

		if(updateForm) {
			Ext.lib.Ajax.request(
				'post',
				'engNewsAction!queryNews',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						newsIdUp = data.engNews.newsId;
						status = data.engNews.newsStatus;
						var newsTitleT = data.engNews.newsTitle;
						var newsSectionT = data.engNews.engSection.sectionName;
						var newsAuthorT = data.engNews.newsAuthor;
						var isPicNewsT = data.engNews.isPicNews;
						var isNoticeT = data.engNews.isNotice;
						var isAttachT = data.engNews.isAttach;
						var newsContent = data.engNews.newsContent;
						var picPathT = data.engNews.picPath;
						chnNewsUp = data.engNews.chnNews;
						attachPathT = data.engNews.attachPath;
						Ext.getCmp('newsTitleUp').setValue(newsTitleT);
						Ext.getCmp('newsSectionUp').setValue(newsSectionT);
						Ext.getCmp('newsAuthUp').setValue(newsAuthorT);
						KE.html('newsContentUp', newsContent);
						Ext.getCmp('chnNewsChnUp').setValue(chnNewsUp);	
						if(isNoticeT == 1) {
							Ext.getCmp('noticeUp').expand();						
						}
						if(isPicNewsT == 1) {
							Ext.getCmp('picSetUp').expand();							
						}
						if(isAttachT == 1) {
							Ext.getCmp('attachSetUp').expand();
						}
					
						if(status == 0){
							newsWinUp.hide();
							Ext.Msg.alert('提示','请先翻译该新闻'+status);
							
						}
						Ext.lib.Ajax.request(
								'post',
								'newsAction!queryNews',
								{
									success: function(response) {
										var data = Ext.decode(response.responseText);
										
										var newsTitle = data.news.newsTitle;
										var newsSection = data.news.section.sectionName;
										var newsAuthor = data.news.newsAuthor;
										var newsContent = data.news.newsContent;
										var picPath = data.news.picPath;
										var attachPath = data.news.attachPath;
										Ext.getCmp('newsTitleChnUp').setValue(newsTitle);
										Ext.getCmp('newsSectionChnUp').setValue(newsSection);
										Ext.getCmp('newsAuthChnUp').setValue(newsAuthor);
										Ext.getCmp('newsPicChnUp').setValue(picPath);
										Ext.getCmp('newsAttachChnUp').setValue(attachPath);
										Ext.getCmp('newsContentChnUp').setValue(newsContent);	
									
									},
									failure: function() {
										Ext.Msg.alert('失败','初始化数据失败');
									}
								},
								'newsId=' + encodeURIComponent(chnNewsUp)

							);
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