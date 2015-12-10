package com.woutwoot.printcalc3d;


import javax.swing.*;

/**
 * <div xmlns:cc="http://creativecommons.org/ns#" about="http://www.thingiverse.com/thing:29310/"><a rel="cc:attributionURL" property="cc:attributionName" href="http://www.thingiverse.com/delsydsoftware">delsydsoftware</a> / <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">CC BY 3.0</a></div>
 */
public class Main {

    private static Calculator mainForm;

    public static void main(String[] args) {
        System.out.println(Math.round(calcPrice(50, calcWeight(calcArea(1.75), 20, new Material("PLA", 0.00125)))));
        JFrame frame = new JFrame("3D Printing Calculator v1.0");
        mainForm = new Calculator();
        frame.setContentPane(mainForm.mainPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        mainForm.fillInDefaults();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @param diameter Filament diameter in mm
     * @return Area of the end of the filament
     */
    public static double calcArea(double diameter) {
        double radius = diameter / 2;
        return radius * radius * Math.PI;
    }

    /**
     * @param area   Area of the end of the filament
     * @param length Length filament used in m
     * @param mat    Material used for print
     * @return Weight of the total object
     */
    public static double calcWeight(double area, double length, Material mat) {
        return area * (length * 1000) * mat.getDensity();
    }

    /**
     * @param cost   Cost for a 1kg roll of filament
     * @param weight Weight of the total object
     * @return cost for this item
     */
    public static double calcPrice(double cost, double weight) {
        return (cost / 1000) * weight;
    }
}
