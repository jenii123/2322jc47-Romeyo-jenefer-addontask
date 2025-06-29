package Day 4- Task;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadTextFile {
  public static void main(String[] args) {
	  try {
	FileReader fr = new FileReader("C:\\Users\\priyadharshini\\eclipse-workspace\\JavaDay4\\src\\TasksDay4\\Readfile.txt");
	BufferedReader br = new BufferedReader(fr);
	String line = br.readLine();
	while(line!=null) {
	System.out.print((String)line);
	line=br.readLine();
	}
	br.close();
	  }
	  catch(Exception e) {
		  System.out.println(e);
	  }
}
}
