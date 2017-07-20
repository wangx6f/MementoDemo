package cpp.edu.cs356.demo;
import cpp.edu.cs356.demo.memento.Caretaker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.Font;

import javax.swing.JButton;

public class Demo {

    private Demo demo;

	private JFrame frame;
    private JLabel textDisplay;
    
    private DefaultListModel<String> model;
    private JList list;
    
    private JLabel curLabel;
    private JButton btnNewButton;
    private JButton btnSaveState;

    private String selectedListObject;

    private Caretaker caretaker;

    // State Fields
    private Color color;
    private int size;
    
    public Demo(Caretaker c) {
        demo = this;
    	caretaker = c;
        initalize();
    }

    @SuppressWarnings("unchecked")
	private void initalize() {

		generateFrame();
		generateTextComponents();
		generateList();
        renderObjects();
    }

    /*
    private void sync() {
    	textDisplay.setText("Color: " + textDisplay.getForeground() + " Size: "+textDisplay.getSize());
    }
    */

    private void randomize(){
        int colorint = new Random().nextInt(4);
        size = new Random().nextInt(100);
        textDisplay.setFont(new Font("Tahoma", Font.BOLD, size));
        switch (colorint) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.BLUE;
                break;
            case 3:
                color = Color.GREEN;
                break;
            default:
                color = Color.YELLOW;
        }
        textDisplay.setForeground(color);
        //sync();
    }

    private void restore() {

    }

    private void generateFrame(){
        frame = new JFrame();
        frame.setTitle("MementoDemo");
        frame.setResizable(false);
        frame.setBounds(200, 200, 615, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
    }

    private void generateTextComponents(){
        curLabel = new JLabel("Current Display: ");
        curLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        curLabel.setBounds(20, 12, 158, 42);
        frame.getContentPane().add(curLabel);

        textDisplay = new JLabel("textDisplay");
        textDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textDisplay.setBounds(188, 12, 158, 42);
        frame.getContentPane().add(textDisplay);
    }

    private void generateList(){
        model = new DefaultListModel<String>();
        list = new JList(model);
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });

        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                selectedListObject = (String)list.getSelectedValue();
            }
        });
    }

    private void renderObjects(){

        list.setBounds(20, 111, 571, 450);
        frame.getContentPane().add(list);

        btnNewButton = new JButton("Randomize State");
        btnNewButton.setBounds(20, 65, 273, 30);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomize();
            }
        });


        frame.getContentPane().add(btnNewButton);

        btnSaveState = new JButton("Save State");
        btnSaveState.setBounds(318, 65, 273, 30);
        btnSaveState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currTime = "" + System.currentTimeMillis();
                model.addElement(currTime);
                caretaker.addMemento(currTime, demo);
            }
        });

        frame.getContentPane().add(btnSaveState);
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
