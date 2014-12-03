import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
  public OrderedSuperArray(){
    data = new String[0];
  }
    
  public void sort(){
    String c;
    for(int i=0 ; i<size()-1 ; i++){
	    int result = get(i).compareTo(get(i+1));
	    if(result > 0){
        c = get(i);
        remove(i);
        for(int l=i; i<size();i++){
          int big = c.compareTo(get(l+1));
          if(big > 0){
            add(l,c);
          }
        }
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
