package org.yuni.chemicalnote.model;

public class DataUnsur {

    String namaUnsur;
    String descp;
    Integer imageUrl;

    public DataUnsur(String namaUnsur, String descp, Integer imageUrl) {
        this.namaUnsur = namaUnsur;
        this.descp = descp;
        this.imageUrl = imageUrl;
    }

    public String getNamaUnsur() {
        return namaUnsur;
    }

    public void setNamaUnsur(String namaUnsur) {
        this.namaUnsur = namaUnsur;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
