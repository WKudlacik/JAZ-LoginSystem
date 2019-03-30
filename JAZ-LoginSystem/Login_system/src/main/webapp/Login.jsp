<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<style>
input:not([type='submit']):not([type='reset']) {    
	display:block;
}
</style>
<body>
<form action="login" method="post"> 
	Username:
  	<input type="text" name="Username" required>
 	Password:
  	<input type="password" name="Password" required>
 	<input type="submit" value="Submit">
    <input type="reset" value="Reset"/>
</form>
<p>${wrongLoginOrPassword}</p>
<p>${dbError}</p>
</body>
</html>