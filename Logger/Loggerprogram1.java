package logger;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import java.util.logging.FileHandler;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
import java.util.logging.*;
import java.util.*;
public class Loggerprogram1 {
	private static Logger logger=Logger.getLogger("Loggerprogram1");
public static void main(String[] args) {
	init();
	try(Scanner scan=new Scanner(System.in)) {
		System.out.println("Enter a number 1: ");
		int num=scan.nextInt();
		System.out.println("Enter number2 : ");
		int num2=scan.nextInt();
		System.out.println(num/num2);
		logger.log(Level.INFO,"No probelm");
	}
	catch(ArithmeticException a) {
		logger.log(Level.WARNING,"Divide by zero can't possible",a);
	}
	catch(InputMismatchException e) {
		logger.log(Level.SEVERE,"Enter only numbers",e);
	}
}
public static void init() {
	FileHandler fh;
	try {
		fh=new FileHandler("C:\\Users\\abdur\\OneDrive\\Desktop\\Intelizign\\Loggerprogram1.txt",true);
		
		logger.addHandler(fh);
		SimpleFormatter formatter=new SimpleFormatter();
		fh.setFormatter(formatter);
		logger.info("Logger initialized");
	}
	catch(Exception e){
		e.printStackTrace();
	} 
}
}
