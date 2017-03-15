/**
 *
 */
if (window.innerHeight)
	var winHeight = window.innerHeight;
else if ((document.body) && (document.body.clientHeight))
	var winHeight = document.body.clientHeight;
var h = Math.round((winHeight-106)/20);

Ext.onReady(function() {
	var start = 0;
	var limit = h;
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();

	var editor = new Ext.ux.grid.RowEditor({
        saveText: '更新',
        cancelText: '取消'
    });

    var sectPageStore = new Ext.data.Store({
	    	reader: new Ext.data.JsonReader({
	    		root: 'sectionsList',
	    		totalProperty:'totalProperty',
                fields: [{
                    name: 'sectionName',
                    mapping: 'sectionName'
                }, {
                	name: 'sectionId',
                	mapping: 'sectionId'
                }, {
                	name: 'sectionCode',
                	mapping: 'sectionCode'
                }, {
                	name: 'sectionPlace',
                	mapping: 'sectionPlace'
                }, {
                	name: 'sectionOrder',
                	mapping: 'sectionOrder'
                }]
	        }),
	        baseParams:{
            	start:start,
            	limit:limit
            },
	        url: 'sectionAction!queryAllSectionsByPage',
	        autoLoad: true
	    })

    Ext.ux.sectionCtrl = Ext.extend(Ext.grid.GridPanel,{
    	id: 'sectionCtrl-grid',
    	plugins: [editor],
    	border: false,
        viewConfig: {
            forceFit: true
        },
        listeners: {
        	'rowclick' : function rowclick(){
            	var sectionManage = Ext.getCmp('sectionCtrl-grid');
        		var removeBtn = Ext.getCmp('removeSection');
        		var updateBtn = Ext.getCmp('updateSection');
        		removeBtn.setDisabled(false);
        		updateBtn.setDisabled(false);
        		sectionManage.removeListener('rowclick',rowclick);
        	}
        },
	    ds: sectPageStore,
	    cm: new Ext.grid.ColumnModel([
			{
                header: '栏目名称',
                dataIndex: 'sectionName',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '栏目名称不能为空'
        		}
            }, {
            	header: '栏目ID',
                dataIndex: 'sectionId',
                sortable: true
            }, {
            	header: '栏目编码',
                dataIndex: 'sectionCode',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '栏目名称不能为空'
        		}
         	}, {
            	header: '栏目位置',
                dataIndex: 'sectionPlace',
                sortable: true,
                editor: {
            		xtype: 'combo',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '栏目位置不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				        	'spDisplay',
				            'sectionPlace'
				        ],
				        data: [['不显示','noshow'], ['外左','left'], ['外右','right'], ['内左','center_left'], ['内右','center_right']]
				    }),
                    valueField: 'spDisplay',
                    displayField: 'sectionPlace'
        		}
            }, {
            	header: '栏目顺序',
                dataIndex: 'sectionOrder',
                sortable: true,
                editor: {
            		xtype: 'numberfield',
            		allowBlank: false,
            		blankText: '栏目顺序不能为空'
        		}
            }]),
         initComponent : function() {
         	this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加栏目',
                    iconCls: 'add',
                    handler: addSection
                }, '-', {
                    text: '删除栏目',
                    iconCls: 'remove',
                    id: 'removeSection',
                 	disabled: true,
                    handler: delSection
                }, '-', {
                    text: '保存修改',
                    iconCls: 'update',
                    id: 'updateSection',
                 	disabled: true,
                    handler: updateSection
                }]
            };

           	this.bbar = {
           		store: sectPageStore,
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

			Ext.ux.sectionCtrl.superclass.initComponent.call(this);
         }
    });

	Ext.reg('sectionCtrl', Ext.ux.sectionCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'sectionCtrl',
			region:'center'
		}]
	}).show();

	function addSection() {
		new Ext.Window({
			id: 'addSection-win',
            title: '新建栏目',
            height: 240,
            width: 400,
            minWidth: 320,
        	minHeight: 160,
            layout: 'fit',

        	buttonAlign:'center',
            border: false,
            modal: true,
            items: {
                xtype: 'form',
                id: 'newSection',
				frame: true,
				labelWidth: 100,
				bodyStyle:'padding:15px;',
                defaults: {
                    msgTarget: 'side',
                    margin: '15 15 15 15'
                },
                items: [{
                    xtype: 'textfield',
                    name: 'section.sectionName',
                    fieldLabel: '栏目名称',
                    allowBlank: false,
                    blankText: '栏目名称不能为空',
                    anchor:'80%'
                }, {
                    xtype: 'textfield',
                    name: 'section.sectionCode',
                    fieldLabel: '栏目编码',
                    allowBlank: false,
                    blankText: '栏目编码不能为空',
                    anchor:'80%'
                }, {
                	xtype: 'combo',
                	name: 'section.sectionPlace',
                	fieldLabel: '栏目位置',
                	anchor:'80%',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '栏目位置不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				        	'spDisplay',
				            'sectionPlace'
				        ],
				        data: [['不显示','noshow'], ['外左','left'], ['外右','right'], ['内左','center_left'], ['内右','center_right']]
				    }),
                    valueField: 'sectionPlace',
                    displayField: 'sectionPlace'
                }, {
                    xtype: 'numberfield',
                    name: 'section.sectionOrder',
                    fieldLabel: '栏目顺序',
                    allowBlank: false,
                    blankText: '栏目编码不能为空',
                    anchor:'80%'
                }]
            },
            buttons: [{
                text: '确定',
                handler: function(){
                    var form = Ext.getCmp('newSection').getForm();
                    if (form.isValid()) {
                        form.submit({
                            waitMsg: '正在添加',
                            url: 'sectionAction!addSection',
                            method: 'POST',
                            success: function(form, action){
                                Ext.Msg.alert('Success', '添加成功');
                                Ext.getCmp('addSection-win').destroy();
                                Ext.getCmp('sectionCtrl-grid').getStore().reload();
                            },
                            failure: function(form, action){
                                Ext.Msg.alert('Failed', '添加失败');
                            }
                        })
                    }
                }
            }, {
                text: '重置',
                handler: function(){
                    Ext.getCmp('newSection').getForm().reset();
                }
            }, {
            	text: '取消',
            	handler :function() {
            		Ext.getCmp('addSection-win').destroy();
            	}
            }]
		}).show();
	}

	function delSection() {
		Ext.Msg.confirm('信息', '删除栏目同时会删除栏目下所有新闻，确定删除栏目？' ,
			function(btn){
				if(btn == 'yes') {
					var secGrid = Ext.getCmp('sectionCtrl-grid');
					var sm = secGrid.getSelectionModel();
					var store = Ext.getCmp('sectionCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'sectionAction!deleteSection',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','栏目删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'sectionArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}

	function updateSection() {
		var secGrid = Ext.getCmp('sectionCtrl-grid');
		var m = secGrid.getStore().modified.slice(0);
		if(m == '') {
			Ext.Msg.alert('信息','没有进行任何修改，请先双击记录进行修改');
		}
		else {
			var store = secGrid.getStore();
			var jsonArray = [];
			Ext.each(m, function(item){
				jsonArray.push(item.data);
			});
			Ext.lib.Ajax.request(
				'POST',
				'sectionAction!updateSection',
				{success: function(response){
					Ext.Msg.alert('信息', '更新已成功', function(){
						store.reload();
					});
				},failure:function(){
					Ext.Msg.alert('错误','后台联系出错');
				}},
				'sectionArray=' + encodeURIComponent(Ext.encode(jsonArray))
			);
		}

	}
});