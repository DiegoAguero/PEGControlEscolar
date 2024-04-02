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
        <link rel="stylesheet" href="./css/style.css"/>
        <title>Borrar</title>
    </head>
    <body>
        <form action="./borrar" method="POST" class="form"> 
                <input type="hidden" name="id" value="${carrera.id}" />
                <input disabled placeholder="Desea eliminar ${carrera.name}?" class="deleteInput"/>
                <input type="submit" value="Confirmar" class="deleteButton"/>
        </form>
    </body>
</html>
