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
                <h1>${carrera.name}</h1>
                <input type="hidden" name="id" value="${carrera.id}" />
                <input disabled placeholder="${carrera.name}"/>
                <input type="submit" value="Confirmar"/>
        </form>
    </body>
</html>
