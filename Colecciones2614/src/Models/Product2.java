package Models;

public class Product2 {

    private final int id;
    private final String name;
    private final int weight;
    
    public Product2(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product2 [id=" + id + ", name=" + name + ", weight=" + weight + "]";
    }

    
}
