<%-- 
    Document   : buses
    Created on : 19/11/2018, 01:00:54 AM
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
        <h1>Buses</h1>
        <div>
            <a href="jsp/registrarBus.jsp">Registrar</a>
        </div>
        <table>
            <tr>
                <th>Id Bus</th>
                <th>Estado</th>
                <th>Placa</th>
                <th>SOAT</th>
                <th>Capacidad</th>
                <th>Año</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${buses}" var="bus">
                <tr>
                    <td>${bus.idBus}</td>
                    <td>${facade.getEstado(bus.idEstado)}</td>
                    <td>${bus.placa}</td>
                    <td>${bus.soat}</td>
                    <td>${bus.capacidad}</td>
                    <td>${bus.anho}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletBus">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${bus.idBus}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletBus">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${bus.idBus}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
