  /*function showLogin() {
            var loginDiv = document.getElementById("loginDiv");
            var zhezhao = document.getElementById("zhezhao");
            var clientx = document.documentElement.clientWidth;
            var clienty = document.documentElement.clientHeight;
            var l_margin = (clientx - parseInt(loginDiv.style.width)) / 2;
            var t_margin = (clienty - parseInt(loginDiv.style.height)-200) / 2
            loginDiv.style.left = l_margin + "px";
            loginDiv.style.top = t_margin +"px";
            loginDiv.style.display = "block";
            zhezhao.style.display = "block";
        }
        function hidLogin() {
            var loginDiv = document.getElementById("loginDiv");
            var zhezhao = document.getElementById("zhezhao");
            loginDiv.style.display = "none";
            zhezhao.style.display = "none";
        }
        function titleMove() {
            var moveable = true;
            var loginDiv = document.getElementById("loginDiv");
            var clientX = window.event.clientX;
            var clientY = window.event.clientY;
            var moveTop = parseInt(loginDiv.style.top);
            var moveLeft = parseInt(loginDiv.style.left);
            document.onmousemove = function MouseMove() {
                if (moveable) {
                    var y = moveTop + window.event.clientY - clientY;
                    var x = moveLeft + window.event.clientX - clientX;
                    if (x > 0 && y > 0) {
                        loginDiv.style.top = y + "px";
                        loginDiv.style.left = x + "px";
                    }
                }
            }
            document.onmouseup = function Mouseup() {
                moveable = false;
            }
        }
		
		
		function showRes() {
            var resDiv = document.getElementById("resDiv");
            var zhezhao1 = document.getElementById("zhezhao1");
            var clientx = document.documentElement.clientWidth;
            var clienty = document.documentElement.clientHeight;
            var l_margin = (clientx - parseInt(resDiv.style.width)) / 2;
            var t_margin = (clienty - parseInt(resDiv.style.height)-200) / 2
            resDiv.style.left = l_margin + "px";
            resDiv.style.top = t_margin +"px";
            resDiv.style.display = "block";
            zhezhao1.style.display = "block";
        }
        function hidRes() {
            var resDiv = document.getElementById("resDiv");
            var zhezhao1 = document.getElementById("zhezhao1");
            resDiv.style.display = "none";
            zhezhao1.style.display = "none";
        }
        function titleMove1() {
            var moveable = true;
            var resDiv = document.getElementById("resDiv");
            var clientX = window.event.clientX;
            var clientY = window.event.clientY;
            var moveTop = parseInt(resDiv.style.top);
            var moveLeft = parseInt(resDiv.style.left);
            document.onmousemove = function MouseMove() {
                if (moveable) {
                    var y = moveTop + window.event.clientY - clientY;
                    var x = moveLeft + window.event.clientX - clientX;
                    if (x > 0 && y > 0) {
                        resDiv.style.top = y + "px";
                        resDiv.style.left = x + "px";
                    }
                }
            }
            document.onmouseup = function Mouseup() {
                moveable = false;
            }
        }*/
        
        function saveIt(){
        	if (document.f2.upass.value!=document.f2.upass1.value) {  
        		alert('password is different'); 
        		return false;  
        		}
        	if (document.f2.uid.value==""||document.f2.upass.value==""||document.f2.uage.value==""||document.f2.uname.value=="") {  
        		alert('can not empty'); 
        		return false;  
        		}
        	}
        function kongK(){
        	if (document.f1.uid.value==""||document.f1.upass.value=="") {  
        		alert('can not empty'); 
        		return false;  
        		}
        	}
        function kongD(){
        	
        	}