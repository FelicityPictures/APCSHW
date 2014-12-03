import java.util.*;
public class OrderedSuperArray extends SuperArray{
    
  public OrderedSuperArray(){
    data = new String[2];
  }
  
  public static void main(String[]args){
    OrderedSuperArray t = new OrderedSuperArray();
    t.add("cat");
    t.add("mouse");
    t.add("apple");
    t.add("dog");
    t.add("zebra");
    t.add("banana");
    t.add("tiger");
    t.add("phone");
    t.add("eraser");
    t.add("bubbles");
    t.insertionSort();
    System.out.println(t.toString());
  }
}
