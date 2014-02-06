package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import play.mvc.Controller;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Streaming extends Controller{

	/*
	public static void sendFile() {
		String path = "/home/eduardo/Música/Roupa Nova - Anjo.mp3";

		try {

			File file = new File(path);

			BufferedInputStream bufferedInputStream = new BufferedInputStream( new FileInputStream( file ) );

			response.contentType = "audio/mpeg";

			byte[] stream = new byte[4 * 1024]; // what should this value be?
			int read = 0;
			while(bufferedInputStream.read(stream, 0, read) > 0){
		        response.writeChunk(stream);
			}

		}catch( FileNotFoundException fileNotFoundException ) {
			renderJSON( "" );
		} catch (IOException ioException) {
			renderJSON("");
		}
	}
	 */

	public static void sendFile() {
		
		// open the sound file as a Java input stream
	    String gongFile = "/home/eduardo/Música/Roupa Nova - Anjo.mp3";
	    InputStream in;
		try {
			in = new FileInputStream(gongFile);
			// create an audiostream from the inputstream
			AudioStream audioStream = new AudioStream(in);
			
			// play the audio clip with the audioplayer class
			AudioPlayer.player.start(audioStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/*public static void sendFile() throws Exception{

		try {


			File file = new File("/home/eduardo/Música/Roupa Nova - Anjo.mp3");
			AudioInputStream stream = AudioSystem.getAudioInputStream(new FileInputStream(file));
			//			    stream = AudioSystem.getAudioInputStream(new URL(
			//      "http://hostname/audiofile"));

			AudioFormat format = stream.getFormat();
			if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
						.getSampleRate(), format.getSampleSizeInBits() * 2, format
						.getChannels(), format.getFrameSize() * 2, format.getFrameRate(),
						true); // big endian
				stream = AudioSystem.getAudioInputStream(format, stream);
			}

			SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, stream
					.getFormat(), ((int) stream.getFrameLength() * format.getFrameSize()));
			SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(stream.getFormat());
			line.start();

			int numRead = 0;
			byte[] buf = new byte[line.getBufferSize()];
			while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
				int offset = 0;
				while (offset < numRead) {
					offset += line.write(buf, offset, numRead - offset);
				}
			}
			line.drain();
			line.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} */
	public static void getPage() {
		render();
	}
}
