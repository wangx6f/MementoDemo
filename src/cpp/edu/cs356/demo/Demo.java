package cpp.edu.cs356.demo;
import java.awt.Color;
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

	private JFrame frame;
    private JLabel textDisplay;
    
    private DefaultListModel<String> model;
    private JList list;
    
    private JLabel curLabel;
    private JButton btnNewButton;
    private JButton btnSaveState;

    private String selectedMemento;
    
    public Demo()
    {
    	initalize();
    }

    @SuppressWarnings("unchecked")
	private void initalize()
    {
    	frame = new JFrame();
		frame.setTitle("MementoDemo");
		frame.setResizable(false);
		frame.setBounds(200, 200, 615, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		curLabel = new JLabel("Current Display: ");
		curLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		curLabel.setBounds(20, 12, 158, 42);
		frame.getContentPane().add(curLabel);
		
		textDisplay = new JLabel("textDisplay");
		textDisplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDisplay.setBounds(188, 12, 158, 42);
		frame.getContentPane().add(textDisplay);
		
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
                selectedMemento = list.getSelectedValue().toString();
            }
        });
		
		list.setBounds(20, 111, 571, 450);
		frame.getContentPane().add(list);
		
		btnNewButton = new JButton("Randomize State");
		btnNewButton.setBounds(20, 65, 273, 30);
		frame.getContentPane().add(btnNewButton);
		
		btnSaveState = new JButton("Save State");
		btnSaveState.setBounds(318, 65, 273, 30);
		frame.getContentPane().add(btnSaveState);
    }


    private void sync() {
    	textDisplay.setText("Color: " + textDisplay.getForeground() + " Size: "+textDisplay.getSize());
    }

    private void randomize(){
        int color = new Random().nextInt(4);
        int size = new Random().nextInt(100);
        textDisplay.setFont(new Font("Tahoma", Font.BOLD, size));
        Color colorString;
        switch (color)
        {
            case 0:
                colorString = Color.BLACK;
                break;
            case 1:
                colorString = Color.RED;
                break;
            case 2:
                colorString = Color.BLUE;
                break;
            case 3:
                colorString = Color.GREEN;
                break;
            default:
                colorString = Color.YELLOW;
        }
        textDisplay.setForeground(colorString);
        sync();
    }

    private void restore() {

    }
}
