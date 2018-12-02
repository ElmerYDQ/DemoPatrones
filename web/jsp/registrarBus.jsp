<%-- 
    Document   : registrarBus
    Created on : 19/11/2018, 01:01:04 AM
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
    <body style="text-align: center">
        <jsp:include page="../componente/header.jsp"></jsp:include>
        <h1>Registrar bus</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/ServletBus" method="post">
            <input type="hidden" name="accion" value="registrar">
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Placa:</h5>
                <input type="text" class="form-control col-sm-8" name="placa">
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">SOAT:</h5>
                <input type="text" class="form-control col-sm-8" name="soat">
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Capacidad:</h5>
                <input type="text" class="form-control col-sm-8" name="capacidad">
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Año:</h5>
                <input type="text" class="form-control col-sm-8" name="capacidad">
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Estado:</h5>
                <select class="form-control col-sm-8" id="sel1" name="idEstado">
                    <<c:forEach items="${facade.listarEstado()}" var="estado">
                        <option value="${estado.idEstado}">${estado.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Registrar" class="btn btn-success">
        </form>
    </body>
</html>
