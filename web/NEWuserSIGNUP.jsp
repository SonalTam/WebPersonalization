<%-- 
    Document   : NEWuserSIGNUP
    Created on : Mar 14, 2017, 4:22:37 PM
    Author     : Sonal
--%>

<!DOCTYPE html>

<html>
  <head>
     <title> Welcome to Movie Recommender| Signup or Learn More </title>
	</head>
	<body>
            <script type="text/javascript">
               
    function validateform(){    
     var Pass =document.getElementById('password').value;
    // alert(document.getElementById('password').value);
     var Conf=document.getElementById('confirm').value;
     // alert(document.getElementById('confirm').value);
     //Conf =document.Signup.confirm.value;
   // alert("password :" +Pass);
    //alert("confirm :" +Conf);
     // alert("Sonal2");
      
      
   
       if(Pass ===Conf){
       // alert(" Password match");
        
      return true;
       
    } 
    else {alert(" Passwords do not match");
    return false;
         }
      //   return false;
    }
</script>  
	   <div id ="outerBody" style= "width:1150px;height:900;background-color:silver ;margin:0 Auto;">
	   <div id="Header" style="height:182px">
	   <div id ="leftsection" style ="float:right;width:70%">
	           <b><font size="4">MOVIE RECOMMENDER</b></font><br><br><br><br>
			   <b><font size ="6">Sign Up for your Movie Recommender Account</b></font>
	      
	   
	   
	   </div>
	          <div id="leftsection" style="width:278px;height:150px;background:url('Images/images1.jpg')"></div>
	          <div id="middlesection" style ="text-align:left"><b><font size="4">MOVIE RECOMMENDER</b></font></div>
			  
			  
		</div>
		 
	   <div id ="Bodycontainer">
				<div id ="Bodyleftsection" style="float:left;width:40%;height:300">
				
					<p>
					<b>Benefits of signing up for a MOVIE RECOMMENDER Account include:</b><br><br>
					* The ability to rate movies you love(or hate)<br><br>
					* Receive recommendations based on your preference<br><br>
					* Keep track of your favorite movies
				
					</p>
				
				
				</div>
				<div id ="Bodyrightsection" style="float:right;width:45%;height:300">
                                    <form name="NEWuserSIGNUP" action="NEWUSI.jsp" method="POST" >
                                                                                  
                                        <table border="0">
                                            
                                            <tbody>
                                               
                                                <tr>
                                                    <td><label for="User Name">USER NAME:</label></td><br><br>
                                                    <td><input type="text" name="UName" value="" size="20" /></td>
                                                </tr>
                                                <tr>
                                                <br>
                                                </tr>
                                                
                                                <tr>
                                                    <td>Create Password :</td>
                                                    <td><input type="password" name="password" value="" size="10" id="password"/></td>
                                                </tr>
                                                <tr>
                                                    <td>Confirm Password :</td>
                                                    <td><input type="password" name="confirm" value="" size="10" id="confirm"/></td>
                                                </tr>
                                                
                                                <tr>
                                                    <td>Security Question-1 for Password Recovery :</td>
                                                    <td><input type="text" name="Security-Q-1" value="" size="50" /></td>
                                            
                                                </tr>  
                                                <tr>
                                                    <td> Answer to Security Question-1 :</td>
                                                    <td><input type="text" name="Security-A-1" value="" size="50" /></td>
                                            
                                                </tr>
                                                 <tr>
                                                    <td>Security Question-2 for Password Recovery :</td>
                                                    <td><input type="text" name="Security-Q-2" value="" size="50" /></td>
                                            
                                                </tr>  
                                                <tr>
                                                    <td> Answer to Security Question-2 :</td>
                                                    <td><input type="text" name="Security-A-2" value="" size="50" /></td>
                                            
                                                </tr>
                                                    </tbody>
                                        </table>

                                                                                                                 

                                                    
						  
				
				<div id ="Bodyrightdown" style ="float:right;width:45%; height:100">
				
                                    <input type="submit" value="Signup" name="signup" onclick="return validateform();" />
                                    <input type="reset" value="Reset" name="reset" />
						   
						</form>   
				
				</div>
                 				
						
						
				
				
				
				</div>
		</div>  
	   
	   
	   
	   </div>
	
	</body>

</html>


    </body>
</html>

