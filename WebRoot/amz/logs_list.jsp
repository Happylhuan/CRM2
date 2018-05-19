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
<link rel="icon" type="image/png" href="<%=path%>amz/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path%>/amz/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path%>/amz/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path%>/amz/assets/css/admin.css">
<link rel="stylesheet" href="<%=path%>/amz/assets/css/app.css">
<script src="<%=path%>/amz/assets/js/echarts.min.js"></script>
<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
<script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
<script src="<%=path%>/amz/assets/js/app.js"></script>
<script src="<%=path%>/amz/assets/js/main.js"></script>
<style type="text/css">
td{
	text-align: center;
}
</style>
</head>

<body data-type="chart" >
	  		<div class="tpl-portlet" >
				
                <ol class="am-breadcrumb">
				  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')"  class="am-icon-home">首页</a></li>
				  <li><label class="am-icon-calendar">日志列表</label></li>
				</ol>		 
			<div class="tpl-block">
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						
						<div class="am-btn-toolbar">
							
							<div class="am-btn-group am-btn-group-xs">
								
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-send"></span>
										<s:a action="/user/list_log">
										<span style="color:black">工作日志</span>
										<s:param name="log.logStateStr" value="%{'gz'}"></s:param>
										<s:param name="log.userId">${session.userId}</s:param>
										</s:a> 

								</button>
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-all"></span>
										<s:a action="/user/list_log">
										<span style="color:black">全部</span>
										<s:param name="log.logStateStr" value="%{'all'}"></s:param>
										<s:param name="log.userId">${session.userId}</s:param>
										</s:a>
								</button>
								<button type="button"
									class="am-btn am-btn-default am-round">
									<span class="am-icon-send-o"></span>
										<s:a action="/user/list_log">
										<span style="color:black">生活日志</span>
										<s:param name="log.logStateStr" value="%{'sh'}"></s:param>
										<s:param name="log.userId">${session.userId}</s:param>
										</s:a>
								</button>
								
							</div>
						</div>
					</div><input type="hidden" id="echartsData" value='<s:property value="page.pageNo"/>'/>
					<form action="<%=path%>/user/user_list">
					
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
						<input style="display:none" type="text" value="<%=session.getAttribute("loginName")%>" name="manageName">
							 	
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
				<div class="am-g">
				
				<div class="am-u-sm-12"  >
				
				 <div class="tpl-left-nav tpl-left-nav-hover" style="position:fixed;">
            <div class="tpl-left-nav-title">
                	菜单 
            </div>
            <div class="tpl-left-nav-list" style="width:150px">
                <ul class="tpl-left-nav-menu">
                    <li class="tpl-left-nav-item">
                        <a id="indexMenu" href="<%=path%>/amz/logs_add.jsp" onclick="changeTy(this.id)" class="nav-link">
                            <span>添加日志</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
				<div class="am-scrollable-vertical" style="width:70%;margin: 0 auto; height:480px;">
				<ul>
				<s:if test="page.allRows == 0">
					<div style="text-align: center;margin:0 auto;margin-top: 100px">无数据</div>
				</s:if>
				<s:iterator var="log" value="logs" status="ss">
				
					<li>
					 <div class="am-u-sm-12 am-u-md-6 am-u-lg-4" style="width:100%;">
					<div class="tpl-table-images-content" >
						 			<div class="tpl-table-images-content-i-time">
                                    	<img style="width: 50px;height: 50px" src="<%=path%>/amz/assets/img/user02.png" alt=""><s:property value="userName"/>
                                    	
                                    	<div style="float: right">发布时间：<s:date format="yyyy-MM-dd hh:mm:ss" name="logAddtime"/></div>
                                    	
                                    </div>
                                    <div class=" tpl-table-images-content-block" style="text-align: center;">
                                       <h3>[&nbsp;<s:property value="logTitle"/>&nbsp;]</h3>
                                    </div>
                                   
                                    <div class="tpl-i-title" >
                                        <div style="word-break:break-all; ">
                                           	&nbsp;&nbsp;<s:property escapeHtml="false" value="logInfo"/><hr>
                                        </div>
                                    </div>
                               		<div class="tpl-table-images-content-block">
                                        <div >
                         					<div  style="text-align: center;">评论</div><br>
                                           <s:iterator var="ment2" value="ments" status="s" >
                                           		<b>${ment2.userName}</b>&nbsp;:&nbsp;${ment2.mentLog}
                                           		
                                           		<s:if test="#ment2.userId == #session.userId">
                                           		
                                           		<a style="float: right;font-size: small;" href="<%=path%>/user/del_ment?mentId=${ment2.mentId}&page.pageNo=${pageModel.page.pageNo}&userId=${session.userId}">删除</a>
                                           		
												</s:if>
												<s:else>
												<a style="float: right;font-size: small;visibility:hidden;" href="<%=path%>/user/del_ment?mentId=${ment2.mentId}&page.pageNo=${pageModel.page.pageNo}&userId=${session.userId}">删除</a>
												</s:else>
												<label style="float: right;font-size: small;"><s:date format="yyyy-MM-dd hh:mm" name="#ment2.mentTime"/>&nbsp;&nbsp;</label>    <hr style="padding: 0;margin: 0">
                                           	</s:iterator>
                                        </div>
                                    </div>
                         <div id="heiDiv${ss.index}"  style="width:100%;height:50px;">
                         <br>
			 				<form action="<%=path%>/user/add_ment?page.pageNo=${pageModel.page.pageNo}" method="post">
				 				<input placeholder="评论" id="mentText${ss.index}"  type="text" style="width:70%;display:inline;"  onclick="change('mentText${ss.index}','mentTextarea${ss.index}','heiDiv${ss.index}')">
				 				<input style="display:none" name="logId" value="${logId}">
				 				<input  style="display:none" name="userId" value="${session.userId}">
				 				<textarea  name="ment.mentLog" rows="6" cols="5" id="mentTextarea${ss.index}" placeholder="评论" style=" width:70%;display:none"  onblur="change('mentText${ss.index}','mentTextarea${ss.index}','heiDiv${ss.index}')"></textarea>
				 				<input id="subId" onclick="inputIsNull('mentText${ss.index}','mentTextarea${ss.index}',this.id)" type="button" value="点评"/>
				 				 <s:if test="#log.userId == #session.userId">
				 				 <a href="<%=path%>/user/del_log?logId=${logId}&page.pageNo=${pageModel.page.pageNo}&userId=${userId}"><input type="button" value="删除/"/></a>&nbsp;
				 				 <a href="<%=path%>/user/updBef_log?logId=${logId}&page.pageNo=${pageModel.page.pageNo}&userId=${userId}"><input type="button" value="修改/"/></a>
				 				 </s:if>
			 				</form>
 						</div>
				         </div>
						</div>
						</li>
						<%-- <s:property value="logTitle"/> 
						<s:property value="logAddtime"/>
						<s:property value="logInfo"/>
						<s:property value="logState"/> --%>
				</s:iterator>
				</ul>					
						
	       <%-- <div>	
			<h6 align="left" style="color:#03a9f4;">共&nbsp;<s:property value="pageModel.page.allRows"/>&nbsp;条数据,&nbsp;&nbsp;每页&nbsp;<s:property value="pageModel.page.pageSize"/>&nbsp;条 ,&nbsp;&nbsp;共&nbsp;<s:property value="pageModel.page.totalPage"/>&nbsp;页</h6>
    		<div style="margin-left: 32%">
    		   <ul class="am-pagination tpl-pagination" >	
	    		   <s:if test="page.pageNo <= 0">
	    		   		<li class="am-disabled"><a >首页</a></li>&nbsp;&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a >«</a></li>
	    		   </s:if>
	    		   <s:else>
		    		    <li class="am-active"><a href="<%=path %>/list_log.action?page.pageNo=0&userId=<%=session.getAttribute("userId")%>&logStateStr=${logStateStr}">首页</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"><a href="<%=path %>/list_log.action?page.pageNo=<s:property value="page.pageNo - 1"/>&userId=<%=session.getAttribute("userId")%>&logStateStr=${logStateStr}">«</a></li>
	    		   </s:else>
	    		   		<li  class="am-active"><a style="background-color:gray;"><s:property value="pageModel.page.pageNo+1"/></a></li>
	    		   <s:if test="(page.pageNo + 2) > pageModel.page.totalPage">
	    		   		<li class="am-disabled"><a>»</a></li>&nbsp;&nbsp;&nbsp;<li class="am-disabled"><a>尾页</a></li>
	    		   </s:if>
	    		   <s:else>
		    		   	<li class="am-active"><a href="<%=path %>/list_log.action?page.pageNo=<s:property value="page.pageNo + 1"/>&userId=<%=session.getAttribute("userId")%>&logStateStr=${logStateStr}">»</a></li>
			            &nbsp;&nbsp;&nbsp;
			            <li class="am-active"> <a href="<%=path %>/list_log.action?page.pageNo=<s:property value="page.totalPage -1"/>&userId=<%=session.getAttribute("userId")%>&logStateStr=${logStateStr}">尾页</a></li>
	    		   </s:else>
	        	</ul>
	        </div>
        </div> --%>
        </div>
        
       		</div>
       		</div>
					
				</div>
				</div>
	
	 <script type="text/javascript">
 	function change(id1,id2,id3){
 		var ele= document.getElementById(id3);
 		var ele1 = document.getElementById(id1);
		var ele2 = document.getElementById(id2);
		if(""==ele2.value||null==ele2.value){
			if(ele1.style.display == "none"){
				ele1.style.display="inline"
				ele2.style.display="none"
				ele.style.height="50px";
				ele1.select();
			}else{
				ele2.style.display="inline"
				ele1.style.display="none"
				ele.style.height="150px";
				ele2.select();
			}
		}
		}
		
	
 </script>
 </div>
</body>

</html>