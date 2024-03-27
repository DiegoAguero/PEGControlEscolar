<%-- 
    Document   : modificar
    Created on : 27 mar 2024, 9:48:29
    Author     : Mati
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar carrera</title>
    </head>
    <body>
        <form action="./modificar" method="post">
            <input type="hidden" name="id" value="${carrera.id}" />
            <input type="text" name ="name"  placeholder="${carrera.name}"/>
            <input type="submit" title="Modificar"/>
        </form>
    </body>
</html>
