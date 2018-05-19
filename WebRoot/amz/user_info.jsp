<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>

<head>
   <base href="<%=basePath%>">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="amz/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="amz/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="amz/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="amz/assets/css/admin.css">
<link rel="stylesheet" href="amz/assets/css/app.css">
<script src="amz/assets/js/echarts.min.js"></script>
<script src="amz/assets/js/jquery.min.js"></script>
<script src="amz/assets/js/amazeui.min.js"></script>
<script src="amz/assets/js/app.js"></script>
<script src="amz/assets/js/main.js"></script>
</head>

<body data-type="generalComponents">
<div class="tpl-portlet">
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')"  class="am-icon-home">首页</a></li>
				  <li><label class="am-icon-user">用户信息</label></li>
				</ol>	 
 <div class="tpl-block ">

                    <div align='center' class="am-g tpl-amazeui-form">
							  <div class="am-u-sm-12 am-u-md-9">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">姓名 /ClientName</label>
                                    <label> ${user.userName}</label>
                                </div><hr>
									<div class="am-form-group">
	                                    <label for="user-email" class="am-u-sm-3 am-form-label">登录名 / LoginName</label>
	                              <label> ${user.loginName}</label>
                                	</div><hr>
                                	
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">角色 / Role</label>
                                 	<label> ${user.role}</label>
                                </div><hr>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">电话 / PhoneNum</label>
                                    <label> ${user.phoneNumber}</label>
                                	</div><hr>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">密码 / PassWord</label>
                                    <label> ${user.passWord}</label>
                                	</div><hr>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">资质级别 / power</label>
                                    <label> 
                                    <s:if test="1 == user.power" >
                                		   一级
                                    </s:if>
                                    <s:if test="2 == user.power" >
                                		   二级
                                    </s:if>
                                    <s:if test="3 == user.power" >
                                		   三级
                                    </s:if>
                                    <s:if test="4 == user.power" >
                                		   四级
                                    </s:if>
                                    <s:if test="5 == user.power" >
                                		   五级
                                    </s:if>
                                    <s:if test="6 == user.power" >
                                		   六级
                                    </s:if>
                                    <s:if test="7 == user.power" >
                                		   七级
                                    </s:if>
                                    <s:if test="8 == user.power" >
                                		   八级
                                    </s:if>
                                    <s:if test="9 == user.power" >
                                		   九级
                                    </s:if>
                                   </label>
                                	</div><hr>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">管理员 / Manage</label>
                                    <label> ${user.manageName}</label>
                                	</div><hr>
                                	<div class="am-form-group">
                                 	<div class="am-u-sm-9 am-u-sm-push-3">
	                                 	<a style="margin-right:25%" href="<%=path%>/user/usermain_getupedit?user.userId=${user.userId}&user.manageId=${user.manageId}" target="mainIframe"><input type="button" value="修改" class="am-btn am-btn-primary"/></a>
	                                    <a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" ><input type="button" value="返回" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                                	</div>
                           		
                        </div>
                    </div>
               </div> </div>
</body>

</html>