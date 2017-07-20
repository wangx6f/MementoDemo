package cpp.edu.cs356.demo;
import cpp.edu.cs356.demo.memento.Caretaker;
import cpp.edu.cs356.demo.memento.Memento;

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
    @SuppressWarnings("rawtypes")
	private JList list;
    
    private JLabel curLabel;
    private JButton btnNewButton;
    private JButton btnSaveState;
    private JButton btnLoadState;

    private String selectedListObject;

    private Caretaker caretaker;
    
    private static final Color[] COLORLIST = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    
    // State Fields
    private Color color;
    private int size;
    private int counter;
    private String displayText;
    
    
    public Demo(Caretaker c) {
        demo = this;
    	caretaker = c;
        initalize();
        color = Color.black;
        size = 12;
        counter = 0;
        displayText = "textDisplay";
        setTextDisplay();
    }

	private void initalize() {

		generateFrame();
		generateTextComponents();
		generateList();
        renderObjects();
    }

	//Randomize a new State for textDisplay.
    private void randomize(){
        size = new Random().nextInt(37);
        color = COLORLIST[new Random().nextInt(COLORLIST.length - 1)];
        displayText = "Randomized State " + counter;
        setTextDisplay();
        counter++;
    }
    
    //Restore a state from Memento using HashTable
    private void restore() {
        Memento tempento = caretaker.getMomento(selectedListObject);
        color = tempento.getColorState();
        size = tempento.getSizeState();
        displayText = "Saved State";
        setTextDisplay();
    }

    private void setTextDisplay(){
        textDisplay.setFont(new Font("Tahoma", Font.BOLD, size));
        textDisplay.setText(displayText);
        textDisplay.setForeground(color);
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
        textDisplay.setBounds(188, 12, 403, 42);
        frame.getContentPane().add(textDisplay);
    }

    @SuppressWarnings({ "unchecked", "rawtypes", "serial" })
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

        list.setBounds(20, 145, 571, 416);
        frame.getContentPane().add(list);

        btnNewButton = new JButton("Randomize State");
        btnNewButton.setBounds(20, 104, 571, 30);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomize();
            }
        });


        frame.getContentPane().add(btnNewButton);

        btnSaveState = new JButton("Save State");
        btnSaveState.setBounds(20, 63, 273, 30);
        btnSaveState.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			@Override
            public void actionPerformed(ActionEvent e) {
                String currTime = "" + System.currentTimeMillis();
                model.addElement(currTime);
                list.setModel(model);
                caretaker.addMemento(currTime, demo);
            }
        });

        frame.getContentPane().add(btnSaveState);
        
        btnLoadState = new JButton("Load State");
        btnLoadState.setBounds(318, 63, 273, 30);
        frame.getContentPane().add(btnLoadState);
        btnLoadState.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (selectedListObject != null) {
            		restore();
            	}
            }
        });

    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}
