<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://"
   + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<html>
 <head>
  <script type="text/javascript">
   window.top.location.href="<%=basePath%>user_index.action";
   <%session.setAttribute("error", "登陆超时,请重新登录");%>
  </script>
 </head>
</html>