<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Turno</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Editar Doctor</h3>
                    <form Method="POST" action="./editar.htm">
                        <c:forEach var="dato" items="${lista}">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="IDDoctor" value="${dato.IDDoctor}" />
                        <label  class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="Nombre" value="${dato.Nombre}"/>
                        <label  class="form-label">Especialidad</label>
                        <Select class="form-select" name="IDEspecialidad" value="${dato.IDEspecialidad}" >
                            <c:forEach var="datoE" items="${listaEspecialidad}">
                                <OPTION <c:if test="${datoE.ID == dato.IDEspecialidad}" >SELECTED</c:if> 
                                    value="${datoE.ID}">
                                    ${datoE.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Horario</label>
                        <Select class="form-select" name="IDHorario" value="${dato.IDHorario}" >
                            <c:forEach var="datoH" items="${listaHorario}">
                                <OPTION <c:if test="${dato.IDHorario == datoH.IDHorario}" >SELECTED</c:if>
                                    value="${datoH.IDHorario}">
                                    ${datoH.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Telefono</label>
                        <input class="form-control" type="text" name="Telefono"  value="${dato.Telefono}"/>
                        <br>
                        </c:forEach>
                        <br/>
                        <button type="summit" class="btn btn-success">Grabar</button>
                        <a class="btn btn-warning" href="./listar.htm">Cancelar</a>
                    </form>
                </div>          
            </div>
        </div>
    </body>
</html>

