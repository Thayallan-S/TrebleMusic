import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
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
	
	public Treble() {
		url = this.getClass().getClassLoader().getResource("happy.wav");
	}

	public static void main(String[] args) throws IOException {
		SensorData timeA = new SensorData();
		
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  public void run() {
				  Double track = timeA.data;
				  String song = songSelection(track);
				  System.out.println(song);
				  System.out.println(counter);
				  if(song.equals(songToPlay) && counter == 2) {
					  if(songPlaying.equals(song)) {
						  counter = 0;
					  }
					  else {
						  playSound();
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
			  }
			}, 10*1000, 10*1000);
	}

	public static void playSound() {
	    try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("happy.wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static String songSelection(Double track) {
		if(track > 5) {
			return "1";
		}
		if(track > 4) {
			return "2";
		}
		if(track > 3) {
			return "3";
		}
		if(track > 2) {
			return "4";
		}
		if(track > 1) {
			return "5";
		}
		if(track > 0) {
			return "6";
		}
		if(track > -1) {
			return "happy.wav";
		}
		if(track > -2) {
			return "8";
		}
		if(track > -3) {
			return "9";
		}
		else {
			return null;
		}
		
	}
	
	
	

}

