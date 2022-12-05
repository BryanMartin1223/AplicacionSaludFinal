package Controller;

import Config.Conexion;
import Entidad.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerCita {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();    
    @RequestMapping("/Cita/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select c.IDCita, c.IDDoctor, c.IDPaciente, c.IDHorario, c.Fecha, c.Diagnostico, c.Tratamiento, c.Observaciones, "
                      + "d.Nombre NDoctor, p.Nombre NPaciente, h.Nombre NHorario " +
                        "from tbcita c " +
                        "inner join tbdoctor d on d.IDDoctor = c.IDDoctor " +
                        "inner join tbpaciente p on c.IDPaciente = p.ID " +
                        "inner join tbhorario h on h.IDHorario = c.IDHorario";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Cita/listar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject("listaDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listaPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Cita objEsp){
        String sql = "insert into tbcita(IDCita, IDDoctor, IDPaciente, IDHorario, Fecha, Diagnostico, Tratamiento, Observaciones)values(?,?,?,?,?,?,?,?)";
        this.jdbctemplate.update(sql,objEsp.getIDCita(), objEsp.getIDDoctor(), 
                    objEsp.getIDPaciente(),objEsp.getIDHorario(),objEsp.getFecha(), objEsp.getDiagnostico(),objEsp.getTratamiento(),objEsp.getObservaciones());        
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    @RequestMapping(value="/Cita/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbcita where IDCita = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listaPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/editar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Cita objCit){
        String sql = "update tbcita set IDDoctor=?, "
                + "IDPaciente=?, IDHorario=?, Fecha=?, Diagnostico=?, Tratamiento=?, Observaciones=? where IDCita=?";
        this.jdbctemplate.update(sql, objCit.getIDDoctor(), 
                    objCit.getIDPaciente(),objCit.getIDHorario(), objCit.getFecha(), objCit.getDiagnostico(),objCit.getTratamiento(),objCit.getObservaciones(), objCit.getIDCita());
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    @RequestMapping(value="/Cita/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
         int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbcita where IDCita = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaDoctor",new ControllerDoctor().ListarDoctor());
        mav.addObject("listaPaciente",new ControllerPaciente().ListarPaciente());
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.setViewName("/Cita/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Cita/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Cita objCit){
        String sql = "delete from tbcita where IDCita=?";
        this.jdbctemplate.update(sql, objCit.getIDDoctor());        
        return new ModelAndView("redirect:/Cita/listar.htm");
    }
    
    public List ListarCita(){
        String sql = "Select * from tbcita";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }    
}
