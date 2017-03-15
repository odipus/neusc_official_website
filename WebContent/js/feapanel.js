sysCtrl = new Ext.tree.TreePanel({
	title: '系统管理',
	id: "sysCtrl",
	iconCls: 'sysCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root : new Ext.tree.AsyncTreeNode({
			children : [{
						text : '用户管理',
						iconCls : 'feed-icon',
						leaf : true,
						id : 'userCtrl',
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,sysCtrl.id);
							}
						}
					}, {
						text : '角色管理',
						iconCls : 'feed-icon',
						leaf : true,
						id : 'roleCtrl',
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,sysCtrl.id);
							}
						}
					}]
		}),
	rootVisible: false
});

newsCtrl = new Ext.tree.TreePanel({
	title: '新闻管理',
	id: "newsCtrl",
	iconCls: 'newsCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '新闻管理',
						iconCls : 'feed-icon',
						leaf : true,
						id : 'newsCtrl',
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,newsCtrl.id);
							}
						}
					}]
		}),
    rootVisible: false
});

sectionCtrl = new Ext.tree.TreePanel({
	title: '栏目管理',
	id: "sectionCtrl",
	collapsible:true,
	iconCls: 'sectionCtrl',
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '栏目管理',
						iconCls : 'feed-icon',
						id : 'sectionCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,sectionCtrl.id);
							}
						}
					}]
		}),
    rootVisible: false
});

orgCtrl = new Ext.tree.TreePanel({
	title: '机构管理',
	id: "orgCtrl",
	iconCls: 'orgCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '机构管理',
						iconCls : 'feed-icon',
						id : 'orgCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,orgCtrl.id);
							}
						}
					}]
		}),
    rootVisible: false
});

tchCtrl = new Ext.tree.TreePanel({
	title: '教师管理',
	id: "tchCtrl",
	iconCls: 'tchCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '教师管理',
						iconCls : 'feed-icon',
						id : 'tchCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,tchCtrl.id);
							}
						}
					}]
		}),
    rootVisible: false
});

subCtrl = new Ext.tree.TreePanel({
	title: '子网站管理',
	id: "subCtrl",
	iconCls: 'subCtrl',
	collapsible:true,
	split: true,
	lines: false,
    loader: new Ext.tree.TreeLoader({
        		dataUrl: 'authPrivilegeAction!feaSubTree',
        		baseParams: {
        			'roleId': roleId
        		},
        		listeners : {
					load : function() {
						var subRoot = Ext.getCmp('subCtrl').getRootNode();
						subRoot.eachChild(function(){
							//this.text;
							this.addListener('click',function(){
								loadSub(this.text,this.id);
							});
						});
					}
				}
        	}),
	root: new Ext.tree.AsyncTreeNode({
			  id: 'root',
			  text: 'sss'
		  }),
    rootVisible: false
});

var upperId;
pageCtrl = new Ext.tree.TreePanel({
	title: '资料页管理',
	id: "pageCtrl",
	iconCls: 'powerF',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '公共页管理',
						iconCls : 'feed-icon',
						id : '1001Ctrl',
						leaf : true,
						listeners : {
							click : function() {
								loadPage(this.text,this.id);
							}
						}
			},{
							text : '大事记管理',
							iconCls : 'feed-icon',
							id : '1002Ctrl',
							leaf : true,
							listeners : {
								click : function() {
									loadPage(this.text,this.id);
								}
							}
				},{
					text : '本科生专业管理',
					iconCls : 'feed-icon',
					id : '1003Ctrl',
					leaf : true,
					listeners : {
						click : function() {
							loadPage(this.text,this.id);
						}
					}
				},{
					text : '研究生专业管理',
					iconCls : 'feed-icon',
					id : '1004Ctrl',
					leaf : true,
					listeners : {
						click : function() {
							loadPage(this.text,this.id);
						}
					}
				},{
								text : '研究室管理',
								iconCls : 'feed-icon',
								id : '1005Ctrl',
								leaf : true,
								listeners : {
									click : function() {
										loadPage(this.text,this.id);
									}
								}
			},{
									text : '联合实验室管理',
									iconCls : 'feed-icon',
									id : '1006Ctrl',
									leaf : true,
									listeners : {
										click : function() {
											loadPage(this.text,this.id);
										}
									}
			},{
										text : '工程中心管理',
										iconCls : 'feed-icon',
										id : '1007Ctrl',
										leaf : true,
										listeners : {
											click : function() {
												loadPage(this.text,this.id);
											}
										}
					},{
						text : '常用资料下载管理',
						iconCls : 'feed-icon',
						id : '1111Ctrl',
						leaf : true,
						listeners : {
							click : function() {
								loadDoc();
							}
						}
					}]
		}),
    rootVisible: false
});

engCtrl = new Ext.tree.TreePanel({
	title: '英文新闻管理',
	id: "engCtrl",
	iconCls: 'infoCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '新闻翻译',
						iconCls : 'feed-icon',
						id : 'transCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadTrans();
							}
						}
					},{
						text : '新闻管理',
						iconCls : 'feed-icon',
						id : 'engCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadEng();
							}
						}
					}]
		}),
    rootVisible: false
});


shenCtrl = new Ext.tree.TreePanel({
	title: '英文新闻审核',
	id: "shenCtrl",
	iconCls: 'infoCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
				text : '新闻审核',
				iconCls : 'feed-icon',
				id : 'checkCtrl',
				leaf : true,
				listeners : {
					click : function() {
						loadCheck();
					}
				}
			}]
			
			}),
		    rootVisible: false
});

