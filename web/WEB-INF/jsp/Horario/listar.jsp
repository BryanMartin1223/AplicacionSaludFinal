<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Horarios</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>

    <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Lista de Horarios</h3>
                    <a class="btn btn-primary" href="./agregar.htm">Nuevo Registro</a>
                    <table class="table table-striped">
                        <tr>
                            <td>ID</td>
                            <td>Nombre</td>
                            <td>Turno</td>
                            <td>Editar</td>
                            <td>Eliminar</td>
                        </tr>
                        <c:forEach var="dato" items="${lista}">
                            <tr>
                                <td>${dato.IDHorario}</td>
                                <td>${dato.Nombre}</td>
                                <td>${dato.NTurno}</td>
                                <td><a class="btn btn-warning" href="./editar.htm?ID=${dato.IDHorario}">Editar</a></td>
                                <td><a  class="btn btn-danger" href="./eliminar.htm?ID=${dato.IDHorario}">Eliminar</a></td>
                            </tr>
                         </c:forEach>
                     </table>
                    <a class="btn btn-primary" href="./../index.htm">Menu Principal</a>
                </div>
                <div class="col-md-4"></div>                
            </div>
        </div>
    </body>
</html>
