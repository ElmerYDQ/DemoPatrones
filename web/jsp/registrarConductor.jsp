<%-- 
    Document   : registrarConductor
    Created on : 18/11/2018, 06:37:26 PM
    Author     : Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar conductor</h1>
        <form action="${pageContext.request.contextPath}/ServletConductor" method="post">
            <input type="hidden" name="accion" value="registrar">
            <table>
                <tr>
                    <th>Nombres</th>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <th>Apellidos</th>
                    <td><input type="text" name="apellido"></td>
                </tr>
                <tr>
                    <th>DNI</th>
                    <td><input type="text" name="dni"></td>
                </tr>
                <tr>
                    <th>Brevete</th>
                    <td><input type="text" name="brevete"></td>
                </tr>
                <tr>
                    <th>Telefono</th>
                    <td><input type="text" name="telefono"></td>
                </tr>
                <tr>
                    <th>Direccion</th>
                    <td><input type="text" name="direccion"></td>
                </tr>
                <tr>
                    <th>Email</th>
                    <td><input type="email" name="email"></td>
                </tr>
            </table>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
