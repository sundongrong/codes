package mutil;

import java.io.Console;
import java.io.IOException;

public class PackTest {

    public static void main(String[] args) {
        IntArrayBag ages = new IntArrayBag();
	Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
	add(ages,c);
	remove(ages,c);
    }
    public static void add(IntArrayBag ages,Console c){
	int ag=-1;

	do{
	   try {
	        ag=Integer.parseInt(c.readLine("Input your ades :"));
		if (ag!=-1) ages.addBefore(ag);
	    }catch(Exception e) {
		System.out.println(e); 
	    }
	}while(ag!=-1);

	 print(ages);
    }  
 
    public static void remove(IntArrayBag ages,Console c){
        int ag=0;
	int count = 0;
	while(ages.size()!=0){
	     try {
	          ag=Integer.parseInt(c.readLine());
	     }catch(Exception e) { }
	     if(ages.countOccurrences(ag)!=0){
	         ages.remove(ag);
	         System.out.format("%d has bean removed%n",ag);
	          print(ages);
	     }
	      else 
	         System.out.println("Cant remove it");
             
	}
    }
    public static void print(IntArrayBag ages){
	//System.out.println("***************");
	for(ages.start();ages.isCurrent();ages.advance())
	    System.out.format("%d-",ages.getCurrent());
        System.out.println();
   }	
}  	   