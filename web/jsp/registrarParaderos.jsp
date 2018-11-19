<%-- 
    Document   : registrarParaderos
    Created on : 18/11/2018, 07:38:03 PM
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
        <h1>Registrar Paradero</h1>
        <form action="${pageContext.request.contextPath}/ServletParadero" method="post">
            <input type="hidden" name="accion" value="registrar">
            <table>
                <tr>
                    <th>Nombre</th>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <th>Avenida</th>
                    <td>
                        <select name="idAvenida">
                            <c:forEach items="${facade.listarAvenida()}" var="avenida">
                                <option value="${avenida.idAvenida}">${avenida.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Direccion</th>
                    <td><input type="text" name="direccion"></td>
                </tr>
            </table>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
