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
public class TiyatroController extends AnamenuController implements Initializable {

    @FXML private TableView<tiyatro> tableview2;
     @FXML private TableColumn<tiyatro,String> oyunadi2;
     @FXML private TableColumn<tiyatro,String> turu2;
     @FXML private TableColumn<tiyatro,String> tarih2;
     @FXML private TableColumn<tiyatro,String> adres2;
     @FXML private TableColumn<tiyatro,String> durum2;
     @FXML private TableColumn<tiyatro,Integer> id2;
     @FXML private TableColumn<tiyatro,Integer> fiyat2;
     
      @FXML private TextField t_id;
      @FXML private TextField t_fiyat;
       @FXML private TextField t_oyunadi;
        @FXML private TextField t_turu;
         @FXML private TextArea t_adres;
          @FXML private TextField t_durum;
      @FXML private TextField t_tarih;
      
      @FXML private TextField aratiyatro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Oku();
            // TODO
            oyunadi2.setCellValueFactory(new PropertyValueFactory<tiyatro,String> ("OyunAdi"));
            turu2.setCellValueFactory(new PropertyValueFactory<tiyatro,String> ("Turu"));
            tarih2.setCellValueFactory(new PropertyValueFactory<tiyatro,String> ("Sattarih"));
             adres2.setCellValueFactory(new PropertyValueFactory<tiyatro,String> ("adres"));
              durum2.setCellValueFactory(new PropertyValueFactory<tiyatro,String> ("Durumu"));
               fiyat2.setCellValueFactory(new PropertyValueFactory<tiyatro,Integer> ("fiyat"));
             id2.setCellValueFactory(new PropertyValueFactory<tiyatro,Integer> ("id"));
            
            tableview2.setItems(gettiyatro);
        } catch (IOException ex) {
            Logger.getLogger(SoylesiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public ObservableList<tiyatro> gettiyatro=FXCollections.observableArrayList();
        List<String> liste = new ArrayList<>();
        BackgroundData  txt= new BackgroundData();
 public void Oku() throws IOException{
            liste.clear();
            gettiyatro.clear();
            txt.TxtReader("tiyatro.txt",liste);
            
            tiyatro tmp;
             for (int i = 0; i < txt.Length("tiyatro.txt"); i++) {
            tmp = new tiyatro();
            tmp.setId(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("@") + 1, liste.get(i).indexOf("#"))));
            tmp.setFiyat(Integer.parseInt(liste.get(i).substring(liste.get(i).indexOf("#") + 1, liste.get(i).indexOf("$"))));
            tmp.setAdres(liste.get(i).substring(liste.get(i).indexOf("$") + 1, liste.get(i).indexOf("%")));
            tmp.setOyunAdi(liste.get(i).substring(liste.get(i).indexOf("%") + 1, liste.get(i).indexOf("^")));
            tmp.setTuru(liste.get(i).substring(liste.get(i).indexOf("^") + 1, liste.get(i).indexOf("&")));
            tmp.setDurumu(liste.get(i).substring(liste.get(i).indexOf("&") + 1, liste.get(i).indexOf("*")));
            tmp.setSattarih(liste.get(i).substring(liste.get(i).indexOf("*") + 1, liste.get(i).indexOf("@@")));
            

            gettiyatro.add(tmp);
        }
            
        }
    @Override
    public void ekle() {
         try {
            gettiyatro.add(getData());
            t_id.clear();
            t_fiyat.clear();
            t_oyunadi.clear();
            t_turu.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            
            txt.addLine("tiyatro.txt", gettiyatro.get(gettiyatro.size() - 1).toString(), true);
        } catch (IOException ex) {
            Logger.getLogger(SoylesiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    int index;

    @Override
    public void guncelle() {
              if (index <= -1) {
            return;
        }else{
            gettiyatro.set(index, getData());
            t_id.clear();
            t_fiyat.clear();
            t_oyunadi.clear();
            t_turu.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < gettiyatro.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tiyatro.txt", gettiyatro.get(i).toString(), false);

                    } else {

                        txt.addLine("tiyatro.txt", gettiyatro.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SoylesiController.class.getName()).log(Level.SEVERE, null, ex);
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
            t_oyunadi.clear();
            t_turu.clear();
            t_durum.clear();
            t_tarih.clear();
            t_adres.clear();
            for (int i = 0; i < gettiyatro.size(); i++){
                try{
                    if (i == 0) {
                        txt.addLine("tiyatro.txt", gettiyatro.get(i).toString(), false);

                    } else {

                        txt.addLine("tiyatro.txt", gettiyatro.get(i).toString(), true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(SoylesiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void ara() {
        aratiyatro.textProperty().addListener(new InvalidationListener() {
             @Override
             public void invalidated(Observable observable) {
                 if (aratiyatro.textProperty().get().isEmpty()) {
                    tableview2.setItems(gettiyatro);
                    return;
                }//eger bos ise

                //degilse?
                ObservableList<tiyatro> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<tiyatro, ?>> column = tableview2.getColumns();
                
                for (int row = 0; row < gettiyatro.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn colVar = column.get(col);
                        String celValue = colVar.getCellData(gettiyatro.get(row)).toString();
                        celValue = celValue.toLowerCase();

                        if (celValue.contains(aratiyatro.getText().toLowerCase()) && celValue.startsWith(aratiyatro.getText().toLowerCase())) {
                            items.add(gettiyatro.get(row));
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
        t_oyunadi.setText(oyunadi2.getCellData(index));
        t_turu.setText(turu2.getCellData(index));
        t_durum.setText(durum2.getCellData(index));
        t_tarih.setText(tarih2.getCellData(index));
    }
    
     public tiyatro getData() {
        int id = Integer.parseInt(t_id.getText());
        int fiyat = Integer.parseInt(t_fiyat.getText());
         String Turu = t_turu.getText();
        String adres = t_adres.getText();
        
        String OyunAdi = t_oyunadi.getText();
        
        
        String Durumu = t_durum.getText();
        String Sattarih = t_tarih.getText();
        
       
        return new tiyatro(OyunAdi, Turu, id, fiyat, adres, Durumu, Sattarih);

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

