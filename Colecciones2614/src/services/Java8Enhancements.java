package services;

import java.util.HashMap;
import java.util.Map;

import Models.Product;
import Models.Product2;

public class Java8Enhancements {

    public static void main(String[] args) {
        final Map<Integer, Product2> idToProduct = new HashMap<>();
        Product2 defaultProduct = new Product2(-1, "Producto no existe", 0);

        Product2 door = new Product2(1,"Wooden Door", 35);
        Product2 floorPanel = new Product2(2,"Floor Panel", 25);
        Product2 window = new Product2(3,"Glass Window", 10);

        idToProduct.put(10, door);
        idToProduct.put(20, floorPanel);
        idToProduct.put(30, window);

        Product2 result = idToProduct.getOrDefault(50, defaultProduct);
        System.out.println(result);

        result = idToProduct.replace(10, new Product2(1, "Big Door", 50));
        System.out.println(result);
        System.out.println(idToProduct.get(10));
        System.out.println();

    }
}
