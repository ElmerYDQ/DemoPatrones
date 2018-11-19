<%-- 
    Document   : paraderos
    Created on : 18/11/2018, 07:37:39 PM
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
        <h1>Paraderos</h1>
        <div>
            <a href="jsp/registrarParaderos.jsp">Registrar</a>
        </div>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Avenida</th>
                <th>Direccion</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${paraderos}" var="paradero">
                <tr>
                    <td>${paradero.nombre}</td>
                    <td>${facade.getNombreAvenida(paradero.idAvenida)}</td>
                    <td>${paradero.direccion}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletParadero">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${paradero.idParadero}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletParadero">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${paradero.idParadero}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
