<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Especialidad</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <h3>Eliminar Especialidades</h3>
                    <form Method="POST" action="./eliminar.htm" >
                        <c:forEach var="dato" items="${lista}">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="ID" readonly="readonly" value="${dato.ID}"/>
                        <label  class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="Nombre" readonly="readonly" value="${dato.Nombre}"/>
                        </c:forEach>
                        <label  class="form-label"><b>Se procedera con la eliminacion de este registro<br>
                                ¿Está seguro de continuar?</b></label>
                        <button type="summit" class="btn btn-danger">Si, Eliminar</button>
                        <a class="btn btn-warning" href="./listar.htm">Cancelar</a>
                    </form>
                </div>
                <div class="col-md-4"></div>                
            </div>
        </div>
    </body>
</html>

