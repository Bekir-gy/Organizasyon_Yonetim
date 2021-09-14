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
public class soylesi extends anayonetim{
    private anayonetim yonsoylesi;
     String Katilimci;
     String Davetli;

    public soylesi() {
        
        this.yonsoylesi= new anayonetim();
    }

    public soylesi(String Katilimci, String Davetli) {
        this.Katilimci = Katilimci;
        this.Davetli = Davetli;
    }

    public soylesi(String Katilimci, String Davetli, int id, int fiyat, String adres, String durumu, String sattarih) {
        super(id, fiyat, adres, durumu, sattarih);
        this.Katilimci = Katilimci;
        this.Davetli = Davetli;
    }

    public String getKatilimci() {
        return Katilimci;
    }

    public void setKatilimci(String Katilimci) {
        this.Katilimci = Katilimci;
    }

    public String getDavetli() {
        return Davetli;
    }

    public void setDavetli(String Davetli) {
        this.Davetli = Davetli;
    }

     @Override
    public String toString() {
        return "@" + this.getId() + "#" + this.getFiyat() + "$" + this.getAdres() + "%" + this.getKatilimci()+ "^" + this.getDavetli()+ "&" + this.getDurumu()+ "*"
                + this.getSattarih()+ "@@" ;
    }
    
     
     
     
    
}
