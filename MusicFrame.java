import javax.swing.JFrame;
import javax.swing.JPanel;

//main method, creates the frame
public class MusicFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//public DBManager d;
	//defines the frame
	public MusicFrame(DBManager d)
	{
		setTitle( "Music Database" );
		setSize( 475, 230 );
		setResizable(false);
		//this.d=d;
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		JPanel panel = new MusicPanel(d);
		this.add( panel );
		
	}


}
