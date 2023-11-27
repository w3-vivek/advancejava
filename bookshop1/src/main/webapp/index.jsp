<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>

</head>
<body>
    <form action="fc?page=login" method="post">
        Email: <input type="text" name="email"/> <br/><br/>
        Password: <input type="password" name="passwd"/> <br/><br/>
        <input type="submit" value="Sign In"/>
        <a href="fc?page=register">Sign Up</a>
    </form>
</body>
</html>
