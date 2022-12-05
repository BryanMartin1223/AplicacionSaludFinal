<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Cita</title>|
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    </head>
 <body class="container">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <h3>Agregar Citas</h3>
                    <form Method="POST">
                        <label  class="form-label">ID</label>
                        <input class="form-control" type="text" name="IDCita" />
                        <label  class="form-label">Doctor</label>
                        <Select class="form-select" name="IDDoctor" >
                            <c:forEach var="datoD" items="${listaDoctor}">
                                <OPTION value="${datoD.IDDoctor}">${datoD.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Paciente</label>
                        <Select class="form-select" name="IDPaciente" >
                            <c:forEach var="datoP" items="${listaPaciente}">
                                <OPTION value="${datoP.ID}">${datoP.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Horario</label>
                        <Select class="form-select" name="IDHorario" >
                            <c:forEach var="datoH" items="${listaHorario}">
                                <OPTION value="${datoH.IDHorario}">${datoH.Nombre}</OPTION>
                            </c:forEach>                            
                        </select>
                        <label  class="form-label">Fecha</label>
                        <input class="form-control" type="text" name="Fecha" />
                        <label  class="form-label">Diagnostico</label>
                        <input class="form-control" type="text" name="Diagnostico" />
                        <label  class="form-label">Tratamiento</label>
                        <input class="form-control" type="text" name="Tratamiento" />
                        <label  class="form-label">Observaciones</label>
                        <input class="form-control" type="text" name="Observaciones" />
                        <br/>
                        <button type="summit" class="btn btn-success">Grabar</button>
                        <a class="btn btn-warning" href="./listar.htm">Cancelar</a>
                    </form>
                </div>             
            </div>
        </div>
    </body>
</html>
