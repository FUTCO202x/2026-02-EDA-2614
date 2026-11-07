package services;

import java.util.HashMap;
import java.util.Map;

public class HashMapIntermedio {

    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();

        // System.out.println(stock.getOrDefault("lapiz", 0));

        stock.putIfAbsent("lapiz", 300);
        stock.putIfAbsent("lapiz", 999);
        System.out.println(stock.get("lapiz"));

        String texto = "java es java y java es genial";
        Map<String, Integer> frecuencia = new HashMap<>();
        for (String palabra : texto.split(" ")) {
            frecuencia.merge(palabra, 1, Integer::sum);
        }
        System.out.println(frecuencia);

        /*
         * Map<String, Integer> manual = new HashMap<>();
         * for (String palabra : texto.split(" ")) {
         * if (manual.containsKey(palabra))
         * manual.put(palabra, manual.get(palabra) + 1);
         * else
         * manual.put(palabra, 1);
         * }
         */

        frecuencia.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        Map<String, String> capitales = Map.of("Colombia", "Bogotá", "Perú", "Lima");
        capitales.put("Chile", "Santiago");

    }
}
