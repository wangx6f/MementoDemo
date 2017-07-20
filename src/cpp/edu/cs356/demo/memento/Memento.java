package cpp.edu.cs356.demo.memento;

import cpp.edu.cs356.demo.Demo;
import cpp.edu.cs356.demo.Text;

import java.awt.*;

/**
 * Created by jason on 7/19/17.
 */
public class Memento {
    private Color color;
    private int size;

    public Memento(Demo d){
        color = d.getColor();
        size = d.getSize();
    }

    public Color getColorState() {
        return color;
    }
    public int getSizeState(){ return size; }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
