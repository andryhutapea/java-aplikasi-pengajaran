/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11316006.Controller;

import Model.login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Andry F. Hutapea
 */
public class Register_FXMLController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TableView<login> jtblviewlogin;
    private ObservableList<login>data;
    @FXML
    private TableColumn<?, ?> tblviewusername;
    @FXML
    private TableColumn<?, ?> jtblviewpassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    }

    @FXML
    private void loginAction(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String Username = username.getText();
        String Password = password.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/pbo1316006", "root", "");
            Statement statement = (Statement) koneksi.createStatement();

            String sql = "insert into login(username,password) values('" + Username + "','" + Password + "')";
            int executeUpdate = statement.executeUpdate(sql);
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {

        }
    }


    @FXML
    private void update(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String Username = username.getText();
        String Password = password.getText();
        
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/tutor", "root", "");
            Statement statement = (Statement) koneksi.createStatement();

            String sql = "Update login SET password = '"+Password+"' WHERE username = '"+Username+"'";
            int executeUpdate = statement.executeUpdate(sql);
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {

        }
    }

    @FXML
    private void delete(ActionEvent event) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String Username = username.getText();
        String Password = password.getText();
        
         try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/tutor", "root", "");
            Statement statement = (Statement) koneksi.createStatement();

            String sql = "DELETE FROM login WHERE username = '"+Username+"'AND password='"+Password+"'";
            int executeUpdate = statement.executeUpdate(sql);
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {

        }
    }

    private void tampilan_tabel() {
       tblviewusername.setCellValueFactory(new PropertyValueFactory<>("Username"));
       tblviewusername.setCellValueFactory(new PropertyValueFactory<>("Password"));
    }

    private void loadDataFromDatabase() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        data.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection koneksi = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/tutor", "root", "");
            Statement statement = (Statement) koneksi.createStatement();

            String sql = "SELECT * FROM login";
            PreparedStatement stmt= koneksi.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
            data.add(new login(rs.getString(2),rs.getString(3)));
        }
            jtblviewlogin.setItems(data);
        } catch (SQLException ex) {

        }
        
    }

}
