package jain.tarun.Retailer;

/**
 * Created by atul on 2/4/17.
 */

public class Product {

    public String product;
    public String quantity;
    public String unit;
    public String Rate;


    public Product(String product,String quantity,String Rate,String unit)
    {

        this.product=product;
        this.quantity=quantity;
        this.unit=unit;
        this.Rate=Rate;

    }
}
