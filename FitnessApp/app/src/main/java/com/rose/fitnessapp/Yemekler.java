package com.rose.fitnessapp;

public class Yemekler {
    public Yemekler() {
        // Boş bir yapıcı metot gereklidir (Firebase'den verileri çekerken kullanılır)
    }
    private String key;
    private String yemekAdi;
    private String kalori;

    public Yemekler(String key, String yemekAdi, String kalori) {
        this.key = key;
        this.yemekAdi = yemekAdi;
        this.kalori = kalori;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getYemekAdi() {
        return yemekAdi;
    }

    public void setYemekAdi(String yemekAdi) {
        this.yemekAdi = yemekAdi;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }
}
