/**
 * 
 */

Ext.onReady(function() {
	Ext.QuickTips.init();
	new Ext.Viewport({
				layout : 'border',
				items : [{
					region : 'north',
					xtype: 'topPanel'
				}, {
					region : 'west',
					xtype: 'panel',
					border: false,
					id : 'feature-panel',
					title : '功能列表',
					split : true,
					animate : true,
					width : 250,
					minWidth : 175,
					maxWidth : 400,
					collapsible : true,
					animCollapse : true,
					margins : '0 0 0 5',
					layout : 'accordion',
					listeners: {
                		'afterrender': {
                			fn: addFeature
							//scope: this
                		}
            		}
				}, {
					region : 'center',
					xtype : 'cenPanel',
					listeners: {
						beforeremove: function(tabs,tab) {
							this.hideTabStripItem(tab.hide());
							return false;
						}
					}
					/*
					listeners: {
                		'afterrender': {
                			fn: addModule,
							scope: this
                		}
            		}
            		*/
				}, {
					region : 'south',
					border : false,
					margins : '5 0 0 0',
					html : '<img src="images/bgbuttom.jpg" height="100%" width="100%"/>',
					height : 30
				}]
			});
	
	function addFeature() {
		for(i = 0; i < moduleCode_a.length; i++) {
			//alert(moduleCode_a[i]);
			Ext.getCmp('feature-panel').add(eval(moduleCode_a[i]));
		}
	}
	/*
	function addModule() {
		for(i = 0; i < featureTab_a.length; i++) {
			Ext.getCmp('cenPanel').add(eval(featureTab_a[i]));
		}
	}
	*/
});