<%@page import="com.huan.business.service.UserService"%>
<%@page import="com.huan.business.service.LoginService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginName = request.getParameter("loginName");
session.setAttribute("loginName", loginName);
System.out.println("---------------------------userId:["+session.getAttribute("userId")+"]进入主页---------------------------");
%>
<%@taglib prefix="s" uri="/struts-tags" %>
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


<body data-type="index" style="display: flex; overflow-y: hidden;">

<script type="text/javascript">
	
</script>
    <header class="am-topbar am-topbar-inverse admin-header">
        <div class="am-topbar-brand">
            <a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" target="mainIframe" class="tpl-logo">
                <img src="amz/assets/img/logo.png" alt="">
            </a>
        </div>
        <div class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right">

        </div>

        <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only" data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

        <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

            <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class=" tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-bell-o"></span> 提醒 <span class="am-badge tpl-badge-success am-round">5</span></span>
                    </a>
                   
                </li>
                <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                    <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                        <span class="am-icon-comment-o"></span> 公告 <span class="am-badge tpl-badge-danger am-round"><s:property value="userIndex.notices.size()" /></span>
                    </a>
                    <ul class="am-dropdown-content tpl-dropdown-content am-scrollable-vertical" style="height:300px;overflow-y: scroll;">
                         <li class="tpl-dropdown-content-external">
                            <h3>共有 <span class="tpl-color-success"><s:property value="userIndex.notices.size()" /></span> 条公告</h3><!-- <a onclick="showWin()" >添加</a> -->
                         </li>
	                        <s:iterator var="noti" value="userIndex.notices" status="ss">
	                        <li class="tpl-dropdown-list-bdbc">
	                        <a  data-am-modal="{target:'#my-popup${ss.index}'}" >
	                      		${noti.manageName} &nbsp;:&nbsp; 【${noti.noticeTitle}】
	                        </a>
	                         <%-- <s:if test="#noti.manageId == #session.manageId">
	                        	<a  href="<%=path%>/manage/del_notice?noticeId=${noti.noticeId}"><i class="am-icon-times"></i></a>
	                        </s:if> --%>
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
                  <li class=" am-dropdown" onclick="changeTy(this.id)" data-am-dropdown data-am-dropdown-toggle>
                    <a class=" tpl-header-list-link" href="<%=path%>/user/list_log?log.userId=${session.userId}"  target="mainIframe">
                        <span class="am-icon-calendar"></span> 日志 <span class="am-badge tpl-badge-primary am-round">${userIndex.logNum}</span>
                    </a>
                </li>
                <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen" class="tpl-header-list-link"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

                <li class="am-dropdown" onclick="changeTy(this.id)" data-am-dropdown data-am-dropdown-toggle>
                    <a class="tpl-header-list-link" href="<%=path%>/user/user_getInfo?user.userId=${session.userId}"  target="mainIframe">
                        <span class="tpl-header-list-user-nick"> <%=session.getAttribute("userName")%></span>
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
	                    <li class="tpl-left-nav-item">
	                        <a id="indexMenu" href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" target="mainIframe" onclick="changeTy(this.id)" class="nav-link active">
	                            <i class="am-icon-home"></i>
	                            &nbsp;<span>首页</span>
	                        </a>
	                    </li>
	                    <li class="tpl-left-nav-item">
	                        <a id="userMenu" href="<%=path%>/user/order_list?order.userId=${session.userId}" target="mainIframe" onclick="changeTy(this.id)" class="nav-link tpl-left-nav-link-list">
	                            <i class="am-icon-columns"></i>
	                            &nbsp;<span>订单管理</span><i class="tpl-left-nav-content ">${userIndex.orderNum}</i>
	                            
	                        </a>
	                    </li>
		
	                    <li class="tpl-left-nav-item">
	                        <a id="clientMenu"  href="<%=path%>/user/client_list?client.userId=${session.userId}" target="mainIframe" onclick="changeTy(this.id)" class="nav-link tpl-left-nav-link-list">
	                            <i class="am-icon-users"></i>
	                            &nbsp;<span>客户管理</span><i class="tpl-left-nav-content tpl-badge-warning">${userIndex.clientNum}</i>
	                        </a>
	                    </li>
	                     <li class="tpl-left-nav-item">
	                        <a id="productMenu"  href="<%=path%>/user/product_query?product.userId=${session.userId}" target="mainIframe" onclick="changeTy(this.id)" class="nav-link tpl-left-nav-link-list">
	                            <i class="am-icon-th-list"></i>
	                            &nbsp;<span>查看产品</span><i class="tpl-left-nav-content tpl-badge-danger">${userIndex.productNum}</i>
	                        </a>
	                    </li>
	
	 					
	                  
	                    <li id="LoinMenu" class="tpl-left-nav-item" onclick="clearSession('userId');changeTy(this.id)">
	                        <a  href="<%=path%>/Userdown_index" class="nav-link tpl-left-nav-link-list" >
	                            <i class="am-icon-key"></i>
	                            &nbsp;<span>重新登录</span>
	                        </a>
	                    </li>
	                 
	                </ul>
	            </div>
	        </div>
	   	<div style="height: 100%;margin-right:20px;padding-top: 0" class="tpl-content-wrapper">
	       <iframe src="<%=path%>/user/usermain_list?userMain.userId=${session.userId}"  name="mainIframe" style="width:100%;height: 100%;"></iframe>
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
<script type="text/javascript">
	setInterval("flush()",1000000);
			function flush()
			{
			window.location.reload();
			}
</script>
  	<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
    <script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
    <script src="<%=path%>/amz/assets/js/iscroll.js"></script>
    <script src="<%=path%>/amz/assets/js/app.js"></script>
</body>

</html>