/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBd;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Adriana
 */
public class CrudPais {
    ConexionBd con = new ConexionBd();
    
    public List<Pais> mostrarPais(){
        Connection cn; 
        PreparedStatement pst;
        ResultSet rs;
        List<Pais> lst = new ArrayList(); 
        String sql = "select * from tb_pais";
        try{
            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lst.add(new Pais(rs.getInt("codPais"), 
                rs.getString("nombre")));
            }
            rs.close();
            pst.close();
            cn.close();
        }
            catch(Exception e){
                System.out.println(e.toString());
        }
        return lst;
    }
}
