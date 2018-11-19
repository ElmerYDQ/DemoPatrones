<%-- 
    Document   : editarRuta
    Created on : 18/11/2018, 07:39:30 PM
    Author     : Diaz
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar ruta</h1>
        <form action="${pageContext.request.contextPath}/ServletRuta" method="post">
            <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id" value="${ruta.idRuta}">
            <input type="hidden" name="idParaderoInicio" value="${ruta.paraderoInicio}">
            <input type="hidden" name="idParaderoFinal" value="${ruta.paraderoFinal}">
            <table>
                <tr>
                    <th>Nombre</th>
                    <td><input type="text" name="nombre" value="${ruta.nombre}"></td>
                </tr>
                <tr>
                    <th>Paradero inicial</th>
                    <td><input type="text" name="paradero" value="${facade.getNombreParadero(ruta.paraderoInicio)}" readonly></td>
                </tr>
                <tr>
                    <th>Paradero final</th>
                    <td><input type="text" name="paradero" value="${facade.getNombreParadero(ruta.paraderoFinal)}" readonly></td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
