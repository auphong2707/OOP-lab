 package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame{
	
	static String TITLE = "";
	static int WIDTH, HEIGHT;
	
	Store store;
	
	public AddItemToStoreScreen(Store store) {
		super();
		
		this.store = store;
		
		JPanel topPanel = buildTop();
		JPanel centerPanel = buildCenter();
		JPanel bottomPanel = buildBottom();
		
		setLayout(new BorderLayout());
		
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setVisible(true);
	}
	
	private JPanel buildTop() {
		JPanel panel = new JPanel();
		
		JLabel label = new JLabel(TITLE);
		panel.add(label);
		
		return panel;
	}
	
	abstract JPanel buildCenter();
	
	private JPanel buildBottom() {
		JPanel panel = new JPanel();
		
		JButton button = new JButton();
		button.setText("Add Media");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputMedia() != null) {
					store.addMedia(inputMedia());
					dispose();
				}
			}
		});
		
		panel.add(button);
		
		return panel;
	}
	
	abstract Media inputMedia();
	
	JPanel inputField(String labelText) {
		JPanel inputPanel = new JPanel(new BorderLayout());
		
		JLabel label = new JLabel(labelText + ": ");
	    JTextField textField = new JTextField(35);

	    
	    inputPanel.add(label, BorderLayout.WEST);
        inputPanel.add(textField, BorderLayout.EAST);
        
        return inputPanel;
	}
	
	String getContentFromPanel(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                return ((JTextField) component).getText();
            }
        }
        return null;
    }

}
