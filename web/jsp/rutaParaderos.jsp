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
        <h1>Ruat de paraderos</h1>
        <div>
            <a href="jsp/registrarRutaParadero.jsp">Registrar</a>
        </div>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Avenida</th>
                <th>Direccion</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${rutaParaderos}" var="paradero">
                <tr>
                    <td>${facade.getParadero(paradero.idParadero).nombre}</td>
                    <td>${facade.getNombreAvenida(facade.getParadero(paradero.idParadero).idAvenida)}</td>
                    <td>${facade.getParadero(paradero.idParadero).direccion}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRutaParadero">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${facade.getParadero(paradero.idParadero).idParadero}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRutaParadero">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${facade.getParadero(paradero.idParadero).idParadero}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
