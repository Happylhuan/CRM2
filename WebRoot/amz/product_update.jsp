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
  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
  <li><a href="<%=path%>/manage/product_list?product.manageId=${session.manageId}" onclick="changeParentTy('productMenu');manageOpenul('product_ul','productStar1')" class="am-icon-list">产品列表</a></li>
  <li><label  class="am-icon-angle-code">更新产品</label></li>
</ol>
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form class="am-form am-form-horizontal" namespace="/manage"  id="product_updformId" action="product_update" method="post">
                         
								<input style="display: none" type="text" name="productId"
								value="${product.productId}">
								<input style="display: none" type="text" name="state"
								value="upd">
								<input style="display: none" type="text" name="addTime"
								value="${product.addTime}">
								<input style="display: none" type="text" name="manageId"
								value="${product.manageId}">
								<input style="display: none" type="text" value="${page.pageNo}" name="page.pageNo">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">品牌名 / productName</label>
                                    <div class="am-u-sm-9">
                                        <input name="productName" type="text" value="${product.productName}" placeholder="品牌名 / productName" onblur="isNum('productNameeError',this.value,'客户名称');checkLen('productNameeError',this.value,0,5)"><span class="check" id="productNameeError"></span>
                                       
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">产品类型/ productType</label>
                                    <div class="am-u-sm-9">
                                        <input name="productType" value="${product.productType}" type="text"  placeholder="产品类型/ productType" onblur="isNum('productTypeError',this.value,'身份证号');checkLen('productTypeError',this.value,0,18)"><span class="check" id="productTypeError"></span>
                                       
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">厂家地址/ venderAddress</label>
                                    <div class="am-u-sm-9">
                                          <textarea  name="venderAddress"  placeholder="厂家地址/ venderAddress" onblur="isNum('venderAddressError',this.value,'厂家地址');checkLen('venderAddressError',this.value,5,100)"><s:property value="product.venderAddress"/></textarea><span class="check" id="venderAddressError"></span>
                                       
                                    </div>
                                	</div>

                                <div  align='center' class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button  style="margin-right:25%" type="button" onclick="SubCheck('product_updformId','check')" class="am-btn am-btn-primary">保存修改</button>
   										<a href="<%=path%>/manage/product_list?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=${page.pageNo}"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>

                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>