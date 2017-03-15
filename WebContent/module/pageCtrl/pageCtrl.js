/**
 *
 */

var addPageWin;
var addPageWinU;


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
                        root: 'pageList',
                        totalProperty:'totalProperty',
                        fields: [{
                            name: 'pageTitle',
                            mapping: 'pageTitle'
                        }, {
                        	name: 'pageId',
                            mapping: 'pageId'
                        }, {
                        	name: 'pageContent',
                        	mapping: 'pageContent'
                        },]
                    }),
                    baseParams:{
                    	upperPage:parent.upperId,
                    },
                    url: 'pageAction!queryPagesByUpperPage',
                    autoLoad: true
                })
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();
	Ext.ux.pageCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
			this.items = [{
                xtype: 'grid',
                id: 'pageCtrl-grid',
                autoHeight: true,
                //stripeRows: true,
                //autoScroll:true,
                //layout: 'fit',
                //unstyled: true,
                viewConfig: {
                    forceFit: true
                },
                listeners: {
                	'rowclick' : function rowclick(){
		            	var pageManage = Ext.getCmp('pageCtrl-grid');
		        		var removeBtn = Ext.getCmp('removePage');
		        		var updateBtn = Ext.getCmp('updatePage');
		        		var publishBtn = Ext.getCmp('publishPage');
		        		removeBtn.setDisabled(false);
		        		updateBtn.setDisabled(false);
		        		/*publishBtn.setDisabled(false);*/
		        		pageManage.removeListener('rowclick',rowclick);
                	}
                },
                ds: pageStore,

                cm: new Ext.grid.ColumnModel([
				/*
                new Ext.grid.RowNumberer({
                	renderer:function(value,metadata,record,rowIndex){
                		return　record_start + 1 + rowIndex;
                	}
    			}),*/
    			{
                    header: '页面ID',
                    dataIndex: 'pageId',
                    sortable: true,
                    width: 100
                }, {
				    header: '页面标题',
				    dataIndex: 'pageTitle',
				    width: 180,
				    sortable: true
				}])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加页面',
                    iconCls: 'add',
                    handler: addPage
                }, '-', {
                    text: '删除页面',
                    iconCls: 'remove',
                    handler: deletePage,
                    id: 'removePage',
                    disabled: true
                }, '-', {
                    text: '修改页面',
                    iconCls: 'update',
                    handler: updatePage,
                    id: 'updatePage',
                    disabled: true
                }]
            };
            this.bbar = {
            	
           	};
			Ext.ux.pageCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('pageCtrl', Ext.ux.pageCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'pageCtrl',
			region:'center'
		}]
	}).show();


	function addPage() {

		if(addPageWin != null) {
			winReset();
			addPageWin.show();
		}
		else {
			addPageWin = new Ext.Window({
				id: 'addPage-win',
	            title: '添加页面',
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

	            	
	            		
	            		var form = Ext.getCmp('addPage-form').getForm();
	                   
	                   	if (loadValid()) {
	                   	
	                        Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'pageAction!addPage',
									params:{
			                        	'page.pageTitle': Ext.getCmp('pageTitle').getValue(),
		                            	'page.pageContent': KE.html('pageContent'),
		                            	'page.upperPage':parent.upperId,
			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '添加成功');
			                            addPageWin.hide();
			                            Ext.getCmp('pageCtrl-grid').getStore().reload();
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
	            		addPageWin.hide();
	            	}
	            }],
	            items: [{
	            	xtype: 'form',
	                id: 'addPage-form',
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
	                	fieldLabel: '页面标题',
	                	id: 'pageTitle',
	                    xtype: 'textfield',
	                    name: 'page.pageTitle',
	                    emptyText: '输入新闻标题',
	                    blankText: '新闻标题不能为空'
	                }, {

	                	fieldLabel: '页面内容',
	                	anchor: '94%',
	                	name: 'page.pageContent',
	                    id: 'pageContent',
	                    xtype: 'textarea',
	              
	                    height: 350
			
	                }],
	                listeners:{
			            'render':function(){
			                KE.show({
			                    id:'pageContent',
			                    imageUploadJson: '../../jsp/upload_json.jsp',
			                    fileManagerJson: '../../jsp/file_manager_json.jsp',
						
			                });
			                setTimeout("KE.create('pageContent');", 1000);

			            }
			    	}
	            }]
			}).show();
		}

	}
	


	function deletePage() {
		Ext.Msg.confirm('信息', '确定删除页面？' ,
			function(btn){
				if(btn == 'yes') {
					var pageGrid = Ext.getCmp('pageCtrl-grid');
					var sm = pageGrid.getSelectionModel();
					var store = Ext.getCmp('pageCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					
					
					Ext.lib.Ajax.request(
            			'POST',
            			'pageAction!deletePage',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','新闻删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'pageId='+encodeURIComponent(record.data.pageId)
        			);
				}
			});
	}
	
	function updatePage() {
		if(addPageWinU != null) {
			winUpset();
			winLoad()
			addPageWinU.show();
		}
		else {
			addPageWinU = new  Ext.Window({
				id: 'updatePage-win',
				closeAction: 'hide',
		        title: '修改页面',
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
					
	            		var form = Ext.getCmp('updatePage-form').getForm();
	            	
							Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'pageAction!updatePage',
									params:{
										'page.pageId': pageIdT,
			                        	'page.pageTitle': Ext.getCmp('pageTitleUp').getValue(),					                            
		                            	'page.pageContent': KE.html('pageContentUp'),
		                            	'page.upperPage':parent.upperId,
	             
			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '更新成功');
			                      
			                            addPageWinU.hide();
			                            Ext.getCmp('pageCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '更新失败');
			                        }
								});
	                    }
	                   
					
		        },  {
					text: '取消',
					handler: function() {
						addPageWinU.hide();
					}
		        }],
		        items: [{
	            	xtype: 'form',
	                id: 'updatePage-form',
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
	                	fieldLabel: '页面标题',
	                	id: 'pageTitleUp',
	                    xtype: 'textfield',
	                    name: 'page.pageTitle',
	                    emptyText: '输入标题',
	                    blankText: '页面标题不能为空'
	                }, {
	                	fieldLabel: '页面内容',
	                	anchor: '94%',
	                	name: 'page.pageContent',
	                    id: 'pageContentUp',
	                    xtype: 'textarea',
	                    height: 350
	                }],
	                listeners: {
		            	'render' : function(){
			                KE.show({
			                    id:'pageContentUp',
			                    imageUploadJson: '../../jsp/upload_json.jsp',
			                    fileManagerJson: '../../jsp/file_manager_json.jsp'
			                });
			                setTimeout("KE.create('pageContentUp');", 100);
			            }
					}
				}]
			}).show();
			winLoad();
		}
	}



	function loadValid() {
		var nt = Ext.getCmp('pageTitle').isValid();

		var ke = KE.isEmpty('pageContent');
		if(ke) {
			Ext.Msg.alert('信息','页面内容不能为空');
			return false;
		}
		
		else {
			return true;
		}
	}

	function loadUpValid() {
		var ntu = Ext.getCmp('pageTitleUp').isValid();
		var keu = KE.isEmpty('pageContentUp');
		if(keu) {
			Ext.Msg.alert('信息','页面内容不能为空');
			return false;
		}
		
		else {
			return false;
		}
	}

	function winReset() {
		Ext.getCmp('addPage-form').getForm().reset();

		KE.html('pageContent','');
	}

	function winLoad() {
		var updateForm = Ext.getCmp('updatePage-form').getForm();
		var pageGrid = Ext.getCmp('pageCtrl-grid');
		var sm = pageGrid.getSelectionModel();
		var store = Ext.getCmp('pageCtrl-grid').getStore();
		var record = sm.getSelected();
		if(updateForm) {
			Ext.lib.Ajax.request(
				'post',
				'pageAction!queryPageById',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						pageIdT = data.page.pageId;
						var pageTitleT = data.page.pageTitle;
						
						var pageContent = data.page.pageContent;
						Ext.getCmp('pageTitleUp').setValue(pageTitleT);
						KE.html('pageContentUp', pageContent);
			
					},
					failure: function() {
						Ext.Msg.alert('失败','初始化数据失败');
					}
				},
				'pageId=' + encodeURIComponent(record.data.pageId)
			);
		}
	}

	function winUpset() {
		Ext.getCmp('updatePage-form').getForm().reset();
		KE.html('pageContentUp','');
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