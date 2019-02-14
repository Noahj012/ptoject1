# Documentation.md

	My problem solving approach for this project was to break the problem 
into small and easily digestable parts that can be tackled one at a time without 
throwing errors in the other methods previously worked on. The parts that I broke
the problem into were the constructor, reading the file, calculating the hamming distance,
calculating node distance, and the toString. 

	The readFile method This loads in the Mesonet.txt file and reads it through the
BufferedReader object.After reading through the first 3 lines of the file, it stores
the fourth line in a string array to be able to extract the stations codes from the file.
The calculatingHammingDistance method compares the two stations codes intilized in the the
Hammingdist constructor and runs a loop to compare the two stations code a letter at a 
time to calculate the hammingdist. The calcuteNodeDistance method compares the 2 codes
given in the constructor to the rest of the station codes and calculates the hamming dist
and then calcs the node distance.The constructor passes in two string parameters that are 
the two stations codes, and calls the read method to get the rest of the stations codes 
from the file, then calculates the hammingDist. and lastly calls for the nodeDistances 
to be calculated.  