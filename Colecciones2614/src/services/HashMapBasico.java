package services;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasico {

    public static void main(String[] args) {
        Map<String, Integer> edades = new HashMap<>();

        edades.put("Ana", 20);
        edades.put("Luis", 22);
        edades.put("Marta", 19);

        System.out.println(edades.get("Luis"));
        System.out.println(edades.get("Pedro"));
        System.out.println(edades.containsKey("Ana"));
        System.out.println(edades.containsValue(19));
        System.out.println(edades.size());

        Integer anterior = edades.put("Ana", 21);
        System.out.println(anterior);

        edades.remove("Marta");

        for (String nombre : edades.keySet())
            System.out.println(nombre);
        for (int edad : edades.values())
            System.out.println(edad);
        for (Map.Entry<String, Integer> e : edades.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        edades.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
