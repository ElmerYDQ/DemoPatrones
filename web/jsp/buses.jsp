<%-- 
    Document   : buses
    Created on : 19/11/2018, 01:00:54 AM
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
    </head>
    <body style="text-align:center">
        <jsp:include page="../componente/header.jsp"></jsp:include>
        <h1>Buses</h1>
        <hr>
        <div>
            <a href="jsp/registrarBus.jsp" class="btn btn-success">Registrar</a>
        </div>
        <br>
        <table class="table">
            <tr>
                <th>Id Bus</th>
                <th>Estado</th>
                <th>Placa</th>
                <th>SOAT</th>
                <th>Capacidad</th>
                <th>Año</th>
                <th>Editar</th>
            </tr>
            <c:forEach items="${buses}" var="bus">
                <tr>
                    <td>${bus.idBus}</td>
                    <td>${facade.getEstado(bus.idEstado)}</td>
                    <td>${bus.placa}</td>
                    <td>${bus.soat}</td>
                    <td>${bus.capacidad}</td>
                    <td>${bus.anho}</td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/ServletBus">
                            <input type="hidden" name="accion" value="obtener">
                            <input type="hidden" name="id" value="${bus.idBus}">
                            <input type="submit" value="Editar" class="btn btn-warning">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
