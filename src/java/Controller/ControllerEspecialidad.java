/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Config.Conexion;
import Entidad.Especialidad;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControllerEspecialidad {
    Conexion con = new Conexion();
    JdbcTemplate jdbctemplate = new JdbcTemplate(con.Conectar());
    ModelAndView mav = new ModelAndView();
    
    @RequestMapping("/Especialidad/listar.htm")
    public ModelAndView Listar(){
        String sql = "Select * from tbespecialidad";
        List datos=jdbctemplate.queryForList(sql);
        mav.addObject("lista",datos);
        mav.setViewName("/Especialidad/listar");
        return mav;
    }
    
    @RequestMapping(value="/Especialidad/agregar.htm", method = RequestMethod.GET )
    public ModelAndView Agregar(){
        mav.addObject(new Especialidad());
        mav.setViewName("/Especialidad/agregar");
        return mav;
    }
    
    @RequestMapping(value="/Especialidad/agregar.htm", method = RequestMethod.POST )
    public ModelAndView Agregar(Especialidad objEsp){
        String sql = "insert into tbespecialidad values(?,?)";
        this.jdbctemplate.update(sql,objEsp.getID(), objEsp.getNombre());        
        return new ModelAndView("redirect:/Especialidad/listar.htm");
    }
    
    @RequestMapping(value="/Especialidad/editar.htm", method = RequestMethod.GET )
    public ModelAndView Editar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbespecialidad where ID = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.setViewName("/Especialidad/editar");
        return mav;
    }
    
    @RequestMapping(value="/Especialidad/editar.htm", method = RequestMethod.POST )
    public ModelAndView Editar(Especialidad objEsp){
        String sql = "update tbespecialidad set Nombre=? where ID=?";
        this.jdbctemplate.update(sql, objEsp.getNombre(), objEsp.getID());        
        return new ModelAndView("redirect:/Especialidad/listar.htm");
    }
    
    @RequestMapping(value="/Especialidad/eliminar.htm", method = RequestMethod.GET )
    public ModelAndView Eliminar(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("ID"));
        String sql = "Select * from tbespecialidad where ID = ?";
        List datos=jdbctemplate.queryForList(sql,id);
        mav.addObject("lista",datos);
        mav.setViewName("/Especialidad/eliminar");
        return mav;
    }
    
    @RequestMapping(value="/Especialidad/eliminar.htm", method = RequestMethod.POST )
    public ModelAndView Eliminar(Especialidad objEsp){
        String sql = "delete from tbespecialidad where ID=?";
        this.jdbctemplate.update(sql, objEsp.getID());        
        return new ModelAndView("redirect:/Especialidad/listar.htm");
    }
    
    public List ListarEspecialidad(){
        String sql = "Select * from tbEspecialidad";
        List datos=jdbctemplate.queryForList(sql);
        return datos;
    }
}