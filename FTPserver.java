import java.io.*;
import java.net.*;

public class FTPserver
{
	public static void main(String[] a)throws IOException
	{
		ServerSocket ss = new ServerSocket(5555);
		
		Socket s = ss.accept();
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		DataInputStream din = new DataInputStream(s.getInputStream());
		
		String s1;

		s1 = din.readLine();
		FileInputStream fin =new FileInputStream(s1);
		
		int str1;

		while((str1 = fin.read()) != -1)
			dos.writeBytes(""+(char)str1);
		System.out.println("\nFile Successfully Sent\t");
	
		dos.close();
		din.close();
		s.close();
	}
}