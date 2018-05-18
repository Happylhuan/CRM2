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
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
		<ol class="am-breadcrumb">
		  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" class="am-icon-home">首页</a></li>
		  <li><a href="<%=path%>/user/order_list?order.userId=${session.userId}" class="am-icon-calendar">订单列表</a></li>
		  <li><label class="am-icon-code">更新订单</label></li>
		</ol> 
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form class="am-form am-form-horizontal" namespace="/user" action="order_update" method="post">
                            <input style="display: none" type="text" name="userId"
					value="${order.userId}">
					  <input style="display: none" type="text" name="orderId"
					value="${order.orderId}">
					<input style="display: none" type="text" value="${page.pageNo}" name="page.pageNo">
					<input style="display: none" value="${order.orderTime}" name="orderTime" type="text" >
                    <input style="display: none" value="${order.isSend}" name="isSend" type="text" >
                    <input style="display: none" value="${order.productPrice}" name="productPrice" type="text" >
                    <input style="display: none" value="${order.productNum}" name="productNum" type="text" >
                    <input style="display: none" value="${order.totalPrice}" name="totalPrice" type="text" >
                    
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">客户姓名 /ClientName</label>
                                    <div class="am-u-sm-9">
                                        <input name="clienName" type="text" value="${order.clienName}" placeholder="客户姓名 /ClientName">
                                        <small>客户姓名^_^</small>
                                    </div>
                                </div>

                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">产品名 / ProductName</label>
                                    <div class="am-u-sm-9">
                                        <input name="productName" value="${order.productName}" type="text"  placeholder="输入产品名 / productName">
                                        <small>产品名你懂得...</small>
                                    </div>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">发送时间 / sendTime</label>
                                    <div class="am-u-sm-9">
                                        <input value="${order.sendTime}" name="sendTime" type="text"  placeholder="发布时间 / sendTime">
                                      
                                    </div>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">收货地址 / address</label>
                                    <div class="am-u-sm-9">
                                          <textarea  name="address" onblur="isNum('addressError',this.value,'地址');checkLen('TelephoneError',this.value,5,100)" class="" rows="10" id="user-intro" placeholder="请输入收货地址 / address">${order.address}</textarea>
                                          <span class="check" id="addressError"></span>
                                    </div>
                                	</div>
                                <div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <div class="am-u-sm-9">
                                        <input value="${order.phoneNum}" type="tel" name="phoneNum" id="user-phone" placeholder="输入客户的电话号码 / Telephone" onblur="isNum('TelephoneError',this.value,'电话');checkLen('TelephoneError',this.value,11,0)">
                                        <span class="check" id="TelephoneError"></span>
                                    </div>
                                </div>
							 	
                                <div  align='center' class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button  style="margin-right:25%" type="submit" class="am-btn am-btn-primary">保存修改</button>
   										<a href="<%=path%>/user/order_list?userId=<%=session.getAttribute("userId")%>&page.pageNo=${page.pageNo}"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>

                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>