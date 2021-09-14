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
public class konser extends anayonetim{
     private anayonetim yonkonser;
     String Sanatci;
     String Satinalan;

    public konser() {
        this.yonkonser= new anayonetim();
    }

    public konser(String Sanatci, String Satinalan) {
        this.Sanatci = Sanatci;
        this.Satinalan = Satinalan;
    }

    public konser(String Sanatci, String Satinalan, int id, int fiyat, String adres, String durumu, String sattarih) {
        super(id, fiyat, adres, durumu, sattarih);
        
        this.Sanatci = Sanatci;
        this.Satinalan = Satinalan;
    }

    public String getSanatci() {
        return Sanatci;
    }

    public void setSanatci(String Sanatci) {
        this.Sanatci = Sanatci;
    }

    public String getSatinalan() {
        return Satinalan;
    }

    public void setSatinalan(String Satinalan) {
        this.Satinalan = Satinalan;
    }

     /*@Override
    public int getFiyat() {
        return fiyat;
    }

     @Override
    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }*/
    
    
     
     @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getSanatci()+ "^" + this.getSatinalan()+ "&" + this.getDurumu()+ "*"
                + this.getSattarih()+ "@@" ;
    }
    
     
    
}
