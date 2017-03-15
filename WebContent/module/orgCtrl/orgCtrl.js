Ext.onReady(function() {
	var start = 0;
	var limit = 20;
	var roleId = parent.roleId;
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();

	var editor = new Ext.ux.grid.RowEditor({
        saveText: '更新',
        cancelText: '取消'
    });
	var orgPageStore = new Ext.data.Store({
	    	reader: new Ext.data.JsonReader({
	    		root: 'orgList',
	    		totalProperty:'totalProperty',
                fields: [{
                    name: 'orgName',
                    mapping: 'orgName'
                }, {
                	name: 'orgId',
                    mapping: 'orgId'
                }, {
                	name: 'orgCode',
                	mapping: 'orgCode'
                }, {
                	name: 'orgDuty',
                	mapping: 'orgDuty'
                }, {
                	name: 'subSite',
                	mapping: 'subSite'
                }]
	        }),
	        baseParams:{
            	start:start,
            	limit:limit
            },
	        url: 'orgAction!queryAllOrgsByPage',
	        autoLoad: true
	    })
    Ext.ux.orgCtrl = Ext.extend(Ext.grid.GridPanel,{
    	id: 'orgCtrl-grid',
    	plugins: [editor],
    	border: false,
        viewConfig: {
            forceFit: true
        },
        listeners: {
        	'rowclick' : function rowclick(){
            	var orgManage = Ext.getCmp('orgCtrl-grid');
        		var removeBtn = Ext.getCmp('removeOrg');
        		var updateBtn = Ext.getCmp('updateOrg');
        		removeBtn.setDisabled(false);
        		updateBtn.setDisabled(false);
        		orgManage.removeListener('rowclick',rowclick);
        	}
        },
	    ds: orgPageStore,
	    cm: new Ext.grid.ColumnModel([
            {
                header: '机构名称',
                dataIndex: 'orgName',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '机构名称不能为空'
        		}
            }, {
            	header: '机构编号',
                dataIndex: 'orgId',
                sortable: true
            }, {
            	header: '机构编码',
                dataIndex: 'orgCode',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '机构编码不能为空'
        		}
         	}, {
         		header: '机构介绍',
                dataIndex: 'orgDuty',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '机构介绍不能为空'
        		}
         	}, {
         		header: '是否创建子网站',
                dataIndex: 'subSite',
                sortable: true,
                editor: {
            		xtype: 'combo',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '该选项不能为空',
            		mode: 'local',
            		value: '否',
				    store: new Ext.data.ArrayStore({
				        fields: [
				        	'bool',
				            'YON'
				        ],
				        data: [[1,'是'], [0,'否']]
				    }),
                    valueField: 'bool',
                    displayField: 'YON'
        		}
         	}
         ]),
         initComponent : function() {
         	this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加机构',
                    iconCls: 'add',
                    handler: addOrg
                }, '-', {
                    text: '删除机构',
                    id: 'removeOrg',
                    iconCls: 'remove',
                    handler: deleteOrg,
                    itemId: 'removeOrg',
                    disabled: true
                }, '-', {
                    text: '保存修改',
                    iconCls: 'update',
                    handler: updateOrg,
                    id: 'updateOrg',
                    disabled: true
                }]
            };
           	this.bbar = {
           		store: orgPageStore,
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
			Ext.ux.orgCtrl.superclass.initComponent.call(this);
         }
    });

	Ext.reg('orgInCtrl', Ext.ux.orgCtrl);
	new Ext.Viewport({
		layout : 'border',
		items:[{
			xtype:'orgInCtrl',
			region:'center',
			border: false
		}]
	});

	function addOrg() {
		new Ext.Window({
			id: 'addOrg-win',
            title: '新建机构',
            height: 370,
            width: 700,
            minWidth: 320,
        	minHeight: 160,
            layout: 'fit',

        	buttonAlign:'center',
            border: false,
            modal: true,
            items: {
                xtype: 'form',
                id: 'newOrg',
				frame: true,
				labelWidth: 80,
				bodyStyle:'padding:15px;',
                defaults: {
                    msgTarget: 'side',
                    margin: '15 15 15 15'
                },
                items: [{
                	id: 'orgNameAdd',
                    xtype: 'textfield',
                    name: 'org.orgName',
                    fieldLabel: '机构名称',
                    allowBlank: false,
                    blankText: '机构名称不能为空',
                    anchor:'80%'
                }, {
                	id: 'orgCodeAdd',
                    xtype: 'textfield',
                    name: 'org.orgCode',
                    fieldLabel: '机构代码',
                    allowBlank: false,
                    blankText: '机构代码不能为空',
                    anchor:'80%'
                }, {
                    xtype: 'htmleditor',
                    height: 200,
                    name: 'org.orgDuty',
                    fieldLabel: '机构简介',
                    allowBlank: true
                    //blankText: '机构简介不能为空',
                    //anchor:'80%'
                }, {
                	fieldLabel: '创建子网站',
                	id: 'subSiteAdd',
            		xtype: 'combo',
            		name: 'org.subSite',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		anchor:'50%',
            		blankText: '该选项不能为空',
            		mode: 'local',
            		value: '该选项为必选',
				    store: new Ext.data.ArrayStore({
				        fields: [
				        	'org.subSite',
				            'YON'
				        ],
				        data: [[1,'是'], [0,'否']]
				    }),
				    hiddenName: 'org.subSite',
                    valueField: 'org.subSite',
                    displayField: 'YON'
                }]
            },
            buttons: [{
                text: '确定',
                handler: function(){
                    var form = Ext.getCmp('newOrg').getForm();
                    if (form.isValid()) {
                    	var cv = Ext.getCmp('subSiteAdd').getValue();
                        form.submit({
                            waitMsg: '正在添加',
                            url: 'orgAction!addOrg',
                            method: 'POST',
                            params:{
                            	'roleId':roleId
                            },
                            success: function(form, action){
                                Ext.Msg.alert('Success', '添加成功');
                                Ext.getCmp('addOrg-win').destroy();
                                Ext.getCmp('orgCtrl-grid').getStore().reload();
                                reloadFea(cv);
                            },
                            failure: function(form, action){
                                Ext.Msg.alert('Failed', '添加失败');
                            }
                        });
                        //setTimeout(reload(cv),5200);



                    }
                }
            }, {
                text: '重置',
                handler: function(){
                    Ext.getCmp('newOrg').getForm().reset();
                }
            }]
		}).show();
	}


	function deleteOrg() {

		Ext.Msg.confirm('信息', '确定删除机构？' ,
			function(btn){
				if(btn == 'yes') {
					var orgGrid = Ext.getCmp('orgCtrl-grid');
					var sm = orgGrid.getSelectionModel();
					var store = Ext.getCmp('orgCtrl-grid').getStore();
					var record = sm.getSelected();
					var cv = record.data.subSite;
					//alert(record.data.subSite);
					store.remove(record);

					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'orgAction!deleteOrg',
            			{
            				success:function(request) {
	                            Ext.Msg.alert('信息','机构删除成功');
	                            store.reload();
	                            reloadFea(cv);
	                        },
	                        failure:function(request){
	                            Ext.Msg.alert('错误','删除时出现未知错误');
	                        }
            			},
                        'orgArray='+encodeURIComponent(Ext.encode(ids))+'&roleId='+roleId
        			);

				}
			});
	}

	function updateOrg() {
		var orgGrid = Ext.getCmp('orgCtrl-grid');
		var m = orgGrid.getStore().modified.slice(0);
		if(m == '') {
			Ext.Msg.alert('信息','没有进行任何修改，请先双击记录进行修改');
		}
		else {
			var store = orgGrid.getStore();
			var cv = 1;
			var jsonArray = [];
			Ext.each(m, function(item){
				jsonArray.push(item.data);
			});
			Ext.lib.Ajax.request(
				'POST',
				'orgAction!updateOrg',
				{
					success: function(response){
						Ext.Msg.alert('信息', '更新已成功', function(){
							store.reload();
						});
						reloadFea(cv)
					},
					failure:function(){
						Ext.Msg.alert('错误','后台联系出错');
					}
				},
				//'orgArray=' + encodeURIComponent(Ext.encode(jsonArray))
				'orgArray=' + encodeURIComponent(Ext.encode(jsonArray))+'&roleId='+roleId
			);
		}



	}

	function reloadFea(cv) {
		if(cv == 1) {
			var cc = top.Ext.getCmp('subCtrl').getLoader();
			var ccRoot = top.Ext.getCmp('subCtrl').getRootNode();
			cc.load(ccRoot);
		}
	}
});