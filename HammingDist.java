import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDist
{
	private ArrayList<String> stationsCodes = new ArrayList<String>();
	private int[] node1 = new int[4];
	private int[] node2 = new int[4];
	private String code1 = "";
	private String code2 = "";
	private int hammDist = 0;

	/**
	 * passes in two string parameters that are the two stations codes, and calls the read method to get the rest of 
	 * the stations codes from the file, then calculates the hammingDist. and lastly calls for the niodeDistances to be calculated. 
	 * @param station1
	 * @param station2
	 * @throws IOException
	 */
	public HammingDist(String station1, String station2) throws IOException
	{
		readFile("Mesonet.txt");
		hammDist = calculatingHammingDstance(station1, station2);
		calculateNode(station1, station2);

		code1 = station1;
		code2 = station2;
	}

	/**
	 * compares the two stations codes intilized in the the Hammingdist constructor
	 * and runs a loop to compare the two stations code a letter at a time to calculate the hammingdist
	 * @param x
	 * @param y
	 * @return
	 */
	public int calculatingHammingDstance(String x, String y)
	{
		// keeps trakc of the different letters in the two stations code
		int diffCount = 0;

		//loops through the two given string codes letter by letter and incraments tje differences between them
		for (int i = 0; i < 4; ++i)
		{
			if (x.charAt(i) != y.charAt(i))
			{
				++diffCount;
			}
		}

		return diffCount;
	}

	/**
	 * This methods compares the 2 codes given in the constructor to the rest of the station codes and calculates the hamming dist
	 * and then calcs the node distance 
	 * 
	 * @param station1
	 * @param station2
	 */
	public void calculateNode(String station1, String station2)
	{
		// declares two variables to keep track of the hamming distances of the stations code
		int diffCount1 = 0;
		int diffCount2 = 0;

		//loops through the remaining 119 station codes
		for (int j = 0; j < stationsCodes.size(); ++j)
		{
			// this compares the current station code to the inputed stations codes from the constructor to calculate the hamming dist
			diffCount1 = calculatingHammingDstance(station1,stationsCodes.get(j));
			diffCount2 = calculatingHammingDstance(station2, stationsCodes.get(j));

			// a layered if else statement to incrament the correct array index to keep track of the node distances
			if (diffCount1 == 1)
			{
				++node1[0];

			}
			if (diffCount1 == 2)
			{
				++node1[1];
			}
			if (diffCount1 == 3)
			{
				++node1[2];
			}
			if (diffCount1 == 4)
			{
				++node1[3];
			}

			if (diffCount2 == 1)
			{
				++node2[0];
			}
			if (diffCount2 == 2)
			{
				++node2[1];
			}
			if (diffCount2 == 3)
			{
				++node2[2];
			}
			if (diffCount2 == 4)
			{
				++node2[3];
			}

			diffCount1 = 0;
			diffCount2 = 0;
		}

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
		//Declars a string variable to store the stations code from the string array to be added to the arraylist
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

			if (filename != null)
			{
				strg = filename.split(" ");
			}
		}
		
	}

	/**
	 * The Hamming Distance of NRMN and NOWA: 3.
		Out of 119, for NRMN, number of nodes are: 0, 0, 23, 96 and
		for NOWA, number of nodes are: 0, 5, 16, 98 respectively.
	 */
	public String toString()
	{
		//formats the output of the toString method to be as specified
		return String.format("The Hamming Distance of %s and %s: %s.\nOut of 119, for %s, number of "
				+ "nodes are: %s, %s, %s, %s and\nfor %s, number of nodes are: %s, %s, %s, %s respectively."
				, code1,code2,hammDist,code1,node1[0],node1[1],node1[2],node1[3],code2,node2[0],node2[1],node2[2],node2[3] );
	}

}