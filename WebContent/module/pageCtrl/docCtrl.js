
var docWin;
var docWinU;
var savePath_dt;

if (window.innerHeight)
	var winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
	var winHeight = document.body.clientHeight;
var h = Math.round((winHeight-106)/20);

Ext.onReady(function() {
	var themeCssS = parent.themeCf;

	limit = h;
	var pageStore = new Ext.data.Store({
                    reader: new Ext.data.JsonReader({
                        root: 'docList',
                        totalProperty:'totalProperty',
                        fields: [{
                        	name: 'docId',
                            mapping: 'docId'
                        }, {
                        	name: 'docName',
                        	mapping: 'docName'
                        },{
					        name: 'docDate',
					        mapping: 'docDate',
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
					    	name: 'docPath',
					    	mapping: 'docPath'
					    }]
                    }),     
                    url: 'docAction!queryAllDocs',
                    autoLoad: true
                })
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/xtheme-blue.css');
	Ext.QuickTips.init();
	Ext.ux.docCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
			this.items = [{
                xtype: 'grid',
                id: 'docCtrl-grid',
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
		            	var docManage = Ext.getCmp('docCtrl-grid');
		        
		        		var removeBtn = Ext.getCmp('removeDoc');

		      
		        		removeBtn.setDisabled(false);

		  
		        		docManage.removeListener('rowclick',rowclick);
                	}
                },
                ds: pageStore,

                cm: new Ext.grid.ColumnModel([
	
    			 {
                	header: '资料序号',
                    dataIndex: 'docId',
                    sortable: true,
                    width: 60
                }, {
                    header: '资料标题',
                    dataIndex: 'docName',
                    sortable: true
                    //width: 120
                }, {
					header: '发布时间',
				    dataIndex: 'docDate',
				    sortable: true,
				    type: 'date',
				    width: 83,
				    renderer:function(v){   
	                    if(!v){   
	                        return "";   
	                    }    
	                    v = v.replace(new RegExp("-","gm"), "/").replace("T"," ");   
	                    if(!Ext.isDate(v)){   
	                        v = new Date(Date.parse(v));    
	                    }   
	                    return v.dateFormat("Y年m月d日 H:i:s");   
	                }   
				}, {
					header: '资料路径',
				    dataIndex: 'docPath',
				    width: 90,
				    sortable: true
				}])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加资料',
                    iconCls: 'add',
                    handler: addDoc,
                    id:'addDoc'
                }, '-', {
                    text: '删除资料',
                    iconCls: 'remove',
                    handler: deleteDoc,
                    id: 'removeDoc',
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
			Ext.ux.docCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('docCtrl', Ext.ux.docCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'docCtrl',
			region:'center'
		}]
	}).show();

	function addDoc() {


	
			docWin = new Ext.Window({
				id: 'addDoc-win',
	            title: '添加资料',
	            width: '80%',
	            height: 350,
	            minWidth: 400,
	            minHeight: 300,
	            layout: 'fit',
	            border: false,
	            modal: true,
	            closeAction: 'close',
	            buttonAlign: 'center',
	            buttons: [{
	            	text: '确定',
	            	handler: function() {
  
	            		var form = Ext.getCmp('addDoc-form').getForm();	        
	                   	if (loadValid()) {
	                        
	                        Ext.Ajax.request({
			                    	waitMsg: '正在添加',
									url: 'docAction!addDoc',
									params:{
			                        	'document.docName': Ext.getCmp('docName').getValue(),
										'document.docDate': Ext.getCmp('docDate').getValue(),
		                            	'document.docPath': '/upload/documents/' + Ext.getCmp('docInfo').text
	
			                        },
									success: function(form, action){
			                            Ext.Msg.alert('信息', '添加成功');
			                            docWin.close();
			                            Ext.getCmp('docCtrl-grid').getStore().reload();
			                        },
			                        failure: function(form, action){
			                            Ext.Msg.alert('信息', '添加失败');
			                        }
								});
	                    }
	                    else if(loadValid()) {
	                 
	                    	Ext.Msg.alert('提示', alertMsg);
	                    	alertMsg = "";
	                    }
	                    else  {
	                    }

	            	}
	            },{
	            	text: '取消',
	            	handler: function() {
	            		docWin.close();
	            	}
	            }],
	            items: [{
	            	xtype: 'form',
	                id: 'addDoc-form',
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
	                	fieldLabel: '资料标题',
	                	id: 'docName',
	                    xtype: 'textfield',
	                    name: 'document.docName',
	                    emptyText: '输入资料标题',
	                    blankText: '资料标题不能为空'
	                }, {
	                	
	                        fieldLabel: '发布日期',
	                        editable: false,
	                        id: 'docDate',
	                        anchor: '80%',
	                        xtype: 'datefield',
	                        name: 'document.docDate',
	                        format: 'Y-m-dTH:i:s'
	          
	                }, {
	                	xtype: 'fieldset',
	                    title: '上传资料',
	                    id: 'docSet',
	                    buttons: [{
	                    		id: 'BRBtn',
	                    		text:'添加／删除资料',
	                    		handler: function() {
	                    			new Ext.Window({
									    width : 550,
									    title : '资料上传',
									    height : 300,
									    layout : 'fit',
									    items : [{
									            xtype : 'uploadPanel',
									            border : false,
									            id: 'docUp',
									            fileSize : 1024*3.5,//限制文件大小
									            uploadUrl : 'uploadAction!uploadAttach',
									            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
									            filePostName : 'attach', //后台接收参数
									            fileTypes : '*.jpg;*.png;*.doc;*.docx;*.xls;*.xlsx;*.pdf',//可上传文件类型
									            postParams : {savePath:'upload\\documents\\'} //上传文件存放目录
									     }],
									     listeners:{
									     	beforeclose: function() {
									     			isDocUp();
									     			showAllAttach();
									     	}
									     }
									}).show();
	                    		}
	                    }],
	                    items: [{
	                    	xtype: 'label',
	                    	id: 'docInfo',
	                    	text:''
	                    }]
	                }]
	            }]
			});
		
			docWin.show();

	}
	


	function deleteDoc() {
		Ext.Msg.confirm('信息', '确定删除资料？' ,
			function(btn){
				if(btn == 'yes') {
					var docGrid = Ext.getCmp('docCtrl-grid');
					var sm = docGrid.getSelectionModel();
					var store = Ext.getCmp('docCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'docAction!deleteDoc',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','资料删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'docArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}




	function isDocUp() {
		var docUpload = Ext.getCmp('docUp').getComponent('gp').getStore().getAt(0);
		if(docUpload) {
			docUp = 1;
		}
	}

	function showAllAttach() {
		var aStore = Ext.getCmp('docUp').getComponent('gp').getStore();
		var docInfo = Ext.getCmp('docInfo');
		var docSet = Ext.getCmp('docSet');
		var BRBtn = Ext.getCmp('BRBtn');
		var count = aStore.getCount();
		attachPath = "";

		
		for(i = 0; i < count; i++) {
			var rec = aStore.getAt(i);

			attachPath = attachPath + rec.data.name + ',';
			savePath_dt = '' + savePath_dt + "1" + ',';
		}
		attachPath = attachPath.substring(0, attachPath.length - 1);
		savePath_dt = savePath_dt.substring(0, savePath_dt.length - 1);
		docInfo.setText(attachPath);
		if(count != 0) {
			docSet.remove(BRBtn,false);
			BRBtn.setVisible(false);
			docSet.doLayout();

		}
	}




	function loadValid() {

	
			return true;
		
	
		
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