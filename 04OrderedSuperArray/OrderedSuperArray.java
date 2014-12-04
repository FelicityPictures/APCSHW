import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
  public OrderedSuperArray(){
    data = new String[2];
  }

  public void add(int index, String o){
    add(o);
  }

  public void add(String o){
    super.add(o);
    insertionSort();
  }
  
  public String set(int index, String o){
    String x = super.set(index,o);
    super.set(index, o);
    insertionSort();
    return x;
  }

    public int search(String t){
	int c = 0;
	int m = Math.pow(2,c);
	int x = size/2;
	while(!data[x].equals(t)){
	    int result;
	    try{
		result = data[m].compareTo(t);    
	    }catch(Exception e){}
	    if(result<0){
		c++;
		
	}
	
    }

    /*
    public int search(String t){
	for(int c=0;math.pow(2,c)<size;c++){
	    int m = size/math.pow(2,c);
	    if(data[m].equals(t)){
		return m;
	    }
    }
    */
}
