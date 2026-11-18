/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
package productapp;

public class ProductCalculations implements IProductCalculations {
    private final double price;

    public ProductCalculations(double price) {
        this.price = price;
    }

    // VAT is 15% of the price
    @Override
    public double GetVat() {
        return price * 0.15;
    }

    // Commission is 5% of the price
    @Override
    public double GetCommission() {
        return price * 0.05;
    }

    // Total = price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}