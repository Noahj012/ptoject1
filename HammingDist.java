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
	
	public void readFile (String filename) throws IOException
	{
		String sCode = "";
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		br.readLine();
		br.readLine();
		br.readLine();
		
		
		filename = br.readLine();
		String[] strg = filename.split(" ");
		
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