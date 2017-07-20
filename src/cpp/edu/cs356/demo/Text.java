package cpp.edu.cs356.demo;

public class Text {

    private String color;

    private int size;

    public Text()
    {
        color = "black";
        size= 13;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }
}
