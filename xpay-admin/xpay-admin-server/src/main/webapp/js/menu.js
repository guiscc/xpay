var _menus;
$(function() {
//	tabClose();
//	tabCloseEven();

	// 导航菜单绑定初始化
	$("#wnav").accordion( {
		animate : false
	});
	clearnav();
	$.ajax({
		url : "sysMenu/getCurrentRoleMenus",
		method : "POST",
		contentType : "application/json",
		dataType : "json",
		async : false,
		success : function(data) {
			var ret = eval(data);
			if(ret.success){
				_menus = ret.data;
				addNav(_menus);
				initLeftMenu();
			}else{
				$.messager.alert('错误','功能菜单加载失败');
				return;
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.messager.alert('错误','登录超时即将跳转登录页面');
			window.setInterval(function(){window.location.href="login.html";}, 3000); 
		}
	});
});

function clearnav() {
	var pp = $('#wnav').accordion('panels');

	$.each(pp, function(i, n) {
		if (n) {
			var t = n.panel('options').title;
			$('#wnav').accordion('remove', t);
		}
	});

	pp = $('#wnav').accordion('getSelected');
	if (pp) {
		var title = pp.panel('options').title;
		$('#wnav').accordion('remove', title);
	}
}

function addNav(data) {

	$.each(data, function(i, sm) {
		var menulist = "";
		menulist += '<ul>';
		$.each(sm.children, function(j, o) {
			menulist += '<li><div><a ref="' + o.id + '" icon="' + o.icon + '" href="#" rel="'
					+ o.url + '" ><span class="icon ' + o.icon
					+ '" >&nbsp;</span><span class="nav">' + o.text
					+ '</span></a></div></li> ';
		});
		menulist += '</ul>';

		$('#wnav').accordion('add', {
			title : sm.text,
			content : menulist,
			iconCls : 'icon ' + sm.icon
		});

	});

	var pp = $('#wnav').accordion('panels');
	var t = pp[0].panel('options').title;
	$('#wnav').accordion('select', t);

}

// 初始化左侧
function initLeftMenu() {
	
	hoverMenuItem();

	
	$('#wnav li a').on('click', function() {
		var tabTitle = $(this).children('.nav').text();
		var url = $(this).attr("rel");
		var icon = 'icon '+$(this).attr("icon");

		addTab(tabTitle, url, icon);
		$('#wnav li div').removeClass("selected");
		$(this).parent().addClass("selected");
	});
}

/**
 * 菜单项鼠标Hover
 */
function hoverMenuItem() {
	$(".easyui-accordion").find('a').hover(function() {
		$(this).parent().addClass("hover");
	}, function() {
		$(this).parent().removeClass("hover");
	});
}

function addTab(subtitle, url, icon) {
	if (!$('#tabs').tabs('exists', subtitle)) {
		$('#tabs').tabs('add', {
			title : subtitle,
			content : createFrame(url),
			closable : true,
			icon : icon
		});
	} else {
		$('#tabs').tabs('select', subtitle);
		$('#mm-tabupdate').click();
	}
//	tabClose();
}

function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

//function tabClose() {
//	/* 双击关闭TAB选项卡 */
//	$(".tabs-inner").dblclick(function() {
//		var subtitle = $(this).children(".tabs-closable").text();
//		$('#tabs').tabs('close', subtitle);
//	});
//	/* 为选项卡绑定右键 */
//	$(".tabs-inner").bind('contextmenu', function(e) {
//		$('#mm').menu('show', {
//			left : e.pageX,
//			top : e.pageY
//		});
//
//		var subtitle = $(this).children(".tabs-closable").text();
//
//		$('#mm').data("currtab", subtitle);
//		$('#tabs').tabs('select', subtitle);
//		return false;
//	});
//}
//// 绑定右键菜单事件
//function tabCloseEven() {
//	// 刷新
//	$('#mm-tabupdate').click(function() {
//		var currTab = $('#tabs').tabs('getSelected');
//		var url = $(currTab.panel('options').content).attr('src');
//		$('#tabs').tabs('update', {
//			tab : currTab,
//			options : {
//				content : createFrame(url)
//			}
//		});
//	});
//	// 关闭当前
//	$('#mm-tabclose').click(function() {
//		var currtab_title = $('#mm').data("currtab");
//		$('#tabs').tabs('close', currtab_title);
//	});
//	// 全部关闭
//	$('#mm-tabcloseall').click(function() {
//		$('.tabs-inner span').each(function(i, n) {
//			var t = $(n).text();
//			$('#tabs').tabs('close', t);
//		});
//	});
//	// 关闭除当前之外的TAB
//	$('#mm-tabcloseother').click(function() {
//		$('#mm-tabcloseright').click();
//		$('#mm-tabcloseleft').click();
//	});
//	// 关闭当前右侧的TAB
//	$('#mm-tabcloseright').click(function() {
//		var nextall = $('.tabs-selected').nextAll();
//		if (nextall.length == 0) {
//			// msgShow('系统提示','后边没有啦~~','error');
//			alert('后边没有啦~~');
//			return false;
//		}
//		nextall.each(function(i, n) {
//			var t = $('a:eq(0) span', $(n)).text();
//			$('#tabs').tabs('close', t);
//		});
//		return false;
//	});
//	// 关闭当前左侧的TAB
//	$('#mm-tabcloseleft').click(function() {
//		var prevall = $('.tabs-selected').prevAll();
//		if (prevall.length == 0) {
//			alert('到头了，前边没有啦~~');
//			return false;
//		}
//		prevall.each(function(i, n) {
//			var t = $('a:eq(0) span', $(n)).text();
//			$('#tabs').tabs('close', t);
//		});
//		return false;
//	});
//
//	// 退出
//	$("#mm-exit").click(function() {
//		$('#mm').menu('hide');
//	});
//}

$(function(){
	var tabsId = 'tabs';//tabs页签Id
	var tab_rightmenuId = 'tab_rightmenu';//tabs右键菜单Id
	
	//绑定tabs的右键菜单
	$("#"+tabsId).tabs({
		onContextMenu:function(e,title){//这时去掉 tabsId所在的div的这个属性：class="easyui-tabs"，否则会加载2次
		  e.preventDefault();
		  if(title=="欢迎使用")return;
		  $('#'+tab_rightmenuId).menu('show',{  
			left: e.pageX,  
			top: e.pageY  
		  }).data("tabTitle",title);
		}
	});
	
	//实例化menu的onClick事件
	$("#"+tab_rightmenuId).menu({
		onClick:function(item){
		  CloseTab(tabsId,tab_rightmenuId,item.name);
		}
	});
});

/**
	tab关闭事件
	@param	tabId		tab组件Id
	@param	tabMenuId	tab组件右键菜单Id
	@param	type		tab组件右键菜单div中的name属性值
*/
function CloseTab(tabId,tabMenuId,type){
	//tab组件对象
	var tabs = $('#' + tabId);
	//tab组件右键菜单对象
	var tab_menu = $('#' + tabMenuId);
	
	//获取当前tab的标题
	var curTabTitle = tab_menu.data('tabTitle');
	
	//关闭当前tab
	if(type === 'tab_menu-tabclose'){
		//通过标题关闭tab
		tabs.tabs("close",curTabTitle);
	}
	
	//关闭全部tab
	else if(type === 'tab_menu-tabcloseall'){
		//获取所有关闭的tab对象
		var closeTabsTitle = getAllTabObj(tabs);
		//循环删除要关闭的tab
		$.each(closeTabsTitle,function(){
			var title = this;
			tabs.tabs('close',title);
		});
	}
	
	//关闭其他tab
	else if(type === 'tab_menu-tabcloseother'){
		//获取所有关闭的tab对象
		var closeTabsTitle = getAllTabObj(tabs);
		//循环删除要关闭的tab
		$.each(closeTabsTitle,function(){
			var title = this;
			if(title != curTabTitle){
				tabs.tabs('close',title);
			}
		});
	}
	
	//关闭当前左侧tab
	else if(type === 'tab_menu-tabcloseleft'){
		//获取所有关闭的tab对象
		var closeTabsTitle = getLeftToCurrTabObj(tabs,curTabTitle);
		//循环删除要关闭的tab
		$.each(closeTabsTitle,function(){
			var title = this;
			tabs.tabs('close',title);
		});
	}
	
	//关闭当前右侧tab
	else if(type === 'tab_menu-tabcloseright'){
		//获取所有关闭的tab对象
		var closeTabsTitle = getRightToCurrTabObj(tabs,curTabTitle);
		//循环删除要关闭的tab
		$.each(closeTabsTitle,function(){
			var title = this;
			tabs.tabs('close',title);
		});
	}
}

/**
	获取所有关闭的tab对象
	@param	tabs	tab组件
*/
function getAllTabObj(tabs){
	//存放所有tab标题
	var closeTabsTitle = [];
	//所有所有tab对象
	var allTabs = tabs.tabs('tabs');
	$.each(allTabs,function(){
		var tab = this;
		var opt = tab.panel('options');
		//获取标题
		var title = opt.title;
		//是否可关闭 ture:会显示一个关闭按钮，点击该按钮将关闭选项卡
		var closable = opt.closable;
		if(closable){
			closeTabsTitle.push(title);
		}
	});
	return closeTabsTitle;
}

/**
	获取左侧第一个到当前的tab
	@param	tabs		tab组件
	@param	curTabTitle	到当前的tab
*/
function getLeftToCurrTabObj(tabs,curTabTitle){
	//存放所有tab标题
	var closeTabsTitle = [];
	//所有所有tab对象
	var allTabs = tabs.tabs('tabs');
	for(var i=0;i<allTabs.length;i++){
		var tab = allTabs[i];
		var opt = tab.panel('options');
		//获取标题
		var title = opt.title;
		//是否可关闭 ture:会显示一个关闭按钮，点击该按钮将关闭选项卡
		var closable = opt.closable;
		if(closable){
			//alert('title' + title + '  curTabTitle:' + curTabTitle);
			if(title == curTabTitle){
				return closeTabsTitle;
			}
			closeTabsTitle.push(title);
		}
	}
	return closeTabsTitle;
}

/**
	获取当前到右侧最后一个的tab
	@param	tabs		tab组件
	@param	curTabTitle	到当前的tab
*/
function getRightToCurrTabObj(tabs,curTabTitle){
	//存放所有tab标题
	var closeTabsTitle = [];
	//所有所有tab对象
	var allTabs = tabs.tabs('tabs');
	for(var i=(allTabs.length - 1);i >= 0;i--){
		var tab = allTabs[i];
		var opt = tab.panel('options');
		//获取标题
		var title = opt.title;
		//是否可关闭 ture:会显示一个关闭按钮，点击该按钮将关闭选项卡
		var closable = opt.closable;
		if(closable){
			//alert('title' + title + '  curTabTitle:' + curTabTitle);
			if(title == curTabTitle){
				return closeTabsTitle;
			}
			closeTabsTitle.push(title);
		}
	}
	return closeTabsTitle;
}

// 弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function msgShow(title, msgString, msgType) {
	$.messager.alert(title, msgString, msgType);
}

// 本地时钟
function clockon() {
	var now = new Date();
	var year = now.getFullYear(); // getFullYear getYear
	var month = now.getMonth();
	var date = now.getDate();
	var day = now.getDay();
	var hour = now.getHours();
	var minu = now.getMinutes();
	var sec = now.getSeconds();
	var week;
	month = month + 1;
	if (month < 10)
		month = "0" + month;
	if (date < 10)
		date = "0" + date;
	if (hour < 10)
		hour = "0" + hour;
	if (minu < 10)
		minu = "0" + minu;
	if (sec < 10)
		sec = "0" + sec;
	var arr_week = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六");
	week = arr_week[day];
	var time = "";
	time = year + "年" + month + "月" + date + "日" + " " + hour + ":" + minu
			+ ":" + sec + " " + week;

	$("#bgclock").html(time);

	var timer = setTimeout("clockon()", 200);
}
