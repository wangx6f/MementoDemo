package cpp.edu.cs356.demo.memento;

import cpp.edu.cs356.demo.Demo;
import cpp.edu.cs356.demo.Text;

/**
 * Created by jason on 7/19/17.
 */
public class Memento {
    private Text textState;

    public Memento(Demo d){
        //TODO textState = d.getText();
    }

    public Text getTextState() {
        return textState;
    }

    public void setTextState(Text textState) {
        this.textState = textState;
    }
}
