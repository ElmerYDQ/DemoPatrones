<%-- 
    Document   : registrarRuta
    Created on : 18/11/2018, 07:38:24 PM
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
        <h1>Registrar ruta</h1>
        <hr>
        <form action="${pageContext.request.contextPath}/ServletRuta" method="post">
            <input type="hidden" name="accion" value="registrar">
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Nombre:</h5>
                <input type="text" class="form-control col-sm-8" name="nombre">
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Paradero inicial:</h5>
                <select class="form-control col-sm-8" id="sel1" name="idParaderoInicio">
                    <c:forEach items="${facade.listarParadero()}" var="paradero">
                        <option value="${paradero.idParadero}">${paradero.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group row">
                <h5 class="col-sm-2 col-form-label">Paradero final:</h5>
                <select class="form-control col-sm-8" id="sel1" name="idParaderoFinal">
                    <c:forEach items="${facade.listarParadero()}" var="paradero">
                        <option value="${paradero.idParadero}">${paradero.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Registrar" class="btn btn-success">
        </form>
    </body>
</html>
