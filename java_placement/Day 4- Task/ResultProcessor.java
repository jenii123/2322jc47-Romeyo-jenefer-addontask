package Day 4- Task;

import java.io.*;
import java.util.*;

public class ResultProcessor {

    public static void main(String[] args) {
        String inputFile = "Marks.csv";
        String outputFile = "Results.csv";
        processResults(inputFile, outputFile);
    }

    public static void processResults(String inputFile, String outputFile) {
        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line = br.readLine(); // Read header
            if (line == null) return;

            bw.write(line + ",Total,Percentage,Grade");
            bw.newLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int maths = Integer.parseInt(data[1]);
                int science = Integer.parseInt(data[2]);
                int english = Integer.parseInt(data[3]);

                int total = maths + science + english;
                double percentage = total / 3.0;
                String grade = getGrade(percentage);

                String resultLine = String.format("%s,%d,%d,%d,%d,%.2f,%s",
                        name, maths, science, english, total, percentage, grade);
                bw.write(resultLine);
                bw.newLine();
            }

            System.out.println("Results written to: " + outputFile);

        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        }
    }

    public static String getGrade(double percentage) {
        if (percentage >= 90) return "A";
        else if (percentage >= 80) return "B";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }
}
