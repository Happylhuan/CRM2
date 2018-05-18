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

<body data-type="chart" >

	   <div class="tpl-portlet" >
				<ol class="am-breadcrumb">
				  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
				  <li><label  class="am-icon-user">人员列表</label></li>
				</ol>
			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						
						<div class="am-btn-toolbar">
							
							<div class="am-btn-group am-btn-group-xs">
								
								<button type="button" 
									class="am-btn .am-btn-secondary am-round">
									<s:a style="color:black" action="user_addBef" namespace="/manage">
									<span class="am-icon-plus">
									<s:param name="manageId"><%=session.getAttribute("manageId")%></s:param>
							    	</span>
									添加</s:a>
								</button>
								<button type="button" onclick="delall('<%=request.getContextPath()%>/manage/user_dels?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.pageNo"/>&user.delEle=')"
									class="dels am-btn .am-btn-default am-round" >
									<span class="am-icon-trash-o"></span> 删除
								</button>

							</div>
						</div>
					</div><input type="hidden" id="echartsData" value='<s:property value="page.pageNo"/>'/>
					<form action="<%=path%>/manage/user_list">
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-form-group">
								<select id="selectID" 
									data-am-selected="{btnSize: 'sm'}">
									<option value="loginName">按登陆账号</option>
									<option value="userName">按用户名称</option>
									<option value="phoneNumber">按电话</option>
									<option value="role">按角色</option>
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
					</form>
			</div>	
					<div class="am-g">
						<div class="am-u-sm-12">
							<div style="width:100%;">
								<table
									class="am-table am-table-striped am-table-hover table-main" style="padding: 0"> 
									<thead>
										<tr>
											<td style="width:5%" class="table-check">
											<input id="allCheckId" onclick="chanceAll()" type="checkbox" class="tpl-table-fz-check"></td>
											<td style="width:10%" class="headpro">编号</td>
											<td style="width:10%" class="headpro">登陆账号</td>
											<td style="width:9%" class="headpro">姓名</td>
											<td style="width:11%" class="headpro">密码</td>
											<td style="width:13%" class="headpro">电话</td>
											<td style="width:12%" class="headpro">角色</td>
											<td style="width:8%" class="headpro">权限</td>
											<td style="width:22%" class="headpro"><b>操作</b></td>
										</tr>
									</thead>
									</table>
									</div>
									<div class="am-scrollable-vertical" style="width:100%; height:315px;">
									<table class="am-table am-table-striped am-table-hover table-main" style="padding: 0">
									<tbody>
									<s:if test="page.allRows == 0">
										<div style="text-align: center;margin:0 auto;margin-top: 100px">无数据</div>
									</s:if>
										<s:iterator value="users">
											<tr>
												<td style="width:5%"><input name="checkId" type="checkbox" value="<s:property value="userId" />"></td>
												<td style="width:10%" class="pro"><s:property value="userId" /></td>
												<td style="width:10%" class="pro"><s:property value="loginName" /></td>
												<td style="width:10%" class="pro"><s:property value="userName" /></td>
												<td style="width:10%" class="pro"><s:property value="passWord" /></td>
												<td style="width:15%" class="pro"><s:property value="phoneNumber" /></td>
												<td style="width:10%" class="pro"><s:property value="role" /></td>
												<td style="width:10%" class="pro"><s:property value="power" /></td>
												<td style="width:20%" class="pro">
												<s:a action="user_del" namespace="/manage">
														<button
															class="del am-btn am-btn-default am-btn-xs am-round am-text-danger am-hide-sm-only">
															<span class="am-icon-trash-o"></span> 删除
														</button>
														<s:param name="user.userId" value="userId"></s:param>
														<s:param name="user.state" value="%{'del'}"></s:param>
														<s:param name="user.manageId" value="manageId"></s:param>
														<s:param name="page.pageNo" value="page.pageNo"></s:param>
													</s:a>
													<s:a action="user_getup" namespace="/manage">
														<button
															class="am-btn am-btn-default am-round am-btn-xs am-text-secondary">
															<span class="am-icon-pencil-square-o"></span> 更新
														</button>
														<s:param name="user.userId" value="userId"></s:param>
														<s:param name="user.manageId" value="manageId"></s:param>
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
		    		    <li class="am-active"><a href="<%=path %>/manage/user_list.action?page.pageNo=1&manageId=<%=session.getAttribute("manageId")%>">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/manage/user_list.action?page.pageNo=<s:property value="page.pageNo - 1"/>&manageId=<%=session.getAttribute("manageId")%>">«</a></li>
	    		   </s:else>
	    		   
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo"/></a></li>
	    		   
	    		   <s:if test="(page.pageNo + 1) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/manage/user_list.action?page.pageNo=<s:property value="page.pageNo + 1"/>&manageId=<%=session.getAttribute("manageId")%>">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/manage/user_list.action?page.pageNo=<s:property value="page.totalPage"/>&manageId=<%=session.getAttribute("manageId")%>">尾页</a></li>
	    		   </s:else>
	        	</ul>
	        </div>
        </div>
        
       		</div>
       		</div>
					
				</div>
				</div>
</body>

</html>