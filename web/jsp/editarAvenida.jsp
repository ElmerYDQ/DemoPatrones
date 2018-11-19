<%-- 
    Document   : editarAvenida
    Created on : 18/11/2018, 07:40:44 PM
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
        <h1>Editar Avenida</h1>
        <form action="${pageContext.request.contextPath}/ServletAvenida" method="post">
            <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id" value="${avenida.idAvenida}">
            <table>
                <tr>
                    <th>Nombre</th>
                    <td><input type="text" name="nombre" value="${avenida.nombre}"></td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
