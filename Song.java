
public class Song 
{
	private String name="";
	private String artist="";
	private String album="";
	private String description="";
	private String itemcode="";
	private double price=0.00;

	Song(String name, String artist, String album, String decription, String itemcode, double price)
	{
		this.name=name;
		this.artist=artist;
		this.album=album;
		this.description=decription;
		this.itemcode=itemcode;
		this.price=price;
	}
	public String toString()
	{
		String line = name+";"+artist+";"+album+";"+description+";"+itemcode+";"+price;
		return line;
	}
	/**
	 * 
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @return
	 */
	public String getArtist()
	{
		return artist;
	}
	/**
	 * 
	 */
	public String getAlbum()
	{
		return album;
	}
	/**
	 * 
	 */
	public String getDescription()
	{
		return description;
	}
	/**
	 * 
	 */
	public String getItemcode()
	{
		return itemcode;
	}
	/**
	 * 
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * 
	 */
	public void setArtist(String args)
	{
		artist = args;
	}
	/**
	 * 
	 */
	public void setAlbum(String args)
	{
		album=args;		
	}
	/**
	 * 
	 */
	public void setDescription( String args)
	{
		description = args;
	}
	/**
	 * 
	 */
	public void setPrice( double p)
	{
		price= p;
	}
	
}
