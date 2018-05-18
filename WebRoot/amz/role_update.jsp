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
<script src="amz/assets/js/main.js"></script>
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
<ol class="am-breadcrumb">
  <li><a href="<%=path%>/manage/main_list?manageId=${session.manageId}" onclick="changeParentTy('indexMenu');manageOpenul('product_ul')" class="am-icon-home">首页</a></li>
  <li><a href="<%=path%>/manage/role_list?role.manageId=${session.manageId}" onclick="changeParentTy('roleMenu');manageOpenul('product_ul')" class="am-icon-users">角色列表</a></li>
  <li><label  class="am-icon-angle-code">更新角色</label></li>
</ol>
 <div class="tpl-block ">

                    <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form id="role_updform" class="am-form am-form-horizontal"  action="role_update?state=upd" namespace="/manage" method="post">
							
							 	 <input style="display: none" value="${role.roleId}" name="roleId" type="text" >
                                 <input style="display: none" value="${role.manageId}" name="manageId" type="text" >
                                  <input style="display: none" value="${page.pageNo}" name="page.pageNo" type="text" >
                                <div class="am-form-group">
                              <label for="user-name" class="am-u-sm-3 am-form-label">角色名称 / RoleName</label>
                              <div class="am-u-sm-9">
                                  <input value="${role.roleName}" name="roleName" type="text" id="user-name" placeholder="角色名称 / RoleName" onblur="isNum('RoleNameError',this.value,'角色名称');checkLen('RoleNameError',this.value,2,10)"><span class="check" id="RoleNameError"></span>
                                 
                              </div>
                         	</div>

                               <div class="am-form-group">
	                              <label for="user-name" class="am-u-sm-3 am-form-label">角色备注/ RoleRemark</label>
	                              <div class="am-u-sm-9">
	                                  <textarea name="roleRemark" class="" rows="10" id="user-intro" placeholder="角色备注 / RoleRemark" onblur="checkLen('roleRemarkError',this.value,0,100)">${role.roleRemark}</textarea><span class="check" id="roleRemarkError"></span>
	                                 
	                              </div>
                          		</div>
                                <div class="am-form-group">
                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                        <button  style="margin-right:25%" type="button" onclick="SubCheck('role_updform','check')" class="am-btn am-btn-primary">保存修改</button>
                                          <a href="<%=path%>/manage/role_list?manageId=${session.manageId}"><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                                    </div>
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div></div></div>
</body>

</html>