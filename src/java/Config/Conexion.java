/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.sql.DriverManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 *
 * @author ferca
 */
public class Conexion {
    public DriverManagerDataSource Conectar(){
    DriverManagerDataSource datasource= new DriverManagerDataSource();
    datasource.setDriverClassName("com.mysql.jdbc.Driver");
    datasource.setUrl("jdbc:mysql://localhost:3306/bd_das");
    datasource.setUsername("root");
    datasource.setPassword("");
    return datasource;
    }
}
