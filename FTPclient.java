import java.io.*;
import java.net.*;

public class FTPclient
{
	public static void main(String a[])throws IOException
	{
		Socket s = new Socket(InetAddress.getLocalHost(),5555);

		DataInputStream s1 = new DataInputStream(s.getInputStream());
		DataInputStream inp = new DataInputStream(System.in);
	
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
		System.out.println("\n\tEnter the FileName(in same folder) or path(for another folder) : ");
			String str = inp.readLine();
	
		out.writeBytes(str);
		out.writeBytes("\n");
		
		FileOutputStream fos = new FileOutputStream("output.txt");
		
		int str1;
		
		//System.out.println("s1.readLine() : \t"+s1.readLine());
		while((str1 = s1.read()) != 1)
			fos.write((char)str1);
		

		System.out.println("\nFile received Successfully");
		
		s1.close();
		out.close();
		inp.close();
		s.close();
	}
}