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
				myAlert("warm-alert","两次密码不一致，请重新输入^_^");
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
					myAlert("warm-alert","请正确输入^_^");
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
	</script>
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
 <ol class="am-breadcrumb">
  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
  <li><a href="<%=path%>/manage/product_list?product.manageId=${session.manageId}" onclick="changeParentTy('productMenu');manageOpenul('product_ul','productStar1')" class="am-icon-list">产品列表</a></li>
  <li><label  class="am-icon-angle-plus">添加产品</label></li>
</ol>
 <div class="tpl-block ">

              <div class="am-g tpl-amazeui-form">


                  <div class="am-u-sm-12 am-u-md-9">
                      <s:form id='role_add_formId' class="am-form am-form-horizontal" namespace="/manage"  action="product_add" method="post">
                          <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">品牌名 / productName</label>
                              <div class="am-u-sm-9">
                               	<s:select list="productBrands" theme="simple" name="productName" onblur="isNum('productNameError',this.value,'品牌名')" headerKey="" headerValue="--请选择品牌"></s:select>
                                <span class="check" id="productNameError">*</span>
                              </div>
                          </div>
						 <input style="display:none" type="text" value="${session.manageId}" name="manageId">
						 <input style="display: none" type="text" value="add" name="state">
							 		 	
						<div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">产品类型/ productType</label>
                              <div class="am-u-sm-9">
                                 <s:select list="productTypes" theme="simple" name="productType" onblur="isNum('productTypeError',this.value,'产品类型')" headerKey="" headerValue="--请选择产品类型"></s:select>
                                 <span class="check" id="productTypeError">*</span>
                              </div>
                          </div>
                          <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">厂家地址/ venderAddress</label>
                              <div class="am-u-sm-9">
          
                                <textarea name="venderAddress" class="" rows="10" id="user-intro" placeholder="请输入厂商地址 / venderAddress" onblur="isNum('venderAddressError',this.value,'厂商地址');checkLen('RoleNameError',this.value,5,100)"></textarea><span class="check" id="venderAddressError">*</span>
                                 
                              </div>
                          </div>
                          
						<div align='center'>
                            <input style="margin-right:25%" id="subId" onclick="SubCheck('role_add_formId','check')" type="button" value="添加" class="am-btn am-btn-primary"/>
                             
                            <a href="<%=path%>/manage/product_list?manageId=<%=session.getAttribute("manageId")%>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                         </div>     
                      </s:form>
                  </div>
              </div>
     </div></div></div>
</body>

</html>