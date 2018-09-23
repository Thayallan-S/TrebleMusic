import java.io.IOException;
import java.net.MalformedURLException;

public class SensorData {
	
	public static double data;

	public SensorData() throws IOException {
		
		MagnetometerData timeA = new MagnetometerData();
		timeA.getData();
		int mntActivity = timeA.data();
		System.out.println(mntActivity);
	
		AccelerometerData timeB = new AccelerometerData();
		timeB.getData();
		int accActivity = timeB.data();
		System.out.println(accActivity);

		GyroscopeData timeC = new GyroscopeData();
		timeC.getData();
		int gysActivity = timeC.data();
		System.out.println(gysActivity);

		data = overallData(mntActivity, accActivity, gysActivity);
		
	}
	
	public double overallData(int mntActivity, int accActivity, int gysActivity) {
		return (0.5*mntActivity) + accActivity + gysActivity;
	}
}