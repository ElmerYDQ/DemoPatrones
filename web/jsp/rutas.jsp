<%-- 
    Document   : rutas
    Created on : 18/11/2018, 07:38:11 PM
    Author     : Diaz
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
         <link rel="stylesheet" href="css/login.css" type="text/css"/> 
         <link rel="stylesheet" href="css/conductor.css" type="text/css"/>  
        <script src="js/app.js"></script>
    </head>
    <body style="text-align: center">
        <jsp:include page="../componente/header.jsp"></jsp:include>
         <div class="titulo_conductor col-xs-12">
        <h1>Rutas</h1>
        </div>
        <div class="conductor_registrar col-xs-12">
            <a href="jsp/registrarRuta.jsp" class="btn btn-success">Registrar</a>
        </div>
      
          <table class="table table-hover table-bordered">
            <tr class="active encabezado">

                <th>Id Ruta</th>
                <th>Nombre</th>
                <th>Paradero Inicial</th>
                <th>Paradero Final</th>
                <th>Editar</th>
                <th>Eliminar</th>
                <th>Paraderos</th>
                <th>Buses</th>
            </tr>
            <c:forEach items="${rutas}" var="ruta">
                <tr>
                    <td>${ruta.idRuta}</td>
                    <td>${ruta.nombre}</td>
                    <td>${facade.getNombreParadero(ruta.paraderoInicio)}</td>
                    <td>${facade.getNombreParadero(ruta.paraderoFinal)}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRuta">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${ruta.idRuta}">
                            <input type="submit" value="Editar" class="btn btn-warning">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRuta">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="id" value="${ruta.idRuta}">
                            <input type="submit" value="Eliminar" class="btn btn-danger">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletRutaParadero">
                            <input type="hidden" name="accion" value="listar">
                            <input type="hidden" name="idRuta" value="${ruta.idRuta}">
                            <input type="submit" value="Paraderos" class="btn btn-info">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletAsignacion">
                            <input type="hidden" name="accion" value="listarBuses">
                            <input type="hidden" name="idRuta" value="${ruta.idRuta}">
                            <input type="submit" value="Buses" class="btn btn-primary">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
