package streamingUtil;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class ClientHandler extends Thread  {

	private Socket conn;
	private DataInputStream in;
	private String pathMusic;
	
	public ClientHandler(Socket conn)throws IOException {
		this.conn= conn;
		in=new DataInputStream(conn.getInputStream());
	}

	public void run() {
		try
		{
			this.pathMusic = in.readUTF();
			sendSong(pathMusic);
		}
		catch(Exception e )
		{
			System.out.println("Erro na Thread do Server");
			e.printStackTrace();
		}
	}
	
	//Metodo para o envio da musica
	public void sendSong(String pathMusic)	
	{
		try
		{
			//Send welcome message to client
			System.out.println("Welcome to the Server"); 
			//Preciso colocar a musica a ser tocadas
			File mp3File = new File(pathMusic);
			FileInputStream fileIn = new FileInputStream(mp3File);
			//Cria o o array de bytes
			byte [] buffer = new byte[(int)mp3File.length()];
			BufferedInputStream bis = new BufferedInputStream(fileIn);
			bis.read(buffer,0,buffer.length); 
			OutputStream os = conn.getOutputStream();
			os.write(buffer, 0, buffer.length);
			os.flush();
			os.close();
			bis.close();
			//client disconnected, so close socket
			conn.close();
		}
		catch(IOException e) {
			System.out.println("Conexão com o cliente fechada.");
		}
	}
	
	
	
}
