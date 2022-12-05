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
public class ControllerHorario {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("/Horario/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select h.IDHorario, h.Nombre, h.IDTurno, t.Nombre NTurno from tbHorario h inner join tbTurno t on h.IDTurno=t.ID";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Horario/listar");
        return mav;
    }
    
    @RequestMapping(value="/Horario/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject("lista",new ControllerTurno().ListarTurno());
        mav.setViewName("/Horario/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Horario/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Horario objEsp){
        String sql = "insert into tbhorario values(?,?,?)";
        this.jdbctemplate.update(sql,objEsp.getIDHorario(), objEsp.getNombre(), objEsp.getIDTurno());        
        return new ModelAndView("redirect:/Horario/listar.htm");
    }
    
    @RequestMapping(value="/Horario/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbhorario where IDHorario = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("turno",new ControllerTurno().ListarTurno());
        mav.setViewName("/Horario/editar");
        return mav;
    }
    
    @RequestMapping(value="/Horario/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Horario objEsp){
        String sql = "update tbHorario set Nombre=?, IDTurno=? where IDHorario=?";
        this.jdbctemplate.update(sql, objEsp.getNombre(), objEsp.getIDTurno(), objEsp.getIDHorario());        
        return new ModelAndView("redirect:/Horario/listar.htm");
    }
    
    @RequestMapping(value="/Horario/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
         int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbhorario where IDHorario = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.addObject("turno",new ControllerTurno().ListarTurno());
        mav.setViewName("/Horario/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Horario/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Horario objEsp){
        String sql = "delete from tbhorario where IDHorario=?";
        this.jdbctemplate.update(sql, objEsp.getIDHorario());        
        return new ModelAndView("redirect:/Horario/listar.htm");
    }
    
    public List ListarHorario(){
        String sql = "Select * from tbhorario";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }    
}
