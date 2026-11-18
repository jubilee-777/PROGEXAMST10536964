/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;

/**
 *
 * @author Student
 */
 // Calculates sales statistics for a 2D array of sales figures
public class Product implements IProduct {
    
    public Product(String[]names, int[][] sales){
        this.names = names;
        this.sales = sales;
    }
    }

    // Adds up every number
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] row : sales) {      
            for (int s : row) total += s; {
        return total;                         // handing the answer back
    }

    // Total divided by how many numbers there are
    @Override
    public double GetAverageProductSold() {
        int count = sales.length * sales [0].length;
        return (double) GetTotalProductsSold() / count; // reuse TotalSales
    }

    // Finds the most popular product
    @Override
    public String GetMostPopularProduct() {
        int best = 0, bestTotal = -1;
        for (int i = 0; i < sales.length; i++) {
            int t = 0;
            for (int s : sales[i])t;best = i; }
        }
    return names [best] + "("+ bestTotal +")";
        }
    }
        