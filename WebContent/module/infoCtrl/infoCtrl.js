/**
 *
 */
var infoWinU;
var tchIdT;
var picUp = 0;
var picPath = "";
var picPath_dt = "";

Ext.onReady(function() {
	var themeCssS = parent.themeCss;
	Ext.util.CSS.swapStyleSheet('window', '../../extjs/resources/css/' + themeCssS +'.css');
	Ext.QuickTips.init();



	var infoPageStore = new Ext.data.GroupingStore({
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
                }, {
                	name: 'tchHomepage',
                	mapping: 'tchHomepage'
                }, {
                	name: 'tchInfo',
                	mapping: 'tchInfo'
                }, {
                	name: 'tchImage',
                	mapping: 'tchImage'
                },{
                	name:'tchEngInfo',
                	magpping:'tchEngInfo'
                }]
	        }),
            baseParams:{
            	tchAbbr:parent.userName,
            },
            groupField:'tchOrg',
	        url: 'tchAction!queryTchesByAbbr',
	        autoLoad: true
	    });

    Ext.ux.infoCtrl = Ext.extend(Ext.grid.GridPanel,{
    	id: 'infoCtrl-grid',
   

        listeners: {
	    	'rowclick' : function rowclick(){
	        	var infoManage = Ext.getCmp('infoCtrl-grid'); 		
	    		var publishBtn = Ext.getCmp('updateInfo');
	    		publishBtn.setDisabled(false);
	    		infoManage.removeListener('rowclick',rowclick);
	    	}
	    },
	    ds: infoPageStore,
	    cm: new Ext.grid.ColumnModel([
         	{
                header: '教师ID',
                dataIndex: 'teacherId',
                sortable: true
               
            }, {
                header: '教师姓名',
                dataIndex: 'tchName',
                sortable: true

            }, {
            	header: '教师性别',
                dataIndex: 'tchGender',
                sortable: true

         	}, {
         		header: '教师编号',
                dataIndex: 'tchNumber',
                sortable: true
 
         	}, {
         		header: '教师职称',
                dataIndex: 'tchTitle',
                sortable: true

         	}, {
         		header: '学院职务',
                dataIndex: 'tchDuty',
                sortable: true,
                width: 100
        
         	}, {
         		header: '机构职务',
                dataIndex: 'tchOrgDuty',
                sortable: true,
        		width: 100
         	}, {
         		header: '学历',
                dataIndex: 'tchDegree',
                sortable: true
    
         	}, {
         		header: '所属机构',
         		width: 130,
        		dataIndex: 'tchOrg',
                sortable: true
        
         }]),
		 view: new Ext.grid.GroupingView({
            forceFit:true,
            groupTextTpl: '{text}'
         }),
         initComponent : function() {

         	this.tbar = {
                xtype: 'toolbar',
                items: [ {
                    text: '修改介绍',
                    iconCls: 'update',
                    handler: updateInfo,
                    id: 'updateInfo',
                    disabled: true
                }]
            };

			Ext.ux.infoCtrl.superclass.initComponent.call(this);
         }
    });

	Ext.reg('infoInCtrl', Ext.ux.infoCtrl);
	new Ext.Viewport({
		renderTo:Ext.getBody(),
		layout : 'border',
		items:[{
			xtype:'infoInCtrl',
			region:'center'
		}]
	}).show();

});

