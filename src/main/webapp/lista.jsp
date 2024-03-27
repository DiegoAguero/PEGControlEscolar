<%-- 
    Document   : lista
    Created on : 18 mar 2024, 14:14:42
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de carreras</title>
        <link rel="stylesheet" href="./css/style.css"/>

    </head>
    <body>
        <h1>Listas de carreras</h1>
        <ul class="careerList">
            <c:forEach items="${carrera}" var="carrera">
                <li>${carrera.name} 
                    <a href="./modificar?id=${carrera.id}" target="_blank">Modificar</a>
                    <a href="./borrar?id=${carrera.id}" target="_blank">Eliminar</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
