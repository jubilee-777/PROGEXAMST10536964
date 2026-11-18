/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesapp;

/**
 *
 * @author Student
 */
import java.util.Scanner;


public class ProductSalesApp {

   public static void main(String[] args) {
    String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    int[][] sales = new int[3][3];
    Scanner in = new Scanner(System.in);
    
    for (int p =0; p < names.length; p++){
        for (int m = 0; m < 3; m++){
            System.out.print("Enter number of sales for month" + (m+1));
            + "for" + names[p] + "mattress:");
            sales[p][m] = in.nextInt();
        }
        System.out.printIn();
    }
    
    PrintProduct printer = new PrintProduct(newProduct(names,sales));
    System.out.printIn("\nPRODUCT SALES REPORT - 2026 /n");
    System.out.printIn("*".repeat(40));
    printer.printTotalProductSales();
    printer.printAverageProductSales();
    printer.printMostPopularProduct();
        }
    }