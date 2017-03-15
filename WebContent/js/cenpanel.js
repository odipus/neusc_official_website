var heightIf = $(window).height() - 170;
var widthIf = $(window).width() - 250;
var subSignId = "";

Ext.ux.cenPanel = Ext.extend(Ext.TabPanel, {
	activeTab : 0,
	id : 'cenPanel',
	initComponent : function() {
		this.items = [{
			title: '首页',
			id: 'welcome',
			html: '<img src="images/bgcen.jpg" width="100%" height="100%"/>'
		}];
		Ext.ux.cenPanel.superclass.initComponent.call(this);
	}
});

Ext.reg('cenPanel', Ext.ux.cenPanel);

//var prepanel = Ext.getCmp('cenPanel');
//alert($(window).height());
//alert(screen.width);

userCTab = new Ext.Panel({
			id : 'userCTab',
			title:'用户管理',
			closable: true,
			//html : ' <iframe id="userTabIf" name="userTabIf" width="100%"  onload="this.height=userTabIf.document.body.scrollHeight" id="sd" src="module/sysCtrl/userCtrl.html"  frameborder="0"></iframe>'
			html : ' <iframe id="userTabIf" name="userTabIf" width="100%" height="100%" marginwidth="0" src="module/sysCtrl/userCtrl.html" marginheight="0" frameborder="0" scrolling="no"></iframe>'
		});
roleCTab = new Ext.Panel({
			id : 'roleCTab',
			title:'角色管理',
			closable: true,
			html : ' <iframe id="roleTabIf" name="roleTabIf" width="100%" height="100%" src="module/sysCtrl/roleCtrl.html"  frameborder="0" ></iframe>'
		});
newsCTab = new Ext.Panel({
			id : 'newsCTab',
			title:'新闻管理',
			closable: true,
			html: ' <iframe id="newsTabIf" name="newsTabIf" width="100%" height="100%" src="module/newsCtrl/newsCtrl.html"  frameborder="0"></iframe>'
		});
sectionCTab = new Ext.Panel({
			id : 'sectionCTab',
			title:'栏目管理',
			closable : true,
			html : ' <iframe id="sectionTabIf" name="sectionTabIf" width="100%" height="100%" src="module/sectionCtrl/sectionCtrl.html"  frameborder="0"></iframe>'
		});
orgCTab = new Ext.Panel({
			id : 'orgCTab',
			title:'机构管理',
			closable: true,
			html : ' <iframe id="orgTabIf" name="orgTabIf" width="100%" height="100%" src="module/orgCtrl/orgCtrl.html"  frameborder="0"></iframe>'
		});
tchCTab = new Ext.Panel({
			id : 'tchCTab',
			title:'教师管理',
			closable: true,
			html : ' <iframe  id="tchTabIf" name="tchTabIf" width="100%" height="100%" src="module/tchCtrl/tchCtrl.html"  frameborder="0"></iframe>'
		});
subCTab = new Ext.Panel({
			id : 'subCTab',
			title:'子网站管理',
			closable: true,
			html : ' <iframe  id="subTabIf" name="subTabIf" width="100%" height="100%" src="module/subCtrl/subCtrl.html"  frameborder="0"></iframe>'
		});
infoCTab = new Ext.Panel({
	id : 'infoCTab',
	title:'个人信息管理',
	closable: true,
	html : ' <iframe  id="infoTabIf" name="infoTabIf" width="100%" height="100%" src="module/infoCtrl/infoCtrl.html"  frameborder="0"></iframe>'
});
pageCTab = new Ext.Panel({
	id : 'pageCTab',
	title:'资料页管理',
	closable: true,
	html : ' <iframe  id="pageTabIf" name="pageTabIf" width="100%" height="100%" src="module/pageCtrl/pageCtrl.html"  frameborder="0"></iframe>'
});
engCTab = new Ext.Panel({
	id : 'engCTab',
	title:'英文新闻管理',
	closable: true,
	html : ' <iframe  id="engTabIf" name="engTabIf" width="100%" height="100%" src="module/engCtrl/engCtrl.html"  frameborder="0"></iframe>'
});
shenCTab = new Ext.Panel({
	id : 'shenCTab',
	title:'英文新闻审核',
	closable: true,
	html : ' <iframe  id="shenTabIf" name="shenTabIf" width="100%" height="100%" src="module/engCtrl/engCtrl.html"  frameborder="0"></iframe>'
});
engpageCTab = new Ext.Panel({
	id : 'engpageCTab',
	title:'英文页面管理',
	closable: true,
	html : ' <iframe  id="engpageTabIf" name="engpageTabIf" width="100%" height="100%" src="module/engpageCtrl/engpageCtrl.html"  frameborder="0"></iframe>'
});