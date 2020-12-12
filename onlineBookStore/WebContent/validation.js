
 
function validateform(){  
var num=document.myform.number.value;
var name=document.myform.name.value;  
var number=document.myform.number.value; 
var username=document.myform.username.value; 
var password=document.myform.password.value;  
var firstpassword=document.myform.password.value;  
  var secondpassword=document.myform.password2.value;  
if (name==null || name==""){  
  document.getElementById("sname").innerHTML="Name can't be blank";  
  return false;  
}else if(number==null || number==""){  
  document.getElementById("numonly").innerHTML="number can't be null";  
  return false;  
  } 
   else if (isNaN(num)){  
  document.getElementById("numonly").innerHTML="Enter Numeric value only";  
  return false;  
}
  else if(number.length !=10){  
   document.getElementById("numonly").innerHTML="number must be  10 characters long.";  
  return false;  
  } else if(username==null || username==""){  
document.getElementById("suname").innerHTML= "username can't be null";  
  return false;  
  } else if(username.length<6){  
  document.getElementById("suname").innerHTML="username must be at least 6 characters long.";  
  return false;  
  }
  else if(password == null || password == ""){  
  document.getElementById("pass").innerHTML="Password can't be null";  
  return false;  
  }
   else if(password.length<6){  
  document.getElementById("pass").innerHTML="Password must be at least 6 characters long.";  
  return false;  
  }else if( secondpassword==null ||secondpassword ==""){  
document.getElementById("samepass").innerHTML="re-enter password not null"; 
return false;   
} else if( secondpassword != password ){  
document.getElementById("samepass").innerHTML=" password must be same"; 
return false;   
}  
  

}  