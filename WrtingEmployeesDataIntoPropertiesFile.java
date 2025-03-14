package com.testNG;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
public class WrtingEmployeesDataIntoPropertiesFile {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			System.out.print("\nEnter no.of employees you need to keep in Map : ");
			int size;
			while(true) {
				size = getValidInput(sc);
				if(size > 0 )break;
				System.out.print("\n"+size+" -> size must be greater than zero!Try Again : ");
			}
			Map<Integer,String> employeesData = new LinkedHashMap<Integer,String>();
			takeInput(sc,size,employeesData);
			Properties properties = new Properties();
			//Stroing the employees data into properties file
			
			for (Map.Entry<Integer,String> entry : employeesData.entrySet()) {
				
				properties.put(String.valueOf(entry.getKey()),entry.getValue());
			}
			
			try(FileOutputStream fop = new FileOutputStream("C:\\Users\\guruv\\eclipse-workspace\\com.testNG\\employee.properties")){
				properties.store(fop, "Employees Data");
				System.out.println("\nEmployees data written into properties file successfully..");
			}catch(IOException ie) {
				ie.printStackTrace();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void takeInput(Scanner sc,int size,Map<Integer,String>employeesData) {
		
		for(int i = 0 ; i < size ; ++i) {
			System.out.print("\nEnter Employee ID : ");
			int eid = getValidInput(sc);
			System.out.print("\nEnter Employee Name : ");
			String employeeName = sc.next();
			employeesData.put(eid,employeeName);
		}
	}
	public static int getValidInput(Scanner sc) {
		while(true) {
			try {
				return sc.nextInt();
			}catch(InputMismatchException ime) {
				System.out.println("\nInvalid Input!Please enter valid integer as input : ");
				sc.next();
			}
		}
	}
}
