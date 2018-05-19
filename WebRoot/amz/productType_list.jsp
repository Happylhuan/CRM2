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
				  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul','productStar1')" class="am-icon-home">首页</a></li>
				  <li><label  class="am-icon-angle-list">产品类型列表</label></li>
				</ol>
			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
							
								<button type="button" 
									class="am-btn .am-btn-secondary am-round">
									<s:a  style="color:black" href="amz/productType_add.jsp">
									<span class="am-icon-plus">
							    	</span>
									添加</s:a>
								</button>
								<button type="button" onclick="delall('<%=request.getContextPath()%>/manage/productType_dels?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.pageNo"/>&productType.delEle=')"
									class="am-btn .am-btn-default am-round" >
									<span class="am-icon-trash-o"></span> 删除
								</button>
								
							</div>
						</div>
					</div>
					<form action="<%=path%>/manage/productType_list">
					
				
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-form-group">
								<select id="selectID" 
									data-am-selected="{btnSize: 'sm'}">
									<option value="productTypeName">按产品类型名</option>
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
						
				<input type="hidden" id="echartsData" value='<s:property value="page.pageNo"/>'/>
					</form>
					<div class="am-g">
						<div class="am-u-sm-12">
							
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<td class="table-check"><input id="allCheckId" onclick="chanceAll()" type="checkbox"
												class="tpl-table-fz-check"></td>
											<td class="headpro">产品类型</td>
											<td class="headpro"><b>操作</b></td>
										</tr>
									</thead>
									<tbody>

										<s:iterator value="productTypes">
											<tr>
												<td><input name="checkId"  type="checkbox" value='<s:property value="productTypeId"/>'></td>
												<td class="pro"><s:property value="productTypeName" /></td>
												<td class="pro">
												<s:a action="productType_del"
														namespace="/manage">
														<button
															class="am-btn am-btn-default am-round am-btn-xs am-text-danger am-hide-sm-only">
															<span class="am-icon-trash-o"></span> 删除
														</button>
														<s:param name="productType.productTypeId" value="productTypeId"></s:param>
														<s:param name="page.pageNo" value="page.pageNo"></s:param>
														<s:param name="manageId" value="manageId"></s:param>
													</s:a> 
													</td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
	
         <div>	
			<small align="left" style="color:#03a9f4;">共&nbsp;<s:property value="pageModel.page.allRows"/>&nbsp;条数据,&nbsp;&nbsp;每页&nbsp;<s:property value="pageModel.page.pageSize"/>&nbsp;条 ,&nbsp;&nbsp;共&nbsp;<s:property value="pageModel.page.totalPage"/>&nbsp;页</small>
    		<div style="margin-left: 32%">
    		   <ul class="am-pagination tpl-pagination" >	
	    		   <s:if test="(page.pageNo - 1) <= 0">
	    		   		<li class="am-disabled"><a >首页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a >«</a></li>
	    		   </s:if>
	    		   <s:else>
		    		    <li class="am-active"><a href="<%=path %>/manage/productType_list.action?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=1">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/manage/productType_list.action?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.pageNo - 1"/>">«</a></li>
	    		   </s:else>
	    		   
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo"/></a></li>
	    		   
	    		   <s:if test="(page.pageNo + 1) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/manage/productType_list.action?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.pageNo + 1"/>">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/manage/productType_list.action?manageId=<%=session.getAttribute("manageId")%>&page.pageNo=<s:property value="page.totalPage"/>">尾页</a></li>
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