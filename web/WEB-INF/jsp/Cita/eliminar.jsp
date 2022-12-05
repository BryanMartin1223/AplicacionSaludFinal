<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Cita</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Eliminar Cita</h3>
                    <form Method="POST" action="./eliminar.htm" >
                        <form Method="POST" action="./editar.htm">
                        <c:forEach var="dato" items="${lista}">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="IDDoctor" readonly="readonly" value="${dato.IDDoctor}" />
                        <label  class="form-label">Doctor</label>
                        <Select class="form-select" name="IDDoctor" readonly="readonly" value="${dato.IDDoctor}" >
                            <c:forEach var="datoD" items="${listaDoctor}">
                                <OPTION <c:if test="${datoD.IDDoctor == dato.IDDoctor}" >SELECTED</c:if> 
                                    value="${datoD.IDDoctor}">
                                    ${datoD.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Paciente</label>
                        <Select class="form-select" name="IDPaciente" readonly="readonly" value="${dato.IDPaciente}" >
                            <c:forEach var="datoP" items="${listaPaciente}">
                                <OPTION <c:if test="${dato.ID == datoP.IDPaciente}" >SELECTED</c:if>
                                    value="${datoP.ID}">
                                    ${datoP.Nombre}</OPTION>
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
                        <label  class="form-label">Fecha</label>
                        <input class="form-control" type="text" name="Fecha" readonly="readonly" value="${dato.Fecha}"/>
                        <label  class="form-label">Diagnostico</label>
                        <input class="form-control" type="text" name="Diagnostico" readonly="readonly" value="${dato.Diagnostico}"/>
                        <label  class="form-label">Tratamiento</label>
                        <input class="form-control" type="text" name="Tratamiento="readonly" value="${dato.Tratamiento}"/>
                        <label  class="form-label">Observaciones</label>
                        <input class="form-control" type="text" name="Observaciones" readonly="readonly" value="${dato.Observaciones}"/>
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

