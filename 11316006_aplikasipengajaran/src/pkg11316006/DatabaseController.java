/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11316006;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andry F. Hutapea
 */
public class DatabaseController {

    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    public DatabaseController() {
        this.con = null;
        this.stmt = null;
        this.rs = null;
    }

    //method untuk terhubung ke database
    public void connect() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost/pbo11316006?"
                    + "user=user&password=user");
        } catch (Exception e) {
            System.out.println("Koneksi ke database gagal!!");
            System.out.println(e);
        }
    }

    /**
     * @param stmt the stmt to set
     */
    private void setStmt() {
        try {
            this.stmt = this.con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the rs
     */
    public ResultSet getRs(String statement) {
        try {
            this.setStmt();
            this.rs = stmt.executeQuery(statement);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.rs;
    }

    //for insert,update,delete

    public void Execute(String statement) {
        this.connect();
        try {
            this.setStmt();
            this.stmt.execute(statement);
            this.stmt.close();
            this.con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    //get row count of an ResultSet
    public int getRowCount(ResultSet resultSet) {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            try {
                resultSet.beforeFirst();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
        return 0;
    }

    //free all databese resource
    public void close() {
        try {
            this.rs.close();
            this.stmt.close();
            this.con.close();
        } catch (SQLException ex) {

        }

    }

}
