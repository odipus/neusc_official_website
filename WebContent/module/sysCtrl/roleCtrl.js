var moduleName = "";
var moduleCode = "";
var moduleTab = "";
var moduleName_a = "";
var moduleCode_a = "";
var moduleTab_a = "";
var featureTab = "";
var featureTab_a = "";
//var sectionCtrlSon = 0;
//var newsCtrlSon = 0;
//var userCtrlSon = 0;
var roleId = 0;
$.ajax({
			url : 'authPrivilegeAction!authCtrl',
			async : false,
			success : function(data) {
				try {
					var moduleJson = eval("("+ data +")");
					moduleName = moduleJson.moduleName;
					moduleCode = moduleJson.moduleCode;
					moduleTab = moduleJson.moduleTab;
					featureTab = moduleJson.feaTab;
					if (moduleJson.success != 'true') {
						window.location.href = "login.jsp";
					} else {
						moduleName_a = moduleName.split(",");
						moduleCode_a = moduleCode.split(",");
						moduleTab_a = moduleTab.split(",");
						featureTab_a = featureTab.split(",");
					}
				} catch (err) {
					alert(err);
				}

			}
		});



Ext.onReady(function() {
	var start = 0;
	var limit = 20;
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();
	var rolePageStore = new Ext.data.Store({
                    reader: new Ext.data.JsonReader({
                        root: 'roleList',
                        totalProperty:'totalProperty',
                        fields: [{
                            name: 'roleName',
                            mapping: 'roleName'
                        }, {
                        	name: 'roleId',
                        	mapping: 'roleId'
                        }]
                    }),
                    baseParams:{
            			start:start,
            			limit:limit
            		},
                    url: 'roleAction!queryAllRolesByPage',
                    autoLoad: true
                })

	Ext.ux.treeRole = Ext.extend(Ext.tree.TreePanel,{
		id : "treerole",
		rootVisible: false,

		initComponent:function() {
			this.loader = new Ext.tree.TreeLoader({
				preloadChildren : true,
				//clearOnLoad : true,
				dataUrl:''
			}),

			this.root=new Ext.tree.AsyncTreeNode({
           		id:"root",
           		expanded:true,
           		clearOnLoad : true,
           		leaf:false,
           		children : [{
					text : '栏目管理',
					id : 'sectionCtrl',
					leaf : false,
					checked: true
				}, {
					text: '新闻管理',
					id : 'newsCtrl',
					leaf : true,
					checked: true
				}, {
					text: '系统管理',
					id : 'sysCtrl',
					leaf : true,
					checked: true
				}, {
					text: '机构管理',
					id : 'orgCtrl',
					leaf : true,
					checked: true
				}, {
					text: '教师管理',
					id : 'tchCtrl',
					leaf : true,
					checked: true
				}]
         	});
         	this.bbar = {
           		store: rolePageStore,
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
         	Ext.ux.treeRole.superclass.initComponent.call(this);
		}
	});
	Ext.reg('roleTree', Ext.ux.treeRole);

	Ext.ux.roleCtrl = Ext.extend(Ext.Panel, {
		border:false,
		bodyBorder:false,
		initComponent : function() {
            this.items = [{
                xtype: 'grid',
                id: 'roleCtrl-grid',
                autoHeight: true,
                stripeRows: true,
                autoScroll: true,
                layout: 'fit',
                unstyled: true,
                viewConfig: {
                    forceFit: true
                },
                listeners: {
		        	'rowclick' : function rowclick(){
		            	var roleManage = Ext.getCmp('roleCtrl-grid');
		        		var removeBtn = Ext.getCmp('removeRole');
		        		var updateBtn = Ext.getCmp('updateRole');
		        		removeBtn.setDisabled(false);
		        		updateBtn.setDisabled(false);
		        		roleManage.removeListener('rowclick',rowclick);
		        	}
		        },
                ds: rolePageStore,

                cm: new Ext.grid.ColumnModel([
                new Ext.grid.RowNumberer(),{
                    header: '角色名称',
                    dataIndex: 'roleName',
                    sortable: true
                }, {
                	header: '角色编号',
                	dataIndex: 'roleId',
                	sortable: true
                }])
            }];
            this.tbar = {
                xtype: 'toolbar',
                items: [{
                    text: '添加角色',
                    iconCls: 'add',
                    handler: addRole
                }, '-', {
                    text: '删除角色',
                    iconCls: 'remove',
                    id: 'removeRole',
                    disabled: true,
                    handler: deleteRole
                }, '-', {
                    text: '修改角色信息',
                    iconCls: 'update',
                    id: 'updateRole',
                    disabled: true,
                    handler: updateRole
                }]
            };
            this.bbar = {
           		store: rolePageStore,
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
			Ext.ux.roleCtrl.superclass.initComponent.call(this);
		}
	});
	Ext.reg('roleInCtrl', Ext.ux.roleCtrl);

	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'roleInCtrl',
			region:'center'
		}]
	}).show();


	function addRole() {
		new Ext.Window({
			title: '增加角色',
			id: 'addRole-win',
			width:370,
			border: false,
			height:460,
			minWidth: 300,
        	minHeight: 400,
			layout : 'fit',
			modal: true,
			buttonAlign:'center',
			buttons: [{
				text: '确定',
				handler: function() {
					var roleArray = "";
					var roles = Ext.getCmp('roletp').getChecked();
					for(i = 0; i < roles.length; i++) {
						roleArray = roleArray + roles[i].id + ",";
					}

					var roleform = Ext.getCmp('addR-form').getForm();
					if(roleform.isValid()) {
						roleform.submit({
							waitMsg: '正在添加角色',
                            url: 'roleAction!addRole',
                            method: 'POST',
                            params: {
                            	roleArray: roleArray
                            },
                            success: function(form, action){
                            	if(action.result.success == "success") {
                            		Ext.Msg.alert('信息', '添加成功');
                            	}
                            	else {
                            		Ext.Msg.alert('信息', '添加失败,角色名称已存在');
                            	}
                                Ext.getCmp('addRole-win').destroy();
                                Ext.getCmp('roleCtrl-grid').getStore().reload();
                            },
                            failure: function(form, action){
                                Ext.Msg.alert('信息', '添加失败，出现未知错误');
                            }
						});
					}

				}
			},{
				text: '重置',
				handler: function() {
					Ext.getCmp('addR-form').getForm().reset();
					var rtmp = Ext.getCmp('roletp').getRootNode();
					rtmp.eachChild(function(child) {
						child.attributes.checked = true;
	            		child.ui.toggleCheck(true);
					});
				}
			},{
				text: '取消',
				handler: function() {
					Ext.getCmp('addRole-win').destroy();
				}
			}],
			items:[{
				id: 'addR-form',
				border: false,
				xtype: 'form',
				autoScroll: true,
				frame: true,
				labelWidth: 80,
				bodyStyle:'padding:20px;',
				defaults: {
                    msgTarget: 'side'
                },
                items: [{
                	xtype : 'textfield',
					width : 160,
					fieldLabel : '角色名称',
					id : 'roleName',
					name : 'role.roleName',
					style : 'font=size:15px',
					allowBlank : false,
					blankText : '角色名称不能为空',
					style : {
						marginBottom : '10px'
					}
                }, {
                	fieldLabel : '角色权限',
                	xtype: 'treepanel',
                	id: 'roletp',
                	autoScroll:true,
                	rootVisible: false,
                	lines: false,
                	loader: new Ext.tree.TreeLoader({
                		dataUrl: 'authPrivilegeAction!authTree'
                	}),
                	root: new Ext.tree.AsyncTreeNode({
                		id: 'root',
                		text: 'sss'
                	}),
 
			     	listeners: {
		                'afterrender': function() {

		                	}
                	}
                }]
			}]
		}).show();
	}

	function deleteRole() {
		Ext.Msg.confirm('信息', '确定删除角色？' ,
			function(btn){
				if(btn == 'yes') {
					var roleGrid = Ext.getCmp('roleCtrl-grid');
					var sm = roleGrid.getSelectionModel();
					var store = Ext.getCmp('roleCtrl-grid').getStore();
					var record = sm.getSelected();
					store.remove(record);
					var ids = [];
					Ext.each(record, function(item){
						ids.push(item.data);
					});
					Ext.lib.Ajax.request(
            			'POST',
            			'roleAction!deleteRole',
            			{
                            success:function(request) {
                                Ext.Msg.alert('信息','角色删除成功.如果您要删除的角色有对应的用户，请您先将用户删除后再删除该角色');
                                store.reload();
                            },failure:function(){
                                Ext.Msg.alert('错误','删除时出现未知错误');
                            }
            			},
            			'roleArray='+encodeURIComponent(Ext.encode(ids))
        			);
				}
			});
	}

	function updateRole() {
		new Ext.Window({
			title: '修改角色权限',
			id: 'updateRole-win',
			width:370,
			border: false,
			height:460,
			minWidth: 300,
        	minHeight: 400,
			layout : 'fit',
			modal: true,
			buttonAlign:'center',
			buttons: [{
				text: '确定',
				handler: function() {
					var roleArray = "";
					var roles = Ext.getCmp('roletpUp').getChecked();
					for(i = 0; i < roles.length; i++) {
						roleArray = roleArray + roles[i].id + ",";
					}
					var roleform = Ext.getCmp('updateR-form').getForm();
					if(roleform.isValid()) {
						roleform.submit({
							waitMsg: '正在修改角色权限',
                            url: 'roleAction!updateRole',
                            method: 'POST',
                            params: {
                            	roleArray: roleArray,
                            	'role.roleId': roleId
                            },
                            success: function(form, action){
                            	if(action.result.success == "success") {
                            		Ext.Msg.alert('信息', '添加成功');
                            	}
                            	else {
                            		Ext.Msg.alert('信息', '添加失败,角色名称已存在');
                            	}
                                Ext.getCmp('updateRole-win').destroy();
                                Ext.getCmp('roleCtrl-grid').getStore().reload();
                            },
                            failure: function(form, action){
                                Ext.Msg.alert('信息', '添加失败，出现未知错误');
                            }
						});
					}

				}
			},{
				text: '重置',
				handler: loadRole
			},{
				text: '取消',
				handler: function() {
					Ext.getCmp('updateRole-win').destroy();
				}
			}],
			items:[{
				id: 'updateR-form',
				border: false,
				autoScroll: true,
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
					fieldLabel : '角色名称',
					id : 'roleNameUp',
					name : 'role.roleName',
					style : 'font=size:15px',
					allowBlank : false,
					blankText : '角色名称不能为空',
					style : {
						marginBottom : '10px'
					}
                }, {
                	fieldLabel : '角色权限',
                	xtype: 'treepanel',
                	id: 'roletpUp',
                	autoScroll:true,
                	rootVisible: false,
                	lines: false,
                	loader: new Ext.tree.TreeLoader({
                		dataUrl: 'authPrivilegeAction!authTreeUp'
                	}),
                	root: new Ext.tree.AsyncTreeNode({
                		id: 'rootUp',
                		expanded:true,
        		  		clearOnLoad : true,
        		  		leaf:false,
                	}),
                	listeners: {
                		afterrender : loadRole
                	}

                	/*
                	root: new Ext.tree.AsyncTreeNode({
			       		id:'rootUp',
			       		expanded:true,
			       		clearOnLoad : true,
			       		leaf:false,
			       		children : [{
							text : '栏目管理',
							id : 'sectionCtrlSonUp',
							leaf : true,
							checked: false
						}, {
							text: '新闻管理',
							id : 'newsCtrlSonUp',
							leaf : true,
							checked: false
						}, {
							text: '系统管理',
							id : 'sysCtrlSonUp',
							leaf : true,
							checked: false
						}, {
							text: '机构管理',
							id : 'orgCtrlSonUp',
							leaf : true,
							checked: false
						}, {
							text: '教师管理',
							id : 'tchCtrlSonUp',
							leaf : true,
							checked: false
						}]
			     	})
			     	*/
                }],
                listeners: {
                	//afterrender : loadRole
                }
			}],
			listeners: {
                	//'show': loadRole
            }
		}).show();
	}

	function loadRole() {
		var updateForm = Ext.getCmp('updateR-form').getForm();
		var roleGrid = Ext.getCmp('roleCtrl-grid');
		var sm = roleGrid.getSelectionModel();
		var store = Ext.getCmp('roleCtrl-grid').getStore();
		var record = sm.getSelected();
		roleId = encodeURIComponent(record.data.roleId);
		var cn = "";
		if(updateForm) {
			Ext.lib.Ajax.request(
				'post',
				'roleAction!queryRole',
				{
					success: function(response) {
						var data = Ext.decode(response.responseText);
						Ext.getCmp('roleNameUp').setValue(data.role.roleName);
						var modA = data.role.modules;
						for(i = 0; i < modA.length; i++) {
							var rootTp = Ext.getCmp('roletpUp').getRootNode();
							var tmpId = modA[i].moduleCode + 'SonUp';
							if(tmpId == 'newsCtrlSonUp') {
								//cn.expand();
								cn = rootTp.findChild('id',tmpId);
								var sectA = data.role.sections;
								for(j = 0; j < sectA.length; j++) {
						    		var cnSon1 = cn.findChild('id',sectA[j].sectionCode+'GonUp');
						    		cnSon1.attributes.checked = true;
									cnSon1.ui.toggleCheck(true);
								}
							}
							else if(tmpId.match('subCtrlSonUp') != null) {
								cn = rootTp.findChild('id',tmpId);
								//alert(cn);
								//cn.expand();
								Ext.Ajax.request({
									url: 'roleAction!querySubByRole',
								    params: {
								    	'roleId': roleId
								    },
								    success: function(response) {
								    	var subData = Ext.decode(response.responseText);
								    	var subA = subData.subSiteList;
								    	//alert(cn);
								    	for(j = 0; j < subA.length; j++) {
								    		//alert(subA[j]);
								    		//alert(cn);
								    		var subId = subA[j]+'OonUp';
								    		cn = rootTp.findChild('id','subCtrlSonUp');
								    		//alert(cn.hasChildNodes());
								    		//alert(subId);
								    		var cnSon2 = cn.findChild('id',subId);
								    		cnSon2.attributes.checked = true;
											cnSon2.ui.toggleCheck(true);
								    	}
								    },
								    failure: function() {
								    	Ext.Msg.alert('信息', '新闻管理权限载入失败，出现未知错误');
								    },
								});
							}
							else {
								cn = rootTp.findChild('id',tmpId);
							}
							cn.attributes.checked = true;
							cn.ui.toggleCheck(true);
						}
					},
					failure: function() {
						Ext.Msg.alert('失败','初始化数据失败');
					}
				},
				'roleId=' + encodeURIComponent(record.data.roleId)
			);
		}
	}

	function loadSectAuth() {

	}
});
