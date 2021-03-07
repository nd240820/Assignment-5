package kz.aitu.oop.practice.assignment5.entities;

public class Stone {

    /*
    access modifier, data types, variables
     */
    private int id;
    private String name;
    private int cost;
    private double weight;


    /*
    method for recording data
     */
    public Stone(int id, String name, int cost, double weight) {
        setId(id);
        setName(name);
        setCost(cost);
        setWeight(weight);
    }

    /*
    getters and setters for data
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
    method for outputting all data
     */
    @Override
    public String toString() {
        return "Stone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost + '\'' + "kzt" +
                ", weight=" + weight + '\'' + "carat" +
                "}\n";
    }
}
