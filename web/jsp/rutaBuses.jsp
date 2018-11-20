<%-- 
    Document   : rutaBuses
    Created on : 19/11/2018, 11:10:03 PM
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
        <h1>Buses de la ruta</h1>
        <form action="${pageContext.request.contextPath}/ServletAsignacion" method="post">
            <input type="hidden" name="accion" value="registrarHistorialBus">
            <input type="hidden" name="idRuta" value="${idRuta}">
            <table>
                <tr>
                    <th>Bus</th>
                    <td>
                        <select name="idBus">
                            <c:forEach items="${facade.listarBus()}" var="bus">
                                <option value="${bus.idBus}">${bus.placa}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Asignar">
        </form>

        <table>
            <tr>
                <th>Placa</th>
                <th>SOAT</th>
                <th>Capacidad</th>
                <th>Año</th>
                <th>Fecha</th>
            </tr>
            <c:forEach items="${listaHistorial}" var="historial">
                <tr>
                    <td>${facade.getBus(historial.idBus).placa}</td>
                    <td>${facade.getBus(historial.idBus).soat}</td>
                    <td>${facade.getBus(historial.idBus).capacidad}</td>
                    <td>${facade.getBus(historial.idBus).anho}</td>
                    <td>${historial.fecha}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
