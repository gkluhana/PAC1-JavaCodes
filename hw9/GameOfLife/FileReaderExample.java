import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReaderExample {
	public static void main (String [] args) {

		final int M = 25;
		Scanner consoleReader = new Scanner(System.in);
		System.out.print ("Which file do you want to open?");
		String filename = consoleReader.next();
		File file = new File(filename);
		Scanner fileReader = null;

		try { 
		   fileReader = new Scanner (file);
		}
		catch (FileNotFoundException e) {
		   System.out.print("file " + file + " does not exist");
		   System.exit(0);
		}
		
		for (int i = 1; i <= M; i++) {
			String line = fileReader.nextLine();
			System.out.println(line);
  		}
  	} 
}
