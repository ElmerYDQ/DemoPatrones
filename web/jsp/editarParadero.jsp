<%-- 
    Document   : editarParadero
    Created on : 18/11/2018, 07:39:10 PM
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
        <h1>Editar Paradero</h1>
        <form action="${pageContext.request.contextPath}/ServletParadero" method="post">
            <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id" value="${paradero.idParadero}">
            <table>
                <tr>
                    <th>Nombres</th>
                    <td><input type="text" name="nombre" value="${paradero.nombre}" readonly></td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
