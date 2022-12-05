/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ControllerTurno {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("/Turno/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select * from tbturno";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Turno/listar");
        return mav;
    }
    
    @RequestMapping(value="/Turno/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject(new Turno());
        mav.setViewName("/Turno/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Turno/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Turno objEsp){
        String sql = "insert into tbturno values(?,?)";
        this.jdbctemplate.update(sql,objEsp.getID(), objEsp.getNombre());        
        return new ModelAndView("redirect:/Turno/listar.htm");
    }
    
    @RequestMapping(value="/Turno/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbturno where ID = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.setViewName("/Turno/editar");
        return mav;
    }
    
    @RequestMapping(value="/Turno/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Turno objEsp){
        String sql = "update tbturno set Nombre=? where ID=?";
        this.jdbctemplate.update(sql, objEsp.getNombre(), objEsp.getID());        
        return new ModelAndView("redirect:/Turno/listar.htm");
    }
    
    @RequestMapping(value="/Turno/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbturno where ID = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.setViewName("/Turno/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Turno/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Turno objEsp){
        String sql = "delete from tbturno where ID=?";
        this.jdbctemplate.update(sql, objEsp.getID());        
        return new ModelAndView("redirect:/Turno/listar.htm");
    }
    
    public List ListarTurno(){
        String sql = "Select * from tbturno";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }
            
}
