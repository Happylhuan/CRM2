<%@page import="com.huan.business.dao.LoginDao"%>
<%@page import="com.huan.business.po.TsNotice"%>
<%@page import="com.huan.business.service.UserService"%>
<%@page import="com.huan.business.service.LoginService"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginName = request.getParameter("loginName");
session.setAttribute("loginName", loginName);

System.out.println("---------------------------manageId:["+session.getAttribute("manageId")+"]进入主页---------------------------");
%>

<!doctype html>
<html>

<head>
      <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>CRM客户关系管理系统</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="<%=path %>/amz/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="<%=path %>/amz/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="<%=path %>/amz/assets/css/amazeui.min.css" />
  <link rel="stylesheet" href="<%=path %>/amz/assets/css/admin.css">
  <link rel="stylesheet" href="<%=path %>/amz/assets/css/app.css">
   <script src="amz/assets/js/echarts.min.js"></script>
	<script src="amz/assets/js/jquery.min.js"></script>
	<script src="amz/assets/js/amazeui.min.js"></script>
	<script src="amz/assets/js/app.js"></script>
	<script src="amz/assets/js/main.js"></script>
	<style>
::-webkit-scrollbar {display:none}
 </style>
</head>


<body data-type="index" style="display: flex; overflow-y: hidden;" >
	<header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a  href="<%=path%>/manage/main_list?manageId=${session.manageId}" target="mainIframe"  class="tpl-logo">
                <img src="amz/assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>
 			
        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li onclick="lod()" class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content">
                        <li class="tpl-dropdown-content-external">
                            <h3>你有 <span class="tpl-color-success">5</span> 条提醒</h3><a href="###">全部</a></li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-plus tpl-dropdown-ico-btn-size tpl-badge-success"></span> 【预览模块】移动端 查看时 手机、电脑框隐藏。</a>
                            <span class="tpl-dropdown-list-fr">3小时前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-check tpl-dropdown-ico-btn-size tpl-badge-danger"></span> 移动端，导航条下边距处理</a>
                            <span class="tpl-dropdown-list-fr">15分钟前</span>
                        </li>
                        <li class="tpl-dropdown-list-bdbc"><a href="#" class="tpl-dropdown-list-fl"><span class="am-icon-btn am-icon-bell-o tpl-dropdown-ico-btn-size tpl-badge-warning"></span> 追加统计代码</a>
                            <span class="tpl-dropdown-list-fr">2天前</span>
                        </li>
                    </ul>
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;" >
                        <span class="am-icon-comment-o"></span> 公告 <span class="am-badge tpl-badge-danger am-round"><s:property value="manageIndex.notices.size()" /></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content am-scrollable-vertical" style="height:300px;overflow-y: scroll;">
                         <li class="tpl-dropdown-content-external">
                            <h3>共有 <span class="tpl-color-success"><s:property value="manageIndex.notices.size()" /></span> 条公告</h3><a onclick="showWin()" class="am-dropdown-toggle tpl-header-list-link">添加</a>
                         </li>
	                        <s:iterator var="noti" value="manageIndex.notices" status="ss">
	                        <li class="tpl-dropdown-list-bdbc">
	                        <a  data-am-modal="{target:'#my-popup${ss.index}'}" >
	                      		${noti.manageName} &nbsp;:&nbsp; 【${noti.noticeTitle}】
	                        </a>
	                         <s:if test="#noti.manageId == #session.manageId">
	                        	<a  href="<%=path%>/manage/del_notice?noticeId=${noti.noticeId}"><i class="am-icon-times"></i></a>
	                        </s:if>
	                        <div  class="am-popup" id="my-popup${ss.index}">
							  <div class="am-popup-inner">
							    <div class="am-popup-hd">
							      <h4 class="am-popup-title">${noti.noticeTitle}</h4>
							      <span data-am-modal-close
							            class="am-close">&times;</span>
							    </div>
							    <div class="am-popup-bd" style="height: 100%;word-break:break-all; " >
							      ${noti.noticeInfo}
							    </div>
							  </div>
							</div>
							
	                        </li>
	                        </s:iterator>
                     </ul>
                </li>
                <li class=" tpl-left-nav-item" onclick="changeTy(this.id)" data-am-dropdown data-am-dropdown-toggle>
                    <a class=" tpl-header-list-link" href="<%=path%>/manage/managelist_log?log.manageId=${session.manageId}" target="mainIframe" onclick="openul('product_ul')">
                        <span class="am-icon-calendar"></span> 日志 <span class="am-badge tpl-badge-primary am-round">${manageIndex.logNum}</span>
                    </a>
                    
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" onclick="changeTy(this.id)" data-am-dropdown data-am-dropdown-toggle>
                    <a class="tpl-header-list-link" href="<%=path%>/manage/manage_getInfo?manage.manageId=${session.manageId}"  target="mainIframe" >
                        <span class="tpl-header-list-user-nick"> <%=session.getAttribute("manageName") %></span>
                        <span class="tpl-header-list-user-ico"> <img src="amz/assets/img/user01.png"></span>
                    </a>
                </li>
              
                <li><s:a href="Login.jsp" class="tpl-header-list-link"><span class="am-icon-sign-out tpl-header-list-ico-out-size"></span></s:a></li>
            </ul>
        </div>
    </header>

	<div class="tpl-content-wrapper"  style="width:100%;margin-top:80px;padding-left:0">
	    <div class="tpl-left-nav tpl-left-nav-hover " style="width:235px;margin-left: 15px;position:absolute;">
           <div class="tpl-left-nav-title">
          		功能 列表
            </div>
            <div class="tpl-left-nav-list">
                <ul class="tpl-left-nav-menu">
                    <li  class="tpl-left-nav-item">
                        <a id="indexMenu" href="<%=path%>/manage/main_list?manageId=${session.manageId}" target="mainIframe" onclick="changeTy(this.id);openul('product_ul')" class="nav-link active">
                            &nbsp;<i class="am-icon-home"></i>
                            &nbsp;<span>首页</span>
                        </a>
                    </li>
                    <li class="tpl-left-nav-item">
                        <a id="userMenu" href="<%=path%>/manage/user_list?user.manageId=${session.manageId}" target="mainIframe" onclick="changeTy(this.id);openul('product_ul')" class="nav-link tpl-left-nav-link-list">
                            &nbsp;<i class="am-icon-user"></i>
                            &nbsp;<span>人员管理</span><i class="tpl-left-nav-content ">${manageIndex.userNum}</i>
                           
                        </a>
                    </li>
	
                    <li class="tpl-left-nav-item">
                        <a id="roleMenu"  href="<%=path%>/manage/role_list?role.manageId=${session.manageId}" target="mainIframe" onclick="changeTy(this.id);openul('product_ul')" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-users"></i>
                            &nbsp;<span>角色管理</span> <i class="tpl-left-nav-content tpl-badge-warning">${manageIndex.roleNum}</i>
                        </a>
                    </li>
  					 <li class="tpl-left-nav-item">
                        <a id="orderMenu" href="<%=path%>/manage/order_managelist?manageId=${session.manageId}" target="mainIframe" onclick="changeTy(this.id);openul('product_ul')" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-columns"></i>
                            &nbsp;<span>查看订单</span><i class="tpl-left-nav-content tpl-badge-danger">${manageIndex.orderNum}</i>
                         
                        </a>
                    </li>
                    
                    <li class="tpl-left-nav-item">
                        <!-- 打开状态 a 标签添加 active 即可   -->
                        <a id="productMenu"  class="nav-link tpl-left-nav-link-list"   onclick="changeTy(this.id);" >
                            <i class="am-icon-th-list"></i>
                            &nbsp;<span>产品管理</span>
                            <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                        </a>
                        <!-- 打开状态 添加 display:block-->
                      <ul id="product_ul" style="display: none;" class="tpl-left-nav-sub-menu" >
                            <li>
                                <a id="productMenu1" href="<%=path%>/manage/product_list?product.manageId=${session.manageId}" target="mainIframe" onclick="changeMenuTy(this.id,'productStar1')" class="menu_link">
                                    <i class="am-icon-angle-right"></i>
                                    <span>产品</span><i class="tpl-left-nav-content tpl-badge-default">${manageIndex.productNum}</i>
                                    <i id="productStar1" class=" am-margin-right"></i>
                                </a>

                                <a id="productMenu2" href="<%=path%>/manage/productType_list?manageId=${session.manageId}" target="mainIframe" onclick="changeMenuTy(this.id,'productStar2')" class="menu_link">
                                    <i class="am-icon-angle-right"></i>
                                    <span>产品类型</span><i class="tpl-left-nav-content tpl-badge-default">${manageIndex.productTypeNum}</i>
                                    <i id="productStar2" class=" am-margin-right"></i>
                                </a>
                              		<a id="productMenu3" href="<%=path%>/manage/productBrand_list?manageId=${session.manageId}" target="mainIframe" onclick="changeMenuTy(this.id,'productStar3')" class="menu_link">
                                    <i class="am-icon-angle-right"></i>
                                    <span>产品品牌</span><i class="tpl-left-nav-content tpl-badge-default">${manageIndex.productBrandNum}</i>
                                    <i id="productStar3" class=" am-margin-right"></i>
                                </a>
                            </li>
                        </ul>
                    
                    </li>

                    <li id="LoinMenu" class="tpl-left-nav-item" onclick="changeTy(this.id)">
                        <a href="<%=path%>/Managedown_index" class="nav-link tpl-left-nav-link-list">
                            <i class="am-icon-power-off"></i>
                            &nbsp;<span>重新登录</span>
                        </a>
                    </li>
                 
                </ul>
            </div>
    
        </div>
    
    <div style="height: 100%;margin-right:20px;padding-top: 0" class="tpl-content-wrapper">
		<iframe id="mainIframe" src="<%=path%>/manage/main_list?manageId=${session.manageId}"  name="mainIframe" style="width:100%;height: 100%;"></iframe>
    </div>
	</div>



