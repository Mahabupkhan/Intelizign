package jsonTraining;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {
	private Map<String,Object> keyvalues=new HashMap<String,Object>();
public static void main(String[] args) {
	try(BufferedReader bf=new BufferedReader(new FileReader("C:\\Users\\abdur\\OneDrive\\Desktop\\Intelizign\\Json Practice\\books.json"))){
		StringBuilder TotalStringInFile=new StringBuilder();
		String eachLine;
		while((eachLine=bf.readLine())!=null) {
			TotalStringInFile.append(eachLine);
			TotalStringInFile.append("\n");
		}
		List<String> result= ConvertToMap(TotalStringInFile);
//		for(String s:result) {
//			System.out.println(s);
//			System.out.println("----------------------------------------------------");
//		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
public static List ConvertToMap(StringBuilder json) {
	Map<String,Object> result=new HashMap<String,Object>();
	ArrayList<String> splittedArray=new ArrayList<String>();
	String[] returned;
	do {
		returned=separateBlock(json);
		splittedArray.add(returned[0]);
		StringBuilder s=new StringBuilder(returned[1]);
		json=s;
	}while(json.length()<4);
	
	return splittedArray;
}
public static String[] separateBlock(StringBuilder totalStringInFile) {
	
	String result="";
	String balancePart="";
	String[] finalResult= {result,balancePart};
	
	int openBracketCount=0;
	
	for(int i=0;i<totalStringInFile.length();i++) {
		//boolean flag=false;
		if(totalStringInFile.charAt(i)=='{') {
			int j;
			for(j=i;j<totalStringInFile.length();j++) {
				if(totalStringInFile.charAt(j)=='{') {
					openBracketCount++;
				}
				if(totalStringInFile.charAt(j)=='}') {
					openBracketCount--;
				}
				if(totalStringInFile.charAt(j)=='}' && openBracketCount==0 ) {
					result+=totalStringInFile.charAt(j);
					//flag=true;
					break;
				}
				result+=totalStringInFile.charAt(j);
			}
			for(int k=j+1;k<totalStringInFile.length();k++) {
				balancePart+=totalStringInFile.charAt(k);
			}
		}
		
	}
	finalResult[0]=result;
	finalResult[1]=balancePart;
	System.out.println("result : "+result+"\nBalance : "+balancePart);
	return finalResult;
}
}
