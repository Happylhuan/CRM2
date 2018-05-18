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
  <li><label  class="am-icon-angle-plus">添加人员</label></li>
</ol>
 <div class="tpl-block ">
                    <div class="am-g tpl-amazeui-form">
                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form id="user_add_formId" class="am-form am-form-horizontal"  action="/manage/user_add" method="post">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">账号 / LoginName</label>
                                    <div class="am-u-sm-9">
                                        <input name="loginName" type="text" id="user-name" placeholder="账号 / LoginName" onblur="isNum('LoginNameError',this.value,'登陆账号');checkLen('LoginNameError',this.value,3,11)"><span class="check" id="LoginNameError">*</span>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">姓名 / UserName</label>
                                    <div class="am-u-sm-9">
                                        <input  name="userName" type="text" id="user-name" placeholder="输入用户的中文姓名 / Name" onblur="isNum('NameError',this.value,'名字');isChinese('NameError',this.value);checkLen('PassError',this.value,2,4)"><span class="check" id="NameError">*</span>
                                        
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">密码 / PassWord</label>
                                    <div class="am-u-sm-9">
                                        <input name="passWord" type="password" id="user-pass" placeholder="输入用户登陆密码 / Pass" onblur="isNum('PassError',this.value,'密码');checkLen('PassError',this.value,6,8)"><span class="check" id="PassError">*</span>
                                      
                                    </div>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">确认密码 / Check</label>
                                    <div class="am-u-sm-9">
                                        <input  type="password" id="user-repass" placeholder="输入确认密码 / CheckPass" onblur="isNum('CheckPassError',this.value,'确认密码');checkLen('CheckPassError',this.value,6,8);checkpass(this.value)"><span class="check" id="CheckPassError">*</span>
                                        
                                    </div>
                                	</div>
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <div class="am-u-sm-9">
                                        <input type="tel" name="phoneNumber" id="user-phone" placeholder="输入用户的电话号码 / Telephone" onblur="isNum('TelephoneError',this.value,'电话');checkLen('TelephoneError',this.value,11,0)"><span class="check" id="TelephoneError">*</span>
                                       
                                    </div>
                                </div>
							 	<input style="display: none" type="text" value="add" name="state">
							 	
							 	<div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">角色 / Role</label>
                                    <div class="am-u-sm-9">
                                       	<s:select list="rolesName"  theme="simple" onblur="isNum('RoleError',this.value,'角色')" name="role"
											headerKey="" headerValue="--请选择角色">
										</s:select><span class="check" id="RoleError">*</span>
                                        
                                    </div>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">日志权限等级 / Power</label>
                                    <div class="am-u-sm-9">
                                       	<s:select list="powerList" theme="simple" onblur="isNum('PowerError',this.value,'权限')" name="power"
											headerKey="" headerValue="--请选择权限">
										</s:select><span class="check" id="PowerError">*</span>
                                        
                                    </div>
                                </div>
                                <input type="text" name="manageId" style="display: none" value="${session.manageId}">
                                <div align='center'>
		                            <input style="margin-right:25%" id="subId" onclick="SubCheck('user_add_formId','check')" type="button" value="添加" class="am-btn am-btn-primary"/>
		                             
		                          	  <a href="<%=path%>/manage/user_list?manageId=<%=session.getAttribute("manageId")%>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                         		</div>
                            </s:form>
                        </div>
                    </div>
       </div></div>         </div>
</body>

</html>