<div>
	<div class="am-modal am-modal-alert" tabindex="-1" id="warm-alert">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				<h3 style="background-color: yellow;">
					<b>△警告提示△</b>
				</h3>
			</div>
			<div class="am-modal-bd">
				<span id="alertTxt"></span>
			</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
	
	<div class="am-modal am-modal-alert" tabindex="-1" id="error-alert">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				<h3 style="background-color: red;">
					<b >△错误提示△</b>
				</h3>
			</div>
			<div class="am-modal-bd">
				<span id="alertTxt"></span>
			</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
	
	<div class="am-modal am-modal-alert" tabindex="-1" id="success-alert">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">
				<h3 style="background-color:green;">
					<b >△成功提示△</b>
				</h3>
			</div>
			<div class="am-modal-bd">
				<span id="alertTxt"></span>
			</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn">确定</span>
			</div>
		</div>
	</div>
</div>

<!-- <button
  type="button"
  class="am-btn am-btn-success"
  data-am-modal="{target: '#my-modal-loading'}">
  Modal Loading
</button> -->

<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">正在载入...</div>
    <div class="am-modal-bd">
      <span class="am-icon-spinner am-icon-spin"></span>
    </div>
  </div>
</div>

<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">添加公告</div>
	   <form id="regForm" class="am-form" method="post" action="<%=path%>/manage/add_notice?manageId=${session.manageId}">
	      <fieldset class="am-form-set">
	      <table style="width: 80%;height:200px; text-align: center;margin: 0 auto;">
	      	<tr><td>标&nbsp;&nbsp;题：<input class="inputClear" style="width: 80%;float:right" name="noticeTitle" type="text" placeholder="登录名" onblur="isNum('noticeTitleError',this.value,'公告标题');"></td></tr>
	      	<tr><td><span class="check" id="noticeTitleError">*&nbsp;</span></td></tr>
	      	<tr><td>内&nbsp;&nbsp;容：<textarea style="width: 80%;float:right" rows="" cols="" name="noticeInfo" onblur="isNum('noticeInfoError',this.value,'公告内容');"></textarea></td></tr>
	      	<tr><td><span class="check" id="noticeInfoError">*&nbsp;</span></td></tr>
	      </table>
	      </fieldset>
	      <button type="button" onclick="SubCheck('regForm','check');Myflush();" id="doc-prompt-reg" class="am-btn am-btn-warning am-round">确认添加</button>
	    </form>
  </div>
</div>


<script type="text/javascript">
    $(function() {
    var isNoticeAdd = '<%=(String)session.getAttribute("isNoticeAdd")%>';
    if('noticeAdd' == isNoticeAdd){
	   myAlert("success-alert","恭喜！添加成功^_^");
    }
	});
	 function showWin() {
	    $('#my-prompt').modal({
	      relatedTarget: this,
	    });
	    
	  }
	function hidWin() {
	    $('#my-prompt').modal({
	      relatedTarget: this,
	    });
	  }
	<%session.setAttribute("isNoticeAdd", null);%>

	window.onbeforeunload=function(){
		 $('#my-modal-loading').modal({
	      relatedTarget: this,
	    });
	    setTimeout(function() {
	    	$('#my-modal-loading').modal({
	      relatedTarget: this,
	    });
	    }, 500)
	}

	</script>
  	<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
    <script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
    <script src="<%=path%>/amz/assets/js/iscroll.js"></script>
    <script src="<%=path%>/amz/assets/js/app.js"></script>
  	

</body>

</html>