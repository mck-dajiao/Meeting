//*****global function*********
function navload(index){
	document.getElementsByTagName('li')[index].setAttribute('class', 'active');
}


function addNotify(num){
	var element = document.getElementById('notiBadge');
	element.innerText=num;
}

function titleLoad(title){
	document.getElementById('page-title').innerText=title;
}


//*****meetingManager.jsp******

function showAlert() {
    bootbox.alert("你TM还没登陆呢！！！！");
	bootbox.center();
}

// use for note if login fail
function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  //匹配目标参数
	if (r!=null) return unescape(r[2]); return null; //返回参数值
} 

function homeLoad(){
	if(getUrlParam('fail') == '1'){
		bootbox.alert("用户名或密码错误！");
	}
	
	if(getUrlParam('register') == '1'){
		bootbox.alert("注册成功，等待管理员审批");
	}else if(getUrlParam('register') == '0'){
		bootbox.alert("注册失败，请重新注册");
	}

	for(var index=0;index<5;index++){
		var elem = document.getElementsByTagName('a')[index];
		elem.setAttribute('href', '#');
		elem.setAttribute('onclick', 'showAlert();');
	}
	var elem = document.getElementsByTagName('a')[5];
	elem.setAttribute('href', '#login');
	elem.setAttribute('data-toggle', 'modal');
	
}

//****end of meetingManager.jsp******


//****myNotification.jsp***********



//****end of myNotification.jsp****
