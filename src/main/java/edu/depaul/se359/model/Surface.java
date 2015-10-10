package main.java.edu.depaul.se359.model;

/**
 * Created on 10/10/15.
 * Class: Surface.java
 * Author: eric
 * Assignment: SE459
 */
public class Surface {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Surface{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

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
}
