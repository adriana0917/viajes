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
public class CrudAerolinea {
    
    ConexionBd con = new ConexionBd();

    public List<Aerolinea> mostrarAerolinea(){
        Connection cn; 
        PreparedStatement pst;
        ResultSet rs;
        List<Aerolinea> lst = new ArrayList(); 
        String sql = "select * from tb_aerolinea";
        try{
            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lst.add(new Aerolinea(rs.getInt("codAerolinea"), 
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
    
    public String insertarAerolinea(Object obj){
        String resp=null;
        Connection cn; 
        PreparedStatement pst;
        String sql="insert into tb_aerolinea values(?,?)";        
        Aerolinea pro=(Aerolinea)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);           
            pst.setInt(1,pro.getCodAerolinea());
            pst.setString(2, pro.getNombre());                        
            pst.executeUpdate();
        } catch (Exception e) {
           resp=e.toString();
        }
        return resp;
    }
    
    public void modificarAerolinea(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="update tb_aerolinea set nombre=? where codAerolinea=? ";
           Aerolinea pro=(Aerolinea)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);            
            pst.setString(1, pro.getNombre());            
            pst.setInt(2,pro.getCodAerolinea());
            pst.executeUpdate();            
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarAerolinea(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="delete from tb_aerolinea where codAerolinea=?";
        Aerolinea pro=(Aerolinea)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setInt(1,pro.getCodAerolinea());
            pst.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public int contarAerolineas(Object obj){
     Connection cn;
     PreparedStatement pst;
     ResultSet rs;
     int cant=0;
     String sql="select count(*) as cantidad from tb_aerolinea";
     try{
            Class.forName(con.getDriver());//Obteniendo valores de la conexion
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            rs= pst.executeQuery();
            while(rs.next()){
                cant=rs.getInt("cantidad")+1;
            }
                rs.close();
                pst.close();
                cn.close();
     }   
     catch(Exception e) {
         e.printStackTrace();
     }
     return cant;
    }
    
}
