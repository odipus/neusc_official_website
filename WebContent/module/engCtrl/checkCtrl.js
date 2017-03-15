/**
 *
 */



var newsIdT = 0;
var alertMsg = "";
var start = 0;
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
					    }, {
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
                    url: 'engNewsAction!queryNewsUndetermined',
                    autoLoad: true
                })
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/xtheme-blue.css');
	Ext.QuickTips.init();
	Ext.ux.checkCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
			this.items = [{
                xtype: 'grid',
                id: 'checkCtrl-grid',
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
		            	var newsManage = Ext.getCmp('checkCtrl-grid');
		        
		        		var checkBtn = Ext.getCmp('checkNews');

		        		checkBtn.setDisabled(false);

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
				},  {
					header: '是否有附件',
				    dataIndex: 'isAttach',
				    sortable: true,
				    width: 60
				}, {
					header: '附件地址',
				    dataIndex: 'attachPath',
				    sortable: true,
				    width: 100
				}, {
					header: '对应中文新闻',
				    dataIndex: 'chnNews',
				    renderer : function(value)
				    {
				    	if(value==0)
				    		return "无";
				    	else 
				    		return "有";
				    	
				    },
				    sortable: true,
				    width: 100
				}])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '审查新闻',
                    iconCls: 'update',
                    handler: checkNews,
                    id:'checkNews'
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
			Ext.ux.checkCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('checkCtrl', Ext.ux.checkCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'checkCtrl',
			region:'center'
		}]
	}).show();



	function checkNews() {

		if(newsWinU != null) {
			winSet();
			winLoad();
			newsWinU.show();
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
			        	fieldLabel:"所属栏目",
			        	id: 'newsSectionChn'
	
			        },{
			        	xtype: 'textfield',
			        	fieldLabel:"作者",
			        	id: 'newsAuthChn'
	      
			        },{
			        	xtype: 'textarea',
			        	fieldLabel:"新闻内容",
			        	id: 'newsContentChn',
			        	height:255
	      
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
						    	hideLabel: true,
						    	anchor: '99%',
						    	name: 'engNews.newsContent',
						        id: 'newsContentUp',
						        xtype: 'textarea',
						        height: 270
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
				newsWinU = new  Ext.Window({
					id: 'checkNews-win',
					closeAction: 'hide',
			        title: '审查新闻',
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
						text: '审查通过，发布新闻',
						handler: function() {
	
		            		var form = Ext.getCmp('updateNews-form').getForm();
		            		if (loadUpValid() && (alertMsg == "")) {
	
		            			
								Ext.Ajax.request({
				                    	waitMsg: '正在添加',
										url: 'engNewsAction!checkNews',
										params:{
											'engNews.newsId': newsIdT,
				                        	'engNews.newsTitle': Ext.getCmp('newsTitleUp').getValue(),
											'newsSection': Ext.getCmp('newsSectionUp').getValue(),		                                    
			                            	'engNews.newsContent': KE.html('newsContentUp'),
			                            	
				                        },
										success: function(form, action){
				                            Ext.Msg.alert('信息', '更新成功');
				                            newsWinU.hide();
				                            Ext.getCmp('checkCtrl-grid').getStore().reload();
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
			        },  {
						text: '取消',
						handler: function() {
							newsWinU.hide();
						}
			        }],
			        items: [nav,tra]
				});
				newsWinU.show();
				winLoad();
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
		Ext.getCmp('updateNews-form').getForm().reset();	
		Ext.getCmp('chnNews-form').getForm().reset();	
		
		KE.html('newsContentUp','');
	}

	
	function winLoad() {
		var updateForm = Ext.getCmp('updateNews-form').getForm();
		var newsGrid = Ext.getCmp('checkCtrl-grid');
		var sm = newsGrid.getSelectionModel();
		var store = Ext.getCmp('checkCtrl-grid').getStore();
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
						var newsContent = data.engNews.newsContent;
						var chnNews = data.engNews.chnNews;
						Ext.getCmp('newsTitleUp').setValue(newsTitleT);
						Ext.getCmp('newsSectionUp').setValue(newsSectionT);
						Ext.getCmp('newsAuthUp').setValue(newsAuthorT);
						KE.html('newsContentUp', newsContent);
						if(chnNews != 0){
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
											Ext.getCmp('newsTitleChn').setValue(newsTitle);
											Ext.getCmp('newsSectionChn').setValue(newsSection);
											Ext.getCmp('newsAuthChn').setValue(newsAuthor);								
											Ext.getCmp('newsContentChn').setValue(newsContent);	
										},
										failure: function() {
											Ext.Msg.alert('失败','初始化数据失败');
										}
									},
									'newsId=' + encodeURIComponent(chnNews)

								);
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



});