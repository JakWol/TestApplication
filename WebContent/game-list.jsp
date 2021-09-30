<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
  <%@include file="style.css" %>
</style>


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>
           <a href="<%=request.getContextPath()%>/new">Add New Game</a>
</div>

<table id="tablestyle">
			<thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Platform</th>
                                
                            </tr>
            </thead>
 			<tbody>     
                            <c:forEach var="game"  items="${listGame}">
                                <tr>
                                    <td>
                                        <c:out value="${game.gID}" />
                                    </td>
                                    <td>
                                        <c:out value="${game.gName}" />
                                    </td>
                                    <td>
                                        <c:out value="${game.gPlatform}" />
                                    </td>                                                                                                                
                                </tr>
                            </c:forEach>                          
 			</tbody>
 </table>

</body>
</html>