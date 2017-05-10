package by.htp.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class inOutLog {

	public static void main(String[] args) {
		BufferedReader reader = null;
		FileInputStream in = null;
		
		FileWriter logWr = null;
		PrintWriter logPr = null;
		
		String fileName = "C:/Users/YOGA 2 Pro/javaWS/Exception/src/by/htp/io/input.txt";
		String logName = "C:/Users/YOGA 2 Pro/javaWS/Exception/src/by/htp/io/log.txt";

		int s = 0;
		
		StringBuilder newFile = new StringBuilder();
		
		try {
			// the true will append the new data
			logWr = new FileWriter(logName, true);
			logPr = new PrintWriter(logWr);
			
			in = new FileInputStream(new File(fileName));
			reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				newFile.append(line);
				// splitting line into numbers and operation kind
				String[] numInLine = line.split(" ");

				int numOne = Integer.parseInt(numInLine[0]);
				int numTwo = Integer.parseInt(numInLine[2]);
				String oper = numInLine[1];

				System.out.print("Numbers: " + numOne + " & " + numTwo);
				logPr.println("1. Numbers: " + numOne + " & " + numTwo);

				s = 0;

				switch (oper) {
				case ("+"):
					s = numOne + numTwo;
					break;
				case ("-"):
					s = numOne - numTwo;
					break;
				case ("*"):
					s = numOne * numTwo;
					break;
				case ("/"):
					s = numOne / numTwo;
					break;
				}

				System.out.println("  Operation: " + (numInLine[1]) + "  Result: " + s);
				logPr.println("2. Operation: " + (numInLine[1]));
				logPr.println("3. Printed on monitor: " + s);
				
				newFile.append(" = "+s);
				newFile.append(System.getProperty("line.separator"));
				logPr.println("4. Results were added to the input file");
			}
		} catch (FileNotFoundException e) {
			System.out.println("!File doesn't exists!");
		} catch (IOException e) {
			System.out.println("!Something's wrong!");
		} finally {
			try {
				reader.close();
				logWr.close();
				logPr.close();
				FileWriter fileWr = new FileWriter(fileName);
				PrintWriter filePr = new PrintWriter(fileWr);
				filePr.print(newFile.toString());
				filePr.close();
			} catch (IOException e) {
				System.out.println("!NULL is somewhere!");
			}
		}

	}

}
