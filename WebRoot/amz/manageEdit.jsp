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
				  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')"  class="am-icon-home">首页</a></li>
				  <li><a href="<%=path%>/manage/manage_getInfo?manage.manageId=${session.manageId}"   class="am-icon-home">管理员信息</a></li>
				  <li><label class="am-icon-code">编辑信息</label></li>
				</ol>	 
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form id="manageEditForm" class="am-form am-form-horizontal"  action="main_edit" method="post">
							<input style="display: none" type="text" value="${session.manageId}" name="manage.manageId">
							
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
                                    <div class="am-u-sm-9">
                                        <input name="manage.manageName" type="text" value="${manage.manageName}" id="user-name" placeholder="姓名 / Name"  onblur="isNum('NameError',this.value,'姓名');checkLen('NameError',this.value,2,5);isChinese('NameError',this.value);"><span class="check" id="NameError"></span>
                                        <small>管理员的中文名^_^</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">登录账号 / LoginName</label>
                                    <div class="am-u-sm-9">
                                        <input name="manage.manageLoginName" value="${manage.manageLoginName}" type="text" id="LoginName" placeholder="登录账号 / LoginName"  onblur="isNum('loginNameError',this.value,'登录名');checkLen('loginNameError',this.value,4,10)"><span class="check" id="loginNameError"></span>
                                        <small>登录账号你懂得...</small>
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">密码 / password</label>
                                    <div class="am-u-sm-9">
                                        <input value="${manage.managePass}" name="manage.managePass" type="password" id="user-pass" placeholder="输入登陆密码 / password"  onblur="isNum('PassError',this.value,'密码');checkLen('PassError',this.value,6,16)"><span class="check" id="PassError"></span>
                                        <small>输入密码</small>
                                    </div>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">确认密码 / CheckPassword</label>
                                    <div class="am-u-sm-9">
                                        <input value="${manage.managePass}" onblur="checkpass(this.value)" type="password" id="user-repass" placeholder="输入确认密码 / Email" onblur="isNum('CheckPassError',this.value,'确认密码');checkLen('CheckPassError',this.value,6,16);checkpass(this.value)"><span class="check" id="CheckPassError"></span>
                                        <small>确认密码</small>
                                    </div>
                                	</div>
                               
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button style="margin-right:25%" type="button" onclick="SubCheck('manageEditForm','check')" class="am-btn am-btn-primary">保存修改</button>
                                          <a href="<%=path%>/manage/manage_getInfo?manage.manageId=<%=session.getAttribute("manageId")%>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>