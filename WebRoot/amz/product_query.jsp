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
<script src="amz/assets/js/main.js"></script>
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
				  <li><label class="am-icon-list">产品列表</label></li>
				</ol>	 
			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
							
								<button style="visibility:hidden;" type="button" 
									class="am-btn am-btn-default am-btn-success">
									<s:a href="amz/client_add.jsp">
									<span class="am-icon-plus">
							    	</span>
									添加</s:a>
								</button>
								
								<button style="visibility:hidden;" type="button"
									class="am-btn am-btn-default am-btn-secondary">
									<span class="am-icon-save"></span> 保存
								</button>
								<button style="visibility:hidden;" type="button"
									class="am-btn am-btn-default am-btn-warning">
									<span class="am-icon-archive"></span> 审核
								</button>
								<button style="visibility:hidden;" type="button"
									class="am-btn am-btn-default am-btn-danger">
									<span class="am-icon-trash-o"></span> 删除
								</button>
								
							</div>
						</div>
					</div>
					<form action="<%=path%>/user/product_query">
					
				
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-form-group">
								<select id="selectID" 
									data-am-selected="{btnSize: 'sm'}">
									<option value="productName">按产品名</option>
									<option value="productType">按产品类型</option>
									<option value="addTime">按添加时间</option>
									
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
					<script type="text/javascript">
				
					function delall(){
				 	var page = document.getElementById("echartsData").value;
				    var ele = document.getElementsByName("checkId");
				    var eles = "";
				    for(var i=0;i<ele.length;i++){
				    	if(ele[i].checked){
				    		eles+=ele[i].value+";";
				    	}
				    }
				    
				    var c = window.confirm("是否确定删除选中？");
				    if(c){
				    window.location="<%=request.getContextPath()%>/user/user_dels?user.delEle="+eles+"&page.pageNo="+page+"&user.manageName=<%=session.getAttribute("loginName")%>";
				    }
				    }
					</script>
					<input type="hidden" id="echartsData" value='<s:property value="page.pageNo"/>'/>
					</form>
					<div class="am-g">
						<div class="am-u-sm-12">
							<div style="width:100%;">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<td style="width: 5%"  class="table-check"><input id="allCheckId" onclick="chanceAll()" type="checkbox"
												class="tpl-table-fz-check"></td>
											<td style="width: 15%"  class="headpro">产品名</td>
											<td style="width: 14%" class="headpro">产品类型</td>
											<td style="width: 16%" class="headpro">添加时间</td>
											<td style="width: 50%" class="headpro">工厂地址</td>
											
										</tr>
									</thead>
									</table>
							</div>
							<div class="am-scrollable-vertical" style="width:100%; height:315px;">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<tbody>

										<s:iterator value="products">
											<tr>
												<td style="width: 5%"><input name="checkId" type="checkbox"></td>
												
												<td style="width: 15%" class="pro"><s:property value="productName" /></td>
												<td style="width: 15%" class="pro"><s:property value="productType" /></td>
												<td style="width: 15%" class="pro"><s:date format="yyyy-MM-dd" name="addTime"/></td>
												<td style="width: 50%" class="pro"><s:property value="venderAddress" /></td>
												
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
		    		    <li class="am-active"><a href="<%=path %>/user/product_query.action?page.pageNo=1&userId=${session.userId}">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/user/product_query.action?page.pageNo=<s:property value="page.pageNo - 1"/>&userId=${session.userId}">«</a></li>
	    		   </s:else>
	    		   
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo"/></a></li>
	    		   
	    		   <s:if test="(page.pageNo + 1) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/user/product_query.action?page.pageNo=<s:property value="page.pageNo + 1"/>&userId=${session.userId}">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/user/product_query.action?page.pageNo=<s:property value="page.totalPage"/>&userId=${session.userId}">尾页</a></li>
	    		   </s:else>
	        	</ul>
	        </div>
        </div>
        
       		</div>
       		</div>
					
				</div>
				</div>

			</div>
	<script src="amz/assets/js/jquery.min.js"></script>
	<script src="amz/assets/js/amazeui.min.js"></script>
	<script src="amz/assets/js/app.js"></script>
</body>

</html>