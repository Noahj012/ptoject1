import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HammingDist
{
	private ArrayList<String> stationsCodes = new ArrayList<String>();
	private int totalStations = 120;
	
	public HammingDist(String station1, String station2) throws IOException
	{
		readFile("Mesonet.txt");
	}
	
	public int calculatingDstance(String x, String y)
	{
		
		return 0;
	}
	
	/**
	 * This loads in the Mesonet.txt file and reads it through the BufferedReader object.
	 * After reading through the first 3 lines of the file =, it stores the fourth line in a string array to be able to 
	 * extract the stations codes from the file
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void readFile (String filename) throws IOException
	{
		//declars a string variable to store the stations code from the string array to be added to the arraylist
		String sCode = "";
		
		//Declares buffered reader object to read the Mesonet.txt file
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		//reads through the first 3 lines of the .txt file to skip the first 3 lines for it is uneeded info
		br.readLine();
		br.readLine();
		br.readLine();
		
		//stores the 4th line of the Mesonet.txt file into a string
		filename = br.readLine();
		
		// splits the line read into the variable and stores it into the a String array
		String[] strg = filename.split(" ");
		
		//this loops through the Mesonet.txt file and extracts the stations codes into the stationsCodes ArrayList
		while(!(filename == null))
		{
			sCode = strg[1];
			
			stationsCodes.add(sCode);
			filename = br.readLine();
			System.out.println(filename);
			if (filename != null)
			{
				strg = filename.split(" ");
			}
		}
		
	}
	
}