function updateInfo() {
	if(infoWinU != null) {
		winUpset();
		winLoad()
		infoWinU.show();
	}
	else {

	infoWinU = new  Ext.Window({
			id: 'updateInfo-win',
			closeAction: 'hide',
	        title: '修改简介',
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
					
					
		
            		var form = Ext.getCmp('updateInfo-form').getForm();
            	
            		
            			var ppp = new String();
            			
            			ppp = Ext.getCmp('tchImageUp').text;
            		
            			if(ppp.charAt(0)=='/'){
            				ppp = ppp;
            			}else if(ppp.charAt(6)=='/'){
            				ppp = ppp;
            			}else{
            				ppp = '/upload/teachers/'+ppp;
            			}
            			
						Ext.Ajax.request({
		                    	waitMsg: '正在添加',
								url: 'tchAction!updateTchInfo',
								params:{
									'tchId': tchIdT,		                      	                            
	                            	'tchInfo': KE.html('tchInfoUp'),
	                            	'tchEngInfo': KE.html('tchEngInfoUp'),
	                            	'tchImage':ppp,
	            					'tchName':Ext.getCmp('tchNameUp').getValue(),
	            					'tchGender':Ext.getCmp('tchGenderUp').getValue(),
	            					'tchDegree':Ext.getCmp('tchDegreeUp').getValue(),
	            					'tchTitle':Ext.getCmp('tchTitleUp').getValue(),
								
	                          
		                        },
								success: function(form, action){
		                            Ext.Msg.alert('信息', '更新成功');
		                          
		                            infoWinU.hide();
		                            Ext.getCmp('infoCtrl-grid').getStore().reload();
		                        },
		                        failure: function(form, action){
		                            Ext.Msg.alert('信息', '更新失败');
		                        }
							});
                    
             
				}
				
	        },{
				text: '取消'	,
				handler: function() {
            		infoWinU.hide();
            	}
				
	        }],
	        items: [{
            	xtype: 'form',
                id: 'updateInfo-form',
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
                	fieldLabel: '姓名',
                	id: 'tchNameUp',
                    xtype: 'textfield',
            		allowBlank: false,
            		blankText: '教师姓名不能为空'
                },{
                	fieldLabel: '性别',
                	id: 'tchGenderUp',        
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

                },{
                	fieldLabel: '职称',
                	id: 'tchTitleUp',           
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
        
                },{
                	fieldLabel: '学历',
                	id: 'tchDegreeUp',             
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
                },{
                	fieldLabel: '个人照片',
                	id: 'picSet',
                	xtype:'fieldset',
                	items: [{
	                    	xtype: 'label',
	                    	id: 'tchImageUp',
	                    	fieldLabel: '照片地址(请上传1M以下的照片)'
	                    	
	                }],
                	buttons: [{
                    		id: 'PRBtn',
                    		text:'上传照片',
                    		handler: function() {
                    			new Ext.Window({
								    width : 650,
								    title : '图片上传',
								    height : 300,
								    layout : 'fit',
								    items : [{
								            xtype : 'uploadPanel',
								            border : false,
								            id: 'picUp',
								            fileSize : 1024*50,//限制文件大小
								            uploadUrl : 'uploadAction!uploadAttach',
								            flashUrl : '../../extjs/ux/swfupload/swfupload.swf',
								            filePostName : 'attach', //后台接收参数
								            fileTypes : '*.jpg;*.png',//可上传文件类型
								            postParams : {savePath:'upload\\teachers\\'} //上传文件存放目录
								     }],
								     listeners:{
									     	beforeclose: function() {
									     		isPicUp();
									     		showPic();
									     	
									     	}
									     }
									}).show();

								
                    		}
                    }]

     
                }, {
                	
                	anchor: '94%',
                	fieldLabel: '个人简介',
                    id: 'tchInfoUp',
                    xtype: 'textarea',
                    height: 350
                }, {
                	
                	anchor: '94%',
                	fieldLabel: '个人英文简介',
                    id: 'tchEngInfoUp',
                    xtype: 'textarea',
                    height: 350
                }],
                listeners: {
	            	'render' : function(){
		                KE.show({
		                    id:'tchInfoUp',
		                    imageUploadJson: '../../jsp/upload_json.jsp',
		                    fileManagerJson: '../../jsp/file_manager_json.jsp'
		                });
		                setTimeout("KE.create('tchInfoUp');", 100);
		                KE.show({
		                    id:'tchEngInfoUp',
		                    imageUploadJson: '../../jsp/upload_json.jsp',
		                    fileManagerJson: '../../jsp/file_manager_json.jsp'
		                });
		                setTimeout("KE.create('tchEngInfoUp');", 100);
		            }
				}

			}]
		}).show();
		winLoad();
	}
}
function winLoad() {
	var updateForm = Ext.getCmp('updateInfo-form').getForm();
	var infoGrid = Ext.getCmp('infoCtrl-grid');
	var sm = infoGrid.getSelectionModel();
	var store = Ext.getCmp('infoCtrl-grid').getStore();
	var record = sm.getSelected();
	tchIdT =  encodeURIComponent(record.data.teacherId);
	if(updateForm) {
		Ext.lib.Ajax.request(
			'post',
			'tchAction!queryTchById',
			{
				success: function(response) {
					var data = Ext.decode(response.responseText);
					tchIdT = data.tch.teacherId;
					var tchNameT = data.tch.tchName;
					var tchImageT = data.tch.tchImage;
					var tchInfoT = data.tch.tchInfo;
					var tchEngInfoT = data.tch.tchEngInfo;
					var tchBirthDateT = data.tch.tchBirthDate;
					var tchGenderT = data.tch.tchGender;
					var tchDegreeT = data.tch.tchDegree;
					var tchTitleT = data.tch.tchTitle;
				
					Ext.getCmp('tchNameUp').setValue(tchNameT);
					Ext.getCmp('tchImageUp').setText(tchImageT);
					Ext.getCmp('tchGenderUp').setValue(tchGenderT);
					Ext.getCmp('tchDegreeUp').setValue(tchDegreeT);
					Ext.getCmp('tchTitleUp').setValue(tchTitleT);
					KE.html('tchInfoUp', tchInfoT);
					KE.html('tchEngInfoUp', tchEngInfoT);
					
				},
				failure: function() {
					Ext.Msg.alert('失败','初始化数据失败');
				}
			},
			'tchId=' + encodeURIComponent(record.data.teacherId)
		);
	}
}
function winUpset() {
	Ext.getCmp('updateInfo-form').getForm().reset();
    Ext.getCmp('tchImageUp').setText("");
	
	KE.html('tchInfoUp','');
	KE.html('tchEngInfoUp','');
}
function isPicUp() {
	var picUpload = Ext.getCmp('picUp').getComponent('gp').getStore().getAt(0);
	if(picUpload) {
		picUp = 1;
	}
}
function showPic() {
	var aStore = Ext.getCmp('picUp').getComponent('gp').getStore();
	var picInfo = Ext.getCmp('tchImageUp');
	var picSet = Ext.getCmp('picSet');
	var PRBtn = Ext.getCmp('PRBtn');
	var count = aStore.getCount();
	picPath = "";

	for(i = 0; i < count; i++) {
		var rec = aStore.getAt(i);

		picPath = picPath + rec.data.name + ',';
		picPath_dt = '' + picPath_dt + "1" + ',';
	}
	picPath = picPath.substring(0, picPath.length - 1);
	picPath_dt = picPath_dt.substring(0, picPath_dt.length - 1);
	picInfo.setText(picPath);

	if(count != 0) {
		picSet.remove(PRBtn,false);
		PRBtn.setVisible(false);
		picSet.doLayout();

	}
}

