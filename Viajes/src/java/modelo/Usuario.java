/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.ConexionBd;
import java.sql.*;
/**
 *
 * @author Adriana
 */
public class Usuario {
    ConexionBd con = new ConexionBd();
    
    public boolean autenticarUsuario(String usuario, String contraseña){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        try {
            String sql = "select * from tb_usuario where userName=? and clave=?";
            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst = cn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            if (rs.absolute(1)) {
                return true;
            }
            
            rs.close();
            pst.close();
            cn.close();            
        } 
        catch (Exception e) {
            System.err.println("Error");
        }
        return false;
    }

    public static void main(String[] args){
        Usuario objeto = new Usuario();
        System.out.println(objeto.autenticarUsuario("Administrador1", "1234"));
    }
}