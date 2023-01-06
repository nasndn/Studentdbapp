<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
      <h2>Update your mobile number here....</h2>
      <form action="update" method="post">
         <pre>
              email<input type="text" name="email" value="<%=request.getAttribute("email") %>" readonly>
               mobile<input type="text" name="mobile" value="<%=request.getAttribute("mobile") %>">
               <input type="submit" value="save" />
         </pre>    
      </form>
</body>
</html>