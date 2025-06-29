package MainTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultProcessing 
{
    public static void main(String[] args) 
    {
        String inputFile = "marks.txt";
        String outputFile = "results.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) 
        {

            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(" ");
                String name = parts[0];
                int total = 0;
                for (int i = 1; i < parts.length; i++) 
                {
                    total += Integer.parseInt(parts[i]);
                }
                double average = total / (double)(parts.length - 1);

                String result = name + " Total: " + total + " Average: " + String.format("%.2f", average);
                bw.write(result);
                bw.newLine();
            }

            System.out.println("Results written to " + outputFile);

        } 
        catch (IOException e) 
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
