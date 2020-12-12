package org.yuni.chemicalnote.model;

public class DataSaya {
    private String namaSaya, nimSaya, matkulSy, akunGithub;

    public DataSaya(String namaSaya, String nimSaya,String matkulSy,String akunGithub){
        this.namaSaya=namaSaya;
        this.matkulSy=matkulSy;
        this.nimSaya=nimSaya;
        this.akunGithub=matkulSy;
    }

    public DataSaya(){

    }

    public String getNamaSaya() {
        return namaSaya;
    }

    public void setNamaSaya(String namaSaya) {
        this.namaSaya = namaSaya;
    }

    public String getNimSaya() {
        return nimSaya;
    }

    public void setNimSaya(String nimSaya) {
        this.nimSaya = nimSaya;
    }

    public String getMatkulSy() {
        return matkulSy;
    }

    public void setMatkulSy(String matkulSy) {
        this.matkulSy = matkulSy;
    }

    public String getAkunGithub() {
        return akunGithub;
    }

    public void setAkunGithub(String akunGithub) {
        this.akunGithub =  akunGithub;
    }

}
