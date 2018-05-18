<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
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
<link rel="icon" type="image/png" href="<%=path %>/amz/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path %>/amz/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path %>/amz/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path %>/amz/assets/css/admin.css">
<link rel="stylesheet" href="<%=path %>/amz/assets/css/app.css">
<script src="<%=path %>/amz/assets/js/echarts.min.js"></script>
<script src="<%=path %>/amz/assets/js/main.js"></script>
<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
<script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
<script src="<%=path%>/amz/assets/js/app.js"></script>
<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
<script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
<script src="<%=path%>/amz/assets/js/iscroll.js"></script>
<script src="<%=path%>/amz/assets/js/app.js"></script>
<style type="text/css">

.check{
	color:red;
}
</style>
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
        <div class="tpl-portlet">
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" class="am-icon-home">首页</a></li>
				  <li><a href="<%=path%>/user/order_list?order.userId=${session.userId}"  class="am-icon-columns">订单列表</a></li>
				  <li><label class="am-icon-plus">添加订单</label></li>
				</ol>
					 <div class="tpl-block " >
					
					   <div class="am-g tpl-amazeui-form">

                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form id="order_add_formId" class="am-form am-form-horizontal" namespace="/user"  action="order_add" method="post">
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">客户姓名 /ClientName</label>
                                    <div class="am-u-sm-9">
      
                                    	 <s:select list="clientsName" theme="simple"  onblur="isNum('ClientNameError',this.value,'客户姓名')" name="clienName"
											headerKey="%{order.clienName}" headerValue="--请选择客户">
										</s:select><span class="check" id="ClientNameError">*</span>
										
                                    </div>
                                </div>
								<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">发货时间 <span class="tpl-form-line-small-title">Time</span></label>
                                    <div class="am-u-sm-9">
                                        <input type="text" class="am-form-field tpl-form-no-bg" placeholder="发货时间" data-am-datepicker="" name="sendTime" readonly/>
                                        <small>发货时间为必填</small>
                                    </div>
                                </div>
                               
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">产品名 / ProductName</label>
                                    <div class="am-u-sm-9">
                                         <s:select list="productsName" theme="simple"  onblur="isNum('productNameError',this.value,'客户姓名')" name="productName"
											headerKey="%{order.clienName}" headerValue="--请选择产品">
										</s:select>
                                     		<span class="check" id="productNameError">*</span>
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">数量/个</label>
                                    <div class="am-u-sm-9">
                                        <input type="tel" name="productNum" id="user-phone" placeholder="输入数量 / Num" onblur="isNum('ProductNumError',this.value,'数量');isNumber('ProductNumError',this.value,'数量');checkLen('ProductNumError',this.value,0,8)">
                                        <span class="check" id="ProductNumError">*</span>
                                    </div>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">单价/元</label>
                                    <div class="am-u-sm-9">
                                        <input type="tel" name="productPrice" id="user-phone" placeholder="单价 / Price" onblur="isNum('ProductPriceError',this.value,'单价');isNumber('ProductPriceError',this.value,'单价');checkLen('ProductPriceError',this.value,0,8)">
                                        <span class="check" id="ProductPriceError">*</span>
                                    </div>
                                </div>
                               
							 	<div class="am-form-group">
                                      <label for="user-intro" class="am-u-sm-3 am-form-label">收货地址 / address</label>
                                      <div class="am-u-sm-9">
                                          <textarea name="address" class="" rows="10" id="user-intro" placeholder="请输入收货地址 / address" onblur="isNum('addressError',this.value,'地址');checkLen('addressError',this.value,5,100)"></textarea>
                                          <span class="check" id="addressError">*</span>
                                      </div>
                                 </div>
                                	
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <div class="am-u-sm-9">
                                        <input type="tel" name="phoneNum" id="user-phone" placeholder="输入用户的电话号码 / Telephone" onblur="isNum('TelephoneError',this.value,'电话');checkLen('TelephoneError',this.value,11,0);">
                                        <span class="check" id="TelephoneError">*</span>
                                    </div>
                                </div>
							 	<input style="display:none" type="text" value="<%=session.getAttribute("userId")%>" name="userId">
							 	
							 	<!-- <input style="display: none" type="text" value="0" name="isSend"> -->
							 	
                                <div align='center'>
		                            <input style="margin-right:25%" id="subId" onclick="SubCheck('order_add_formId','check')" type="button" value="添加" class="am-btn am-btn-primary"/>
		                             
		                            <a href="<%=path%>/user/order_list?order.userId=<%=session.getAttribute("userId")%>"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                         		</div>
                            </s:form>
                        </div>
                    </div>
                </div>
                </div></div>
</body>
</html>