package org.aplas.basicappx;

public class Weight {
    private double gram;

    Weight(){
        this.gram=0;
    }
    public void setGram(double gram) {
        this.gram = gram;
    }
    public double getGram() {
        return gram;
    }
    public void setOunce(double gram) {
        this.gram = gram*28.3495231;
    }
    public double getOunce() {
        return gram/28.3495231;
    }
    public void setPound(double gram) {
        this.gram = gram*453.59237;
    }
    public double getPound() {
        return gram/453.59237;
    }

    public double convert (String oriUnit, String convUnit, double value) {
        if (oriUnit.equals("Grm")) {
            setGram(value);
        } else if (oriUnit.equals("Onc")) {
            setOunce(value);
        } else {
            setPound(value);
        }
        if (convUnit.equals("Grm")) {
            return getGram();
        } else if (convUnit.equals("Onc")) {
            return  getOunce();
        } else {
            return getPound();
        }
    }
}
