package mutil;

public class IntArrayBag implements Cloneable {

    private int items;
    private int[] data;
    private int currentPoint=0;

    public IntArrayBag(){
	items = 0;
	data = new int[5];
    }
    public IntArrayBag(int initialCapacity){
	if(initialCapacity < 0) 
	    initialCapacity = 10;
	items = 0;
	data = new int[initialCapacity];
    }
    private void ensureCapacity(int length){
	int[] temp=new int[length];
	for(int i=0; i<items; i++) {
	    temp[i]=data[i];
        }
	data = temp;  
    } 	
    public void add(int element) {
	if (items == data.length) ensureCapacity(items*2+1);
	data[items] = element;
	items++;
    }
    public void addAll(IntArrayBag addend) {
	ensureCapacity(items+addend.items);
	System.arraycopy(addend.data,0,data,items,addend.items);
	items += addend.items;
    }
    public Object clone() {
	IntArrayBag  answer;
	try {
	    answer = (IntArrayBag)super.clone();
	}catch(CloneNotSupportedException e){
	    throw new RuntimeException("not support clone method");
	}
	answer.data = (int[])data.clone();
	return answer;
    }
    public int countOccurrences(int target){
	int numbers=0;
	for (int i=0; i<items; i++) 
	    if (target == data[i])
		numbers++;
	return numbers;
    }
    public int getCapacity() {
	return data.length;
    }
    public boolean remove(int target) {
	int index=0;
	while ((index < items)&&(data[index]!=target)) 
	    index++;
	if(index == items)
	    return false;
	else {
	    items --;
	    data[index]=data[items];
	    return true;
        }
    }
    
    public int removeAll(int target) {
	int index=0;
	int count=0;
	while(index < items){
	    if (data[index]==target) {
		items--;
		data[index]=data[items];
		count++;
	    }
	    else	
	        index++;
	}
        return count;
    }

    public int size() {
	return items;
    }

    public void trimToSize(){
	int trimmedArray[];
	if(data.length != items) {
	   trimmedArray = new int[items];
	   System.arraycopy(data,0,trimmedArray,0,items);
	   data=trimmedArray;
	}
    }

    public static IntArrayBag union(IntArrayBag b1,IntArrayBag b2) {
	IntArrayBag answer = new IntArrayBag(b1.getCapacity()+b2.getCapacity());
	System.arraycopy(b1.data,0,answer,0,b1.items);
	System.arraycopy(b2.data,0,answer,b1.items,b2.items);
	answer.items = b1.items+b2.items;
	return answer;
    }

    public void start(){
	currentPoint=0;
    }

    public int getCurrent(){
	return data[currentPoint];
    }

    public boolean isCurrent(){
	return currentPoint<items;
    }	

    public void advance(){
        if (currentPoint < items)
	      currentPoint++;
    }

    public void addBefore(int element) {
	if (items == data.length)  ensureCapacity(items*2+1);

	for(int i=items; i>currentPoint; i--){
	     data[i] = data[i-1];
	} 
	data[currentPoint]=element;
	items++;
    }

    public int getLast(){
	if(items==0) return 0;
	return data[items-1];
    }	
    	
}




 	