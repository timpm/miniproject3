import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class MusicPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JComboBox songDropdown;
	public JButton addButton, editButton, acceptButton, 
					cancelButton, exitButton,deleteButton;
	
	public JTextField itemCodeTextField, desTextField,
						artistTextField, albumTextField,
						priceTextField;
						
	private JLabel itemcodeLabel, desLabel, artistLabel, 
					albumLabel, priceLabel, songLabel;
	public ArrayList<Song> songList;
	public DBManager db;
	public MusicPanel(DBManager d) 
	{
		// Create buttons
		addButton = new JButton( "Add" );
		editButton = new JButton( "Edit" );
		deleteButton = new JButton( "Delete" );
		acceptButton = new JButton("Accept");
		cancelButton = new JButton("Cancel");
		exitButton = new JButton ("Exit");
		acceptButton.setEnabled(false);
		cancelButton.setEnabled(false);
		db=d;
		songList=d.mysongs;
		
		//Create label 
		itemcodeLabel = new JLabel("Item Code:");
		desLabel = new JLabel("Description:");
		artistLabel = new JLabel("Artist:");
		albumLabel = new JLabel("Album:");
		priceLabel = new JLabel("Price:");
		songLabel= new JLabel("Select Song:");
		
		//Create combo box
		songDropdown = new JComboBox();
		for (Song s:songList)
		{
			songDropdown.addItem(s.getName());
		}
		
		//Create text field
		itemCodeTextField= new JTextField(20);
		itemCodeTextField.setEditable(false);
		desTextField = new JTextField(20);
		desTextField.setEditable(false);
		artistTextField = new JTextField(20);
		artistTextField.setEditable(false);
		albumTextField = new JTextField(20);
		albumTextField.setEditable(false);
		priceTextField = new JTextField(20);
		priceTextField.setEditable(false);
		
		//default value of combobox is the first song in the list
		Song defval= songList.get(0);
		songDropdown.setSelectedItem(defval.getName());
		//set the default values of the combobox
		artistTextField.setText(defval.getArtist());
		albumTextField.setText(defval.getAlbum());
		itemCodeTextField.setText(defval.getItemcode());
		desTextField.setText(defval.getDescription());
		priceTextField.setText(Double.toString(defval.getPrice()));
		addButton.setEnabled(true);
		acceptButton.setEnabled(false);
		cancelButton.setEnabled(false);
		editButton.setEnabled(true);
		deleteButton.setEnabled(true);
		artistTextField.setEditable(false);
		albumTextField.setEditable(false);
		desTextField.setEditable(false);
		itemCodeTextField.setEditable(false);
		priceTextField.setEditable(false);
		songDropdown.setEditable(false);
		
		//Register buttons
		ActionListener musicListener= new MusicListener(this);
		songDropdown.addActionListener(musicListener);
		addButton.addActionListener(musicListener);
		acceptButton.addActionListener(musicListener);
		editButton.addActionListener(musicListener);
		cancelButton.addActionListener(musicListener);
		deleteButton.addActionListener(musicListener);
		exitButton.addActionListener(musicListener);
		
		// Create a button group & add buttons
		ButtonGroup buttonsGroup = new ButtonGroup();
		buttonsGroup.add(addButton);
		buttonsGroup.add(editButton);
		buttonsGroup.add(deleteButton);
		buttonsGroup.add(acceptButton);
		buttonsGroup.add(cancelButton);
		buttonsGroup.add(exitButton);
		
		
		// Create a button border
		Border buttonBorder = BorderFactory.createEtchedBorder();
		buttonBorder = BorderFactory.createTitledBorder( buttonBorder);
		// Create a button panel & add buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout( new FlowLayout( FlowLayout.CENTER ) );
		buttonPanel.add( addButton );
		buttonPanel.add( editButton );
		buttonPanel.add( deleteButton );
		buttonPanel.add(acceptButton);
		buttonPanel.add(cancelButton);
		buttonPanel.add(exitButton);
		buttonPanel.setBorder( buttonBorder );
	
		JPanel attributePanel = new JPanel();
		
		attributePanel.setLayout(new GridLayout(6,4,0,0));
		
		songLabel.setAlignmentX(CENTER_ALIGNMENT);
		attributePanel.add(songLabel);
		attributePanel.add(songDropdown);
		attributePanel.add(artistLabel); 
		attributePanel.add(artistTextField);
		attributePanel.add(albumLabel);
		attributePanel.add(albumTextField);
		attributePanel.add(desLabel);
		attributePanel.add(desTextField);
		attributePanel.add(itemcodeLabel);
		attributePanel.add(itemCodeTextField);
		attributePanel.add(priceLabel);
		attributePanel.add(priceTextField);
		
		// Add panels to main panel
		this.setLayout( new FlowLayout(FlowLayout.CENTER) );
	//	this.add(comboPane);
		this.add( attributePanel);
		this.add( buttonPanel);
		
		
	}

}