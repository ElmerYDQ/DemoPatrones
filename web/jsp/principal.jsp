<%-- 
    Document   : principal
    Created on : 18/11/2018, 03:28:31 PM
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
          <link rel="stylesheet" href="../css/login.css" type="text/css" />
        <script src="js/app.js"></script>
    </head>
    <body style="">
        <jsp:include page="../componente/header.jsp"></jsp:include>
        <div class="titulo_principal col-xs-12">
        <h1>PRINCIPAL</h1>
        </div>
        <div class="col-xs-12 navegador_principal">
            <div class="col-xs-12">
                <form action="${pageContext.request.contextPath}/ServletConductor">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Conductores" class="btn btn-info">
                </form>
            </div>
            
            <div class="col-xs-12">
                <form action="${pageContext.request.contextPath}/ServletBus">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Bus" class="btn btn-info">
                </form>
            </div>
                   
            <div class="col-xs-12">
                <form action="${pageContext.request.contextPath}/ServletParadero">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Paradero" class="btn btn-info">
                </form>
            </div>
                   
            <div class="col-xs-12">
                <form action="${pageContext.request.contextPath}/ServletRuta">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Ruta" class="btn btn-info">
                </form>
            </div>
                  
            <div class="col-xs-12">
                <form action="${pageContext.request.contextPath}/ServletAvenida">
                    <input type="hidden" name="accion" value="listar">
                    <input type="submit" value="Avenida" class="btn btn-info">
                </form>
            </div>
        </div>
                    
    </body>
</html>
