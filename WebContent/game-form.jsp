<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	test 123
	
<form action="./insert">
  <input type="text" value="<c:out value='${game.gName}' />" class="form-control" name="name" required="required">
  <label for="gPlatform">Choose a platform:</label>
  <select name="gPlatform" id="gPlatform">
    <option value="PS2">Volvo</option>
    <option value="XBOX">Saab</option>
    <option value="PC">Opel</option>
  </select>
  <br><br>
  <input type="submit" value="Submit">
</form>
</body>
</html>