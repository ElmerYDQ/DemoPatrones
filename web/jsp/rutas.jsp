<%-- 
    Document   : rutas
    Created on : 18/11/2018, 07:38:11 PM
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
        <h1>Rutas</h1>
        <div>
            <a href="jsp/registrarRuta.jsp">Registrar</a>
        </div>
        <table>
            <tr>
                <th>Id Ruta</th>
                <th>Nombre</th>
                <th>Paradero Inicial</th>
                <th>Paradero Final</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${rutas}" var="ruta">
                <tr>
                    <td>${ruta.idRuta}</td>
                    <td>${ruta.nombre}</td>
                    <td>${facade.getNombreParadero(ruta.paraderoInicio)}</td>
                    <td>${facade.getNombreParadero(ruta.paraderoFinal)}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRuta">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${ruta.idRuta}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRuta">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${ruta.idRuta}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRutaParadero">
                            <input type="hidden" name="accion" value="listar">
                            <input type="hidden" name="id" value="${ruta.idRuta}">
                            <input type="submit" value="Paraderos">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
