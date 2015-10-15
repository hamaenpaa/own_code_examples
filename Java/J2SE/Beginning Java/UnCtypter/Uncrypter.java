import java.io.*;
import Crypter;

public class Uncrypter
{
    public static void main(String[] args)
    {
//	final int LONG_BUFFER = 1024;
//	char[] buffer = new char[LONG_BUFFER];
	Crypter crypter = new Crypter();
/*	String readLocation = "C:\\tempCrypted.txt";
	String writeLocation = "C:\\tempUncrypted.txt";
	BufferedReader reader = new BufferedReader(new FileReader(readLocation));
	BufferedWriter writer = new BufferedWriter(new FileWriter(writeLocation));
	int clus = 0;
	while (reader.ready() && ((clus = reader.read(buffer)) != 0))
	{
	    String crypted = buffer; */
	    String uncrypted = crypter.decrypt(args[0]);
	    // writer.write(uncrypted, 0, clus);
	    System.out.println("Source: " + args[0] + " is decrypted as: " + uncrypted);
//	}
/*	reader.close();
	writer.flush();
	writer.close();*/
    }
}