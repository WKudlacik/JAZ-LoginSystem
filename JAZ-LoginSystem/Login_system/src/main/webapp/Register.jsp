<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<style>
input:not([type='submit']):not([type='reset']) {    
	display:block;
}
</style>
<body>
<form action="register" method="post"> 
	Username:
  	<input type="text" name="Username" required>
 	Password:
  	<input type="password" name="Password" required>
  	Confirm Password:
   	<input type="password" name="ConPassword" required>
   	Email:
    <input type="text" name="Email" required>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
    <input type="submit" name="login" value="Log in" formaction="/Login.jsp" />
    </form>
    <p>${regComplete}</p>
    <p>${regError}</p>
    <p>${dbError}</p>
</body>
</html>