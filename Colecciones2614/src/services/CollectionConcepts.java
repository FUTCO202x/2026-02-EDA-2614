package services;

import java.util.*;
import Models.Product;

public class CollectionConcepts {

    public static void main(String[] args) {
        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window=new Product("Glass Window", 10);

        Collection<Product> products =new ArrayList<>();

        products.add(window);
        products.add(door);
        products.add(floorPanel);

        //System.out.println(products);

        /*for(Product product:products){
            System.out.println(product);
        }*/

        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        products.remove(floorPanel);
        System.out.println(products);

        for (Product product:products){
            if(product.getWeight()>20){
                products.remove(product);
            }
        }

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            final Product product =iterator.next();
            if(product.getWeight()>20){
                iterator.remove();
            }
        }
        System.out.println(products);

        


    }
}
