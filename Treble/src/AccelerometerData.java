import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AccelerometerData {


	public static String filename;
	public static ArrayList<String> dataList = new ArrayList<String>();
	public static String user;
	public static String rdata;
	public static String[] timeStamp;
	public static String userId;
	public static String dataX;
	public static String dataY;
	public static String dataZ;
	public static String time;
	public static String lol = null;
	
	
	public AccelerometerData() {
		this.filename = "accelerometer.txt";
	}
	
	public static void getData() {
		fileReader(filename);
	}
	
	public static void fileReader(String filename) {
		
		try {
			FileReader in = new FileReader(filename); //create FileReader object
			BufferedReader readFile = new BufferedReader(in);	
			//create BufferedReader object 'readfile' which buffers the data
    			
	
				while ((rdata = readFile.readLine()) != null) {	//read new line
					dataList.add(rdata);
					
					timeStamp = rdata.split(",");
					
					for (int i=0; i<timeStamp.length; i++){
						
						if (timeStamp[i].contains("userId")){
							user = timeStamp[i];
							lol = user.substring(11, user.length()-1);
							userId = lol;
			
						}	
						
						if (timeStamp[i].contains("dataX")){
							user = timeStamp[i];
							lol = user.substring(9,  user.length()-1);
							dataX = lol;
							
						}	
						
						if (timeStamp[i].contains("dataY")){
							user = timeStamp[i];
							lol = user.substring(9,  user.length()-1);
							dataY = lol;
							
						}
						
						if (timeStamp[i].contains("dataZ")){
							user = timeStamp[i];
							lol = user.substring(9,  user.length()-2);
							dataZ = lol;
							//System.out.println(dataZ[i]);
						}	
						
						if (timeStamp[i].contains("time")){
							user = timeStamp[i];
							lol = user.substring(7,  user.length()-1);
							time = lol;
							//System.out.println(dataZ[i]);
						}	
					}
					
    			}
		

				readFile.close();
			in.close();	
		}catch (IOException e) {		//this is the minimum catch syntax needed
			System.out.println("Problem reading file.");
    		System.err.println("IOException: " + e.getMessage());
			}
	}
	
	public static int data() {
		double dataX = dataX();
		double dataY = dataY();
		double dataZ = dataZ();
		double data = dataX + dataY + dataZ;
		if(data >= 4) {
			return 2; //High Activity
		}
		else if (data >= 1) {
			return 1;
		}
		else if(data >= 0) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public static int dataX() {
		if(Double.parseDouble(dataX) > 15) {
			return 2; //High Activity
		}
		else if(Double.parseDouble(dataX) < 15 && Double.parseDouble(dataX) > 5) {
			return 1; // Mediocre activity
		}
		else if(Double.parseDouble(dataX) < 5 && Double.parseDouble(dataX) > 0){
			return 0; // Low activity
		}
		else {
			return -1; // No activity
		}
	}
	
	public static int dataY() {
		if(Double.parseDouble(dataY) > 15) {
			return 2; //High Activity
		}
		else if(Double.parseDouble(dataY) < 15 && Double.parseDouble(dataY) > 5) {
			return 1; // Mediocre activity
		}
		else if(Double.parseDouble(dataY) < 5 && Double.parseDouble(dataY) > 0){
			return 0; // Low activity
		}
		else {
			return -1;
		}
			
	}
	
	public static int dataZ() {
		if(Double.parseDouble(dataZ) > 15) {
			return 2; //High Activity
		}
		else if((Double.parseDouble(dataZ) < 15) && (Double.parseDouble(dataZ) > 5)) {
			return 1; // Mediocre activity
		}
		else if(Double.parseDouble(dataZ) < 5 && Double.parseDouble(dataZ) > 0){
			return 0; // Low activity
		}
		else {
			return -1;
		}
			
	}

}
