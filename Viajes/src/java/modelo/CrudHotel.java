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
public class CrudHotel {
    
    ConexionBd con = new ConexionBd();
    
    public List<Hotel> mostrarHotel(){
        Connection cn; 
        PreparedStatement pst;
        ResultSet rs;
        List<Hotel> lst = new ArrayList(); 
        String sql = "select * from tb_hotel";
        try{
            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lst.add(new Hotel(rs.getInt("codHotel"), 
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
    
    public String insertarHotel(Object obj){
        String resp=null;
        Connection cn; 
        PreparedStatement pst;
        String sql="insert into tb_hotel values(?,?)";        
        Hotel hotel=(Hotel)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);           
            pst.setInt(1,hotel.getCodHotel());
            pst.setString(2, hotel.getNombre());                        
            pst.executeUpdate();
        } catch (Exception e) {
           resp=e.toString();
        }
        return resp;
    }
    
    public void modificarHotel(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="update tb_hotel set nombre=? where codHotel=? ";
           Hotel pro=(Hotel)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);            
            pst.setString(1, pro.getNombre());            
            pst.setInt(2,pro.getCodHotel());
            pst.executeUpdate();            
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarHotel(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="delete from tb_hotel where codHotel=?";
        Hotel pro=(Hotel)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setInt(1,pro.getCodHotel());
            pst.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public int contarHotel(Object obj){
     Connection cn;
     PreparedStatement pst;
     ResultSet rs;
     int cant=0;
     String sql="select count(*) as cantidad from tb_hotel";
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
