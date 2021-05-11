import java.io.Serializable;

public class Alpaca implements Serializable {
    private String name;
    private boolean edible;

    public Alpaca(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "Alpaca{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
