public class Driver{

    public static void main(String[]args){
	//tested OrderedSuperArray
	SuperArray t = new OrderedSuperArray();
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
	System.out.println(t.toString());

	System.out.println(t.set(4, "cow"));
	System.out.println(t.toString());
  }

}