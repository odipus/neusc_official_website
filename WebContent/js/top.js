
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
			}
		});

var clock = new Ext.Toolbar.TextItem('');
var logoutBtn = new Ext.Button({
			text : '注销',
			handler: function() {
				window.location.href = "index.jsp";
			}
		});

//author: lc_kykz
//修改个人资料
//2014-12-14
var modifyOwnMsgBtn = new Ext.Button({
	text : '更改个人资料', 
	handler: function() {
		new Ext.Window({
			id: 'changeOwnMsg-win',
         title: '修改个人资料',
         height: 600,
         width: 300,  
         minWidth: 180,
     	 minHeight: 230,
         layout: 'fit',
         modal: true,
         border: false,
         buttonAlign: 'center',
         buttons: [{
         	text: '确认',
         	handler: function() {
         		var pswform = Ext.getCmp('cpform').getForm();
         		var original_pwd = Ext.getCmp('original_pwd').getValue();
         		var new_pwd=Ext.getCmp('newPsw').getValue();
         		if(original_pwd==new_pwd){
         			Ext.Msg.alert('信息', '原始密码与现在密码不能重复');
         			Ext.getCmp('cpform').getForm().reset();
         		}else{
             		if(pswform.isValid()) {
             			alert(userName);
             			pswform.submit({
                             waitMsg: '正在更新密码',
                             url: 'userAction!updatePsw',
                             method: 'POST',
                             params: {
                             	'user.userName': userName
                             },
                             success: function(form, action){
                                 if(action.result.success == 'error') {
                                 	Ext.Msg.alert('信息', '原始密码错误');
                                 }
                                 else{
                                 	Ext.Msg.alert('信息', '更新成功，自动跳转到登陆界面，请重新登陆');
                                 	Ext.getCmp('changeOwnMsg-win').destroy();
    	                                window.setTimeout(
    	                                	function() {
    	                                		location.href='index.jsp'
    	                                	},2000);
                                 }
                             },
                             failure: function(form, action){
                                 Ext.Msg.alert('信息', '更新失败');
                             }
                         })
             		
             	}
         			
         		}
         		
         	}
         }, {
         	text: '重置',
         	handler: function() {
         		Ext.getCmp('cpform').getForm().reset();
         	}
         }, {
         	text: '取消',
         	handler: function() {
         		Ext.getCmp('changeOwnMsg-win').destroy();
         	}
         }],
         items: [{
         	xtype: 'form',
             id: 'cpform',
				frame: true,
				border: false,
				labelWidth: 80,
				bodyStyle:'padding:15px;',
             defaults: {
                 msgTarget: 'side',
                 margin: '15 15 15 15'
             },
             items: [{
             	xtype: 'textfield',
                 name: 'user.userPsw',
                 inputType : 'text',
                 fieldLabel: '姓名',
                 allowBlank: false,
                 blankText: '机构名称不能为空',
                 anchor:'80%',
                 style : {
						marginBottom : '10px'
					}
             }, {
             	xtype: 'textfield',
                 name: 'newUserPsw',
                 id: 'newPsw',
                 fieldLabel: '个人主页',
                 inputType : 'text',
                 allowBlank: false,
                 blankText: '机构名称不能为空',
                 anchor:'80%',
                 style : {
						marginBottom : '10px'
					}
             }, {
             	xtype: 'textfield',
                 name: 'newUserPsw',
                 id: 'newPsw',
                 fieldLabel: '职称',
                 inputType : 'text',
                 allowBlank: false,
                 blankText: '机构名称不能为空',
                 anchor:'80%',
                 style : {
						marginBottom : '10px'
					}
             },{
             	xtype: 'label',
                name: 'tip',
                text: '密码不得少于8位，且必须包含字母数字'
            }]
         }]
		}).show();
	}
});

