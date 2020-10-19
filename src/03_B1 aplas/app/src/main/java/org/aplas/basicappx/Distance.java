package org.aplas.basicappx;

public class Distance {
    private double meter;

    Distance(){
        this.meter =0;
    }
    public void setMeter(double meter){
        this.meter=meter;
    }
    public double getMeter(){
        return meter;
    }
    public void setInch(double meter){
        this.meter= meter/39.3701;
    }
    public double getInch(){
        return meter*39.3701;
    }
    public void setMile(double meter){
        this.meter = meter/0.000621371;
    }
    public double getMile(){
        return meter*0.000621371;
    }
    public void setFoot(double meter){
        this.meter = meter/3.28084;
    }
    public double getFoot(){
        return meter*3.28084;
    }

    public double convert(String oriUnit, String convUnit, double value) {
        if (oriUnit.equals("Mtr")) {
            setMeter(value);
        } else if (oriUnit.equals("Inc")) {
            setInch(value);
        } else if (oriUnit.equals("Mil")) {
            setMile(value);
        } else {
            setFoot(value);
        }
        if (convUnit.equals("Mtr")) {
            return getMeter();
        } else if (convUnit.equals("Inc")) {
            return getInch();
        } else if (convUnit.equals("Mil")) {
            return  getMile();
        } else {
            return getFoot();
        }
    }
}
