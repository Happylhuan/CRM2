<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String isSend = null;
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
<script src="amz/assets/js/jquery.min.js"></script>
<script src="amz/assets/js/amazeui.min.js"></script>
<script src="amz/assets/js/app.js"></script>
<script src="amz/assets/js/main.js"></script>
<style type="text/css">
td{
	text-align: center;
}
</style>
</head>

<body >
			 <div class="tpl-portlet">
 		 		<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
				  <li><label  class="am-icon-calendar">订单列表</label></li>
				</ol>	

			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
							
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-send"></span>
										<s:a action="order_managelist">
										<span style="color:black">已发送</span>
										<s:param name="order.sendState" value="%{'yes'}"></s:param>
										<s:param name="order.manageId">${session.manageId}</s:param>
										</s:a> 

								</button>
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-all"></span>
										<s:a action="order_managelist">
										<span style="color:black">全部</span>
										<s:param name="order.sendState"  value="%{'all'}"></s:param>
										<s:param name="order.manageId">${session.manageId}</s:param>
										</s:a>
								</button>
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-send-o"></span>
										<s:a action="order_managelist">
										<span style="color:black">未发送</span>
										<s:param name="order.sendState" value="%{'no'}"></s:param>
										<s:param name="order.manageId">${session.manageId}</s:param>
										</s:a>
								</button>
								
								
							</div>
						</div>
					</div>
					<form action="<%=path%>/manage/order_managelist">
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-form-group">
								<select id="selectID" 
									data-am-selected="{btnSize: 'sm'}">
									<option value="clienName">输入客户名</option>
									<option value="productName">输入产品名</option>
									<option value="phoneNum">输入客户号码</option>
								</select>
								
							</div>
						</div>
						<input style="display:none" type="text" value="<%=session.getAttribute("manageId")%>" name="manageId">
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-input-group am-input-group-sm">
								<input value="" id="search" type="text" class="am-form-field">
								<span class="am-input-group-btn"> 
								<input type="submit"
									onclick="getName()"
									class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
									value="搜索" />

								</span>
							</div>
						</div>
						<script>
							function getName() {
								var nameval = document.getElementById('selectID').value;
								var inp = document.getElementById('search');
								inp.name = nameval;
							}
							
							
						</script>

					</form>
					<div class="am-g">
						<div class="am-u-sm-12 " >
							<div style="width:100%;">
								<table
									class="am-table am-table-striped am-table-hover table-main" style="padding: 0">
									<thead>
										<tr>
											
											<td style="width:14%" class="headpro">订单号</td>
											<td style="width:16%" class="headpro">客户名</td>
											<td style="width:19%" class="headpro">产品名</td>
											<td style="width:20%" class="headpro">下单时间</td>
											<td style="width:20%" class="headpro">发送时间</td>
											<td style="width:11%" class="headpro">是否发送</td>
										</tr>
									</thead>
								</table>
							</div>
							<div class="am-scrollable-vertical" style="width:100%; height:315px;">
								<table
									class="am-table am-table-striped am-table-hover table-main" style="padding: 0">
									<tbody >
										<s:iterator  status="idx" value="orders" >
											<tr>
												<td style="width:14%" class="pro"><s:a action="/manage/order_getinfo" namespace="">LH117-<s:property value="orderId" />
													<s:param name="order.userId" value="userId"></s:param>
													<s:param name="order.orderId" value="orderId"></s:param>
												</s:a></td>
												<td style="width:16%" class="pro"><s:property value="clienName" /></td>
												<td style="width:20%" class="pro"><s:property value="productName" /></td>
												
												<td style="width:20%" class="pro"><s:date format="yyyy-MM-dd hh:mm" name="orderTime"/></td>
												<td style="width:20%" class="pro"><s:date format="yyyy-MM-dd hh:mm" name="sendTime"/></td>
												<td style="width:10%" class="pro">
												<s:if test="isSend">是</s:if>
												<s:else>否</s:else>
												</td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
        <div>	
			<small align="left" style="color:#03a9f4;">共&nbsp;<s:property value="pageModel.page.allRows"/>&nbsp;条数据,&nbsp;&nbsp;每页&nbsp;<s:property value="pageModel.page.pageSize"/>&nbsp;条 ,&nbsp;&nbsp;共&nbsp;<s:property value="pageModel.page.totalPage"/>&nbsp;页</small>
    		<div style="margin-left: 32%">
    		   <ul class="am-pagination tpl-pagination" >	
	    		   <s:if test="(page.pageNo - 1) <= 0">
	    		   		<li class="am-disabled"><a >首页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a >«</a></li>
	    		   </s:if>
	    		   <s:else>
		    		    <li class="am-active"><a href="<%=path %>/manage/order_managelist.action?page.pageNo=1&manageId=${session.manageId}">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/manage/order_managelist.action?page.pageNo=<s:property value="page.pageNo - 1"/>&manageId=${session.manageId}">«</a></li>
	    		   </s:else>
	    		   
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo"/></a></li>
	    		   
	    		   <s:if test="(page.pageNo + 1) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/manage/order_managelist.action?page.pageNo=<s:property value="page.pageNo + 1"/>&manageId=${session.manageId}">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/manage/order_managelist.action?page.pageNo=<s:property value="page.totalPage"/>&manageId=${session.manageId}">尾页</a></li>
	    		   </s:else>
	        	</ul>
	        </div>
        </div>
        
        
       		</div>
       		</div>
					
				</div>
				</div>

			</div>
	
</body>

</html>