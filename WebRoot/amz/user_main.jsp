<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>

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

</head>

<body data-type="index" >

            <div class="tpl-portlet">
                <div class="tpl-portlet-title">
                    <div class="tpl-caption font-red ">
                        <i class="am-icon-bar-chart"></i>
                        <span>销售额Top5</span>
                    </div>
                    <div class="actions">
                        <ul class="actions-btn">
                            <li class="purple-on">昨天</li>
                            <li class="green">前天</li>
                            <li class="dark">本周</li>
                        </ul>
                    </div>
                </div>
                <div class="tpl-scrollable">
               
                    <div class="number-stats">
                  
                     	<div class="stat-number am-fr am-u-md-6" style="width: 40%;float: left">
                            <div class="title am-text-right">订单Total/单 </div>
                            <div class="number am-text-right am-text-success"><s:property value="totalNum.orderTotalNum"/> </div>
                        </div>
                     
                        <div class="stat-number am-fc am-u-md-6" style="width: 20%;float: left;text-align: center;">
                            <div class="title "> 销量Total/￥ </div>
                            <div class="number font-red "> <s:property value="%{formatDouble(totalNum.priceNum)}"/></div>
                        </div>
						<div class="stat-number am-fr am-u-md-6"  style="width: 40%;float: left">
                            <div class="title  am-text-left"> 客户Total/位 </div>
                            <div class="number am-text-left am-text-warning"> <s:property value="totalNum.clientTotalNum"/> </div>
                        </div>
                    </div>

                    <table class="am-table tpl-table">
                        <thead>
                        <tr class="tpl-table-uppercase">
                        	<th>排名</th>
                            <th>人员</th>
                            <th>角色</th>
                            <th>客户数</th>
                            <th>订单数</th>
                            <th>总销售额/￥</th>
                        </tr>
                        </thead>
                        <tbody>
                        
                        <s:iterator value="mainViews"  status='st' >
	                         <tr>
	                         <td><div class="tpl-caption font-red ">
                        
			                        <span>Top-<s:property value='#st.index+1'/></span>
			                    </div></td>
	                            <td>
	                                <img src="amz/assets/img/user0<s:property value='#st.index+1'/>.png" alt="" class="user-pic">
	                              <s:a action="main_getinfo" namespace="/manage">
	                              	<s:property value="userName" />
		                            <s:param name="user.userId" value="userId"></s:param>
		                          </s:a>
	                            </td>
	                            <td><s:property value="userRole" /></td>
	                            <td><div class="number am-text-success"> <s:property value="clientNum" /> </div></td>
	                             <td><div class="number am-text-success"><s:property value="%{formatOrder(orderNum)}" /> </div></td>
	                            <td class="font-green bold"><s:property value="%{formatDouble(totalPrice)}" /></td>
	                           
	                        </tr>
                        </s:iterator>
                       
                     
                       
                        </tbody>
                    </table>
                </div>
            </div>
</body>

</html>