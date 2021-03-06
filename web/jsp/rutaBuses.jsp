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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous"/>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/conductor.css" type="text/css"/>  
               <link rel="stylesheet" href="css/login.css" type="text/css"/> 
        <script src="js/app.js"></script>
    </head>
    <body style="text-align: center">
        <jsp:include page="../componente/header.jsp"></jsp:include>
        <div class="titulo_registrar_conductor col-xs-12">
        <h1>Buses de la ruta</h1>
        </div>
         <div class="seleccionar_paradero">
        <form action="${pageContext.request.contextPath}/ServletAsignacion" method="post">
            <input type="hidden" name="accion" value="registrarHistorialBus">
            <input type="hidden" name="idRuta" value="${idRuta}">
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Bus:</h5>
                <select class="form-control col-sm-8" id="sel1" name="idBus">
                    <c:forEach items="${facade.listarBusFiltrado()}" var="bus">
                        <option value="${bus.idBus}">${bus.placa}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Asignar" class="btn btn-success">
        </form>
        </div>
  <table class="table table-hover table-bordered">
            <tr class="active encabezado">
                <th>Placa</th>
                <th>SOAT</th>
                <th>Capacidad</th>
                <th>Año</th>
                <th>Fecha</th>
                <th>Desasignar</th>
            </tr>
            <c:forEach items="${listaHistorial}" var="historial">
                <tr>
                    <td>${facade.getBus(historial.idBus).placa}</td>
                    <td>${facade.getBus(historial.idBus).soat}</td>
                    <td>${facade.getBus(historial.idBus).capacidad}</td>
                    <td>${facade.getBus(historial.idBus).anho}</td>
                    <td>${historial.fecha}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/ServletAsignacion" method="post">
                            <input type="hidden" name="accion" value="desasignarHistorialBus">
                            <input type="hidden" name="idBus" value="${historial.idBus}">
                            <input type="hidden" name="idRuta" value="${historial.idRuta}">
                            <input type="submit" value="Desasignar" class="btn btn-danger">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
