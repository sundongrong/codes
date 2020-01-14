package mutil;

import java.util.*;

public class DateCheck {
    public static void main(String[] args) {
	Calendar calendar = Calendar.getInstance();
	//calendar.set(2007, 6, 24);
	//Calendar calendar = new GregorianCalendar(2007,6,29); 
	System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
 	System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
 	System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
 	System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DAY_OF_YEAR :"  +calendar.get(Calendar.DAY_OF_YEAR));
	System.out.println("DAY_OF_WEEK :"  +calendar.get(Calendar.DAY_OF_WEEK));
 	System.out.println("DATE: " + calendar.get(Calendar.DATE));
	System.out.println(calendar.toString());
       
 
    }
}