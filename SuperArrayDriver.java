public class SuperArrayDriver{

    public static void main(String[]args){
	SuperArray a = new SuperArray();
	SuperArray b = new SuperArray(12);
	SuperArray c = new SuperArray(8);
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
	b.remove(11);
	System.out.println(b.remove(4));
	System.out.println(b.toString());

    }
}
