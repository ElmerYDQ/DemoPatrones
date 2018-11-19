<%-- 
    Document   : asignacion
    Created on : 19/11/2018, 04:52:51 PM
    Author     : Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Asignaciones</h1>
        <h2>Asignar Conductor a bus</h2>
        <form action="${pageContext.request.contextPath}/ServletAsignacion">
            <input type="hidden" name="accion" value="filtrarConductor">
            <input type="text" name="filtro">
            <input type="submit" value="Buscar">
        </form>
        <br>
        <br>
        <h2>Asignar Bus a ruta</h2>
        <form action="${pageContext.request.contextPath}/ServletConductor">
            <input type="hidden" name="accion" value="filtrarConductor">
            <input type="text" name="filtro">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
