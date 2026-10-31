package services;

import java.util.Arrays;

import Models.Product;

public class TheArrayProblem {

    public static void main(String[] args) {
        Product door=new Product("Wooden Door", 35);
        Product floorPanel=new Product("Floor Panel", 25);

        Product[] products={door,floorPanel};

        System.out.println(Arrays.toString(products));

        Product window=new Product("Glass Window", 10);
        products=add(window, products);
        System.out.println(Arrays.toString(products));


    }

    private static Product[] add(Product product,Product[] array){
        int length = array.length;
        Product[] newArray=Arrays.copyOf(array, length+1);
        newArray[length]=product;
        return newArray;
    }
}
