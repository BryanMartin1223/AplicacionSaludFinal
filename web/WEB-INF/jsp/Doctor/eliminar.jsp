<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Turno</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Eliminar Turno</h3>
                    <form Method="POST" action="./eliminar.htm" >
                        <form Method="POST" action="./editar.htm">
                        <c:forEach var="dato" items="${lista}">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="IDDoctor" readonly="readonly" value="${dato.IDDoctor}" />
                        <label  class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="Nombre"  readonly="readonly" value="${dato.Nombre}"/>
                        <label  class="form-label">Especialidad</label>
                        <Select class="form-select" name="IDEspecialidad" readonly="readonly" value="${dato.IDEspecialidad}" >
                            <c:forEach var="datoE" items="${listaEspecialidad}">
                                <OPTION <c:if test="${datoE.ID == dato.IDEspecialidad}" >SELECTED</c:if> 
                                    value="${datoE.ID}">
                                    ${datoE.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Horario</label>
                        <Select class="form-select" name="IDHorario" readonly="readonly" value="${dato.IDHorario}" >
                            <c:forEach var="datoH" items="${listaHorario}">
                                <OPTION <c:if test="${dato.IDHorario == datoH.IDHorario}" >SELECTED</c:if>
                                    value="${datoH.IDHorario}">
                                    ${datoH.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Telefono</label>
                        <input class="form-control" type="text" name="Telefono" readonly="readonly" value="${dato.Telefono}"/>
                        <br>
                        </c:forEach>
                        <label  class="form-label"><b>Se procedera con la eliminacion de este registro<br>
                                ¿Está seguro de continuar?</b></label>
                        <button type="summit" class="btn btn-danger">Si, Eliminar</button>
                        <a class="btn btn-warning" href="./listar.htm">Cancelar</a>
                    </form>
                </div>             
            </div>
        </div>
    </body>
</html>

