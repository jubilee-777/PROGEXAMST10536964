
import com.mycompany.productsalesapp.IProduct;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class PrintProduct {
    private final IProduct product = null;
    
    public PrintProduct(IProduct Product) {
        this.product = product;}
    
    public void printTotalProductSales() {
        System.out.printIn("TOTAL PRODUCT SALES:"+ product.GetTotalProductsSold());
    }
    public void printAverageProductSales(){
        System.out.printIn("AVERAGE PRODUCT SALES:"+ Math.round(product.GetAverageProductSold()));
    }
    public void printMostPopularProduct(){
        System.out.printIn("MOST POPULAR PRODUCT:"+ product.GetMostPopularProduct());
    }
}
    