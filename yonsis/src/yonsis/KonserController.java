/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yonsis;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class KonserController extends AnamenuController implements Initializable {

    @FXML private TableView<konser> tableview2;
     @FXML private TableColumn<konser,String> sanatci2;
     @FXML private TableColumn<konser,String> satinal2;
     @FXML private TableColumn<konser,String> tarih2;
     @FXML private TableColumn<konser,String> adres2;
     @FXML private TableColumn<konser,String> durum2;
     @FXML private TableColumn<konser,Integer> id2;
     @FXML private TableColumn<konser,Integer> fiyat2;
     
      @FXML private TextField t_id;
      @FXML private TextField t_fiyat;
       @FXML private TextField t_sanatci;
        @FXML private TextField t_satinal;
         @FXML private TextArea t_adres;
          @FXML private TextField t_durum;
      @FXML private TextField t_tarih;
      
      @FXML private TextField arakonser;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
            // TODO
            sanatci2.setCellValueFactory(new PropertyValueFactory<konser,String> ("Sanatci"));
            satinal2.setCellValueFactory(new PropertyValueFactory<konser,String> ("Satinalan"));
            tarih2.setCellValueFactory(new PropertyValueFactory<konser,String> ("Sattarih"));
             adres2.setCellValueFactory(new PropertyValueFactory<konser,String> ("adres"));
              durum2.setCellValueFactory(new PropertyValueFactory<konser,String> ("Durumu"));
               fiyat2.setCellValueFactory(new PropertyValueFactory<konser,Integer> ("fiyat"));
             id2.setCellValueFactory(new PropertyValueFactory<konser,Integer> ("id"));
            
            tableview2.setItems(getkonser);
        } catch (IOException ex) {
            Logger.getLogger(KonserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public ObservableList<konser> getkonser=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        BackgroundData  txt= new BackgroundData();
 public void Oku() throws IOException{
            liste.clear();
            getkonser.clear();
            txt.TxtReader("konser.txt",liste);
            
            konser tmp;
             for (int i = 0; i < txt.Length("konser.txt"); i++) {
            tmp = new konser();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setSanatci(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setSatinalan(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setDurumu(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setSattarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            getkonser.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
         try {
            getkonser.add(getData());
            t_id.clear();
            t_fiyat.clear();
            t_sanatci.clear();
            t_satinal.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            
            txt.addLine("konser.txt", getkonser.get(getkonser.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(KonserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
              if (index <= -1) {
            return;
        }else{
            getkonser.set(index, getData());
            t_id.clear();
            t_fiyat.clear();
            t_sanatci.clear();
            t_satinal.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < getkonser.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("konser.txt", getkonser.get(i).toString(), false);

                    } else {

                        txt.addLine("konser.txt", getkonser.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(KonserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

    @Override
    public void sil() {
         if (index <= -1) {
            return;
            
          }
        else{
            tableview2.getItems().remove(index);
            index = -1;
            t_id.clear();
            t_fiyat.clear();
            t_sanatci.clear();
            t_satinal.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < getkonser.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("konser.txt", getkonser.get(i).toString(), false);

                    } else {

                        txt.addLine("konser.txt", getkonser.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(KonserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
        arakonser.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (arakonser.textProperty().get().isEmpty()) {
                    tableview2.setItems(getkonser);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<konser> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<konser, ?>> column = tableview2.getColumns();
                
                for (int row = 0; row < getkonser.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(getkonser.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(arakonser.getText().toLowerCase()) && celValue.startsWith(arakonser.getText().toLowerCase())) {
                            items.add(getkonser.get(row));
                            break;
                        }
                    }

                }
                tableview2.setItems(items);
                 
             }
             
             
         });
    }

    @Override
    public void getSelected() {
          index = tableview2.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        t_id.setText(id2.getCellData(index).toString());
        t_fiyat.setText(fiyat2.getCellData(index).toString());
        t_adres.setText(adres2.getCellData(index));
        t_sanatci.setText(sanatci2.getCellData(index));
        t_satinal.setText(satinal2.getCellData(index));
        t_durum.setText(durum2.getCellData(index));
        t_tarih.setText(tarih2.getCellData(index));
    }
    
     public konser getData() {
        int id = Integer.parseInt(t_id.getText());
        int fiyat = Integer.parseInt(t_fiyat.getText());
         String Satinalan = t_satinal.getText();
        String adres = t_adres.getText();
        
        String Sanatci = t_sanatci.getText();
        
        
        String Durumu = t_durum.getText();
        String Sattarih = t_tarih.getText();
        
       
        return new konser(Sanatci, Satinalan, id, fiyat, adres, Durumu, Sattarih);

    }
     
     @Override
    public void geri(Event e) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("anamenu.fxml"));

            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("ANA MENU");
            Rectangle2D rd = Screen.getPrimary().getVisualBounds();
            stage.setX((rd.getWidth() - stage.getWidth()) / 2);
            stage.setY((rd.getHeight() - stage.getHeight()) / 2);
            
        } catch (IOException ex) {

        }

    }
}
