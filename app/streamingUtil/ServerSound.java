package streamingUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSound 
{
	public static void execute( String musicPath )
	{
		ServerSocket socket = null;
		try
		{
			socket = new ServerSocket(9090,10);
			
			echo("Esperando por uma conexao de um cliente...");
			
			while(true)
			{
				
				Socket conn = socket.accept();
				
				echo("Conexao recebida por "+ conn.getInetAddress().getHostName()+ " : "+ conn.getPort());
				
				new ClientHandler(conn).start();
			}
		}
		catch(IOException e)
		{
			System.err.println("Unable to close. IOexception");
		}
		try
		{
			socket.close();
		}
		catch(IOException ioException)
		{
			System.err.println("Unable to close. IOexception");
		}
	}

	public static void echo(String msg)
	{
		System.out.println(msg);
	}
}
