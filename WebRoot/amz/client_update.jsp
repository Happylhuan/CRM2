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
<style type="text/css">
.check{
	color:red;
}
</style>
<script type="text/javascript">
		function checkpass(val){
			var pass = document.getElementById("user-pass");
			var repass = document.getElementById("user-repass");
			if(pass.value!=val){
				alert("两次密码不一致，请重新输入^_^");
				pass.value="";
				repass.value="";
			}
		}
	function SubCheck(valId,valClass){
			var flag = true;
			var sub = document.getElementById(valId);
				var check = document.getElementsByClassName(valClass);	
				for(var i = 0;i < check.length;i++){
					if(check[i].innerHTML!=''){
						flag = false;
					}
				}	
				
				if(flag){
					sub.submit();
				}else{
					alert("请正确输入^_^");
				}
			}
		function isChinese(valId,val) {
			var tarEle = document.getElementById(valId);
			var re=/[^\u4e00-\u9fa5]/; 
            if(re.test(val)){
            	tarEle.innerHTML += "-必须为中文";
            }
		}
		function checkLen(errId,val,min,max){
			var tarEle = document.getElementById(errId);
			if(max==0){
				if(val.length!==min){
            		tarEle.innerHTML += "长度要必须为"+min+"";
            	}else{
            		tarEle.innerHTML = "";
            	}
			}else if(val.length<min||val.length>max){
            	tarEle.innerHTML += "长度要在"+min+"-"+max+"之间";
            }else{
            	tarEle.innerHTML = "";
            }
		}
		function isNum(valId,val,txt){
		var errorEle = document.getElementById(valId);
			if ("" == val || null == val) {
				errorEle.innerHTML = "*"+txt+"不能为空!"
			} else{
            	errorEle.innerHTML = "";
            }
		}
		function subcheck(val){
        var loginform = document.getElementById("loginForm");
        if(val=="Manage"){
            loginform.action="<%=path%>/page/manage_menu.jsp";
            loginform.submit();
        }else{
            loginform.setAttribute("action", "<%=path%>/page/user_menu.jsp");
            loginform.submit();

        }
    }
    function init(){
    	var val = document.getElementById("checkval").value;
    	var yesele = document.getElementById("yesUse");
    	var noele = document.getElementById("noUse");
    	if(val=="true"){
    		yesele.checked="checked";
    	}else{
    		noele.checked="checked";
    	}
    	
    }
	</script>
</head>

<body onload="init()" data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" class="am-icon-home">首页</a></li>
				  <li><a href="<%=path%>/user/client_list?client.userId=${session.userId}" class="am-icon-calendar">客户列表</a></li>
				  <li><label class="am-icon-code">更新客户</label></li>
				</ol> 
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form class="am-form am-form-horizontal" namespace="/user" action="client_update" method="post">
                            <input style="display: none" type="text" name="userId"
								value="${client.userId}">
								  <input style="display: none" type="text" name="clientId"
								value="${client.clientId}">
								<input style="display: none" type="text" name="state"
								value="upd">
								<input style="display: none" type="text" name="page.pageNo"
								value="${page.pageNo}">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">客户姓名 /ClientName</label>
                                    <div class="am-u-sm-9">
                                        <input name="clientName" type="text" value="${client.clientName}" placeholder="客户姓名 /ClientName" onblur="isNum('ClientNameError',this.value,'客户名称');checkLen('ClientNameError',this.value,1,5)"><span class="check" id="ClientNameError"></span>
                                       
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">邮箱 / E-mail</label>
                                    <div class="am-u-sm-9">
                                        <input name="clientIdcard" value="${client.clientIdcard}" type="text"  placeholder="邮箱 / E-mail" onblur="isNum('IdCardError',this.value,'邮箱');isEmail('IdCardError',this.value)"><span class="check" id="IdCardError"></span>
                                       
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">电话号码 / phoneNum</label>
                                    <div class="am-u-sm-9">
                                        <input value="${client.clientPhone}" name="clientPhone" type="text"  placeholder="电话号码 / phoneNum" onblur="isNum('PhoneNumError',this.value,'手机号');checkLen('PhoneNumError',this.value,0,11)"><span class="check" id="PhoneNumError"></span>
                                       
                                    </div>
                                	</div>

								<div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">是否启用/ isUse</label>
	                              <div class="am-u-sm-9">
	                              <input style="display: none" id="checkval" type="text" value="${client.clientIsuser}">
	                              	  是： <input id="yesUse" type="radio" name="clientIsuser" value="true" >	
	                               	 否： <input  id="noUse" type="radio" name="clientIsuser" value="false">
	                              </div>
                         	 </div>
                                <div  align='center' class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button  style="margin-right:25%" type="submit" class="am-btn am-btn-primary">保存修改</button>
   										<a href="<%=path%>/user/client_list?userId=<%=session.getAttribute("userId")%>&page.pageNo=<s:property value="page.pageNo"/>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>

                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>