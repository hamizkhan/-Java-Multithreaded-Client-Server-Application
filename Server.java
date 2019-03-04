import java.util.*;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server 
{
	
	public static void main(String[] args) 
	{
		ServerSocket serverSocket;
		Socket connection;
		int clientNumber=1;

		try
		{
			serverSocket=new ServerSocket(8000);
			System.out.println("Waiting on Client");
			
			ExecutorService threadExecutor =Executors.newCachedThreadPool();
			
			while(true)
			{
				connection=serverSocket.accept();
				System.out.println("Starting Thread for Client "+clientNumber);
				HandleClient thread=new HandleClient(connection,clientNumber);
				threadExecutor.execute(thread);
				clientNumber++;
			}
			
		}	
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
			
	}		
		
}		

class HandleClient implements Runnable
{
	Socket connection;
	int clientNumber;
	ObjectInputStream input;
	ObjectOutputStream output;
	MyString m;
	Object obj;
	
	public HandleClient(Socket connection, int clientNumber)
	{
		this.connection=connection;
		this.clientNumber=clientNumber;
	}
	
	public void run()
	{
		try
		{
			input=new ObjectInputStream(connection.getInputStream());
			output=new ObjectOutputStream(connection.getOutputStream());
			
			while(true)
			{
				obj=input.readObject();
				
				if(obj instanceof MyString)
					{
						System.out.printf("String from client %d: %s%n",clientNumber,((MyString) obj).getString());

						((MyString) obj).determineLength();
					}
				
			output.writeObject(obj);
			output.flush();
			}	
		
			
		}		
			
		catch(ClassNotFoundException cnfe)
		{
			cnfe.printStackTrace();
		}
		
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
			
		
		
	}
	
}
		
	
	
	


