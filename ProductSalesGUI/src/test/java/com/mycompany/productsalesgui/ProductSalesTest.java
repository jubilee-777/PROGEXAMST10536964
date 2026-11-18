/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesgui;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Unit tests for the ProductSales class
public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        // Arrange: create the object we are testing
        ProductSales productSales = new ProductSales();

        // Act: call the method
        int result = productSales.GetSalesOverLimit();

        // Assert: 700 and 600 are over 500, so we expect 2
        assertEquals(2, result);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales productSales = new ProductSales();

        int result = productSales.GetSalesUnderLimit();

        // 300, 150, 250 and 200 are under 500, so we expect 4
        assertEquals(4, result);
    }
}