/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yonsis;

/**
 *
 * @author Lenovo
 */
public class tiyatro extends anayonetim{
     private anayonetim yontiyatro;
     String OyunAdi;
     String Turu;

    public tiyatro() {
        
        this.yontiyatro= new anayonetim();
    }

    public tiyatro(String OyunAdi, String Turu) {
        this.OyunAdi = OyunAdi;
        this.Turu = Turu;
    }

    public tiyatro(String OyunAdi, String Turu, int id, int fiyat, String adres, String durumu, String sattarih) {
        super(id, fiyat, adres, durumu, sattarih);
        this.OyunAdi = OyunAdi;
        this.Turu = Turu;
    }

    

    public String getTuru() {
        return Turu;
    }

    public void setTuru(String Turu) {
        this.Turu = Turu;
    }

    public String getOyunAdi() {
        return OyunAdi;
    }

    public void setOyunAdi(String OyunAdi) {
        this.OyunAdi = OyunAdi;
    }
    
    
    
     @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getOyunAdi()+ "^" + this.getTuru()+ "&" + this.getDurumu()+ "*"
                + this.getSattarih()+ "@@" ;
    }
    

    
    
     
     
     
    
}
