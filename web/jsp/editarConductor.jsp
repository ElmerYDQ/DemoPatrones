<%-- 
    Document   : editarConductor
    Created on : 18/11/2018, 07:38:55 PM
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
        <h1>Editar conductor</h1>
        <form action="${pageContext.request.contextPath}/ServletConductor" method="post">
            <input type="hidden" name="accion" value="editar">
            <input type="hidden" name="id" value="${conductor.idConductor}">
            <table>
                <tr>
                    <th>Nombres</th>
                    <td><input type="text" name="nombre" value="${conductor.nombre}" readonly></td>
                </tr>
                <tr>
                    <th>Apellidos</th>
                    <td><input type="text" name="apellido" value="${conductor.apellido}" readonly></td>
                </tr>
                <tr>
                    <th>DNI</th>
                    <td><input type="text" name="dni" value="${conductor.dni}" readonly></td>
                </tr>
                <tr>
                    <th>Brevete</th>
                    <td><input type="text" name="brevete" value="${conductor.brevete}"></td>
                </tr>
                <tr>
                    <th>Telefono</th>
                    <td><input type="text" name="telefono" value="${conductor.telefono}"></td>
                </tr>
                <tr>
                    <th>Direccion</th>
                    <td><input type="text" name="direccion" value="${conductor.direccion}"></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><input type="email" name="email" value="${conductor.email}"></td>
                </tr>
            </table>
            <input type="submit" value="Editar">
        </form>
    </body>
</html>
