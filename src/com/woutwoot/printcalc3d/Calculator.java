package com.woutwoot.printcalc3d;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WoutP on 9/12/2015.
 */
public class Calculator {
    public JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox<Object> comboBox1;
    private JButton calculatePriceButton;
    private JComboBox comboBox2;

    public Calculator() {
        calculatePriceButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(mainPanel, doCalc(), "Calculated price", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private String doCalc() {
        double diameter = Double.parseDouble(textField1.getText());
        double length = Double.parseDouble(textField2.getText());
        double price = Double.parseDouble(textField3.getText());
        Material m = (Material) comboBox1.getSelectedItem();
        double weight = Main.calcWeight(Main.calcArea(diameter), length, m);
        double endprice = round(Main.calcPrice(price, weight), 2);
        int printable = (int) Math.floor((Double.parseDouble(comboBox2.getSelectedItem().toString()) * 1000) / weight);
        return "This object would cost you " + endprice + "\nIt will weigh " + round(weight, 2) + " grams.\nWith 1 roll filament you could print " + printable + " of these";
    }

    private void createUIComponents() {
        List<Material> materials = new ArrayList<>();
        materials.add(new Material("PLA", 0.00125));
        materials.add(new Material("ABS", 0.00105));
        materials.add(new Material("HDPE", 0.00097));
        materials.add(new Material("PVA", 0.00119));
        comboBox1 = new JComboBox<>(materials.toArray());
    }

    public void fillInDefaults() {
        textField1.setText("1.75");
        textField2.setText("10");
        textField3.setText("40.00");
    }
}
