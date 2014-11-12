public class SuperArrayDriver{

  public static void main(String[]args){
    SuperArray b = new SuperArray(12);
    b.set(0,'T');
    b.set(1,'h');
    b.set(2,'e');
    b.set(4,"kitty");
    b.set(5," ");
    b.set(6,'c');
    b.set(7,'4');
    b.set(8,'t');
    b.set(9," ");
    b.set(10,"is");
    b.set(11,"cute.");
    System.out.println(b.toString());

    try{
      b.add("meow");
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }

    System.out.println(b.toString());
  
    try{
      b.add(3,"cute");
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }
    System.out.println(b.toString());

    System.out.println(b.size());
  
    try{
      b.resize(-12);
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }

    System.out.println(b.toString());

    try{
      System.out.println(b.get(-11));
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }

    try{
      System.out.println(b.set(11,"kawaii."));
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }
    System.out.println(b.toString());
    try{
      System.out.println(b.remove(4));
    }catch(IndexOutOfBoundsException e){
      System.out.println("I guess they don't like cats...");
    }
    System.out.println(b.toString());

    b.clear();
    System.out.println(b.toString());
      
  }
}
