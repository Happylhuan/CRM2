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
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
<ol class="am-breadcrumb">
  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
  <li><a href="<%=path%>/manage/user_list?user.manageId=${session.manageId}" onclick="changeParentTy('userMenu');manageOpenul('product_ul')" class="am-icon-user">人员列表</a></li>
  <li><label  class="am-icon-angle-code">更新人员</label></li>
</ol>
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form class="am-form am-form-horizontal"  action="/manage/user_update" method="post">
                            <input style="display: none" type="text" name="userId"value="${user.userId}">
							<input style="display: none" type="text" value="<%=session.getAttribute("manageId")%>" name="manageId">
							<input style="display: none" type="text" value="upd" name="state">
							 <input style="display: none" type="text" value="${page.pageNo}" name="page.pageNo">	
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">账号 / LoginName</label>
                                    <div class="am-u-sm-9">
                                        <input name="loginName" type="text" value="${user.loginName}" id="user-name" placeholder="账号 / LoginName"  onblur="isNum('LoginNameError',this.value,'登陆账号');checkLen('LoginNameError',this.value,3,11)"><span class="check" id="LoginNameError"></span>
                                        <small>用户的登陆账号^_^</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">姓名 / UserName</label>
                                    <div class="am-u-sm-9">
                                        <input name="userName" value="${user.userName}" type="text" id="user-email" placeholder="输入用户的中文姓名 / UserName"  onblur="isNum('NameError',this.value,'名字');isChinese('NameError',this.value);checkLen('PassError',this.value,2,4)"><span class="check" id="NameError"></span>
                                        <small>姓名你懂得...</small>
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">密码 / PassWord</label>
                                    <div class="am-u-sm-9">
                                        <input value="${user.passWord}" name="passWord" type="password" id="user-pass" placeholder="输入用户登陆密码 / Email"  onblur="isNum('PassError',this.value,'密码');checkLen('PassError',this.value,6,8)"><span class="check" id="PassError"></span>
                                        <small>输入密码</small>
                                    </div>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">确认密码 / CheckPassword</label>
                                    <div class="am-u-sm-9">
                                        <input value="${user.passWord}" onblur="checkpass(this.value)" type="password" id="user-repass" placeholder="输入确认密码 / Email" onblur="isNum('CheckPassError',this.value,'确认密码');checkLen('CheckPassError',this.value,6,8);checkpass(this.value)"><span class="check" id="CheckPassError"></span>
                                        <small>确认密码</small>
                                    </div>
                                	</div>
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <div class="am-u-sm-9">
                                        <input value="${user.phoneNumber}" type="tel" name="phoneNumber" id="user-phone" placeholder="输入用户的电话号码 / Telephone"  onblur="isNum('TelephoneError',this.value,'电话');checkLen('TelephoneError',this.value,11,0)"><span class="check" id="TelephoneError"></span>
                                        <small>用户的手机号码</small>
                                    </div>
                                </div>
							 	
							 	<div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">角色 / Role</label>
                                    <div class="am-u-sm-9">
                                       	<s:select list="rolesName" theme="simple" onblur="isNum('RoleError',this.value,'角色')" name="role"
											headerKey="%{user.role}" headerValue="--更改角色">
										</s:select><span class="check" id="RoleError"></span>
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">日志权限等级 / Power</label>
                                    <div class="am-u-sm-9">
                                       	<s:select list="powerList" theme="simple" onblur="isNum('PowerError',this.value,'权限')" name="power"
											headerKey="%{user.power}" headerValue="--更改用户权限">
										</s:select><span class="check" id="PowerError"></span>
                                         
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button style="margin-right:25%" type="submit" class="am-btn am-btn-primary">保存修改</button>
                                          <a href="<%=path%>/manage/user_list?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.pageNo"/>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>