package com.rose.fitnessapp;

public class Ogun {
    public Ogun() {
        // Boş bir yapıcı metot gereklidir (Firebase'den verileri çekerken kullanılır)
    }
    private String ogun;
    private String toplam1;
    private String yemekAdd;
    private String key;

    public Ogun(String ogun, String toplam1, String yemekAdd, String key) {
        this.ogun = ogun;
        this.toplam1 = toplam1;
        this.yemekAdd = yemekAdd;
        this.key = key;
    }

    public String getOgun() {
        return ogun;
    }

    public void setOgun(String ogun) {
        this.ogun = ogun;
    }

    public String getToplam1() {
        return toplam1;
    }

    public void setToplam1(String toplam1) {
        this.toplam1 = toplam1;
    }

    public String getYemekAdd() {
        return yemekAdd;
    }

    public void setYemekAdd(String yemekAdd) {
        this.yemekAdd = yemekAdd;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
