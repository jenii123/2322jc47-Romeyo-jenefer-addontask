package Day 4- Task;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteTextFile {

	public static void main(String[] args) {
		try {
		FileWriter fw = new FileWriter("C:\\Users\\priyadharshini\\eclipse-workspace\\JavaDay4\\src\\TasksDay4\\Writefile.txt");
		BufferedWriter br = new BufferedWriter(fw);
		br.write("hello world");
		br.write(" hello");
		br.newLine();
		br.close();
		System.out.println("successfully Written!");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
