/**
 *
 */
Ext.onReady(function() {
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();

	var editor = new Ext.ux.grid.RowEditor({
        saveText: '更新',
        cancelText: '取消'
    });

	var tchPageStore = new Ext.data.GroupingStore({
	    	reader: new Ext.data.JsonReader({
	    		root: 'tchesList',
	    		totalProperty:'totalProperty',
                fields: [{
                    name: 'tchName',
                    mapping: 'tchName'
                }, {
                	name: 'teacherId',
                	mapping: 'teacherId'
                }, {
                	name: 'tchNumber',
                	mapping: 'tchNumber'
                }, {
                	name: 'tchGender',
                	mapping: 'tchGender'
                }, {
                	name: 'tchTitle',
                	mapping: 'tchTitle'
                }, {
                	name: 'tchDuty',
                	mapping: 'tchDuty'
                }, {
                	name: 'tchOrgDuty',
                	mapping: 'tchOrgDuty'
                }, {
                	name: 'tchDegree',
                	mapping: 'tchDegree'
                }, {
                	name: 'tchOrg',
                	mapping: 'org.orgName'
                }]
	        }),
            groupField:'tchOrg',
	        url: 'tchAction!queryAllTchesByPage',
	        autoLoad: true
	    });

    Ext.ux.tchCtrl = Ext.extend(Ext.grid.GridPanel,{
    	id: 'tchCtrl-grid',
    	plugins: [editor],

        listeners: {
	    	'rowclick' : function rowclick(){
	        	var tchManage = Ext.getCmp('tchCtrl-grid');
	    		var removeBtn = Ext.getCmp('removeTch');
	    		var updateBtn = Ext.getCmp('updateTch');
	    		removeBtn.setDisabled(false);
	    		updateBtn.setDisabled(false);
	    		tchManage.removeListener('rowclick',rowclick);
	    	}
	    },
	    ds: tchPageStore,
	    cm: new Ext.grid.ColumnModel([
         	{
                header: '教师姓名',
                dataIndex: 'tchName',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: false,
            		blankText: '教师姓名不能为空'
        		}
            }, {
            	header: '教师ID',
                dataIndex: 'teacherId',
                sortable: true
            }, {
            	header: '教师性别',
                dataIndex: 'tchGender',
                sortable: true,
                editor: {
            		xtype: 'combo',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '教师性别不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Gender'
				        ],
				        data: [['男'], ['女']]
				    }),
                    valueField: 'Gender',
                    displayField: 'Gender'
        		}
         	}, {
         		header: '教师编号',
                dataIndex: 'tchNumber',
                sortable: true,
                editor: {
            		xtype: 'numberfield',
            		allowBlank: false,
            		blankText: '教师编号不能为空'
        		}
         	}, {
         		header: '教师职称',
                dataIndex: 'tchTitle',
                sortable: true,
                editor: {
            		xtype: 'combo',
            		forceSelection: true,
        			editable: false,
            		allowBlank: true,
            		triggerAction: 'all',
            		//blankText: '职务职称不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Title'
				        ],
				        data: [['助教'], ['讲师'], ['副教授'], ['教授']]
				    }),
                    valueField: 'Title',
                    displayField: 'Title'
        		}
         	}, {
         		header: '学院职务',
                dataIndex: 'tchDuty',
                sortable: true,
                width: 120,
                editor: {
            		xtype: 'textfield',
            		allowBlank: true
        		}
         	}, {
         		header: '机构职务',
                dataIndex: 'tchOrgDuty',
                sortable: true,
                editor: {
            		xtype: 'textfield',
            		allowBlank: true
        		},
        		width: 150
         	}, {
         		header: '学历',
                dataIndex: 'tchDegree',
                sortable: true,
                editor: {
            		xtype: 'combo',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '学历不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Degree'
				        ],
				        data: [['本科'], ['硕士'], ['博士']]
				    }),
                    valueField: 'Degree',
                    displayField: 'Degree'
        		}
         	}, {
         		header: '所属机构',
         		width: 130,
        		dataIndex: 'tchOrg',
                sortable: true,
                editor: {
                	xtype: 'combo',
                    name: 'tchOrg',
                    forceSelection: true,
        			editable: false,
        			mode: 'local',
        			triggerAction: 'all',
                    //blankText: '所属机构不能为空',
                	store: new Ext.data.JsonStore({
                    	url: 'orgAction!queryAllTchOrgs',
						root : 'orgList',
						autoLoad : true,
						fields: ['orgName']
                    }),
                    valueField: 'orgName',
                    displayField: 'orgName'
                }
         }]),
		 view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "位教师" : "位教师"]})'
         }),
         initComponent : function() {

         	this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加教师',
                    iconCls: 'add',
                    handler: addTch
                }, '-', {
                    text: '删除教师',
                    iconCls: 'remove',
                    handler: deleteTch,
                    id: 'removeTch',
                    disabled: true
                }, '-', {
                    text: '保存修改',
                    iconCls: 'update',
                    id: 'updateTch',
                    disabled: true,
                    handler: updateTch
                }]
            };
            /*
           	this.bbar = {
           		store: tchPageStore,
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
           	*/
			Ext.ux.tchCtrl.superclass.initComponent.call(this);
         }
    });

	Ext.reg('tchInCtrl', Ext.ux.tchCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'tchInCtrl',
			region:'center'
		}]
	}).show();

	function addTch() {
		new Ext.Window({
			id: 'addTch-win',
            title: '新增教师',
            height: 400,
            width: 500,
            minWidth: 40,
        	minHeight: 300,
            layout: 'fit',

        	buttonAlign:'center',
            border: false,
            modal: true,
            items: {
                xtype: 'form',
                layout: 'form',
                id: 'newTch',
				frame: true,
				labelWidth: 80,
				bodyStyle:'padding:15px;',
                defaults: {
                    msgTarget: 'side',
                    margin: '15 15 15 15'
                },
                items: [{
                    xtype: 'textfield',
                    name: 'tch.tchName',
                    fieldLabel: '教师名称',
                    allowBlank: false,
                    blankText: '教师名称不能为空',
                    anchor:'70%'
                }, {
                    xtype: 'textfield',
                    name: 'tch.tchAbbr',
                    fieldLabel: '教师缩写',
                    allowBlank: false,
                    blankText: '教师缩写不能为空',
                    anchor:'70%'
                }, {
                    xtype: 'numberfield',
                    name: 'tch.tchNumber',
                    fieldLabel: '教师编码',
                    allowBlank: false,
                    blankText: '教师编码不能为空',
                    anchor:'70%'
                }, {
                	xtype: 'combo',
                	fieldLabel: '教师性别',
                	name: 'tch.tchGender',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '教师性别不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Gender'
				        ],
				        data: [['男'], ['女']]
				    }),
                    valueField: 'Gender',
                    displayField: 'Gender',
                    anchor:'70%'
                }, {
                	xtype: 'combo',
                	name: 'tch.tchTitle',
                	fieldLabel: '职务职称',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '职务职称不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Title'
				        ],
				        data: [['助教'], ['讲师'], ['副教授'], ['教授']]
				    }),
                    valueField: 'Title',
                    displayField: 'Title',
                    anchor:'70%'
                }, {
                	xtype: 'textfield',
            		allowBlank: true,
            		fieldLabel: '学院职务',
            		name: 'tch.tchDuty',
            		anchor:'70%'
                }, {
                	xtype: 'textfield',
            		allowBlank: true,
            		fieldLabel: '机构职务',
            		name: 'tch.tchOrgDuty',
            		anchor:'70%'
                }, {
                	xtype: 'combo',
                	name: 'tch.tchDegree',
                	fieldLabel: '学历',
            		forceSelection: true,
        			editable: false,
            		allowBlank: false,
            		triggerAction: 'all',
            		blankText: '学历不能为空',
            		mode: 'local',
				    store: new Ext.data.ArrayStore({
				        fields: [
				            'Degree'
				        ],
				        data: [['本科'], ['硕士'], ['博士']]
				    }),
                    valueField: 'Degree',
                    displayField: 'Degree',
                    anchor:'70%'
                }, {
                	xtype: 'combo',
                	name: 'tchOrg',
                	fieldLabel: '所属机构',
            		forceSelection: true,
        			editable: false,
        			mode: 'local',
        			triggerAction: 'all',
                    blankText: '所属机构不能为空',
                	store: new Ext.data.JsonStore({
                    	url: 'orgAction!queryAllTchOrgs',
						root : 'orgList',
						autoLoad : true,
						fields: ['orgName']
                    }),
                    valueField: 'orgName',
                    displayField: 'orgName',
                    anchor:'70%'
                }]
            },
            buttons: [{
                text: '确定',
                handler: function(){
                    var form = Ext.getCmp('newTch').getForm();
                    if (form.isValid()) {
                        form.submit({
                            waitMsg: '正在添加',
                            url: 'tchAction!addTch',
                            method: 'POST',
                            success: function(form, action){
                                Ext.Msg.alert('成功', '添加成功');
                                Ext.getCmp('addTch-win').destroy();
                                Ext.getCmp('tchCtrl-grid').getStore().reload();
                            },
                            failure: function(form, action){
                                Ext.Msg.alert('失败', '添加失败');
                            }
                        })
                    }
                }
            }, {
                text: '重置',
                handler: function(){
                    Ext.getCmp('newTch').getForm().reset();
                }
            }, {
				text: '取消',
				handler: function() {
					Ext.getCmp('addTch-win').destroy();
				}
            }]
		}).show();
	}

	function deleteTch() {
		Ext.Msg.confirm('信息', '确定删除记录？' ,
			function(btn){
				if(btn == 'yes') {
					var secGrid = Ext.getCmp('tchCtrl-grid');
					var sm = secGrid.getSelectionModel();
					var store = Ext.getCmp('tchCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'tchAction!deleteTch',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','记录删除成功');
                                Ext.getCmp('tchCtrl-grid').getStore().reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'tchArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}

	function updateTch() {
		var tchGrid = Ext.getCmp('tchCtrl-grid');
		var m = tchGrid.getStore().modified.slice(0);
		if(m == '') {
			Ext.Msg.alert('信息','没有进行任何修改，请先双击记录进行修改');
		}
		else {
			
			var store = tchGrid.getStore();

			var jsonArray = [];
			Ext.each(m, function(item){
				jsonArray.push(item.data);
			});
			Ext.lib.Ajax.request(
				'POST',
				'tchAction!updateTch',
				{success: function(response){
					Ext.Msg.alert('信息', '更新已成功', 
					function(){
						store.reload();
					});
				},failure:function(){
					Ext.Msg.alert('错误','后台联系出错');
				}},
				'tchArray=' + encodeURIComponent(Ext.encode(jsonArray))
			);
		}

	}
});