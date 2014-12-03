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

    System.out.println(t.set(4, "cow"));
    System.out.println(t.toString());
  }
}
