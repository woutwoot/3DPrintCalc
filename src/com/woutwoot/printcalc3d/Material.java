package com.woutwoot.printcalc3d;

/**
 * Created by WoutP on 9/12/2015.
 */
public class Material {

    private String name;
    private double density; //In mm^3

    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return name;
    }
}