var themes=[
    [0,'默认风格','ext-all'],
    [1,'深蓝风格','xtheme-slate'],
    [2,'黑色风格','xtheme-black'],
    [3,'银白风格','xtheme-gray'],
    [4,'绿色风格','xtheme-olive'],
    [5,'灰色风格','xtheme-darkgray'],
    [6,'紫色风格','xtheme-purple'],
    [7,'靛蓝风格','xtheme-indigo'],
    [8,'红粉风格','xtheme-pink'],
    [9,'黑漆风格','xtheme-midnight'],
    [10,'vista黑色风格','xtheme-vistablack'],
    [11,'vista蓝色风格','xtheme-vistablue'],
    [12,'vista透明风格','xtheme-vistaglass'],
    [13,'灰色extend风格','xtheme-gray-extend'],
    [14,'银红风格','xtheme-silverCherry']
]
var themeCss = 'ext-all';
var themeCf = 'ext-all';
var themeBtn = new Ext.Button({
			text : '更换主题',
			handler: function() {
				new Ext.Window({
					id: 'changetheme-win',
		            title: '更换',
		            height: 150,
		            width: 300,
		            minWidth: 150,
		        	minHeight: 80,
		            layout: 'fit',
		            modal: true,
		            border: false,
		            buttonAlign: 'center',
		            buttons: [{
		            	text: '确定',
		            	handler: function changefirm(combo, record, index){
		            		//comboT = Ext.getCmp('themecom');
		            		//themeCss = comboT.getValue();
                        	//Ext.util.CSS.swapStyleSheet('window', 'extjs/resources/css/' + themeCss +'.css');
		            		themeCf = themeCss;

                    		Ext.util.CSS.swapStyleSheet('window', 'extjs/resources/css/' + themeCf +'.css');
                    		//var ss = $(window.frames["newsTabIf"].document);
                    		//document.getElementById('newsTabIf').sss();
                    		//newsTabIf.window.sss();
                    		//document.getElementById('newsTabIf').sss();
                    		Ext.getCmp('changetheme-win').destroy();
                    	}
		            }, {
		            	text: '取消',
		            	handler: function() {
		            		Ext.util.CSS.swapStyleSheet('window', 'extjs/resources/css/' + themeCf +'.css');
		            		Ext.getCmp('changetheme-win').destroy();
		            	}
		            }],
		            items: [{
		            	xtype: 'form',
		            	frame: true,
		            	items: [{
			            	xtype: 'combo',
			            	id: 'themecom',
			            	fieldLabel: '选择主题',
			                store: new Ext.data.SimpleStore({
			                    fields: ['id', 'theme-view','theme-value'],
			                    data: themes
			                }),
			                defaults: {
		                    msgTarget: 'side',
		                    	margin: '15 15 15 15'
		               		},

			                width: 120,
			                editable: false,
			                displayField: 'theme-view',
			                name: 'change_theme',
			                editable:false,
			                //typeAhead: true,
			                //value:'默认风格',
			                mode: 'local',
			                valueField:'theme-value',
			                triggerAction: 'all',
			                selectOnFocus: true,
			                listeners: {
			                    select: function(combo, record, index){
			                    	comboT = Ext.getCmp('themecom');
			            			themeCss = comboT.getValue();
	                        		Ext.util.CSS.swapStyleSheet('window', 'extjs/resources/css/' + themeCss +'.css');
			                    },
			                    afterrender: function() {
			                    	Ext.getCmp('themecom').setValue(themeCss);
			                    }
			                }
		                }]
		            }]
				}).show();
			}
		});

