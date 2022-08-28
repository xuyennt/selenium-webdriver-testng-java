package javaTester;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class topic19_data_type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 WebDriver driver = new FirefoxDriver();
		 
		 Date date = new Date(); 
		 
		 //object
		 Object students ;
		 //array
		 int numbers[] = {15,20,45};
		 String addresses[] = {" Đà Nẵng", "Hà Nội", "HCM"};
		 // List/set/queue(collection)
		 List<Integer> studentNumber = new ArrayList<Integer>();
		 List<String> studentAddress = new ArrayList<String>();
		 
		 

	}

}
