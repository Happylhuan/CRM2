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
<link rel="icon" type="image/png" href="<%=path%>/amz/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path%>/amz/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path%>/amz/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path%>/amz/assets/css/admin.css">
<link rel="stylesheet" href="<%=path%>/amz/assets/css/app.css">
<script src="<%=path%>/amz/assets/js/echarts.min.js"></script>
<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
    <script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
    <script src="<%=path%>/amz/assets/js/iscroll.js"></script>
    <script src="<%=path%>/amz/assets/js/app.js"></script>
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
 <div class="tpl-block ">
<%-- <div class="caption font-green bold">
					        <span class="am-icon-code"></span> LH117-${order.orderId}/订单详情
					 </div>  <hr> --%>
					 <ol class="am-breadcrumb">
						  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
						  <li><a href="<%=path%>/manage/order_managelist?manageId=${session.manageId}" onclick="changeParentTy('orderMenu');manageOpenul('product_ul')" class="am-icon-home">订单管理</a></li>
						  <li><label  class="am-icon-calendar">LH117-${order.orderId}/订单详情</label></li>
					</ol>
                    <div align='center' class="am-g tpl-amazeui-form">
							  <div class="am-u-sm-12 am-u-md-9">
								<div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">销售姓名 /UserName</label>
                                    <label> ${order.userName}</label>
                                </div>
							  
                                <div class="am-form-group">
                                    <label for="user-name" class="am-u-sm-3 am-form-label">客户姓名 /ClientName</label>
                                    <label> ${order.clienName}</label>
                                </div>
	
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">产品名 / ProductName</label>
                                 		<label> ${order.productName}</label>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">数量/件</label>
                                 		<label> ${order.productNum}</label>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">价格/元</label>
                                 		<label> ${order.productPrice}</label>
                                </div>
                                <div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">总价/元</label>
                                 		<label> ${order.totalPrice}</label>
                                </div>
									<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">下单时间 / orderTime</label>
                                    <label> <s:date format="yyyy-MM-dd hh:mm" name="order.orderTime"/></label>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">发送时间 / sendTime</label>
                                     <label> <s:date format="yyyy-MM-dd hh:mm" name="order.sendTime"/></label>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">收货地址 / address</label>
                                   		<label> ${order.address}</label>
                                	</div>
                                	<div class="am-form-group">
                                    <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
                                    <label> ${order.phoneNum}</label>
                              		</div>
						 				</div>
                           		<div align='center' class="am-form-group">
                                 	<div class="am-u-sm-9 am-u-sm-push-3">
                                      <a href="<%=path%>/manage/order_managelist?manageId=<%=session.getAttribute("manageId")%>"><input type="button" value="返回" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
                </div>
                
</body>

</html>