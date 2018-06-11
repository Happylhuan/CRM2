
function checkpass(val){
			var pass = document.getElementById("user-pass");
			var repass = document.getElementById("user-repass");
			if(pass.value!=val){
				alert("两次密码不一致，请重新输入^_^");
				repass.value="";
			}
		}
	function SubCheck(valId,valClass){
			var flag = true;
			var sub = document.getElementById(valId);
				var check = document.getElementsByClassName(valClass);	
				for(var i = 0;i < check.length;i++){
					if(check[i].innerHTML!=''){
						flag = false;
					}
				}	
				
				if(flag){
					sub.submit();
				}else{
					$('#input-error-alert').modal({
				      relatedTarget: this,
				    });
				}
			}
		function isChinese(valId,val) {
			var tarEle = document.getElementById(valId);
			var re=/[^\u4e00-\u9fa5]/; 
            if(re.test(val)){
            	tarEle.innerHTML += "-必须为中文";
            }
		}
		function isEmail(valId,val){
			var tarEle = document.getElementById(valId);
			var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
			 if (!regex.test(val)){
				 tarEle.innerHTML += "-请输入正确的邮箱";
			 }
		}
		function checkLen(valId,val,min,max){
			var tarEle = document.getElementById(valId);
			if(max==0){
				if(val.length!==min){
            		tarEle.innerHTML += "长度要必须为"+min+"";
            	}else{
            		tarEle.innerHTML = "";
            	}
			}else if(val.length<min||val.length>max){
            	tarEle.innerHTML += "长度要在"+min+"-"+max+"之间";
            }else{
            	tarEle.innerHTML = "";
            }
		}
		function isNum(valId,val,txt){
		var errorEle = document.getElementById(valId);
			if ("" == val || null == val) {
				errorEle.innerHTML = "*"+txt+"不能为空!"
			} else{
            	errorEle.innerHTML = "";
            }
		}
		/*function subcheck(val){
        var loginform = document.getElementById("loginForm");
        if(val=="Manage"){
            loginform.action="<%=path%>/page/manage_menu.jsp";
            loginform.submit();
        }else{
            loginform.setAttribute("action", "<%=path%>/page/user_menu.jsp");
            loginform.submit();

        }
    }*/
		 function changeTy(val){
		        var menus = document.getElementsByClassName('nav-link');
		        var tar = document.getElementById(val);
		        for(var i = 0 ;i<menus.length;i++){
		
		            menus[i].className='nav-link'
		        }
		        tar.className='nav-link active';
		
		
		    }
		 function changeParentTy(val){
		        var menus = parent.document.getElementsByClassName('nav-link');
		        var tar = parent.document.getElementById(val);
		        for(var i = 0 ;i<menus.length;i++){
		
		            menus[i].className='nav-link'
		        }
		        tar.className='nav-link active';
		
		
		    }
		 function getName() {
				var nameval = document.getElementById('selectID').value;
				var inp = document.getElementById('search');
				inp.name = nameval;
			}
			 function chanceAll(){
			    	var ele = document.getElementsByName("allCheckId");
			    	var eles = document.getElementsByName("checkId");
			    	if(!ele.checked){
					    	for(var i=0;i<eles.length;i++){
						    	eles[i].checked=true;
						    	}
						    ele.checked=true;	
			    	}else{
			    	
			    		ele.checked=false;
			    		for(var i=0;i<eles.length;i++){
					    	eles[i].checked=false;
					    	}
			    	}
			    }

function clearInput(val) { 
	 var input = document.getElementsByClassName(val);
     for(var i = 0 ;i<input.length;i++){
         menus[i].value='';
     }
     
}

function isNumber(valId,val,txt){
	var errorEle = document.getElementById(valId);
	var regPos = /^[1-9]+[0-9]*]*$/; // 非负整数
    if(regPos.test(val)){
    	errorEle.innerHTML = "";
    }else{
    	errorEle.innerHTML = "*"+txt+"不是有效数字"
    }
}

function myAlert(type,txt){
	parent.$('#'+type+'').modal({
	      relatedTarget: this,
	    });
	parent.$('#alertTxt').html(txt);
}

function delall(url){
    var ele = document.getElementsByName("checkId");
    var eles = "";
    for(var i=0;i<ele.length;i++){
    	if(ele[i].checked){
    		eles+=ele[i].value+";";
    	}
    }
      if(""==eles){
 		myAlert("warm-alert","未选中要删除的记录！");
		return;
		 }
      if(confirm("确定要删除这些记录吗？")){  
    	  window.location=url+eles;
  	}
    }

function inputIsNull(inputId1,inputId2,eleId){
	var ele1 = document.getElementById(inputId1).value.replace(/(^\s*)|(\s*$)/g, "");
	var ele2 = document.getElementById(inputId2).value.replace(/(^\s*)|(\s*$)/g, "");
	var ele3 = document.getElementById(eleId);
	if(""!=ele2){
		ele3.submit();
		}else{
			myAlert("warm-alert","评论不能为空！");
		}	
	}
function openul(val,open){
	if(null != open){
		if(document.getElementById(val).style.display == "block"){
		document.getElementById(val).style.display='none';
		}else{
		document.getElementById(val).style.display='block';
		}
	}else{
		document.getElementById(val).style.display='none';
		}
	}
function manageOpenul(val,open){
	if(null != open){
		if(parent.document.getElementById(val).style.display == "block"){
			parent.document.getElementById(val).style.display='none';
		}else{
			parent.document.getElementById(val).style.display='block';
		}
	}else{
		parent.document.getElementById(val).style.display='none';
		}
	}