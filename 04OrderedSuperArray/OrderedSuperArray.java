import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
  public OrderedSuperArray(){
    data = new String[2];
  }
    
  public static void main(String[]args){
    OrderedSuperArray t = new OrderedSuperArray();
    t.add("cat");
    t.add("mouse");
    t.add("Aatrox");
    t.add("dog");
    t.insertionSort();
    System.out.println(t.toString());
  }
}
