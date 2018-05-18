<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
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
<link rel="icon" type="image/png" href="<%=path %>/amz/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=path %>/amz/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="<%=path %>/amz/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="<%=path %>/amz/assets/css/admin.css">
<link rel="stylesheet" href="<%=path %>/amz/assets/css/app.css">
<script src="<%=path %>/amz/assets/js/echarts.min.js"></script>
<script src="<%=path %>/amz/assets/js/main.js"></script>
<script src="<%=path%>/amz/assets/js/jquery.min.js"></script>
<script src="<%=path%>/amz/assets/js/amazeui.min.js"></script>
<script src="<%=path%>/amz/assets/js/app.js"></script>

<script type="text/javascript" charset="utf-8" src="<%=path%>/amz/assets/input/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/amz/assets/input/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=path%>/amz/assets/input/lang/zh-cn/zh-cn.js"></script>

    
<style type="text/css">

.check{
	color:red;
}
</style>
</head>

<body data-type="generalComponents">
<div class="am-u-md-6 am-u-sm-12 row-mb" style="width: 100%">
 <div class="tpl-portlet">
		<ol class="am-breadcrumb">
		  <li><a href="<%=path%>/user/usermain_list?userMain.userId=${session.userId}" onclick="changeParentTy('indexMenu')" class="am-icon-home">首页</a></li>
		  <li><a href="<%=path%>/user/list_log?log.userId=${session.userId}" class="am-icon-calendar">日志列表</a></li>
		  <li><label class="am-icon-code">更新日志</label></li>
		</ol>
 <div class="tpl-block " >
   <div class="am-g tpl-amazeui-form">


                        <div class="am-u-sm-12 am-u-md-9">
                            <s:form id="order_add_formId" class="am-form am-form-horizontal"  action="upd_log" method="post">
                        		 <input style="display:none" type="text" value="${userId}" name="userId">
							 	<input style="display:none" type="text" value="${log.logId}" name="logId">
							 	<input style="display:none" type="text" value="${page.pageNo}" name="page.pageNo">
								<div class="am-form-group">
                                    <label for="user-email" class="am-u-sm-3 am-form-label">日志标题 <span class="tpl-form-line-small-title">Time</span></label>
                                    <div class="am-u-sm-9">
                                         <input value="${log.logTitle}" type="tel" name="logTitle" id="user-phone" placeholder="输入日志标题 / Title" onblur="isNum('logTitleError',this.value,'日志');"><span class="check" id="logTitleError"></span>
                                     
                                    </div>
                                </div>
                                
                                 <div class="am-form-group">
                                    <label for="user-weibo" class="am-u-sm-3 am-form-label">日志分类 <span class="tpl-form-line-small-title">Type</span></label>
                                    <div class="am-u-sm-9">
                                    <select name="logState" data-am-selected="{searchBox: 1}">
									  <option value=true>生活日志</option>
									  <option value=false>工作日志</option>
									</select>
                                    </div>
                                    <label onclick="setContent()" for="user-intro" class="am-u-sm-3 am-form-label">点击刷新文章内容</label>
                                </div>
                                
                                <div class="am-form-group">
                                    <label for="user-intro" class="am-u-sm-3 am-form-label">文章内容</label>
                                    <div class="am-u-sm-9">
                                    <div>
								 	 <textarea id="logInfo" style="display: none;" name="logInfo" >${log.logInfo}</textarea>
								     <script id="editor" type="text/plain" style="width:100%;height:30%;"></script>
								</div>
								</div>
                                </div>
                                <div align='center'>
		                            <input style="margin-right:25%" id="subId" onclick="SubCheck('order_add_formId','check');getcont();" type="submit" value="修改" class="am-btn am-btn-primary"/>
		                             
		                            <a href="<%=path%>/list_log?&userId=${userId}" ><input type="button" value="取消" class="am-btn am-btn-primary"/></a>
                         		</div>
                         		
                            </s:form>
                        </div>
                    </div>
               </div></div> </div>
</body>
<script type="text/javascript">
	  function getcont(){
	  	var ele = document.getElementById("logInfo");
	  	var cont = UE.getEditor('editor').getContent();
	  	ele.value=cont;
	  }

    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    /* function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    } */
    function setContent(isAppendTo) {
    	var ele = document.getElementById("logInfo").value;
        UE.getEditor('editor').setContent(ele);
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("已清空草稿箱")
    }
</script>

</html>