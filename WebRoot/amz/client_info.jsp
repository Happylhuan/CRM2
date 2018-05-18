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
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
 				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" class="am-icon-home">首页</a></li>
				  <li><label class="am-icon-calendar">客户信息</label></li>
				</ol>
 <div class="tpl-block ">

                    <div align='center' class="am-g tpl-amazeui-form">
							  <div class="am-u-sm-12 am-u-md-9">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">客户名 /ClientName</label>
                                    <label> ${client.clientName}</label>
                                </div><hr>
	
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">电话 / PhoneNum</label>
                                 		<label> ${client.clientPhone}</label>
                                </div><hr>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">邮箱 / E-mail</label>
                                    <label> ${client.clientIdcard}</label>
                                	</div><hr>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">是否启用 / IsUser</label>
                                   	  <label><s:if test="clientIsuser">弃用</s:if>
									 <s:else>启用</s:else> </label>
                                	</div><hr>
                                	<div class="am-form-group">
                                 	<div class="am-u-sm-9 am-u-sm-push-3">
                                      <a href="<%=path%>/user/usermain_list?userMain.userId=${userId}"><input type="button" value="返回" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                                	</div>
                           		
                        </div>
                    </div>
                </div></div>
</body>
	<script src="amz/assets/js/jquery.min.js"></script>
	<script src="amz/assets/js/amazeui.min.js"></script>
	<script src="amz/assets/js/app.js"></script>
</html>