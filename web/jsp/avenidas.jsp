<%-- 
    Document   : avenidas
    Created on : 18/11/2018, 07:40:29 PM
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
        <h1>Avenidas</h1>
        <div>
            <form method="post" action="${pageContext.request.contextPath}/ServletAvenida">
                <input type="hidden" name="accion" value="registrar">
                <input type="text" name="nombre">
                <input type="submit" value="Registrar">
            </form>
        </div>
        <table>
            <tr>
                <th>Id Avenida</th>
                <th>Nombre</th>
                <th>Editar</th>
                <th>Eliminar</th>
            </tr>
            <c:forEach items="${avenidas}" var="avenida">
                <tr>
                    <td>${avenida.idAvenida}</td>
                    <td>${avenida.nombre}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletBus">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${avenida.idAvenida}">
                            <input type="submit" value="Editar">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletBus">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${avenida.idAvenida}">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
