
function login(){
	
var username=document.myform.username.value; 
var password=document.myform.password.value; 
	
	 if(username==null || username==""){  
document.getElementById("suname").innerHTML= "username can't be null";  
  return false;  
  } else if(username.length<6){  
  document.getElementById("suname").innerHTML="username must be at least 6 characters long.";  
  return false;  
  }  else if(password == null || password == ""){  
  document.getElementById("pass").innerHTML="Password can't be null";  
  return false;  
  }
   else if(password.length<6){  
  document.getElementById("pass").innerHTML="Password must be at least 6 characters long.";  
  return false;  
  }
 
  
}
