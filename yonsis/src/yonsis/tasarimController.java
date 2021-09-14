/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yonsis;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class tasarimController implements Initializable {
    
   @FXML
    TextField username;
    @FXML
    PasswordField password;

    public void login(Event e) {
        try {
            if (username.getText().trim().matches("USER") && password.getText().equalsIgnoreCase("1234")) {

                Parent parent = FXMLLoader.load(getClass().getResource("anamenu.fxml"));

                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("ANA SAYFA");
                Rectangle2D rd = Screen.getPrimary().getVisualBounds();
                stage.setX((rd.getWidth() - stage.getWidth()) / 2);
                stage.setY((rd.getHeight() - stage.getHeight()) / 2);

            } else {
                JOptionPane.showMessageDialog(null, "Lütfen Bilgilerinizi Kontrol Edin");
            }
        } catch (IOException ex) {
            
        }
    }

    public void exit() {
        Platform.exit();
    }
    public void konserAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("konser.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("KONSER SATIŞ");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }
    
    public void soylesiAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("soylesi.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("SÖYLEŞİ ETKİNLİK");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);
                                 
        } catch (IOException ex) {

        }
    }
    
    public void tiyatroAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("tiyatro.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("TİYATRO ETKİNLİK");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }
    
     public void hakkimizdaAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("hakkimizda.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("HAKKIMIZDA");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }
     
      public void maliyetAc(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("konser.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Maliyet Ekranı");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);

        } catch (IOException ex) {

        }
    }

    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    
}
