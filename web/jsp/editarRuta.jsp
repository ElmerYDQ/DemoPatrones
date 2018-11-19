<%-- 
    Document   : editarRuta
    Created on : 18/11/2018, 07:39:30 PM
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
        <h1>Registrar ruta</h1>
        <form action="${pageContext.request.contextPath}/Servletruta" method="post">
            <input type="hidden" name="accion" value="editar">
            <table>
                <tr>
                    <th>Nombre</th>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <th>Paradero inicial</th>
                    <td>
                        <select name="idParaderoInicio">
                            <c:forEach items="${facade.listarParadero()}" var="paradero">
                                <option value="${paradero.idParadero}">${paradero.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Paradero final</th>
                    <td>
                        <select name="idParaderoFinal">
                            <c:forEach items="${facade.listarParadero()}" var="paradero">
                                <option value="${paradero.idParadero}">${paradero.nombre}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
