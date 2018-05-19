<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String isSuccess = request.getParameter("isSuccess");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
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
  <link rel="icon" type="image/png" href="amz/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="amz/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="amz/assets/css/amazeui.min.css" />
  <link rel="stylesheet" href="amz/assets/css/admin.css">
  <link rel="stylesheet" href="amz/assets/css/app.css">
  <script src="amz/assets/js/jquery.min.js"></script>
  <script src="amz/assets/js/amazeui.min.js"></script>
  <script src="amz/assets/js/app.js"></script>
  <script src="amz/assets/js/echarts.min.js"></script>
  <script src="amz/assets/js/main.js"></script>
</head>

<body data-type="login">

  <div class="am-g myapp-login" >
	<div class="myapp-login-logo-block  tpl-login-max" style="margin-top: 8%">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				 CRM&nbsp<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="login-font">
			<i>Log In </i> or <span> Sign Up</span>
		</div>
		<div class="login-font">
			<s:if test="null != #session.error"><span><%=session.getAttribute("error")%></span></s:if>
		</div>
		<div class="am-u-sm-10 login-am-center">
			<form id="loginForm" class="am-form" method="post">
				<fieldset>
				<br><br>
				<table style="width: 100%">
					<tr>
						<td>
						<span style="color: white;">登&ensp;录&ensp;名:</span><input onblur="isNum('nameError',this.value,'登录名');" style="width: 80%;float:right" name="loginName" type="text" class="" id="loginName" placeholder="输入账号/LoginName">
						</td>
					</tr>
					<tr>
						<td>
						<span style="float:right;" class="check1" id="nameError">&ensp;*</span>
						</td>
					</tr>
					<tr>
						<td>
						&ensp;
						</td>
					</tr>
					<tr>
						<td>
						<span style="color: white;">密&emsp;&emsp;码：</span><input onblur="isNum('passError',this.value,'密码');checkLen('regRePassError',this.value,6,16);" style="width: 80%;float:right" name="passWord" type="password" class="" id="passWord" placeholder="密码/PassWord">
						</td>
					</tr>
					<tr>
						<td>
						<span style="float:right;" class="check1" id="passError">&ensp;*</span>
						</td>
					</tr>
					<tr>
						<td>
						&emsp;
						</td>
					</tr>
					<tr>
						<td>
						<button style="width: 40%; white-space:nowrap;" onclick="subLoginCheck('Manage');SubCheck('loginForm','check1')" type="button" class="am-btn am-btn-success am-round">管理员登录</button>
						<button style="width: 18%; white-space:nowrap;" type="button" class="am-btn am-btn-success am-round"
							id="doc-prompt-toggle">注册</button>
						
						<button style="width: 40%;" onclick="subLoginCheck('User');SubCheck('loginForm','check1')"  type="button" class="am-btn am-btn-warning  am-round">员工登录</button>
						</td>
					</tr>
				</table>
				</fieldset>
			</form>
		</div>
	</div>
</div>

<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">管理员注册</div>
	   <form id="regForm" class="am-form" method="post" action="<%=path%>/Reg_Manage">
	      <fieldset class="am-form-set">
	      <table style="width: 80%;height:200px; text-align: center;margin: 0 auto;">
	      	<tr><td>登&ensp;录&ensp;名：<input class="inputClear" style="width: 80%;float:right" name="manage.manageLoginName" type="text" placeholder="登录名" onblur="isNum('regManegeLoginNameError',this.value,'登录名');checkLen('regManegeLoginNameError',this.value,4,10);"></td></tr>
	      	<tr><td><span class="check" id="regManegeLoginNameError">*</span></td></tr>
	      	<tr><td>真实姓名：   <input class="inputClear"  style="width: 80%;float:right" name="manage.manageName" type="text" placeholder="真实姓名" onblur="isNum('regManegeNameError',this.value,'真实姓名');checkLen('regManegeNameError',this.value,2,5);"></td></tr>
	      	<tr><td><span class="check" id="regManegeNameError">*</span></td></tr>
	      	<tr><td>密&emsp;&emsp;码：  <input id="user-pass" class="inputClear" style="width: 80%;float:right" name="manage.managePass" type="password" placeholder="密码" onblur="isNum('regPassError',this.value,'密码');checkLen('regPassError',this.value,6,16)"></td></tr>
	      	<tr><td><span class="check" id="regPassError">*</span></td></tr>
	      	<tr><td>确认密码：  <input id="user-repass" class="inputClear" style="width: 80%;float:right" type="password" placeholder="密码" onblur="isNum('regRePassError',this.value,'确认密码');checkLen('regRePassError',this.value,6,16);checkpass(this.value)"></td></tr>
	      	<tr><td><span class="check" id="regRePassError">*</span></td></tr>
	      </table>
	      
	      </fieldset>
	      <button type="button" onclick="SubCheck('regForm','check')" id="doc-prompt-reg" class="am-btn am-btn-warning am-round">确认注册</button>
	    </form>
  </div>
</div>

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
	<script type="text/javascript">
		function subLoginCheck(val){
        	var loginform = document.getElementById("loginForm");
	      	loginform.action="<%=path%>/check_"+val;
	      	 
        }
       
    $(function() {
    var isSuccess = '<%=(String)session.getAttribute("isSuccess")%>';
    if('isExist' == isSuccess){
     $('#my-prompt').modal({
	      relatedTarget: this,
	    });
	 var regName = document.getElementById("regManegeLoginNameError");
	 regName.innerHTML = "该账号已经存在，请重新输入^_^";
    }else if('true' == isSuccess){
	   myAlert("success-alert","恭喜！注册成功^_^");
    }else if('error' == isSuccess){
    	myAlert("error-alert","注册失败^_^");
    }
  
    
    var passError = '<%=(String)session.getAttribute("passError")%>';
    var nameError = '<%=(String)session.getAttribute("nameError")%>';
    if('null' != passError){
    	document.getElementById("passError").innerHTML = passError;
    }
    if('null' != nameError){
    	document.getElementById("nameError").innerHTML = nameError;
    }
	  $('#doc-prompt-toggle').on('click', function() {
	    $('#my-prompt').modal({
	      relatedTarget: this,
	    });
	  });
	});
	<%session.setAttribute("passError", null);%>
    <%session.setAttribute("nameError", null);%>
    <%session.setAttribute("isSuccess", null);%>
	</script>
 
</body>

</html>