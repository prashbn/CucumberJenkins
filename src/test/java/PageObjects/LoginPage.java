package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ReusableComponents.ObjectActions;

public class LoginPage {
	

	 private static WebElement element = null;
	 
	    public static WebElement txtbx_UserName(){
	 
	         element = ObjectActions.findElementById("Email");
	 
	         return element;
	 
	         }
	 
	     public static WebElement txtbx_Password(){
	 
	    	 element = ObjectActions.findElementById("password");
	    	 
	         return element;
	 
	         }
	 
	     public static WebElement btn_LogIn(){
	 
	    	 element = ObjectActions.findElementById("click");
	    	 
	         return element;
	 
	         }
	 

}
