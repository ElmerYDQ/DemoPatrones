<%-- 
    Document   : conductores
    Created on : 18/11/2018, 04:57:49 PM
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
        <h1>Conductores</h1>
        <div>
            <a href="jsp/registrarConductor.jsp">Registrar</a>
        </div>
        <table>
            <tr>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>DNI</th>
                <th>Brevete</th>
                <th>Telefono</th>
                <th>Direccion</th>
                <th>Email</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${conductores}" var="conductor">
                <tr>
                    <td>${conductor.nombre}</td>
                    <td>${conductor.apellido}</td>
                    <td>${conductor.dni}</td>
                    <td>${conductor.brevete}</td>
                    <td>${conductor.telefono}</td>
                    <td>${conductor.direccion}</td>
                    <td>${conductor.email}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletConductor">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${conductor.idConductor}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletConductor">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${conductor.idConductor}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
