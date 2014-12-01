import java.util.*;
public class OrderedSuperArray extends SuperArray{

    public void sort(){
	for(int i=0 ; i<super.getLength() ; i++){
	    String x = super.get(i);
	    String y = super.get(i+1);
	    int result = x.compareTo(y);
	    if(result > 0){
		add(i+1,super.get(i));
		remove(i);
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
	    }
}