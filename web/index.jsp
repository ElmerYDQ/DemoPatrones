<%-- 
    Document   : index
    Created on : 17/11/2018, 09:29:42 PM
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
        <h1>Hello World!</h1>
        <form action="ServletSesion" method="post">
            <input type="hidden" name="accion" value="ingresar">
            <h3>Usuario</h3>
            <input type="text" name="usuario">
            <h3>Contraseña</h3>
            <input type="password" name="contraseña">
            <input type="submit" value="Ingresar">
        </form>
    </body>
</html>
