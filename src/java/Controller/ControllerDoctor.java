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
public class ControllerDoctor {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();    
    @RequestMapping("/Doctor/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select d.IDDoctor, d.IDHorario, d.IDEspecialidad, d.Nombre, d.Telefono, "
                      + "h.Nombre NHorario, e.Nombre NEspecialidad " +
                        "from tbdoctor d " +
                        "inner join tbHorario h on h.IDHorario = d.IDHorario " +
                        "inner join tbespecialidad e on d.IDEspecialidad = e.ID";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Doctor/listar");
        return mav;
    }
    
    @RequestMapping(value="/Doctor/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.addObject("listaEspecialidad",new ControllerEspecialidad().ListarEspecialidad());
        mav.setViewName("/Doctor/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Doctor/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Doctor objEsp){
        String sql = "insert into tbdoctor  (IDDoctor, IDEspecialidad, IDHorario, Nombre, Telefono )values(?,?,?,?,?)";
        this.jdbctemplate.update(sql,objEsp.getIDDoctor(), objEsp.getIDEspecialidad(), 
                    objEsp.getIDHorario(),objEsp.getNombre(), objEsp.getTelefono());        
        return new ModelAndView("redirect:/Doctor/listar.htm");
    }
    
    @RequestMapping(value="/Doctor/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbdoctor where IDDoctor = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.addObject("listaEspecialidad",new ControllerEspecialidad().ListarEspecialidad());
        mav.setViewName("/Doctor/editar");
        return mav;
    }
    
    @RequestMapping(value="/Doctor/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Doctor objEsp){
        String sql = "update tbdoctor set IDEspecialidad=?, "
                + "IDHorario=?, Nombre=?, Telefono=? where IDDoctor=?";
        this.jdbctemplate.update(sql, objEsp.getIDEspecialidad(), objEsp.getIDHorario(), 
                objEsp.getNombre(), objEsp.getTelefono(),objEsp.getIDDoctor());        
        return new ModelAndView("redirect:/Doctor/listar.htm");
    }
    
    @RequestMapping(value="/Doctor/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
         int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbdoctor where IDDoctor = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("listaHorario",new ControllerHorario().ListarHorario());
        mav.addObject("listaEspecialidad",new ControllerEspecialidad().ListarEspecialidad());
        mav.setViewName("/Doctor/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Doctor/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Doctor objEsp){
        String sql = "delete from tbDoctor where IDDoctor=?";
        this.jdbctemplate.update(sql, objEsp.getIDDoctor());        
        return new ModelAndView("redirect:/Doctor/listar.htm");
    }
    
    public List ListarDoctor(){
        String sql = "Select * from tbdoctor";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }    
}
