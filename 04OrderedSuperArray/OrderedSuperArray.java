import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
    public OrderedSuperArray(){
	data = new String[0];
    }
    
    public void sort(){
	for(int i=0 ; i<size()-1 ; i++){
	    int result = get(i).compareTo(get(i+1));
	    if(result > 0){
		String x = //where I left off
	    }
	}
    }

    public static void main(String[]args){
	OrderedSuperArray t = new OrderedSuperArray();
	t.add("cat");
	t.add("mouse");
	t.add("Aatrox");
	t.add("dog");
	t.sort();
	System.out.println(t.toString());
	    }
}