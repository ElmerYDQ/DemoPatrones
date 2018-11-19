<%-- 
    Document   : principal
    Created on : 18/11/2018, 03:28:31 PM
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
        <div>
            <div>
                <form action="${pageContext.request.contextPath}/ServletConductor">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Conductores">
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/ServletBus">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Bus">
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/ServletParadero">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Paradero">
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/ServletRuta">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Ruta">
                </form>
            </div>
            <div>
                <form action="${pageContext.request.contextPath}/ServletAvenida">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Avenida">
                </form>
            </div>
        </div>
    </body>
</html>
