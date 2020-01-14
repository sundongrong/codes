package mutil;
import java.io.Console;
import java.io.IOException;
public class Towers{
        static int initial = 5;
    public static void main(String[] args){
	int nPegs=0,nPege=0;
	
	Rings ring1= new Rings(initial);
    	Rings ring2= new Rings(0);
    	Rings ring3= new Rings(0);

	Rings startPeg=Rings(0),endPeg=Rings(0);
	ring1.print();	
	ring2.print(); 
	ring3.print();
	Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }
        do {
	     nPegs=Integer.parseInt(c.readLine("Input startPeg:"));
	     nPege=Integer.parseInt(c.readLine("Input endPeg:"));
	    if ((nPegs<=0)||(nPege<=0)) System.exit(0);
	    switch (nPegs){
   		case 1:
		    startPeg = ring1;
	       	    break;	
		case 2:
		    startPeg = ring2;
	       	    break;
		case 3:
		    startPeg = ring3;
	       	    break;
	    }	
	    switch (nPege){
   		case 1:
		    endPeg = ring1;
	       	    break;	
		case 2:
		    endPeg = ring2;
	       	    break;
		case 3:
		    endPeg = ring3;
	       	    break;
	    }
	    if( (nPegs > initial) || (nPege > initial)) continue;
	    move(startPeg,endPeg) ;
	    ring1.print();	
	    ring2.print(); 
	    ring3.print();
	    System.out.println("-------------");
	}while(true);
    }
    public static void move(Rings startPeg,Rings endPeg) {
	int tempRing=0;
	tempRing = startPeg.remove();
	if (tempRing==0) 
	    System.out.println("the ring is empty");
        else{
	    if (!endPeg.add(tempRing)) {
		startPeg.add(tempRing);
		System.out.println("Cant add to the peg");
	    }
        }
   }

}