engpageCtrl = new Ext.tree.TreePanel({
	title: '英文资料页管理',
	id: "engpageCtrl",
	iconCls: 'powerF',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '公共页管理',
						iconCls : 'feed-icon',
						id : '1000ECtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadEngPage(this.text,this.id);
							}
						}
			},{
							text : '专业信息管理',
							iconCls : 'feed-icon',
							id : '1002ECtrl',
							leaf : true,
							listeners : {
								click : function() {
									loadEngPage(this.text,this.id);
								}
							}
				},{
					text : 'Admissions',
					iconCls : 'feed-icon',
					id : '1005ECtrl',
					leaf : true,
					listeners : {
						click : function() {
							loadEngPage(this.text,this.id);
						}
					}
		}
			]
		}),
    rootVisible: false
});

infoCtrl = new Ext.tree.TreePanel({
	title: '个人信息管理',
	id: "infoCtrl",
	iconCls: 'infoCtrl',
	collapsible:true,
	split: true,
	lines: false,
    root: new Ext.tree.AsyncTreeNode({
			children : [{
						text : '个人信息管理',
						iconCls : 'feed-icon',
						id : 'infoCtrl',
						leaf : true,
						listeners : {
							click : function() {
								loadPanel(this.text,this.id,infoCtrl.id);
							}
						}
					}]
		}),
    rootVisible: false
});

function loadPanel(_name, _id, _link) {
	var tabId = _id.substring(0, _id.length-3) + 'Tab';
	var centerPanel = Ext.getCmp("cenPanel");
	var tab = centerPanel.getItem(tabId);

	var newTab = eval(tabId);
    if(!tab) {
    	centerPanel.add(newTab);
    
        centerPanel.setActiveTab(newTab);
    } else {
    	centerPanel.unhideTabStripItem(tab.show());

    }
}

function loadPage(pageText,pageName) {

	var pageTab = pageName.substring(0, pageName.length - 3)+"CTab";
	pageName = pageName.substring(0, pageName.length - 4);
	upperId = pageName;

	var pageCTab = new Ext.Panel({
			id : pageTab,
			title: pageText,
			closable: true,
			html : ' <iframe  id="'+ pageName +'" name="'+ pageName +'" width="'+ widthIf +'" height="'+ heightIf +'" src="module/pageCtrl/pageCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(pageCTab);
	if(!tab){
		cenzPanel.add(pageCTab);
		cenzPanel.setActiveTab(pageCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}

function loadEngPage(engpageText,pageName) {

	var engpageTab = pageName.substring(0, pageName.length - 5)+"ECTab";
	var engpageName = pageName.substring(0, pageName.length - 5)+"E";
	upperId =  pageName.substring(0, pageName.length - 5);
	
	var engpageCTab = new Ext.Panel({
			id : engpageTab,
			title: engpageText,
			closable: true,
			html : ' <iframe  id="'+ engpageName +'" name="'+ engpageName +'" width="'+ widthIf +'" height="'+ heightIf +'" src="module/engpageCtrl/engpageCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(engpageCTab);
	if(!tab){
		cenzPanel.add(engpageCTab);
		cenzPanel.setActiveTab(engpageCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}

function loadSub(newText,newId) {
	subSignId = newId.substring(0, newId.length - 3);
	var subCTabId = 'subCTab'+newId;
	var subIfId = 'subTab' + newId + 'If';
	var subCTab = new Ext.Panel({
			id : subCTabId,
			title: newText,
			closable: true,
			html : ' <iframe  id="'+ subIfId +'" name="'+ subIfId +'" width="'+ widthIf +'" height="'+ heightIf +'" src="module/subCtrl/subCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(subCTabId);
	if(!tab){
		cenzPanel.add(subCTab);
		cenzPanel.setActiveTab(subCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}



function loadDoc() {
	var docCTab = new Ext.Panel({
			id : "docCTab",
			title: "常用资料下载管理",
			closable: true,
			html : ' <iframe  id="docCtrl" name="docCtrl" width="'+ widthIf +'" height="'+ heightIf +'" src="module/pageCtrl/docCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(docCTab);
	if(!tab){
		cenzPanel.add(docCTab);
		cenzPanel.setActiveTab(docCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}

function loadTrans() {
	var transCTab = new Ext.Panel({
			id : "transCTab",
			title: "新闻翻译",
			closable: true,
			html : ' <iframe  id="transCtrl" name="transCtrl" width="'+ widthIf +'" height="'+ heightIf +'" src="module/engCtrl/transCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(transCTab);
	if(!tab){
		cenzPanel.add(transCTab);
		cenzPanel.setActiveTab(transCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}

function loadEng() {
	var engCTab = new Ext.Panel({
			id : "engCTab",
			title: "新闻管理",
			closable: true,
			html : ' <iframe  id="engCtrl" name="engCtrl" width="'+ widthIf +'" height="'+ heightIf +'" src="module/engCtrl/engCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(engCTab);
	if(!tab){
		cenzPanel.add(engCTab);
		cenzPanel.setActiveTab(engCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}

function loadCheck() {
	var checkCTab = new Ext.Panel({
			id : "checkCTab",
			title: "新闻审核",
			closable: true,
			html : ' <iframe  id="checkCtrl" name="checkCtrl" width="'+ widthIf +'" height="'+ heightIf +'" src="module/engCtrl/checkCtrl.html"  frameborder="0"></iframe>'
	});
	var cenzPanel = Ext.getCmp("cenPanel");
	var tab = cenzPanel.getItem(checkCTab);
	if(!tab){
		cenzPanel.add(checkCTab);
		cenzPanel.setActiveTab(checkCTab);
	}
	else {
		cenzPanel.unhideTabStripItem(tab.show());
	}
}
