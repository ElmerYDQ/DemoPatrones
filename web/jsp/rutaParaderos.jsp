<%-- 
    Document   : rutaParaderos
    Created on : 19/11/2018, 11:22:56 AM
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
        <h1>Ruat de paraderos ${idRuta}</h1>
        <div>
            <form action="${pageContext.request.contextPath}/ServletRutaParadero" method="post">
                <input type="hidden" name="accion" value="registrar">
                <input type="hidden" name="idRuta" value="${idRuta}">
                <table>
                    <tr>
                        <th>Paradero</th>
                        <td>
                            <select name="idParadero">
                                <c:forEach items="${facade.listarParadero()}" var="paradero">
                                    <option value="${paradero.idParadero}">${paradero.nombre}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="Registrar">
            </form>
        </div>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Avenida</th>
                <th>Direccion</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${rutaParaderos}" var="paradero">
                <tr>
                    <td>${facade.getParadero(paradero.idParadero).nombre}</td>
                    <td>${facade.getNombreAvenida(facade.getParadero(paradero.idParadero).idAvenida)}</td>
                    <td>${facade.getParadero(paradero.idParadero).direccion}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRutaParadero">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="idRuta" value="${paradero.idRuta}">
                            <input type="hidden" name="idParadero" value="${paradero.idParadero}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
