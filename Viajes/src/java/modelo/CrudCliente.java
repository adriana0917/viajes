
package modelo;

/**
 *
 * @author Adriana
 */

import conexion.ConexionBd;
import java.util.*;
import java.sql.*;

public class CrudCliente {
    
    ConexionBd con = new ConexionBd();

    public List<Cliente> mostrarCliente(){
        Connection cn;
        PreparedStatement pst;
        ResultSet rs;
        List<Cliente> lst = new ArrayList(); 
        String sql = "SELECT * FROM tb_cliente"; 
        try{
            Class.forName(con.getDriver());
            cn = DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                lst.add(new Cliente(rs.getInt("codCliente"), 
                rs.getString("nombre"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("correo")));
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
    
    public String insertarCliente(Object obj){
        String resp=null;
        Connection cn; 
        PreparedStatement pst;
        String sql="insert into tb_cliente values(?,?,?,?,?)";        
        Cliente pro=(Cliente)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);           
            pst.setInt(1, pro.getCodCliente());
            pst.setString(2, pro.getNombre());
            pst.setString(3, pro.getDireccion());
            pst.setString(4, pro.getTelefono());
            pst.setString(5, pro.getCorreo());
            pst.executeUpdate();
        } catch (Exception e) {
           resp=e.toString();
        }
        return resp;
    }
    
    public void modificarCliente(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="update tb_cliente set nombre=?, direccion=?, telefono=?, correo=? where codCliente=? ";
           Cliente pro=(Cliente)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);            
            pst.setString(1, pro.getNombre()); 
            pst.setString(2, pro.getDireccion());
            pst.setString(3, pro.getTelefono());
            pst.setString(4, pro.getCorreo());
            pst.setInt(5,pro.getCodCliente());
            pst.executeUpdate();            
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void eliminarCliente(Object obj){
        Connection cn; 
        PreparedStatement pst;
        String sql="delete from tb_cliente where codCliente=?";
        Cliente pro=(Cliente)obj;
        try {
            Class.forName(con.getDriver());
            cn=DriverManager.getConnection(con.getUrl(),con.getUser(),con.getPass());
            pst=cn.prepareStatement(sql);
            pst.setInt(1,pro.getCodCliente());
            pst.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public int contarclientes(Object obj){
     Connection cn;
     PreparedStatement pst;
     ResultSet rs;
     int cant=0;
     String sql="select count(*) as cantidad from tb_cliente";
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
