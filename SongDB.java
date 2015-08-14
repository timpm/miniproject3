import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class SongDB 
{
	public static void main(String[] args)
	{
		File f = null;
		Scanner input= new Scanner(System.in);
		if(args.length==0)
		{
			System.out.println("No File to read");
		}
		if (!new File(args[0]).exists())
		{
			System.out.println("File does not exist, would you like to create it and start with an empty database? Y or N");
			String in=input.next();
			if (in.equalsIgnoreCase("y"))
			{//creates a new file based on the original input string if needed
				 f = new File(args[0]);
				 try
				 {
					 f.createNewFile();
				 } 
				 catch (IOException e)
				 {
					 System.out.println("Error: "+e);
				 }
				 
			}
			else 
			{
				System.out.println("This program needs a working file. Exiting");
				System.exit(0);
			}
			
		
		}
		else
		{
			f= new File (args[0]);
		}
		
	//mainprogram
	try (Scanner br = new Scanner(f))
	{
		
		ArrayList<Song> mysongs= new ArrayList<Song>();
		String line;
		while (br.hasNextLine())
		{
			line=br.nextLine();
			String lineray[]=line.split(";");
			Song newsong= new Song(lineray[0], lineray[1],lineray[2], lineray[3],lineray[4],Double.parseDouble(lineray[5]));
			mysongs.add(newsong);
		}
		DBManager winamp = new DBManager(mysongs, args[0]);
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	}
		
		
	}
	
	
}
