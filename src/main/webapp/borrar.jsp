<%-- 
    Document   : borrar
    Created on : 19 mar 2024, 11:25:15
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar</title>
    </head>
    <body>
        <form action="./borrar" method="POST"> 
            <c:forEach items="${carrera}" var="carrera">
                <input type="submit" value="Confirmar"/>
            </c:forEach>
        </form>
    </body>
</html>
