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
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" class="am-icon-home">首页</a></li>
				  <li><a href="<%=path%>/user/client_list?client.userId=${session.userId}" class="am-icon-calendar">客户列表</a></li>
				  <li><label class="am-icon-plus">添加日志</label></li>
				</ol>  
 <div class="tpl-block ">

              <div class="am-g tpl-amazeui-form">


                  <div class="am-u-sm-12 am-u-md-9">
                      <s:form id='role_add_formId' class="am-form am-form-horizontal" namespace="/user"  action="client_add?state=add" method="post">
                          <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">客户姓名 / clientName</label>
                              <div class="am-u-sm-9">
                                  <input name="clientName" type="text" placeholder="客户姓名 / clientName" onblur="isNum('ClientNameError',this.value,'客户名称');checkLen('ClientNameError',this.value,1,5)"><span class="check" id="ClientNameError">*</span>
                                 
                              </div>
                          </div>
						 <input style="display:none" type="text" value="${session.userId}" name="userId">
						 <!-- <input style="display: none" type="text" value="add" name="state"> -->
							 		 	
						<div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">邮箱/e-mail</label>
                              <div class="am-u-sm-9">
                                  <input name="clientIdcard" type="email"  placeholder="邮箱/e-mail" onblur="isNum('IdCardError',this.value,'邮箱');isEmail('IdCardError',this.value)"><span class="check" id="IdCardError">*</span>
                                 
                              </div>
                          </div>
                          <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">电话号码/ phoneNum</label>
                              <div class="am-u-sm-9">
                                  <input name="clientPhone" type="text"  placeholder="电话号码/ phoneNum" onblur="isNum('PhoneNumError',this.value,'手机号');checkLen('PhoneNumError',this.value,11,0)"><span class="check" id="PhoneNumError">*</span>
                                 
                              </div>
                          </div>
                          <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">是否启用/ isUse</label>
                              <div class="am-u-sm-9">
                              	  是： <input type="radio" name="clientIsuser" value="true" checked="checked">	
                               	 否： <input  type="radio" name="clientIsuser" value="false">
                              </div>
                          </div>
						<div align='center'>
                            <input style="margin-right:25%" id="subId" onclick="SubCheck('role_add_formId','check')" type="button" value="添加" class="am-btn am-btn-primary"/>
                             
                            <a href="<%=path%>/user/client_list?userId=<%=session.getAttribute("userId")%>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                         </div>     
                      </s:form>
                  </div>
              </div>
              </div>
     </div>
</body>

</html>