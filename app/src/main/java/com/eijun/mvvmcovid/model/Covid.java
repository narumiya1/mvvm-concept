package com.eijun.mvvmcovid.model;

import com.google.gson.annotations.SerializedName;

public class Covid {
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }


    public static class Attributes {
        private int fID;
        @SerializedName("Kode_Provi")
        private int kodeProvi;
        @SerializedName("Kasus_Meni")
        private int kasusMeni;
        @SerializedName("Kasus_Posi")
        private String positif;
        @SerializedName("Provinsi")
        private String provinsi;
        @SerializedName("Kasus_Semb")
        private int kasusSemb;

        public void setFID(int fID) {
            this.fID = fID;
        }

        public int getFID() {
            return fID;
        }

        public void setKodeProvi(int kodeProvi) {
            this.kodeProvi = kodeProvi;
        }

        public int getKodeProvi() {
            return kodeProvi;
        }

        public void setKasusMeni(int kasusMeni) {
            this.kasusMeni = kasusMeni;
        }

        public int getKasusMeni() {
            return kasusMeni;
        }

        public void setKasusPosi(String positif) {
            this.positif = positif;
        }

        public String getKasusPosi() {
            return positif;
        }

        public void setProvinsi(String provinsi) {
            this.provinsi = provinsi;
        }

        public String getProvinsi() {
            return provinsi;
        }

        public void setKasusSemb(int kasusSemb) {
            this.kasusSemb = kasusSemb;
        }

        public int getKasusSemb() {
            return kasusSemb;
        }
    }
}
