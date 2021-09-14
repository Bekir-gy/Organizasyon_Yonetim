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
  class anayonetim {
     private int id;
    private int fiyat;
    private String adres;
    private String durumu;
    private String sattarih;

    public anayonetim() {
    }

    public anayonetim(int id, int fiyat, String adres, String durumu, String sattarih) {
        this.id = id;
        this.fiyat = fiyat;
        this.adres = adres;
        this.durumu = durumu;
        this.sattarih = sattarih;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDurumu() {
        return durumu;
    }

    public void setDurumu(String durumu) {
        this.durumu = durumu;
    }

    public String getSattarih() {
        return sattarih;
    }

    public void setSattarih(String sattarih) {
        this.sattarih = sattarih;
    }
    
    
    
    @Override
    public String toString() {
        return "anayonetim{" + "id=" + id + ", fiyat=" + fiyat + ", adres=" + adres + ", durumu=" + durumu + ", teslimtarih=" + sattarih + '}';
    }
    
    
    
}

