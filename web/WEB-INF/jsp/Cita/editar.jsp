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
                        <input class="form-control" type="text" name="IDCita" value="${dato.IDCita}" />
                        <label  class="form-label">Doctor</label>
                        <Select class="form-select" name="IDDoctor" value="${dato.IDDoctor}" >
                            <c:forEach var="datoD" items="${listaDoctor}">
                                <OPTION <c:if test="${datoD.IDDoctor == dato.IDDoctor}" >SELECTED</c:if> 
                                    value="${datoD.IDDoctor}">
                                    ${datoD.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Paciente</label>
                        <Select class="form-select" name="IDPaciente" value="${dato.IDPaciente}" >
                            <c:forEach var="datoP" items="${listaPaciente}">
                                <OPTION <c:if test="${datoP.ID == dato.IDPaciente}" >SELECTED</c:if> 
                                    value="${datoP.ID}">
                                    ${datoP.Nombre}</OPTION>
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
                        <label  class="form-label">Fecha</label>
                        <input class="form-control" type="text" name="Fecha"  value="${dato.Fecha}"/>
                        <label  class="form-label">Diagnostico</label>
                        <input class="form-control" type="text" name="Diagnostico"  value="${dato.Diagnostico}"/>
                        <label  class="form-label">Tratamiento</label>
                        <input class="form-control" type="text" name="Tratamiento"  value="${dato.Tratamiento}"/>
                        <label  class="form-label">Observaciones</label>
                        <input class="form-control" type="text" name="Observaciones"  value="${dato.Observaciones}"/>
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

