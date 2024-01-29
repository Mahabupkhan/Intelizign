package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileCreatonAndWriting {
	static Scanner scan=new Scanner(System.in);
	static String filePath="C:\\Users\\abdur\\OneDrive\\Desktop\\Intelizign\\example.txt";
public static void main(String[] args) {
	appendToFile();
}
public static void appendToFile() {
	System.out.println("Enter string to append : ");
	String sentence=scan.nextLine();
	try(FileWriter fw=new FileWriter(filePath,true)){
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(sentence);
		bw.newLine();
		bw.flush();
		System.out.println("Text appended to the file successfully.");
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
