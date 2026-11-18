package com.mycompany.productsalesgui;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
// Holds the sales data and calculates the report values
public class ProductSales implements IProductSales {

    // The sales limit used to judge a product's success
    private static final int SALES_LIMIT = 500;

    // Rows = years, columns = Microphone, Speakers, Mixing Desk
    private final int[][] productSales = {
        {300, 150, 700},   // Year 1
        {250, 200, 600}    // Year 2
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    // Adds up every number
    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    // Counts how many sales are above the limit
    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale > SALES_LIMIT) {
                    count++;   // same as count = count + 1
                }
            }
        }
        return count;
    }

    // Counts how many sales are below the limit
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] row : productSales) {
            for (int sale : row) {
                if (sale < SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    // Each row is one year, so the number of rows = years processed
    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }

    // Total divided by how many numbers there are
    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int[] row : productSales) {
            count += row.length;
        }
        return (double) GetTotalSales() / count;
    }
}