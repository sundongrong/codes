package mutil;

public class Rings {

    private IntArrayBag ring = new IntArrayBag();	

    public Rings(int number){
	if (number>64) number = 64;
	for (int i=number; i>0; i--){
	    ring.add(i);
	}
    }
    public Rings(){
	this(4);
    }

    public int getRings(){
	return ring.size();
    }
    public int getDiameter(){
	return ring.getLast();
    }

    public boolean add(int target){
	boolean added=true;
	if (getRings()==0) {
	    ring.add(target);
	    return added;
        }else {
	    if (target>ring.getLast())  
	        return !added;
	    else {
	        ring.add(target);
	        return added;
	    }
        }
    }

    public int remove(){
	int topRing=0;
	if (ring.size() > 0){
	    topRing=getDiameter();
	    ring.remove(topRing);
	}
	return topRing;
    }    	
    public void print(){
        System.out.print("|");
	for(ring.start();ring.isCurrent();ring.advance())
	    System.out.format("%d-",ring.getCurrent());
        System.out.println();
   }
}