var pswBtn = new Ext.Button({
			text : '更改密码',
			handler: function() {
				new Ext.Window({
					id: 'changePsw-win',
		            title: '修改密码',
		            height: 300,
		            width: 350,
		            minWidth: 180,
		        	minHeight: 230,
		            layout: 'fit',
		            modal: true,
		            border: false,
		            buttonAlign: 'center',
		            buttons: [{
		            	text: '确认',
		             	handler: function() {
		             		
		             		var pswform = Ext.getCmp('cpform').getForm();
		             		var original_pwd = Ext.getCmp('original_pwd').getValue();

		             		var new_pwd=Ext.getCmp('newPsw').getValue();
	
		             		if(original_pwd==new_pwd){
		             			Ext.Msg.alert('信息', '原始密码与现在密码不能重复');
		             			Ext.getCmp('cpform').getForm().reset();
		             		}else{
		                 		if(pswform.isValid()) {
		                 			alert(userName);
		                 			pswform.submit({
		                                 waitMsg: '正在更新密码',
		                                 url: 'userAction!updatePsw',
		                                 method: 'POST',
		                                 params: {
		                                 	'user.userName': userName
		                                 },
		                                 success: function(form, action){
		                                     if(action.result.success == 'error') {
		                                     	Ext.Msg.alert('信息', '原始密码错误');
		                                     }
		                                     else{
		                                     	Ext.Msg.alert('信息', '更新成功，自动跳转到登陆界面，请重新登陆');
		                                     	Ext.getCmp('changePsw-win').destroy();
		        	                                window.setTimeout(
		        	                                	function() {
		        	                                		location.href='index.jsp'
		        	                                	},2000);
		                                     }
		                                 },
		                                 failure: function(form, action){
		                                     Ext.Msg.alert('信息', '更新失败');
		                                 }
		                             })
		                 		
		                 	}
		             			
		             		}
		             		
		             	}
		            }, {
		            	text: '重置',
		            	handler: function() {
		            		Ext.getCmp('cpform').getForm().reset();
		            	}
		            }, {
		            	text: '取消',
		            	handler: function() {
		            		Ext.getCmp('changePsw-win').destroy();
		            	}
		            }],
		            items: [{
		            	xtype: 'form',
		                id: 'cpform',
						frame: true,
						border: false,
						labelWidth: 80,
						bodyStyle:'padding:15px;',
		                defaults: {
		                    msgTarget: 'side',
		                    margin: '15 15 15 15'
		                },
		                items: [{
		                	xtype: 'textfield',
		                    name: 'user.userPsw',
		                    id:'original_pwd',
		                    inputType : 'password',
		                    fieldLabel: '原始密码',
		                    allowBlank: false,
		                    blankText: '原始密码不能为空',
		                    anchor:'80%',
		                    style : {
								marginBottom : '10px'
							}
		                }, {
		                	xtype: 'textfield',
		                    name: 'newUserPsw',
		                    id: 'newPsw',
		                    fieldLabel: '新的密码',
		                    inputType : 'password',
		                    regex : /^(([0-9]+[a-zA-Z]+)|([a-zA-Z]+[0-9]+))$/,
		                    regexText : '对不起，用户密码必须同时包含字母和数字！',
		                    minLengthText: 8,
		                    allowBlank: false,
		                    blankText: '新的密码',
		                    anchor:'80%',
		                    style : {
								marginBottom : '10px'
							}
		                }, {
		                	xtype: 'textfield',
		                    name: 'pswconfirm',
		                    fieldLabel: '确认新的密码',
		                    inputType : 'password',
		                    vtype : 'confirmPsw',
							vtypeText : '两次输入的密码不一致！',
							confirmTo : 'newPsw',
		                    allowBlank: false,
		                    blankText: '确认新的密码不能为空',
		                    anchor:'80%'
		                },{
		                	xtype: 'label',
		                    name: 'tip',
		                    text: '密码不得少于8位，且必须包含字母数字'
		                }]
		            }]
				}).show();
			}
		});

var sysConfigBtn = new Ext.Button({
			text : '界面设置',
			handler: function() {
				//alert(userName);
				//window.location.href = "index.jsp";
				$.ajax({
				 		type: 'POST',
						url : 'userAction!configIndex',
						data: "userName="+userName,
						async : false
				});
				window.location.href = "index.jsp";
			}
		});

var returnIndexBtn = new Ext.Button({
			text: '返回主网站',
			handler: function(){
				$.ajax({
				 		type: 'POST',
						url : 'userAction!returnIndex',
						//data: "userName="+userName,
						async : false
				});
				window.location.href = "index.jsp";
			}
		});

Ext.ux.topPanel = Ext.extend(Ext.Panel, {
			html : '<img src="images/bgtop.jpg" border="0" height="100%" width="100%"/>',
			border : false,
			height : 104,
			initComponent : function() {
				this.bbar = {
					xtype : 'statusbar',
					id : 'basic-statusbar',
					border : false,
					defaultText : 'Default status text',
					text : topTitle,
					items : [logoutBtn, '-', returnIndexBtn, '-', pswBtn, '-', themeBtn, '-',
							clock, ' ']
				};
				this.listeners = {
					render : {
						fn : function() {
							Ext.fly(clock.getEl().parent())
									.addClass('x-status-text-panel')
									.createChild({
												cls : 'spacer'
											});
							Ext.TaskMgr.start({
										run : function() {
											Ext.fly(clock.getEl())
													.update(new Date()
															.format('g:i:s A'));
										},
										interval : 1000
									});
						},
						delay : 100
					}
				};
				Ext.ux.topPanel.superclass.initComponent.call(this);
			}
		});
Ext.reg('topPanel', Ext.ux.topPanel);