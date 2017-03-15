/**
 *
 */
Ext.onReady(function() {
	var start = 0;
	var limit = 20;
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();

	Ext.apply(Ext.form.VTypes, {
			confirmPsw : function(val, field) {
				if (field.confirmTo) {
					var psw = Ext.getCmp(field.confirmTo);
					if (val.trim() == psw.getValue().trim()) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			},
			testPsw:function(v){
				if(v.length>=8){
					return true;
					
				}
				else{
					return false;
				}
			}
	
		});


	var editor = new Ext.ux.grid.RowEditor({
        saveText: '更新',
        cancelText: '取消'
    });

	var userPageStore = new Ext.data.Store({
            reader: new Ext.data.JsonReader({
                root: 'userList',
                totalProperty:'totalProperty',
                fields: [{
                    name: 'userName',
                    mapping: 'userName'
                }, {
                	name: 'userId',
                    mapping: 'userId'
                }, {
                    name: 'userPsw',
                    mapping: 'userPsw'
                }, {
                	name: 'showName',
                	mapping: 'showName'
                }, 
				{
                	name: 'engName',
                	mapping: 'engName'
                }, {
                    name: 'roleName',
                    mapping: 'role.roleName'
                }]
            }),
            baseParams:{
            	start:start,
            	limit:limit
            },
            url: 'userAction!queryAllUsersByPage',
            autoLoad: true
        });

    Ext.ux.userCtrl = Ext.extend(Ext.grid.GridPanel,{
    	id: 'userCtrl-grid',
    	plugins: [editor],
    	border: false,
        viewConfig: {
            forceFit: true
        },
        listeners: {
        	'rowclick' : function rowclick(){
            	var userManage = Ext.getCmp('userCtrl-grid');
        		var removeBtn = Ext.getCmp('removeUser');
        		var updateBtn = Ext.getCmp('updateUser');
        		removeBtn.setDisabled(false);
        		updateBtn.setDisabled(false);
        		userManage.removeListener('rowclick',rowclick);
        	}
        },
        ds: userPageStore,
        cm: new Ext.grid.ColumnModel([
        {
            header: '用户名称',
            dataIndex: 'userName',
            sortable: true,
            editor: {
        		xtype: 'textfield',
        		allowBlank: false,
        		blankText: '用户名称不能为空'
        	}
        }, {
        	header: '用户ID',
            dataIndex: 'userId',
            sortable: true
        }, {
            header: '用户密码',
            dataIndex: 'userPsw',
            renderer : function(value, p, r) {return '****'},
            sortable: true,
            editor: {
        		xtype: 'textfield',
        		allowBlank: false,
        		blankText: '用户密码不能为空'
        	}
        }, {
        	header: '显示名称',
        	dataIndex: 'showName',
            sortable: true,
            editor: {
        		xtype: 'textfield',
        		allowBlank: false,
        		blankText: '显示名称不能为空'
        	}
        }, 
		
		{
        	header: '英文名称',
        	dataIndex: 'engName',
            sortable: true,
            editor: {
        		xtype: 'textfield',
        		allowBlank: false,
        		blankText: '英文名称不能为空'
        	}
        },
		{
            header: '用户角色',
            dataIndex: 'roleName',
            sortable: true,
            editor: {
        		xtype: 'combo',
        		allowBlank: false,
        		blankText: '用户角色不能为空',
        		forceSelection: true,
        		editable: false,
        		mode: 'local',
        		triggerAction: 'all',
				store : new Ext.data.JsonStore({
					url: 'roleAction!queryComboRoles',
					root : 'roleList',
					autoLoad : true,
					fields: ['roleName']
				}),
				valueField: 'roleName',
                displayField: 'roleName'

        	}
        }]),
        initComponent : function() {
        	this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加用户',
                    iconCls: 'add',
                    handler: addUser
                }, '-', {
                    text: '删除用户',
                    iconCls: 'remove',
                    handler: deleteUser,
                    id: 'removeUser',
                    disabled: true
                }, '-', {
                    text: '保存修改',
                    iconCls: 'update',
                    handler: updateUser,
                    id: 'updateUser',
                    disabled: true
                }]
            };
           	this.bbar = {
           		store: userPageStore,
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
           	/*
           	this.on('selectionchange', function(view, records){
            		//Ext.getCmp('userCtrl-grid').down('#removeUser').setDisabled(!records.length);
        			alert("s");
        	}, this);
           	this.listeners = {
        		'selectionchange' : function(view, records){
            		//Ext.getCmp('userCtrl-grid').down('#removeUser').setDisabled(!records.length);
        			alert("s");
        		}
    		}
    		*/
           	Ext.ux.userCtrl.superclass.initComponent.call(this);
        }
    });

	Ext.reg('userCtrl', Ext.ux.userCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'userCtrl',
			region:'center'
		}]
	}).show();

	function addUser() {
		new Ext.Window({
			title: '添加用户',
			id: 'addUser-win',
			width : 350,
			height : 300,
			minWidth: 300,
        	minHeight: 250,
			layout : 'fit',
			modal: true,
			buttonAlign:'center',
			buttons : [{
				text: '确定',
				handler: function() {
					Ext.getCmp('addForm').getForm().submit({
						waitMsg : '正在添加用户',
						url : 'userAction!addUser',
						method : 'POST',
						success : function(form, action) {
							Ext.getCmp('addUser-win').destroy();
							Ext.Msg.alert('成功', '添加用户成功');
							Ext.getCmp('userCtrl-grid').getStore().reload();
						},
						failure : function(form, action) {
							Ext.getCmp('addUser-win').destroy();
							Ext.Msg.alert('信息', '添加用户成功失败');
						}
					});
				}
			}, {
				text: '重置',
				handler: function() {
					Ext.getCmp('addForm').getForm().reset();
				}
			}, {
				text: '取消',
				handler: function() {
					Ext.getCmp('addUser-win').destroy();
				}
			}],
			items:[{
				id: 'addForm',
				xtype: 'form',
				frame: true,
				labelWidth: 80,
				bodyStyle:'padding:20px;',
				defaults: {
                    msgTarget: 'side'
                },
				items: [{
					xtype : 'textfield',
					width : 160,
					fieldLabel : '用户名',
					id : 'userName',
					name : 'user.userName',
					style : 'font=size:15px',
					allowBlank : false,
					blankText : '用户名不能为空',
					style : {
						marginBottom : '10px'
					}
				}, {
					xtype : 'textfield',
					width : 160,
					id : "userPsw",
					fieldLabel : '密码',
					inputType : 'password',
                    regex : /^(([0-9]+[a-zA-Z]+)|([a-zA-Z]+[0-9]+))$/,
                    regexText : '对不起，用户帐号只能输入字母和数字！',
					name : 'user.userPsw',
					style : 'font=size:15px',
					vtype : 'testPsw',
					vtypeText : '输入密码最小为8位',
					minLengthText: 8,
					allowBlank : false,
					
					blankText : '密码不能为空',
					style : {
						marginBottom : '10px'
					}
				}, {
					xtype : 'textfield',
					width : 160,
					id : "confirmPsw",
					fieldLabel : '确认密码',
					inputType : 'password',
					minLengthText: 8,
                    regex : /^(([0-9]+[a-zA-Z]+)|([a-zA-Z]+[0-9]+))$/,
                    regexText : '对不起，用户帐号只能输入字母和数字！',
					style : 'font=size:15px',
					vtype : 'confirmPsw',
					vtypeText : '两次输入的密码不一致！',
					confirmTo : 'userPsw',
					allowBlank : false,
					blankText : '确认密码不能为空',
					style : {
						marginBottom : '10px'
					}
				}, {
					xtype : 'textfield',
					width : 160,
					fieldLabel : '显示名称',
					id : 'showName',
					name : 'user.showName',
					style : 'font=size:15px',
					allowBlank : false,
					blankText : '用户名不能为空',
					style : {
						marginBottom : '10px'
					}
				}, 
				
				{
					xtype : 'textfield',
					width : 160,
					fieldLabel : '英文名称',
					id : 'engName',
					name : 'user.engName',
					style : 'font=size:15px',
					allowBlank : false,
					blankText : '英文名不能为空',
					style : {
						marginBottom : '10px'
					}
				}, 
				{
					xtype: 'combo',
					id: 'userRole',
					width : 160,
					fieldLabel : '用户角色',
					name: 'userRole',
					allowBlank : false,
					blankText : '用户角色不能为空',
					forceSelection: true,
	        		editable: false,
	        		mode: 'local',
	        		triggerAction: 'all',
	        		style : {
						marginBottom : '10px'
					},
					store : new Ext.data.JsonStore({
						url: 'roleAction!queryComboRoles',
						root : 'roleList',
						autoLoad : true,
						fields: ['roleName']
					}),
					valueField: 'roleName',
	                displayField: 'roleName'
				}]
			}]
		}).show();
	}

	function updateUser() {
		var userGrid = Ext.getCmp('userCtrl-grid');
		var uStore = userGrid.getStore();
		var m = uStore.modified.slice(0);
		if(m == '') {
			Ext.Msg.alert('信息','没有进行任何修改，请先双击记录进行修改');
		}
		else {
			var jsonArray = [];
			Ext.each(m, function(item){
				jsonArray.push(item.data);
			});
			Ext.lib.Ajax.request(
				'POST',
				'userAction!updateUser',
				{success: function(response){
					Ext.Msg.alert('信息', '更新已成功', function(){
						uStore.reload();
					});
				},failure:function(){
					Ext.Msg.alert('错误','后台联系出错');
				}},
				'userArray=' + encodeURIComponent(Ext.encode(jsonArray))
			);
		}
	}



	function deleteUser() {
		Ext.Msg.confirm('信息', '确定删除用户？' ,
			function(btn){
				if(btn == 'yes') {
					var secGrid = Ext.getCmp('userCtrl-grid');
					var sm = secGrid.getSelectionModel();
					var store = Ext.getCmp('userCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'userAction!deleteUser',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','用户删除成功');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'userArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}
});
