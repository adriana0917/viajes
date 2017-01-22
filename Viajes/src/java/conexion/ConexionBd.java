/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author Adriana
 */
public class ConexionBd {
    private String user;
    private String driver;
    private String pass;
    private String url;
    
    public ConexionBd(){
        this.user = "root";
        this.driver = "com.mysql.jdbc.Driver";
        this.pass = "root";
        this.url = "jdbc:mysql://localhost:3306/db_viajes";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
