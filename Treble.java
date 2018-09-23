import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Treble {
	
	public static int counter = 0;
	public static String songToPlay = null;
	public static URL url;
	public static String songPlaying = "";
	public static Scanner scan = new Scanner(System.in);
	public static  Clip clip;
	
	public Treble() {
		url = this.getClass().getClassLoader().getResource("happy.wav");
	}

	public static void main(String[] args) throws IOException {
		SensorData timeA = new SensorData();
		playTrack();
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				playTrack();				
			}
			  /*public void run() {
				  Double track = timeA.data;
				  String song = songSelection(track);
				  System.out.println(song);
				  System.out.println(counter);
				  if(song.equals(songToPlay) && counter == 2) {
					  if(songPlaying.equals(song)) {
						  counter = 0;
					  }
					  else {
						 
						  counter = 0;
						  songPlaying = song;
					  }
					  
				  }
				  if(song.equals(songToPlay) && counter == 1) {
					  counter++;
				  }
				  else {
					  counter++;
					  songToPlay = song;
				  }
			  }**/
			}, 30*1000, 30*1000);
	}
	
	public static void playTrack() {
		if(clip!= null) {
			clip.stop();
		}
		Double a = Double.parseDouble(scan.next());
		playSound(a);
	}

	public static void playSound(double a) {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(songSelection(a)).getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static String songSelection(Double track) {
		if(track == 5) {
			return "5";
		}
		if(track == 4) {
			return "happy.wav";
		}
		if(track == 3) {
			return "3";
		}
		if(track == 2) {
			return "2";
		}
		if(track == 1) {
			return "1";
		}
		else {
			return null;
		}
		
	}
	
	
	

}

