<%-- 
    Document   : editarBus
    Created on : 19/11/2018, 01:01:19 AM
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
        <h1>Editar bus</h1>
        <form action="${pageContext.request.contextPath}/ServletBus" method="post">
            <input type="hidden" name="accion" value="registrar">
            <input type="hidden" name="id" value="${bus.idBus}">
            <table>
                <tr>
                    <th>Placa</th>
                    <td><input type="text" name="placa" value="${bus.placa}" readonly></td>
                </tr>
                <tr>
                    <th>SOAT</th>
                    <td><input type="text" name="soat" value="${bus.soat}"></td>
                </tr>
                <tr>
                    <th>Capacidad</th>
                    <td><input type="text" name="capacidad"></td>
                </tr>
                <tr>
                    <th>Año</th>
                    <td><input type="text" name="anho"></td>
                </tr>
                <tr>
                    <th>Estado</th>
                    <td>
                        <select>
                            <c:forEach items="${facade.listarEstado()}" var="estado">
                                <option value="${estado.idEstado}">${estado.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
