<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Horario</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Agregar Horario</h3>
                    <form Method="POST">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="IDHorario" />
                        <label  class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="Nombre" />
                        <label  class="form-label">Turno</label>
                        <Select class="form-select" name="IDTurno" >
                            <c:forEach var="dato" items="${lista}">
                                <OPTION value="${dato.ID}">${dato.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <br>
                        <button type="summit" class="btn btn-success">Grabar</button>
                        <a class="btn btn-warning" href="./listar.htm">Cancelar</a>
                    </form>
                </div>
                <div class="col-md-4"></div>                
            </div>
        </div>
    </body>
</html>
