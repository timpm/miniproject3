import javax.swing.*;
import java.awt.event.*;




public class MusicListener implements ActionListener 
{
	private MusicPanel panel;
	
	/**
	 * 
	 * @param p- musicPanel to be manipulated
	 */
	MusicListener(MusicPanel p) 
	{
		panel=p;
	}
	/**
	 * method to call the default view of the panel
	 */
	public void viewDefault()
	{
		if( panel.songDropdown.getItemCount()==0)
		{
			panel.addButton.setEnabled(true);
			panel.acceptButton.setEnabled(false);
			panel.cancelButton.setEnabled(false);
			panel.editButton.setEnabled(true);
			panel.deleteButton.setEnabled(true);
			panel.artistTextField.setEditable(false);
			panel.albumTextField.setEditable(false);
			panel.desTextField.setEditable(false);
			panel.itemCodeTextField.setEditable(false);
			panel.priceTextField.setEditable(false);
			panel.songDropdown.setEditable(false);
			panel.songDropdown.setEnabled(true);
			panel.artistTextField.setText("");
			panel.albumTextField.setText("");
			panel.desTextField.setText("");
			panel.itemCodeTextField.setText("");
			panel.priceTextField.setText("");
			panel.songDropdown.setSelectedIndex(-1);

		}
		else
		{
			Song defval= panel.songList.get(0);
			panel.songDropdown.setSelectedItem(defval.getName());
			//set the default values of the combobox
			panel.artistTextField.setText(defval.getArtist());
			panel.albumTextField.setText(defval.getAlbum());
			panel.itemCodeTextField.setText(defval.getItemcode());
			panel.desTextField.setText(defval.getDescription());
			panel.priceTextField.setText(Double.toString(defval.getPrice()));
			panel.addButton.setEnabled(true);
			panel.acceptButton.setEnabled(false);
			panel.cancelButton.setEnabled(false);
			panel.editButton.setEnabled(true);
			panel.deleteButton.setEnabled(true);
			panel.artistTextField.setEditable(false);
			panel.albumTextField.setEditable(false);
			panel.desTextField.setEditable(false);
			panel.itemCodeTextField.setEditable(false);
			panel.priceTextField.setEditable(false);
			panel.songDropdown.setEditable(false);
			panel.songDropdown.setEnabled(true);
		}
		
	}
	/**
	 * 
	 */

	
	public void actionPerformed( ActionEvent e) 
	{
		
		try
		{
			Object source = e.getSource();
			if (source ==panel.songDropdown)
			{
				int index = panel.songDropdown.getSelectedIndex();
				Song selection =panel.songList.get(index);

				panel.artistTextField.setText(selection.getArtist());
				panel.albumTextField.setText(selection.getAlbum());
				panel.desTextField.setText(selection.getDescription());
				panel.itemCodeTextField.setText(selection.getItemcode());
				panel.priceTextField.setText(Double.toString(selection.getPrice()));
			}
			
			if ( source == panel.addButton )
			{
				panel.acceptButton.setEnabled(true);
				panel.cancelButton.setEnabled(true);
				panel.editButton.setEnabled(false);
				panel.deleteButton.setEnabled(false);
				panel.artistTextField.setEditable(true);
				panel.artistTextField.setText("");
				panel.albumTextField.setEditable(true);
				panel.albumTextField.setText("");
				panel.desTextField.setEditable(true);
				panel.desTextField.setText("");
				panel.itemCodeTextField.setEditable(true);
				panel.itemCodeTextField.setText("");
				panel.priceTextField.setEditable(true);
				panel.priceTextField.setText("");
				panel.songDropdown.setEditable(true);
				panel.songDropdown.setSelectedIndex(-1);
				
			}
			if( source ==panel.editButton)
			{
				panel.acceptButton.setEnabled(true);
				panel.cancelButton.setEnabled(true);
				panel.deleteButton.setEnabled(false);
				panel.addButton.setEnabled(false);
				panel.artistTextField.setEditable(true);
				panel.albumTextField.setEditable(true);
				panel.desTextField.setEditable(true);
				panel.priceTextField.setEditable(true);
				panel.songDropdown.setEnabled(false);
				
				
			}
			if (source == panel.acceptButton)
			{
				try
				{	
					String txtinput= (String)panel.songDropdown.getEditor().getItem();
					//if song is a single
					if(panel.albumTextField.getText().equalsIgnoreCase("single"))
					{
						panel.albumTextField.setText("None");
					}
					//fields are empty
					
					if(panel.artistTextField.getText().isEmpty()||panel.desTextField.getText().isEmpty()||txtinput.isEmpty()||panel.albumTextField.getText().isEmpty()
							||panel.itemCodeTextField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Fields cannot be empty");
					}
					else
					{
						//accept for adding content
						if (panel.addButton.isEnabled()&&!panel.editButton.isEnabled())
						{
							//String txtinput= (String)panel.songDropdown.getEditor().getItem();
							Song newsong = new Song(txtinput,panel.artistTextField.getText(), panel.albumTextField.getText(),
									panel.desTextField.getText(), panel.itemCodeTextField.getText(),Double.parseDouble(panel.priceTextField.getText()));
							panel.songList.add(newsong);
							panel.songDropdown.addItem(newsong.getName());
							viewDefault();
							
							
						}
						//accept case for editing conent
						if(panel.editButton.isEnabled()&&!panel.addButton.isEnabled())
						{
							int index = panel.songDropdown.getSelectedIndex();
							Song selection =panel.songList.get(index);
							selection.setArtist(panel.artistTextField.getText());
							selection.setAlbum(panel.albumTextField.getText());
							selection.setDescription(panel.desTextField.getText());
							selection.setPrice(Double.parseDouble(panel.priceTextField.getText()));
							viewDefault();
							
						}
					}
				}
				catch (NumberFormatException n)
				{
					JOptionPane.showMessageDialog(null, "Price must be numeric value ");
				}
			}
			if (source == panel.cancelButton)
			{
				viewDefault();
			}
			if (source== panel.deleteButton)
			{
				panel.songList.remove(panel.songDropdown.getSelectedIndex());
				panel.songDropdown.removeItemAt(panel.songDropdown.getSelectedIndex());
				viewDefault();
				
			}
			if(source ==panel.exitButton)
			{
				panel.db.exitDB();
				System.exit(0);
			}
		}
		catch(IndexOutOfBoundsException s)
		{
			
		}
		
	}
}
