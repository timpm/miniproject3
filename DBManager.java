import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;


public class DBManager
{
	public ArrayList<Song> mysongs;
	private String filename;
	/**
	 * 
	 * @param mysongs
	 */
	public DBManager(ArrayList<Song> mysongs, String args)
	{
		this.mysongs=mysongs;
		JFrame frame = new MusicFrame(this);
		frame.setVisible(true);
		filename=args;
		
		
	}
	
	public void exitDB()
	{
		try 
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for (Song s:mysongs)
			{
				bw.write(s.toString());
				bw.newLine();
			}
			bw.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
