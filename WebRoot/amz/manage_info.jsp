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
<script src="amz/assets/js/main.js"></script>
</head>

<body data-type="generalComponents">
<div class="tpl-portlet">
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')"   class="am-icon-home">首页</a></li>
				  
				  <li><label class="am-icon-code">管理员信息</label></li>
				</ol>
 <div class="tpl-block ">

                    <div align='center' class="am-g tpl-amazeui-form">
							  <div class="am-u-sm-12 am-u-md-9">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
                                    <label> ${manage.manageName}</label>
                                </div><hr>
									<div class="am-form-group">
	                                    <label for="user-email" class="am-u-sm-3 am-form-label">登录账号 / LoginName</label>
	                              <label> ${manage.manageLoginName}</label>
                                	</div><hr>
                                	<div class="am-form-group">
	                                    <label for="user-email" class="am-u-sm-3 am-form-label">密码 / password</label>
	                              <label> ${manage.managePass}</label>
                                	</div><hr>
                                	
                                	<div class="am-form-group">
                                 	<div class="am-u-sm-9 am-u-sm-push-3">
	                                 	<a style="margin-right:25%" href="<%=path%>/manage/main_getupedit?manage.manageId=${session.manageId}" target="mainIframe"><input type="button" value="修改" class="am-btn am-btn-primary"/></a>
	                                    <a href="<%=path%>/manage/main_list?manageId=${session.manageId}" target="mainIframe" ><input type="button" value="返回" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                                	</div>
                           		
                        </div>
                    </div>
               </div> 
</body>

</html>