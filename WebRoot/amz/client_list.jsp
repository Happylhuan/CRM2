<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script src="amz/assets/js/jquery.min.js"></script>
<script src="amz/assets/js/amazeui.min.js"></script>
<script src="amz/assets/js/app.js"></script>
<script src="amz/assets/js/main.js"></script>
<script src="amz/assets/js/echarts.min.js"></script>
<style type="text/css">
td{
	text-align: center;
}
</style>
</head>

<body data-type="chart">
<div class="tpl-portlet">
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')"  class="am-icon-home">首页</a></li>
				  <li><label class="am-icon-users">客户列表</label></li>
				</ol>	 
			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
							
								<button type="button" 
									class="am-btn .am-btn-secondary am-round">
									<s:a style="color:black" href="amz/client_add.jsp" namespace="/user">
									<span class="am-icon-plus">
							    	</span>
									添加</s:a>
								</button>
								<button type="button" onclick="delall('<%=request.getContextPath()%>/user/client_dels?userId=<%=session.getAttribute("userId")%>&page.pageNo=<s:property value="page.pageNo"/>&client.delEle=')"
									class="am-btn .am-btn-secondary am-round">
									<span class="am-icon-trash-o"></span> 删除
								</button>
								
							</div>
						</div>
					</div>
					<form action="<%=path%>/user/client_list">
					
				
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-form-group">
								<select id="selectID" 
									data-am-selected="{btnSize: 'sm'}">
									<option value="clientName">按客户名</option>
									<option value="clientIdcard">按邮箱</option>
									<option value="clientPhone">按电话</option>
									
								</select>
							</div>
							
						</div>
					<input style="display:none" type="text" value="<%=session.getAttribute("userId")%>" name="userId">
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
						<div class="am-u-sm-12">
							<div style="width:100%;">
								<table
									class="am-table am-table-striped am-table-hover table-main" style="padding: 0">
									<thead>
										<tr>
											<td style="width:11%"  class="table-check"><input type="checkbox"
												class="tpl-table-fz-check"></td>
											<td style="width:10%"  class="headpro">客户名</td>
											<td style="width:19%"  class="headpro">邮箱</td>
											<td style="width:19%"  class="headpro">电话</td>
											<td style="width:11%"  class="headpro">是否启用</td>
											<td style="width:30%"  class="headpro"><b>操作</b></td>
										</tr>
									</thead>
								</table>
							</div>
							<div class="am-scrollable-vertical" style="width:100%; height:315px;">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<tbody>
									<s:if test="page.allRows == 0">
										<div style="text-align: center;margin:0 auto;margin-top: 100px">无数据</div>
									</s:if>

										<s:iterator value="clients">
											<tr>
												<td style="width:10%" ><input type="checkbox"></td>										
												<td style="width:10%"  class="pro"><s:property value="clientName" /></td>
												<td style="width:20%"  class="pro"><s:property value="clientIdcard" /></td>
												<td style="width:20%"  class="pro"><s:property value="clientPhone" /></td>
												<td style="width:10%"  class="pro">
												<s:if test="clientIsuser">√</s:if>
												<s:else>×</s:else>
												</td>
												<td style="width:30%"  class="pro">
												
												<s:a action="client_change" namespace="/user">
														<button
															class="am-btn am-btn-default am-btn-xs am-text-secondary">
															<span class="am-icon-pencil-square-o">
															<s:if test="clientIsuser">弃用</s:if>
															<s:else>启用</s:else>
															</span> 
														</button>
														<s:param name="client.clientId" value="clientId"></s:param>
														<s:param name="page.pageNo" value="page.pageNo"></s:param>
														<s:param name="client.userId" value="userId"></s:param>
														<s:param name="client.state" value="%{'del'}"></s:param>
													</s:a>
												<s:a action="client_del"
														namespace="/user">
														<button
															class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
															<span class="am-icon-trash-o"></span> 删除
														</button>
														<s:param name="client.clientId" value="clientId"></s:param>
														<s:param name="page.pageNo" value="page.pageNo"></s:param>
														<s:param name="client.userId" value="userId"></s:param>
														<s:param name="client.state" value="%{'del'}"></s:param>
													</s:a> 
													<s:a action="client_getup" namespace="/user">
														<button
															class="am-btn am-btn-default am-btn-xs am-text-secondary">
															<span class="am-icon-pencil-square-o"></span> 更新
														</button>
														<s:param name="client.clientId" value="clientId"></s:param>
														<s:param name="page.pageNo" value="page.pageNo"></s:param>
													</s:a></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
	</div>
			
        	<div>	
			<h6 align="left" style="color:#03a9f4;">共&nbsp;<s:property value="pageModel.page.allRows"/>&nbsp;条数据,&nbsp;&nbsp;每页&nbsp;<s:property value="pageModel.page.pageSize"/>&nbsp;条 ,&nbsp;&nbsp;共&nbsp;<s:property value="pageModel.page.totalPage"/>&nbsp;页</h6>
    		<div style="margin-left: 32%">
    		   <ul class="am-pagination tpl-pagination" >	
	    		   <s:if test="(page.pageNo - 1) <= 0">
	    		   		<li class="am-disabled"><a >首页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a >«</a></li>
	    		   </s:if>
	    		   <s:else>
		    		    <li class="am-active"><a href="<%=path %>/user/client_list.action?page.pageNo=1&userId=<%=session.getAttribute("userId")%>">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/user/client_list.action?page.pageNo=<s:property value="page.pageNo - 1"/>&userId=<%=session.getAttribute("userId")%>">«</a></li>
	    		   </s:else>
	    		   
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo"/></a></li>
	    		   
	    		   <s:if test="(page.pageNo + 1) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/user/client_list.action?page.pageNo=<s:property value="page.pageNo + 1"/>&userId=<%=session.getAttribute("userId")%>">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/user/client_list.action?page.pageNo=<s:property value="page.totalPage"/>&userId=<%=session.getAttribute("userId")%>">尾页</a></li>
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