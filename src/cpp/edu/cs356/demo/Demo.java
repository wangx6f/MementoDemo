package cpp.edu.cs356.demo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Demo extends JFrame {

    JLabel textLabel;

    Text text;

    public static void main(String[] args)
    {
        Demo demo = new Demo();
        demo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public Demo()
    {
        init();
        setSize(400,100);
        setVisible(true);

    }

    private void init()
    {
        LayoutManager root = new FlowLayout();
        Container pane = getContentPane();
        pane.setLayout(root);
        textLabel = new JLabel("some text");
        text = new Text();
        sync();
        JButton change = new JButton("Make Change");
        change.addActionListener(e -> change());
        JButton undo = new JButton("Undo");
        undo.addActionListener(e -> {undo();});
        pane.add(textLabel);
        pane.add(change);
        pane.add(undo);

    }


    private void sync() {

        textLabel.setText("Color: "+text.getColor()+" Size: "+text.getSize());
    }

    private void change(){
        int color = new Random().nextInt(4);
        int size = new Random().nextInt(100);
        text.setSize(size);
        String colorString;
        switch (color)
        {
            case 0:
                colorString = "Black";
                break;
            case 1:
                colorString = "Red";
                break;
            case 2:
                colorString = "Blue";
                break;
            case 3:
                colorString ="Green";
                break;
            default:
                colorString ="Yellow";
        }
        text.setColor(colorString);
        sync();
    }

    private void undo() {

    }
}
